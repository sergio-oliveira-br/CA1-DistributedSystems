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
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;


//Logging and Diagnostics
import java.util.logging.*;  //Logging and Diagnostics


public class SmartHomeGUIClient extends JFrame
{
    //Instance Variable
    private ManagedChannel channel;
    private StreamingClientServiceGrpc.StreamingClientServiceStub stub;
    private LightServicesGrpc.LightServicesBlockingStub lightBlockingStub;
    private LockServicesGrpc.LockServicesBlockingStub lockBlockingStub;

    private static boolean streaming = true; //Responsible to stop my streaming client information

    private myGUI myClientGUI;







    //Logging and Diagnostics
    private static final Logger logger = Logger.getLogger(SmartHomeGUIClient.class.getName());







    //Constructor:
    public SmartHomeGUIClient(myGUI myClientGUI)
    {
        this.myClientGUI = myClientGUI;
    }









    public SmartHomeGUIClient()
    {}








    //Constructor: Responsible to set communication to client
    public SmartHomeGUIClient(String host, int port, String stub)
    {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext(), stub);
        lightBlockingStub = LightServicesGrpc.newBlockingStub(channel);             //Synchronous approach
        //logger.info("LOG client - Constructor host, port, stub");
    }

    //Constructor: Make possible to create a SmartHomeClient instance by passing a ManagedChannelBuilder object as an argument
    public SmartHomeGUIClient(ManagedChannelBuilder<?> channelBuilder, String stub)
    {
        //It is called to build a communication channel gRPC
        channel = channelBuilder.build();

        //Synchronous approach: Used to make the gRPC calls to the server waiting (blocking) until get the answer using the channel created
        lightBlockingStub = LightServicesGrpc.newBlockingStub(channel);
        lockBlockingStub = LockServicesGrpc.newBlockingStub(channel);
        this.stub = StreamingClientServiceGrpc.newStub(channel);
    }

    //Method: Close the connection before
    public void shutdown() throws InterruptedException
    {
        //channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        logger.info(" this is the SHUTDOWN: awaitTermination 5 secs");
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);

    }





    /*  from lecture examples
        _____________________________________________
        !!! Smart Devices - Lights and Locks  !!!

        Here are where all method's to switch off/on
        The idea is to send request to the server
        and get response from the server
        _____________________________________________
    */


    //Method: Responsible to control the lights
    public void controlLights(boolean lightOn)
    {
        LightRequest request = LightRequest.newBuilder().setLightOn(lightOn).build();
        LightResponse response = lightBlockingStub.controlLights(request);
        System.out.println("Response: " + response.getMessage());
        //myClientGUI.appendMessage("Response: " + response.getMessage());
        JOptionPane.showMessageDialog(null, "Server Response: " + response.getMessage(),
                "Server Response", JOptionPane.INFORMATION_MESSAGE);
    }

    //Method: Responsible to control the locks
    public void controlLocks(boolean lockOpen)
    {
        LockRequest request = LockRequest.newBuilder().setLockOpen(lockOpen).build();
        LockResponse response = lockBlockingStub.controlLocks(request);
        System.out.println("Response: " + response.getMessage());
    }
















    /*  from lecture examples
        ___________________________________
        !!! Streaming client information !!!

        Here are where all method's PING
        The idea is get response from the user
        ___________________________________
    */







    public void sendUnaryRequest(String name)
    {
        UnaryRequest request = UnaryRequest.newBuilder()
                .setName(name)
                .build();

        System.out.println("You are streaming your information to the server");

        stub.sendUnaryRequest(request, new StreamObserver<UnaryResponse>()
        {
            @Override
            public void onNext(UnaryResponse response)
            {
                JOptionPane.showMessageDialog(null,
                        response.getMessage(),
                        "Unary Response from Server", JOptionPane.INFORMATION_MESSAGE);

                System.out.println("Unary response from server: " + response.getMessage());

            }

            @Override
            public void onError(Throwable t)
            {
                JOptionPane.showMessageDialog(null,
                        t.getMessage(),
                        "Unary Response from Server", JOptionPane.ERROR_MESSAGE);
            }

            @Override
            public void onCompleted()
            {
                JOptionPane.showMessageDialog(null,
                        "Unary request completed",
                        "Unary Response from Server", JOptionPane.INFORMATION_MESSAGE);

                System.out.println("Unary request completed");

            }
        });
    }









    public void streamClientInformation(String clientName)
    {
        StreamObserver<ClientInformation> requestObserver = stub.streamClientInformation(new StreamObserver<ServerResponse>() {
            @Override
            public void onNext(ServerResponse response) {
                System.out.println("Server response: " + response.getMessage());
                //"I CANNOT SEND"
                //myClientGUI.appendMessage("Stop Streaming...");//send to JTextArea
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in streaming client information: " + t.getMessage());
                //"I CANNOT SEND"
                //myClientGUI.appendMessage("Error in streaming client information: " + t.getMessage());//send to JTextArea
            }

            @Override
            public void onCompleted() {
                System.out.println("Streaming client information completed");
                //"I CANNOT SEND"
                //myClientGUI.appendMessage("Streaming client information completed");//send to JTextArea
            }

        });

        try
        {
           while (streaming())
            {
                String dateTime = LocalDateTime.now().toString();
                ClientInformation clientInfo = ClientInformation.newBuilder()
                        .setClientName(clientName)
                        .setDateTime(dateTime)
                        .build();
                requestObserver.onNext(clientInfo);
                Thread.sleep(5000); // Send information every 5 seconds
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

        }
        requestObserver.onCompleted();
    }




    public static boolean streaming()
    {
        return streaming;
    }


    //Method: change the status of streaming boolean
    public static void setStreaming(boolean value)
    {
        streaming = value;
    }















    /*
        __________________________________________________________
                    !!! Thermostats CLIENT !!!

        Here are where all method's related Temperature are
        The idea is set and get updates between Server and Client
        ___________________________________________________________
    */

    //Method: This method allows the user set the temp. Using this on the button SmartThermostats
    public void setYourTemp (String setTemp)
    {
        //Create a channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();


        try {


            //Create a stub for the bidirectional service
            BidirectionalStreamingServiceGrpc.BidirectionalStreamingServiceStub stubBI = BidirectionalStreamingServiceGrpc.newStub(channel);

            //Create a response observer for the server streaming
            StreamObserver<BidirectionalResponse> responseObserver = new StreamObserver<BidirectionalResponse>() {
                @Override
                public void onNext(BidirectionalResponse response) {
                    myClientGUI.appendMessage("Server message: " + response.getMessage()); //send to JTextArea
                    System.out.println("Server message: " + response.getMessage());
                    onCompleted();
                }

                //This is call when the CLIENT is not connected with the SERVER
                @Override
                public void onError(Throwable t) {
                    JOptionPane.showMessageDialog(null,
                            "Error from the server " + t.getMessage() + "\nYou are disconnected from the server.",
                            "Smart Home CA - Client", JOptionPane.ERROR_MESSAGE);
                    System.err.println("Error from server: " + t.getMessage());
                    myClientGUI.appendMessage("Error from server: " + t.getMessage()); //send to JTextArea
                }

                @Override
                public void onCompleted() {
                    System.out.println("Client stream completed. The temperature has been changed to " + setTemp + "ºC");
                    myClientGUI.appendMessage("Client stream completed. The temperature has been changed to " + setTemp + "ºC");//send to JTextArea
                }
            };

            //Create a request observer for the client streaming
            StreamObserver<BidirectionalRequest> requestObserver = stubBI.bidirectionalStream(responseObserver);

            //get the input from the user
            //setTemp = JOptionPane.showInputDialog(null, "Please enter the temp");

            String message = "The temperature has been requested by the user as: " + setTemp + "ºC";
            BidirectionalRequest request = BidirectionalRequest.newBuilder()
                    .setMessage(setTemp)
                    .build();

            JOptionPane.showMessageDialog(null,
                    message,
                    "Client Side", JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Sending message to server: " + message);
            requestObserver.onNext(request);

        }
        finally
        {
            channel.shutdown();
            logger.info("LOG client - setYourTemp() close the channel");
        }
    }














    //Method: This will send to the users random forecast, without the user ask
    public void getForecast()
    {
        //Create a channel to the server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();

        //Create a stub for the bidirectional service
        BidirectionalStreamingServiceGrpc.BidirectionalStreamingServiceStub stubBI = BidirectionalStreamingServiceGrpc.newStub(channel);

        //Create a response observer for the server streaming
        StreamObserver<WeatherForecastResponse> weatherForecastResponseStreamObserver = new StreamObserver<WeatherForecastResponse>()
        {
            @Override
            public void onNext(WeatherForecastResponse weatherForecastResponse)
            {

                String msgRequest = "Client Request: What is the forecast for tomorrow." ;
                String msgResponse = "Server Response: " + weatherForecastResponse.getMessage();

                myClientGUI.appendMessage(msgRequest); //send to JTextArea
                myClientGUI.appendMessage(msgResponse); //send to JTextArea

                //System.out.println("The client requested the forecast for tomorrow.");
                //System.out.println("Server Response: " + weatherForecastResponse.getMessage());

            }

            @Override
            public void onError(Throwable throwable)
            {
                JOptionPane.showMessageDialog(null,
                        "Error from client:" + throwable.getMessage() +
                        "\nYou have no connection to the server",
                        "Smart Home CA - Client", JOptionPane.ERROR_MESSAGE);
                System.err.println("ERROR !!!!!!!");
            }

            @Override
            public void onCompleted()
            {
                myClientGUI.appendMessage("OnCompleted"); //send to JTextArea
            }
        };

        //Create a request observer for the client streaming
        StreamObserver<WeatherForecastRequest> weatherForecastRequestStreamObserver = stubBI.weatherForecast(weatherForecastResponseStreamObserver);
        try
        {
            //Build and send a request
            WeatherForecastRequest requestForecast = WeatherForecastRequest.newBuilder().build();
            weatherForecastRequestStreamObserver.onNext(requestForecast);

        }

        catch (Exception e)
        {
            System.err.println("ERROR!!!! --- Error while sending messages: " + e.getMessage());
            myClientGUI.appendMessage("ERROR!!!! --- Error while sending messages: " + e.getMessage()); //send to JTextArea
        }

        // Mark the end of requests to the server
        weatherForecastRequestStreamObserver.onCompleted();

        //Shutdown the channel gracefully
        try
        {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
            channel.shutdown();
            logger.info("LOG client - forecast() close the channel");
        }

        catch (InterruptedException e)
        {
            myClientGUI.appendMessage("Interrupted while shutting down the channel: " + e.getMessage()); //send to JTextArea
            System.err.println("Interrupted while shutting down the channel: " + e.getMessage());
            Thread.currentThread().interrupt();

            //channel.shutdown();
            logger.info("LOG client - setYourTemp() catch InterruptedE");
        }
    }








    public static void main(String[] args) throws InterruptedException
    {
        //Constructor: myGUI
        new myGUI();
    }
}