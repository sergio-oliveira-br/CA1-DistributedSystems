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
                    .setMessage("From the Server:\n" +
                                "Welcome to Smart Oven " + request.getName()).build();

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
            for(int i = 0; i <= setTemp; i++)
            {
                TempRamp tempRamp = TempRamp.newBuilder().setMessage((i)).build();
                responseObserver.onNext(tempRamp);

                try
                {
                    Thread.sleep(500);
                }

                catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
            //This is the end.
            responseObserver.onCompleted();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException
    {
        //Call build() and start() on the builder to create and start an RPC server for our service.
        SmartServer myServer = new SmartServer(8081);
        myServer.start();
        myServer.blockUntilShutdown();

    }

}
