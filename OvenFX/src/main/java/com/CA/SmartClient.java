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

import com.CA.gRPC.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import static javafx.scene.input.KeyCode.X;

public class SmartClient
{
    /*
        ===========================
            Instance Variables
        ===========================
     */

    private final ManagedChannel channel;
    private final GreeterGrpc.GreeterBlockingStub greeterBlockingStub;
    private final TemperatureRampGrpc.TemperatureRampBlockingStub temperatureRampBlockingStub;


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

        //blocking/synchronous stub: this means that the RPC call waits for the server to respond,
        //and will either return a response or raise an exception
        greeterBlockingStub = GreeterGrpc.newBlockingStub(channel);
        temperatureRampBlockingStub = TemperatureRampGrpc.newBlockingStub(channel);
    }

    /*
        ====================================
            Implement Method - Unary RPC
        ====================================
     */

    // Client-side logic for interacting with the gRPC service.
    public void greet(String name) throws StatusException
    {
        // Creating a request with the user's name.
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();

        try
        {
            //Create a local variable and call the method
            HelloReply response = greeterBlockingStub.sayHello(request);
            System.out.println("Hello " + response.getMessage());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


     /*
        ======================================================
            Implement Method - Client-side streaming RPC

            A server-side streaming RPC where the client
            sends a request to the server and
            gets a stream to read a sequence of messages back.

            The client reads from the returned stream
            until there are no more messages.
        ======================================================
     */

    // Client-side logic for interacting with the gRPC service.
    public void setPointUser(int temp, XYChart.Series<Number, Number> series) throws StatusException
    {
        //Creating a request with the set point temperature
        SetPointTemp request = SetPointTemp.newBuilder().setSetTemp(temp).build();

        //Starts the Streaming
        StreamObserver<TempRamp> observer = new StreamObserver<TempRamp>()
        {
            @Override
            public void onNext(TempRamp tempRamp) {
                Platform.runLater(() ->
                {
                    series.getData().add(new XYChart.Data<>(tempRamp.getMessage(), tempRamp.getMessage()));
                });
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {

            }
        };
        TemperatureRampGrpc.TemperatureRampStub stub = TemperatureRampGrpc.newStub(channel);

        stub.sendTempData(request, observer);
    }





    public static void main(String[] args) throws StatusException
    {

        //Instance Variables
        String host = "localhost";
        int port = 8081;

        //SmartServer myServer = new SmartServer(port);

        SmartClient myClient = new SmartClient(host, port);
        try
        {
            myClient.greet("Sergio");

            XYChart.Series<Number, Number> series = new XYChart.Series<>();
            myClient.setPointUser(1, series);
        }

        catch (StatusException e)
        {
            e.printStackTrace();
        }
    }
}