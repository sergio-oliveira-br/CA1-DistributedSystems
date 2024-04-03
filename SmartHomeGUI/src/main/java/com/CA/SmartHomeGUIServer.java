package com.CA;

import io.grpc.Server;
import io.grpc.ServerBuilder;

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
                //.addService(new StreamingClientServiceImpl()) //ping
                //.addService(new BidirectionalStreamingImpl())
                .build();
    }

    //Method: Initialize the gRPC
    public void start() throws IOException
    {
        server = ServerBuilder.forPort(port)
                //.addService(new StreamingClientServiceImpl())
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
                        "\nby Sergio Oliveira - x23170981@student.ncirl.ie" );
                //System.out.println("\nShutting down gRPC server." +
                        //"\nThis was CA1 - Distributed System" +
                        //"\nby Sergio Oliveira - x23170981@student.ncirl.ie");
                //SmartHomeGUIServer.this.stop();
            }
        }));
    }

    public static void main(String[] args)
    {
        SmartHomeGUIServer server = new SmartHomeGUIServer(8081);
        //server.start();
        //server.blockUntilShutdown();
    }
}
