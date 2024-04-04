package com.CA;

import com.CA.gRPC.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import javax.swing.*;
import java.io.IOException;

public class SmartHomeGUIServer
{
    //Instance Variables
    private final int port;
    private Server server;

    //Constructor: Get the port
    public SmartHomeGUIServer(int port)
    {
        this(ServerBuilder.forPort(port), port);
    }

    //Constructor: Get the port and serve
    public SmartHomeGUIServer(ServerBuilder<?> serverBuilder, int port)
    {
        this.port = port;
        server = serverBuilder
                //.addService(new SmartHomeImpl())
                //.addService(new SmartHomeLockImpl())
                .addService(new StreamingClientServiceImpl()) //ping
                //.addService(new BidirectionalStreamingImpl())
                .build();
    }

    //Method: Initialize the gRPC
    public void start() throws IOException
    {
        server = ServerBuilder.forPort(port)
                .addService(new StreamingClientServiceImpl())
                //.addService(new SmartHomeImpl())
                //.addService(new SmartHomeLockImpl())
                //.addService(new BidirectionalStreamingImpl())
                .build()
                .start();

        System.out.println("Server started on PORT: " + port + " waiting for connection...");
        Runtime.getRuntime().addShutdownHook(new Thread(() ->
        {
            {
                JOptionPane.showMessageDialog(null,"\nShutting down gRPC server." +
                        "\nThis was CA1 - Distributed System" +
                        "\nby Sergio Oliveira - x23170981@student.ncirl.ie");


                //System.out.println("\nShutting down gRPC server." +
                        //"\nThis was CA1 - Distributed System" +
                        //"\nby Sergio Oliveira - x23170981@student.ncirl.ie");
                //SmartHomeGUIServer.this.stop();
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





    /*
        ___________________________________
        !!! Streaming client information !!!

        Here are where all method's PING
        The idea is get response from the user
        ___________________________________
    */

    private static class StreamingClientServiceImpl extends StreamingClientServiceGrpc.StreamingClientServiceImplBase
    {
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
        public StreamObserver<ClientInformation> streamClientInformation(StreamObserver<ServerResponse> responseObserver)
        {
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

















    public static void main(String[] args) throws IOException, InterruptedException
    {
        SmartHomeGUIServer server = new SmartHomeGUIServer(8081);
        server.start();
        server.blockUntilShutdown();
    }
}