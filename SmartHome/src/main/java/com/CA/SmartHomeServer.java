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
                .build();
    }


    //Method: Initialize the gRPC
    public void start() throws IOException
    {
        server = ServerBuilder.forPort(port)
                .addService(new StreamingClientServiceImpl())
                .build()
                .start();
        System.out.println("Server started on PORT: " + port + " waiting for connection...");
        Runtime.getRuntime().addShutdownHook(new Thread(() ->
        {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            SmartHomeServer.this.stop();
            System.err.println("*** server shut down");
        }));
    }


    /*

    //THIS IS OK - BACKUP

    //Method: Initialize the gRPC
    public void start() throws IOException
    {
        server.start();
        System.out.println("Server started on PORT: " + port + " waiting for connection...");
        Runtime.getRuntime().addShutdownHook(new Thread(() ->
        {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            SmartHomeServer.this.stop();
            System.err.println("*** server shut down");
        }));
    }


    //THIS IS FAKE FROM THE EXAMPLES

    public void start(int port) throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new StreamingClientServiceImpl())
                .build()
                .start();
        System.out.println("Server started, listening on port " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down gRPC server");
            try {
                StreamingClientServer.this.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
        }));
    }



     */








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
        Here is where all information about the PING method
        The idea is get response from the user
    */

    private static class StreamingClientServiceImpl extends StreamingClientServiceGrpc.StreamingClientServiceImplBase {
        @Override
        public void sendUnaryRequest(UnaryRequest request, StreamObserver<UnaryResponse> responseObserver) {
            String message = "Received unary request from client: " + request.getName();
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
                public void onNext(ClientInformation clientInfo) {
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
        SmartHomeServer server = new SmartHomeServer(8081);
        server.start();
        server.blockUntilShutdown();

    }
}
