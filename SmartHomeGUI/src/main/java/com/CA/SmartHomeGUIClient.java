package com.CA;

import com.CA.gRPC.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



public class SmartHomeGUIClient extends JFrame
{
    //Instance Variable
    private ManagedChannel channel;
    private StreamingClientServiceGrpc.StreamingClientServiceStub stub;

    private myGUI myClientGUI;



    public SmartHomeGUIClient(myGUI myClientGUI)
    {
        this.myClientGUI = myClientGUI;
    }






    public SmartHomeGUIClient()
    {}








    //Constructor:Responsible to get 3 parameters
    public SmartHomeGUIClient(String host, int port, String stub)
    {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext(), stub);
    }

    //Constructor: Make possible to create a SmartHomeClient instance by passing a ManagedChannelBuilder object as an argument
    public SmartHomeGUIClient(ManagedChannelBuilder<?> channelBuilder, String stub)
    {
        channel = channelBuilder.build();                       //It is called to build a communication channel
        //lightBlockingStub = LightServicesGrpc.newBlockingStub(channel);  //Used to make RPC calls to the server
        //lockBlockingStub = LockServicesGrpc.newBlockingStub(channel);
        this.stub = StreamingClientServiceGrpc.newStub(channel);

    }

    //Method: Close the connection before
    public void shutdown() throws InterruptedException
    {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }










    /*
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
        stub.sendUnaryRequest(request, new StreamObserver<UnaryResponse>()
        {
            @Override
            public void onNext(UnaryResponse response)
            {
                JOptionPane.showMessageDialog(null, response.getMessage(), "Unary Response from Server", JOptionPane.INFORMATION_MESSAGE);

            }

            @Override
            public void onError(Throwable t)
            {
                JOptionPane.showMessageDialog(null, t.getMessage(),"Unary Response from Server", JOptionPane.ERROR_MESSAGE);
            }

            @Override
            public void onCompleted()
            {
                JOptionPane.showMessageDialog(null,"Unary request completed", "Unary Response from Server", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }










    public void streamClientInformation(String clientName)
    {
        StreamObserver<ClientInformation> requestObserver = stub.streamClientInformation(new StreamObserver<ServerResponse>() {
            @Override
            public void onNext(ServerResponse response) {
                System.out.println("Server response: " + response.getMessage());
                myClientGUI.appendMessage("Server response: " + response.getMessage());//send to JTextArea
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in streaming client information: " + t.getMessage());
                myClientGUI.appendMessage("Error in streaming client information: " + t.getMessage());//send to JTextArea
            }

            @Override
            public void onCompleted() {
                System.out.println("Streaming client information completed");
                myClientGUI.appendMessage("Streaming client information completed");//send to JTextArea
            }
        });

        try {
            while (true) {
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









    /*
        __________________________________________________________
                    !!! Thermostats CLIENT !!!

        Here are where all method's related temp are
        The idea is set and get updates between Server and Client
        ___________________________________________________________
    */

    //Method: This method allows the user set the temp. Using this on the button SmartThermostats
    public void setYourTemp (String setTemp)
    {
        //Create a channel to the server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();

        //Create a stub for the bidirectional service
        BidirectionalStreamingServiceGrpc.BidirectionalStreamingServiceStub stubBI = BidirectionalStreamingServiceGrpc.newStub(channel);

        //Create a response observer for the server streaming
        StreamObserver<BidirectionalResponse> responseObserver = new StreamObserver<BidirectionalResponse>()
        {
            @Override
            public void onNext(BidirectionalResponse response)
            {
                myClientGUI.appendMessage("Server message: " + response.getMessage()); //send to JTextArea
                System.out.println("Server message: " + response.getMessage());
            }

            //This is call when the CLIENT is not connected with the SERVER
            @Override
            public void onError(Throwable t)
            {
                JOptionPane.showMessageDialog(null,
                        "Error from the server " + t.getMessage() + "\nYou are disconnected from the server.",
                        "Smart Home CA - Client", JOptionPane.ERROR_MESSAGE);
                System.err.println("Error from server: " + t.getMessage());
                myClientGUI.appendMessage("Error from server: " + t.getMessage()); //send to JTextArea
            }

            @Override
            public void onCompleted()
            {
                System.out.println("Server stream completed");
                myClientGUI.appendMessage("Server stream completed");//send to JTextArea
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

        JOptionPane.showMessageDialog(null, message, "Client Side", JOptionPane.INFORMATION_MESSAGE);
        //System.out.println("Sending message to server: " + message);
        requestObserver.onNext(request);
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
                System.out.println("Msg from the server -> " + weatherForecastResponse.getMessage() );
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
                myClientGUI.appendMessage("onCompleted"); //send to JTextArea
                System.out.println("onCompleted");
            }
        };

        //Create a request observer for the client streaming
        StreamObserver<WeatherForecastRequest> weatherForecastRequestStreamObserver = stubBI.weatherForecast(weatherForecastResponseStreamObserver);
        try
        {

            WeatherForecastRequest requestForecast = WeatherForecastRequest.newBuilder()
                    .build();

            myClientGUI.appendMessage("Client is requesting the forecast for tomorrow."); //send to JTextArea
            System.out.println("Client is requesting the forecast for tomorrow.");
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
        }

        catch (InterruptedException e)
        {
            myClientGUI.appendMessage("Interrupted while shutting down the channel: " + e.getMessage()); //send to JTextArea
            System.err.println("Interrupted while shutting down the channel: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }








    public static void main(String[] args) throws InterruptedException
    {
        //Constructor: myGUI
        new myGUI();
    }
}