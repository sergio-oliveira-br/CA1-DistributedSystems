package com.CA;

import com.CA.gRPC.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

public class SmartHomeClient
{
    //Instance Variable
    private final ManagedChannel channel;
    private final LightServicesGrpc.LightServicesBlockingStub lightBlockingStub;
    private final LockServicesGrpc.LockServicesBlockingStub lockBlockingStub;

    //Constructor:Responsible to get 2 parameters, host and port
    public SmartHomeClient(String host, int port)
    {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());

    }

    //Constructor: Make possible to create a SmartHomeClient instance by passing a ManagedChannelBuilder object as an argument
    public SmartHomeClient(ManagedChannelBuilder<?> channelBuilder)
    {
        channel = channelBuilder.build();                       //It is called to build a communication channel
        lightBlockingStub = LightServicesGrpc.newBlockingStub(channel);  //Used to make RPC calls to the server
        lockBlockingStub = LockServicesGrpc.newBlockingStub(channel);
    }

    //Method: Close the connection before
    public void shutdown() throws InterruptedException
    {
        channel.shutdown().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
    }

    //Method: Responsible to control the lights
    public void controlLights(boolean lightOn)
    {
        LightRequest request = LightRequest.newBuilder().setLightOn(lightOn).build();
        LightResponse response = lightBlockingStub.controlLights(request);
        System.out.println("Response: " + response.getMessage());
    }


    //Method: Responsible to control the lights
    public void controlLocks(boolean lockOpen)
    {
        LockRequest request = LockRequest.newBuilder().setLockOpen(lockOpen).build();
        LockResponse response = lockBlockingStub.controlLocks(request);
        System.out.println("Response: " + response.getMessage());
    }




    public static void menuHome()
    {
        System.out.println("\nCA1 - Smart Home");
        System.out.println("    *** ");
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
        System.out.println("1. The Living Room");
        System.out.println("2. Kitchen");
        System.out.println("3. Laundry Facilities");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }


    public static void menuLights()
    {
        System.out.println("\nCA1 - Smart Home");
        System.out.println("    *** ");
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
        System.out.println("3. Gate");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    public static void menuLockers()
    {
        System.out.println("\nCA1 - Smart Home");
        System.out.println("Menu - Lockers");
        System.out.println("    *** ");
        System.out.println("1. Locked");
        System.out.println("2. Unlocked");
        System.out.println("3. Check status");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    public static void main(String[] args)
    {
        SmartHomeClient client = new SmartHomeClient("localhost", 8081);

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
                                    //The Living Room
                                    case 1:
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
                                        System.out.println("Main Door");
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
                                        System.out.println("Back Door");


                                    break;


                                    //Gate
                                    case 3:
                                        System.out.println("Gate");
                                    break;
                                }
                                break;
                        }
                    break;

                    //Smart Thermostats
                    case 2:
                        System.out.println("Need to build... Therm!!!!!");
                    break;

                    //Your connection (ping)
                    case 3:
                        System.out.println("Need to build... PING     !!!!!");
                    break;

                    //Exit
                    case 4:
                        running = false;
                    break;

                    default:
                        System.out.println("Sorry, invalid option  =[ " +
                                            "\nPlease choose again.");
                }








            /*

                switch (option) {
                    case 1:
                        client.controlLights(true);
                        break;
                    case 2:
                        client.controlLights(false);
                        break;
                    case 3:
                        // Add logic to check status
                        System.out.println("Checking status...");
                        break;
                    case 4:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option! Please choose again.");
                }

             */
            }
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
