package com.CA;

import com.CA.gRPC.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SmartHomeGUIClient extends JFrame
{
    //Instance Variable
    private final ManagedChannel channel;
    private StreamingClientServiceGrpc.StreamingClientServiceStub stub;

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

    public void sendUnaryRequest(String name) {
        UnaryRequest request = UnaryRequest.newBuilder()
                .setName(name)
                .build();
        stub.sendUnaryRequest(request, new StreamObserver<UnaryResponse>()
        {
            @Override
            public void onNext(UnaryResponse response)
            {
                JOptionPane.showMessageDialog(null, "Unary response from server:" +response.getMessage(), "Server", JOptionPane.INFORMATION_MESSAGE);
            }

            @Override
            public void onError(Throwable t)
            {
                JOptionPane.showMessageDialog(null, "Error in unary request: " + t.getMessage(),"Server", JOptionPane.ERROR_MESSAGE);
            }

            @Override
            public void onCompleted()
            {
                JOptionPane.showMessageDialog(null,"Unary request completed", "Server", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public void streamClientInformation(String clientName) {
        StreamObserver<ClientInformation> requestObserver = stub.streamClientInformation(new StreamObserver<ServerResponse>() {
            @Override
            public void onNext(ServerResponse response) {
                System.out.println("Server response: " + response.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in streaming client information: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Streaming client information completed");
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

    private static boolean streaming = true;








    public static void main(String[] args) throws InterruptedException
    {
        //Constructor: myGUI
        new myGUI();

        /*
        //Scanner
        Scanner scanner = new Scanner(System.in);

        //Instance Variable
        String host = "localhost";
        int port = 8081;
        String stub = "Sergio Oliveira";

        SmartHomeGUIClient clientPing = new SmartHomeGUIClient(host, port, stub);

        clientPing.sendUnaryRequest(stub); // Send unary request

        // Start streaming client information
        Thread streamThread = new Thread(() -> clientPing.streamClientInformation(stub));
        streamThread.start();

        // Wait for user input to stop streaming
        System.out.println("Press 'Q' to stop streaming client information");

        while (streaming)
        {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Q"))
            {
                streaming = false; //Stop the loop by setting the streaming to false
            }
        }

        // Shutdown client
        clientPing.shutdown();


         */


    }
}