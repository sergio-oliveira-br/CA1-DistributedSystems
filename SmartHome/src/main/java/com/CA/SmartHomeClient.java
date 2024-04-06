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
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class SmartHomeClient
{
    //Instance Variable
    private final ManagedChannel channel;
    private final LightServicesGrpc.LightServicesBlockingStub lightBlockingStub;
    private final LockServicesGrpc.LockServicesBlockingStub lockBlockingStub;
    private final StreamingClientServiceGrpc.StreamingClientServiceStub stub;

     /*
        ___________________________________
        !!! Lights and Locks Control !!!

        Here are where all method's to control are
        The idea is the user send requests to
        turn on/turn off or open/close to the server
        ___________________________________
    */

    //Constructor:Responsible to get 3 parameters
    public SmartHomeClient(String host, int port, String stub)
    {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext(), stub);
    }

    //Constructor: Make possible to create a SmartHomeClient instance by passing a ManagedChannelBuilder object as an argument
    public SmartHomeClient(ManagedChannelBuilder<?> channelBuilder, String stub)
    {
        channel = channelBuilder.build();                       //It is called to build a communication channel
        lightBlockingStub = LightServicesGrpc.newBlockingStub(channel);  //Used to make RPC calls to the server
        lockBlockingStub = LockServicesGrpc.newBlockingStub(channel);
        this.stub = StreamingClientServiceGrpc.newStub(channel);

    }

    //Method: Close the connection before
    public void shutdown() throws InterruptedException
    {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    //Method: Responsible to control the lights
    public void controlLights(boolean lightOn)
    {
        LightRequest request = LightRequest.newBuilder().setLightOn(lightOn).build();
        LightResponse response = lightBlockingStub.controlLights(request);
        System.out.println("Response: " + response.getMessage());
    }

    //Method: Responsible to control the locks
    public void controlLocks(boolean lockOpen)
    {
        LockRequest request = LockRequest.newBuilder().setLockOpen(lockOpen).build();
        LockResponse response = lockBlockingStub.controlLocks(request);
        System.out.println("Response: " + response.getMessage());
    }

    public static void menuHome()
    {
        System.out.println("\nCA1 - Smart Home");
        System.out.println("      *** ");
        System.out.println("1. Smart Devices");
        System.out.println("2. Smart Thermostats");
        System.out.println("3. Your Connection");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    public  static void menuSmartDevices()
    {
        System.out.println("\nCA1 - Smart Home");
        System.out.println("Menu - Smart Devices");
        System.out.println("    *** ");
        System.out.println("1. Lighting");
        System.out.println("2. Lockers");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    public static void menuLocationLights()
    {
        System.out.println("\nCA1 - Smart Home");
        System.out.println("Menu - Lighting");
        System.out.println("    *** ");
        System.out.println("1. Living Room");
        System.out.println("2. Kitchen");
        System.out.println("3. Laundry Facilities");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    public static void menuLights()
    {
        //System.out.println("CA1 - Smart Home");
        System.out.println("    --- ");
        System.out.println("1. Turn on lights");
        System.out.println("2. Turn off lights");
        System.out.println("3. Check status");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    public static void menuLocationLockers()
    {
        System.out.println("\nCA1 - Smart Home");
        System.out.println("Menu - Lockers");
        System.out.println("    *** ");
        System.out.println("1. Main Door");
        System.out.println("2. Back Door");
        System.out.println("3. Front Gate");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    public static void menuLockers()
    {
        System.out.println("    --- ");
        System.out.println("1. Locked");
        System.out.println("2. Unlocked");
        System.out.println("3. Check status");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
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
            public void onNext(UnaryResponse response) {
                System.out.println("Unary response from server: " + response.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in unary request: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Unary request completed");
                System.out.println("-------");
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

    /*
        __________________________________________________________
                    !!! Thermostats Services !!!

        Here are where all method's related temp are
        The idea is set and get updates between Server and Client
        ___________________________________________________________
    */

    public static void main(String[] args)
    {
        SmartHomeClient client = new SmartHomeClient("localhost", 8081, "Sergio Oliveira");

        try
        {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;
            while (running)
            {
                menuHome();
                int userOptionHome = scanner.nextInt();
                switch (userOptionHome)
                {
                    case 1:
                        menuSmartDevices();
                        int userOptionSmartDevices = scanner.nextInt();
                        switch (userOptionSmartDevices)
                        {
                            //Smart Devices - Lights
                            case 1:
                                menuLocationLights();
                                int userOptionMenuLocationLights = scanner.nextInt();
                                switch (userOptionMenuLocationLights)
                                {
                                    //Living Room
                                    case 1:
                                        System.out.println("\n    ***");
                                        System.out.println("Living Room");
                                        menuLights();
                                        int userOptionOnOffLivingRoom = scanner.nextInt();
                                        switch (userOptionOnOffLivingRoom)
                                        {
                                            //Turned on lights
                                            case 1:
                                                client.controlLights(true);
                                                break;

                                            //Turned off lights
                                            case 2:
                                                client.controlLights(false);
                                                break;

                                            //Check the status
                                            case 3:
                                                System.out.println("NEED TO DO!!!!!"); //NEED TO DO
                                                break;
                                        }
                                        break;

                                    //Kitchen
                                    case 2:
                                        System.out.println("\n    ***");
                                        System.out.println("Kitchen");
                                        menuLights();
                                        int userOptionOnOffKitchen = scanner.nextInt();
                                        switch (userOptionOnOffKitchen)
                                        {
                                            //Turned on lights
                                            case 1:
                                                client.controlLights(true);
                                                break;

                                            //Turned off lights
                                            case 2:
                                                client.controlLights(false);
                                                break;

                                            //Check the status
                                            case 3:
                                                System.out.println("NEED TO DO!!!!!"); //NEED TO DO
                                                break;
                                        }
                                        break;

                                    //Laundry
                                    case 3:
                                        System.out.println("\n    ***");
                                        System.out.println("Laundry Facilities");
                                        menuLights();
                                        int userOptionOnOffLaundry = scanner.nextInt();
                                        switch (userOptionOnOffLaundry)
                                        {
                                            //Turned on lights
                                            case 1:
                                                client.controlLights(true);
                                                break;

                                            //Turned off lights
                                            case 2:
                                                client.controlLights(false);
                                                break;

                                            //Check the status
                                            case 3:
                                                System.out.println("NEED TO DO!!!!!"); //NEED TO DO
                                                break;
                                        }
                                        break;
                                }
                                break;

                            //Smart Devices - Locks
                            case 2:
                                menuLocationLockers();
                                int userOptionMenuLocks = scanner.nextInt();
                                switch (userOptionMenuLocks)
                                {
                                    //Main Door
                                    case 1:
                                        System.out.println("\n    ***");
                                        System.out.println(" Main Door");
                                        menuLockers(); //NEED TO CHANGE THE NAME
                                        int userOptionOpenedClosedMainDoor = scanner.nextInt();
                                        switch (userOptionOpenedClosedMainDoor)
                                        {
                                            //Open
                                            case 1:
                                                client.controlLocks(true);
                                                break;

                                            //Close
                                            case 2:
                                                client.controlLocks(false);
                                                break;

                                            //Check the status
                                            case 3:
                                                System.out.println("NEED TO DO!!!!!"); //NEED TO DO
                                                break;
                                        }
                                        break;

                                    //Back Door
                                    case 2:
                                        System.out.println("\n    ***");
                                        System.out.println(" Back Door");
                                        menuLockers(); //NEED TO CHANGE THE NAME
                                        int userOptionOpenedClosedBackDoor = scanner.nextInt();
                                        switch (userOptionOpenedClosedBackDoor)
                                        {
                                            //Open
                                            case 1:
                                                client.controlLocks(true);
                                                break;

                                            //Close
                                            case 2:
                                                client.controlLocks(false);
                                                break;

                                            //Check the status
                                            case 3:
                                                System.out.println("NEED TO DO!!!!!"); //NEED TO DO
                                                break;
                                        }
                                        break;


                                    //Gate
                                    case 3:
                                        System.out.println("\n    ***");
                                        System.out.println(" Front Gate");
                                        menuLockers(); //NEED TO CHANGE THE NAME
                                        int userOptionOpenedClosedGate = scanner.nextInt();
                                        switch (userOptionOpenedClosedGate)
                                        {
                                            //Open
                                            case 1:
                                                client.controlLocks(true);
                                                break;

                                            //Close
                                            case 2:
                                                client.controlLocks(false);
                                                break;

                                            //Check the status
                                            case 3:
                                                System.out.println("NEED TO DO!!!!!"); //NEED TO DO
                                                break;
                                        }
                                        break;
                                }
                                break;

                        }
                        break;

                    //Smart Thermostats
                    case 2:
                        System.out.println("\n-------");
                        System.out.println("Smart Thermostats");

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
                                System.out.println("Server WORKING HERE message: " + response.getMessage());
                            }

                            @Override
                            public void onError(Throwable t)
                            {
                                System.err.println("Error from server: " + t.getMessage());
                            }

                            @Override
                            public void onCompleted()
                            {
                                System.out.println("Server stream completed");
                            }
                        };

                        // Create a request observer for the client streaming
                        StreamObserver<BidirectionalRequest> requestObserver = stubBI.bidirectionalStream(responseObserver);

                        System.out.println("      ***");
                        System.out.println("1. Set a Room Temperature");
                        System.out.println("2. Get Weather Forecast");

                        int inputUserThermostats = scanner.nextInt();

                        if(inputUserThermostats == 1)
                        {
                            try
                            {
                                // Send some messages to the server
                                System.out.print("Gotcha! \nWhat is your preferred room temperature?");
                                int setTemp = scanner.nextInt();

                                if (setTemp < 15 || setTemp > 25)
                                {
                                    System.err.println("Sorry! Unfortunately your request is out of the range." +
                                            "\nTry between (15ºC - 25ºC)");
                                    break;
                                }

                                else
                                {
                                    String message = "The temperature has been requested by the user as: " + setTemp + "ºC";
                                    BidirectionalRequest request = BidirectionalRequest.newBuilder()
                                            .setMessage(message)
                                            .build();

                                    System.out.println("Sending message to server: " + message);
                                    requestObserver.onNext(request);
                                }
                            }

                            catch (Exception e)
                            {
                                System.err.println("Error while sending messages: " + e.getMessage());
                            }

                            // Mark the end of requests to the server
                            requestObserver.onCompleted();

                            //Shutdown the channel gracefully
                            try
                            {
                                channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
                                break;
                            }

                            catch (InterruptedException e)
                            {
                                System.err.println("Interrupted while shutting down the channel: " + e.getMessage());
                                Thread.currentThread().interrupt();
                            }
                        }

                        else if (inputUserThermostats == 2)
                        {
                            //Create a channel to the server ->                 !Its already created
                            //Create a stub for the bidirectional service ->    !Its already created


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
                                    System.err.println("ERROR !!!!!!!");
                                }

                                @Override
                                public void onCompleted()
                                {
                                    System.out.println("onCompleted");
                                }
                            };

                            //Create a request observer for the client streaming
                            StreamObserver<WeatherForecastRequest> weatherForecastRequestStreamObserver = stubBI.weatherForecast(weatherForecastResponseStreamObserver);
                            try
                            {

                                WeatherForecastRequest requestForecast = WeatherForecastRequest.newBuilder()
                                        .build();

                                System.out.println("Client is requesting the forecast for the next day.");
                                weatherForecastRequestStreamObserver.onNext(requestForecast);
                            }

                            catch (Exception e)
                            {
                                System.err.println("ERROR!!!! --- Error while sending messages: " + e.getMessage());
                            }

                            // Mark the end of requests to the server
                            weatherForecastRequestStreamObserver.onCompleted();

                            //Shutdown the channel gracefully
                            try
                            {
                                channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
                                break;
                            }

                            catch (InterruptedException e)
                            {
                                System.err.println("Interrupted while shutting down the channel: " + e.getMessage());
                                Thread.currentThread().interrupt();
                            }
                            break;
                        }
                        break;


                        //Your connection (ping)
                    case 3:
                        System.out.println("\nYou are streaming information to sever");

                        String host = "localhost";
                        int port = 8081;
                        String stub = "Sergio Oliveira";

                        SmartHomeClient clientPing = new SmartHomeClient(host, port, stub);

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
                        break;

                    //Exit
                    case 4:
                        running = false;
                        break;

                    default:
                        System.out.println("Oops! Invalid option." +
                                "\nPlease choose again.");
                        break;
                }
            }
        }

        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        finally
        {
            try
            {
                client.shutdown();
            }

            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
