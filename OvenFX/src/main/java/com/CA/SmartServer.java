/*
  CA - Distributed System
  Author: Sergio Oliveira - x23170981@student.ncirl.ie
  Date: 13 Apr 2024

  Lecturer: Mark Cudden

  References:
    https://grpc.io/docs/languages/java/quickstart/
    https://grpc.io/docs/languages/java/basics/

    SERVER SIDE
 */


package com.CA;

import com.CA.gRPC.GreeterGrpc;
import com.CA.gRPC.HelloReply;
import com.CA.gRPC.HelloRequest;


import com.CA.gRPC.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;



public class SmartServer
{
    //Instance Variables
    int port;
    Server server;


    //Constructor: Start up a gRPC server so that clients can actually use our service.
    public SmartServer (int port)
    {
        this(ServerBuilder.forPort(port), port);
    }

    //Constructor: Create a RouteGuide server using serverBuilder as a base and features as data.
    public SmartServer(ServerBuilder<?> serverBuilder, int port)
    {
        this.port = port;
    }





    //Implementation of the gRPC service "Greater" on the server-side.
    //The class extends the generated GreeterGrpc.GreeterImplBase abstract class:
    private static class GreeterService extends GreeterGrpc.GreeterImplBase
    {
        @Override
        public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver)
        {
            super.sayHello(request, responseObserver);

        }
    }

}
