/*
  CA - Distributed System
  Author: Sergio Oliveira - x23170981@student.ncirl.ie
  Date: 13 Apr 2024

  Lecturer: Mark Cudden

  References:
    https://grpc.io/docs/languages/java/quickstart/
    https://grpc.io/docs/languages/java/basics/

    CLIENT SIDE
 */


package com.CA;

import com.CA.gRPC.GreeterGrpc;
import com.CA.gRPC.HelloReply;
import com.CA.gRPC.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class SmartClient
{
    /*
        ===========================
            Instance Variables
        ===========================
     */

    private final ManagedChannel channel;
    private final GreeterGrpc.GreeterBlockingStub blockingStub;


    /*
        ===========================
            Instantiating a stub
        ===========================
     */

    //Constructor: Create a gRPC channel for our stub, specifying the port we want to connect
    public SmartClient(String host, int port)
    {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
    }

    //Constructor: Accessing SmartServer server using the existing channel.
    public SmartClient(ManagedChannelBuilder<?> channelBuilder)
    {
        channel = channelBuilder.build();

        //blocking/synchronous stub:
        //this means that the RPC call waits for the server to respond, and will either return a response or raise an exception
        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    /*
        ===========================
            Implement Method
        ===========================
     */

    // Client-side logic for interacting with the gRPC service.
    public void greet(String name)
    {
        // Creating a request with the user's name.
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();

        //Create a local variable and call the method
        HelloReply response;
        response = blockingStub.sayHello(request);

        System.out.println("Hi " + response.getMessage());
    }



    public static void main(String[] args)
    {

        SmartClient myClient = new SmartClient("localhost", 8081);
        myClient.greet("Sergio");

    }
}