package com.CA;

import com.CA.gRPC.LightRequest;
import com.CA.gRPC.LightResponse;
import com.CA.gRPC.SmartHomeGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class SmartHomeServer
{
    private final int port;
    private final Server server;

    public SmartHomeServer(int port)
    {
        this(ServerBuilder.forPort(port), port);
    }

    public SmartHomeServer(ServerBuilder<?> serverBuilder, int port)
    {
        this.port = port;
        server = serverBuilder.addService(new SmartHomeImpl()).build();
    }

    public void start() throws IOException
    {
        server.start();
        System.out.println("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            SmartHomeServer.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    public void stop()
    {
        if (server != null)
        {
            server.shutdown();
        }
    }

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

    static class SmartHomeImpl extends SmartHomeGrpc.SmartHomeImplBase
    {
        @Override
        public void controlLights(LightRequest request, StreamObserver<LightResponse> responseObserver)
        {
            // Logic to control lights based on the request
            boolean lightOn = request.getLightOn();
            String message;
            if (lightOn)
            {
                message = "Lights turned on";
            } else
            {
                message = "Lights turned off";
            }
            LightResponse response = LightResponse.newBuilder().setMessage(message).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
