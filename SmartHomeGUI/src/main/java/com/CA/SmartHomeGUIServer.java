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
import javax.swing.*;
import java.io.IOException;
import java.util.Random;


//Logging and Diagnostics
import java.util.logging.*;  //Logging and Diagnostics



public class SmartHomeGUIServer
{
    //Instance Variables
    private int port;
    private static Server server;


    //Logging and Diagnostics
    private static final Logger logger = Logger.getLogger(SmartHomeGUIServer.class.getName());





    //Constructor: Default
    public SmartHomeGUIServer()
    {}

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
                .addService(new SmartHomeImpl())                //Lights
                .addService(new SmartHomeLockImpl())            //Locks
                .addService(new StreamingClientServiceImpl())   //Ping
                .addService(new BidirectionalStreamingImpl())   //Temperature
                .build();

        logger.info("LOG - THIS IS SmartHomeGUIServer Constructor (ServerBuilder, Port) ");
    }




    //Method: Initialize the gRPC
    public void start() throws IOException
    {
        server = ServerBuilder.forPort(port)
                .addService(new StreamingClientServiceImpl())   //ping
                //.addService(new SmartHomeImpl())
                //.addService(new SmartHomeLockImpl())
                .addService(new BidirectionalStreamingImpl()) //temperature
                .build()
                .start();

        System.out.println("Server started on PORT: " + port + " waiting for connection...");

        logger.info("LOG - START() BEFORE addShutdownHook");


        Runtime.getRuntime().addShutdownHook(new Thread(() ->
        {
            //SwingUtilities.invokeLater(() ->
            {
                try
                {
                    JOptionPane.showMessageDialog(null, "\nShutting down gRPC server." +
                            "\nThis was CA1 - Distributed System" +
                            "\nby Sergio Oliveira - x23170981@student.ncirl.ie");
                    System.out.println("working here inside");
                }



                catch (Exception e)
                {
                    System.out.println("working here after");
                    logger.info("LOG - before  STOP()");
                    stop();
                    //SmartHomeGUIServer.this.stop();
                    logger.info("LOG - after  STOP()");
                    System.out.println("this is the Exception: " + e);
                }



            }
        }));
    }

    //Method: Ends and clean the gRPC
    public void stop()
    {
        if (server != null)
        {
            server.shutdown();
            logger.info("LOG - inside stop()");
        }
    }

    //Method: To ensure that the main program does not go offline until the gRPC has been completely shut down
    static void blockUntilShutdown() throws InterruptedException
    {
        if (server != null)
        {
            server.awaitTermination();
            logger.info("LOG - inside blockUtilShutdown");
        }
    }


    /*
        ___________________________________
        !!! Smart Devices - Lights and Locks  !!!

        Here are where all method's to switch off/on
        The idea is to send request to the server
        and get response from the server
        ___________________________________
    */



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
            String message = "Received unary request from client: " + request.getName();
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

                    ServerResponse response = ServerResponse.newBuilder()
                            .setMessage("HI FROM SERVER")
                            .build();
                   // responseObserver.onNext(response);
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
            return new StreamObserver<BidirectionalRequest>()
            {
                @Override
                public void onNext(BidirectionalRequest request)
                {
                    System.out.println("Received message from client: " + request.getMessage());
                    {
                        //Respond to the client's message with a stream
                        if(request.getMessage().compareTo("15") < 0 || request.getMessage().compareTo("25") > 0)
                        {
                            JOptionPane.showMessageDialog(null,
                                    "Sorry. Your request is out of range." +
                                             "\nPlease, could you try again within the range (15ºC - 25ºC)",
                                    "Smart Home CA - Server", JOptionPane.ERROR_MESSAGE);
                        }

                        else if(request.getMessage().compareTo("15") > 0 || request.getMessage().compareTo("25") < 0)
                        {
                            JOptionPane.showMessageDialog(null,
                                    "Hi Client, I got your request!" +
                                             "\nYour temperature has been adjusted to " + request.getMessage() + "ºC",
                                    "Smart Home CA - Server", JOptionPane.INFORMATION_MESSAGE);
                        }

                        BidirectionalResponse response = BidirectionalResponse.newBuilder()
                                .setMessage("Received and processing request from the client.")
                                .build();
                        responseObserver.onNext(response);
                    }
                }

                //This appears when the user the request is not finished
                @Override
                public void onError(Throwable t)
                {
                    System.err.println("Error from client: " + t.getMessage());

                }

                @Override
                public void onCompleted() {
                    System.out.println("Requested stream completed");
                    responseObserver.onCompleted(); // Complete the response stream
                }
            };
        }

        @Override
        public StreamObserver<WeatherForecastRequest> weatherForecast(StreamObserver<WeatherForecastResponse> streamObserver) {
            return new StreamObserver<WeatherForecastRequest>() {
                @Override
                public void onNext(WeatherForecastRequest weatherForecastRequest)
                {
                    Random random = new Random();
                    int tomorrow = random.nextInt(15) + 10;

                    JOptionPane.showMessageDialog(null,
                            "The weather forecast for tomorrow is: " + tomorrow + "ºC",
                            "Smart Home CA - Server", JOptionPane.INFORMATION_MESSAGE);

                    WeatherForecastResponse response = WeatherForecastResponse.newBuilder()
                            .setMessage("The weather forecast for tomorrow is: " + tomorrow + "ºC")
                            .build();
                    streamObserver.onNext(response);
                }

                //This will be used when the user is not connected with the server
                @Override
                public void onError(Throwable throwable)
                {

                    System.err.println("I NEED TO SOLVE THIS");
                }

                //This start after the onNext
                @Override
                public void onCompleted()
                {
                    System.out.println("Connection onCompleted");
                }
            };
        }
    }

















    public static void main(String[] args) throws IOException, InterruptedException
    {
        SmartHomeGUIServer server = new SmartHomeGUIServer(8081);
        server.start();
        blockUntilShutdown();
    }
}
