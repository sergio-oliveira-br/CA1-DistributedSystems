/*
  CA - Distributed System
  Author: Sergio Oliveira - x23170981@student.ncirl.ie
  Date: 13 Apr 2024

  Lecturer: Mark Cudden

  References:
    https://grpc.io/docs/languages/java/quickstart/
    https://grpc.io/docs/languages/java/basics/

    SERVER SIDE
 */


package com.CA;

import com.CA.gRPC.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SmartServer
{
    //Instance Variables
    int port;
    Server server;

    /*
        ===========================
            Starting the server
        ===========================
     */

    //Constructor: Start up a gRPC server so that clients can actually use our service.
    public SmartServer(int port)
    {
        //Specify the address and port we want to use to listen for client requests using the builder’s forPort() method.
        this(ServerBuilder.forPort(port), port);
    }

    //Constructor: Create a RouteGuide server using serverBuilder as a base and features as data.
    public SmartServer(ServerBuilder<?> serverBuilder, int port)
    {
        this.port = port;

        //Create an instance of our service implementation class RouteGuideService and pass it to the builder’s addService() method.
        server = serverBuilder
                .addService(new GreeterImpl())
                .addService(new TemperatureRampImpl())
                .addService(new SmartDoorServicesImpl())
                .addService(new SmartAlarmServicesImpl())
                .build();

    }



    public void start() throws IOException
    {
        server.start();
        System.out.println("Server is running on port 8081...");
    }

    //Method: makes my Server running until the user stop.
    private void blockUntilShutdown() throws InterruptedException
    {
        if (server != null)
        {
            server.awaitTermination();
        }
    }

    //Stop serving requests and shutdown resources.
    public void stop() throws InterruptedException
    {
        if (server != null)
        {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }



    /*
        ===========================
                Simple RPC
        ===========================
     */

    //Implementation of the gRPC service "Greater" on the server-side.
    //The class extends the generated GreeterGrpc.GreeterImplBase abstract class:
    private static class GreeterImpl extends GreeterGrpc.GreeterImplBase
    {
        @Override
        public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver)
        {
            //super.sayHello(request, responseObserver); !IMPORTANT: I DO NOT NEED THIS

            //Generate a greeting message
            HelloReply reply = HelloReply.newBuilder()
                    .setMessage("From the Server: Welcome to Smart Oven " + request.getName()).build();

            //Send the reply back to the client.
            responseObserver.onNext(reply);

            //Indicate that no further messages will be sent to the client.
            responseObserver.onCompleted();
        }
    }

    /*
        ======================================================
            Implement Method - Server-side streaming RPC

            A server-side streaming RPC where the client
            sends a request to the server and
            gets a stream to read a sequence of messages back.

            The client reads from the returned stream
            until there are no more messages.
        ======================================================
     */

    private static class TemperatureRampImpl extends TemperatureRampGrpc.TemperatureRampImplBase
    {
        @Override
        public void sendTempData(SetPointTemp request, StreamObserver<TempRamp> responseObserver)
        {
            int setTemp = request.getSetTemp();
            int currentTemp = 0;

            //here is where my dots rise
            for (int i = 0; i <= setTemp; i++)
            {
                //double tempValue = Math.exp(i / 10.0);
                TempRamp tempRamp = TempRamp.newBuilder().setMessage((int)i).build();
                responseObserver.onNext(tempRamp);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            //here is where my graph goes down


            //here I need to implement the same number



            //This is the end.
           responseObserver.onCompleted();
        }
    }







    /** Home Security Proto (Open/Close Door): Implementation of Unary RCP */
    public static class SmartDoorServicesImpl extends SmartDoorServicesGrpc.SmartDoorServicesImplBase
    {
        @Override
        public void openDoor (OpenRequest request, StreamObserver<OpenResponse> responseObserver)
        {
            //Build the response
            OpenResponse response = OpenResponse.newBuilder().setStatus("\nFrom the server: Door Opened -> ").build();

            //Send the response
            responseObserver.onNext(response);
            responseObserver.onCompleted(); //finish the request

        }

        @Override
        public void closeDoor (CloseRequest request, StreamObserver<CloseResponse> responseObserver)
        {
            //Build the response
            CloseResponse response = CloseResponse.newBuilder().setStatus("\nFrom the Server: Door Closed -> ").build();

            //Send the response
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    /** Home Security Proto (Alarm): Implementation of Server Side Streaming RCP */
    public static class SmartAlarmServicesImpl extends SmartAlarmServicesGrpc.SmartAlarmServicesImplBase
    {
        private static volatile boolean streaming = false;
        @Override
        public void turnOnAlarm (TurnOnAlarmRequest request, StreamObserver<TurnOnAlarmResponse> responseStreamObserver)
        {
            streaming = true;
            //Start streaming Server information
            Thread streamThread = new Thread(() ->
            {
                try
                {
                    int i = 0;
                    while(streaming || i == 200)
                    {
                        {
                            TurnOnAlarmResponse response = TurnOnAlarmResponse.newBuilder().setStatusOn("Alarm ON: Pulse ").build();
                            System.out.print("Alarm is ON...");
                            responseStreamObserver.onNext(response);
                            Thread.sleep(1500);
                            i++;
                        }
                    }
                    if (streaming)
                    {
                        TurnOnAlarmResponse response = TurnOnAlarmResponse.newBuilder().setStatusOn("Alarm ON: Completed").build();
                        responseStreamObserver.onNext(response);
                        responseStreamObserver.onCompleted();
                    }
                }

                catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    responseStreamObserver.onCompleted();
                }
            });
            streamThread.start();
        }

        @Override
        public void turnOffAlarm (TurnOffAlarmRequest request, StreamObserver<TurnOffAlarmResponse> responseObserver)
        {
            streaming = false;

            //Build the response
            TurnOffAlarmResponse response = TurnOffAlarmResponse.newBuilder().setStatusOff("\nFrom the server: " +
                    "Your Alarm was turned Off").build();

            //Send the response
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }



    /** Environment Management Proto (Forecast): Implementation of Unary RCP */
    public static class EnvironmentMgmtServicesImpl extends SmartDoorServicesGrpc.SmartDoorServicesImplBase
    {
        @Override
        public void forecast ()
    }



    public static void main(String[] args) throws IOException, InterruptedException
    {
        //Call build() and start() on the builder to create and start an RPC server for our service.
        SmartServer myServer = new SmartServer(8081);
        myServer.start();
        myServer.blockUntilShutdown();
    }

}
