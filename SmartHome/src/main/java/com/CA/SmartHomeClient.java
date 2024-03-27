package com.CA;

import com.CA.gRPC.LightRequest;
import com.CA.gRPC.LightResponse;
import com.CA.gRPC.SmartHomeGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

public class SmartHomeClient {
    private final ManagedChannel channel;
    private final SmartHomeGrpc.SmartHomeBlockingStub blockingStub;

    public SmartHomeClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
    }

    public SmartHomeClient(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();
        blockingStub = SmartHomeGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
    }

    public void controlLights(boolean lightOn)
    {
        LightRequest request = LightRequest.newBuilder().setLightOn(lightOn).build();
        LightResponse response = blockingStub.controlLights(request);
        System.out.println("Response: " + response.getMessage());
    }

    public static void main(String[] args)
    {
        SmartHomeClient client = new SmartHomeClient("localhost", 8081);
        try {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;
            while (running) {
                System.out.println("*** CA - Smart Home ***");
                System.out.println("1. Turn on lights");
                System.out.println("2. Turn off lights");
                System.out.println("3. Check status");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
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
            }
        } finally {
            try {
                client.shutdown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
