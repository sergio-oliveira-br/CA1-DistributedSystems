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
    private final Server server;

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
                .build();
    }

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

    public static void main(String[] args) throws IOException, InterruptedException
    {
        SmartHomeServer server = new SmartHomeServer(8081);
        server.start();
        server.blockUntilShutdown();
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
}
