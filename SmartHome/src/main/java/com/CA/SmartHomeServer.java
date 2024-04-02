/*
Continuous Assessment (CA)
Type: Project

Distributed Systems - NCI
HDip in Computing - HDCSDEV_INT

Due Date: 19th April 2024
Lecturer: Mark Cudden

Student:
    Sergio Vinicio da Silva Oliveira
    x23170981@student.ncirl.ie

GitHub:
https://github.com/sergio-oliveira-br/CA1-DistributedSystems
*/


package com.CA;

import com.CA.gRPC.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class SmartHomeServer
{
    //Instance Variables
    private final int port;
    private Server server;

    /*
        ___________________________________
        !!! Lights and Locks Control !!!

        Here are where all method's to control are
        The idea is the user send requests to
        turn on/turn off or open/close to the server
        ___________________________________
    */


    //Constructor: Get the port
    public SmartHomeServer(int port)
    {
        this(ServerBuilder.forPort(port), port);
    }

    //Constructor: Get the port and serve
    public SmartHomeServer(ServerBuilder<?> serverBuilder, int port)
    {
        this.port = port;
        server = serverBuilder
                .addService(new SmartHomeImpl())
                .addService(new SmartHomeLockImpl())
                .addService(new StreamingClientServiceImpl()) //ping
                .addService(new BidirectionalStreamingImpl())
                .build();
    }

    //Method: Initialize the gRPC
    public void start() throws IOException
    {
        server = ServerBuilder.forPort(port)
                .addService(new StreamingClientServiceImpl())
                .addService(new SmartHomeImpl())
                .addService(new SmartHomeLockImpl())
                .addService(new BidirectionalStreamingImpl())
                .build()
                .start();

        System.out.println("Server started on PORT: " + port + " waiting for connection...");
        Runtime.getRuntime().addShutdownHook(new Thread(() ->
        {
            {
                System.out.println("\nShutting down gRPC server." +
                        "\nThis was CA1 - Distributed System" +
                        "\nby Sergio Oliveira - x23170981@student.ncirl.ie");
                SmartHomeServer.this.stop();
            }
        }));
    }

    //Method: Ends and clean the gRPC
    public void stop()
    {
        if (server != null)
        {
            server.shutdown();
        }
    }

    //Method: To ensure that the main program does not go offline until the gRPC has been completely shut down
    public void blockUntilShutdown() throws InterruptedException
    {
        if (server != null)
        {
            server.awaitTermination();
        }
    }

    //Method: To control lights based on the request
    static class SmartHomeImpl extends LightServicesGrpc.LightServicesImplBase
    {
        @Override
        public void controlLights(LightRequest request, StreamObserver<LightResponse> responseObserver)
        {

            boolean lightOn = request.getLightOn();
            String message;
            if (lightOn)
            {
                message = "Lights turned on" + "\n------";
            } else
            {
                message = "Lights turned off" + "\n------";
            }
            LightResponse response = LightResponse.newBuilder().setMessage(message).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }


    //Method: To control locks based on the request
    static class SmartHomeLockImpl extends LockServicesGrpc.LockServicesImplBase
    {
        @Override
        public void controlLocks(LockRequest request, StreamObserver<LockResponse> responseObserver)
        {


            boolean lockOpen = request.getLockOpen();
            String message;
            if (lockOpen)
            {
                message = "Lock closed" + "\n------";
            } else
            {
                message = "Lock opened" + "\n------";
            }
            LockResponse response = LockResponse.newBuilder().setMessage(message).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    /*
        ___________________________________
        !!! Streaming client information !!!

        Here are where all method's PING
        The idea is get response from the user
        ___________________________________
    */

    private static class StreamingClientServiceImpl extends StreamingClientServiceGrpc.StreamingClientServiceImplBase {
        @Override
        public void sendUnaryRequest(UnaryRequest request, StreamObserver<UnaryResponse> responseObserver)
        {
            String message = "\nReceived unary request from client: " + request.getName();
            UnaryResponse response = UnaryResponse.newBuilder()
                    .setMessage(message)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public StreamObserver<ClientInformation> streamClientInformation(StreamObserver<ServerResponse> responseObserver) {
            return new StreamObserver<ClientInformation>() {
                @Override
                public void onNext(ClientInformation clientInfo)
                {
                    System.out.println("-------");
                    System.out.println("Received client information:");
                    System.out.println("Client Name: " + clientInfo.getClientName());
                    System.out.println("Date and Time: " + clientInfo.getDateTime());
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Error in client information streaming: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("Client information streaming completed");
                    ServerResponse response = ServerResponse.newBuilder()
                            .setMessage("Client information streaming completed")
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                }
            };
        }
    }




    /*
        __________________________________________________________
                    !!! Thermostats Services !!!

        Here are where all method's related temp are
        The idea is set and get updates between Server and Client
        ___________________________________________________________
    */

    static class BidirectionalStreamingImpl extends BidirectionalStreamingServiceGrpc.BidirectionalStreamingServiceImplBase {

        @Override
        public StreamObserver<BidirectionalRequest> bidirectionalStream(StreamObserver<BidirectionalResponse> responseObserver) {
            return new StreamObserver<BidirectionalRequest>() {
                @Override
                public void onNext(BidirectionalRequest request) {
                    System.out.println("Received message from client: " + request.getMessage());
                    // Respond to the client's message with a stream
                    {
                        BidirectionalResponse response = BidirectionalResponse.newBuilder()
                                .setMessage("Okay. Room temperature set !!!!!! " + request.getMessage())
                                .build();
                        responseObserver.onNext(response);
                    }
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Error from client: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("Client stream completed");
                    responseObserver.onCompleted(); // Complete the response stream
                }
            };
        }

        @Override
        public StreamObserver<WeatherForecastRequest> weatherForecast(StreamObserver<WeatherForecastResponse> streamObserver)
        {
            return new StreamObserver<WeatherForecastRequest>()
            {
                @Override
                public void onNext(WeatherForecastRequest weatherForecastRequest)
                {
                    int weatherForecast = 22;
                    WeatherForecastResponse response = WeatherForecastResponse.newBuilder()
                            .setMessage("The Weather Forecast is: " + weatherForecast + "ºC")
                            .build();
                    streamObserver.onNext(response);
                }

                @Override
                public void onError(Throwable throwable) {
                    System.err.println("I NEED TO SOLVE THIS");

                }

                @Override
                public void onCompleted() {
                    System.out.println("Connection onCompleted");
                }
            };
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException
    {
        SmartHomeServer server = new SmartHomeServer(8081);
        server.start();
        server.blockUntilShutdown();
    }
}
