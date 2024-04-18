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
import javafx.application.Platform;
import javafx.scene.chart.XYChart;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

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
    private final SmartDoorServicesGrpc.SmartDoorServicesBlockingStub smartDoorServicesBlockingStub;
    private final SmartAlarmServicesGrpc.SmartAlarmServicesBlockingStub smartAlarmServicesBlockingStub;
    private final EnvironmentMgmtServicesGrpc.EnvironmentMgmtServicesBlockingStub environmentMgmtServicesBlockingStub;


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
        smartDoorServicesBlockingStub = SmartDoorServicesGrpc.newBlockingStub(channel);
        smartAlarmServicesBlockingStub = SmartAlarmServicesGrpc.newBlockingStub(channel);
        environmentMgmtServicesBlockingStub = EnvironmentMgmtServicesGrpc.newBlockingStub(channel);
    }

    //Method: Close the connection before
    public void shutdown() throws InterruptedException
    {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /*
        ====================================
            Implement Method - Unary RPC
        ====================================
     */

    // Client-side logic for interacting with the gRPC service.
    public StringBuilder greet(String name) throws StatusException
    {
        // Creating a request with the user's name.
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();

        //To allow to display a msg
        StringBuilder serverResponse = new StringBuilder();

        try
        {
            //Create a local variable and call the method
            HelloReply response = greeterBlockingStub.sayHello(request);

            //This will send the msg to TextFlow
            serverResponse.append(response.getMessage());

            System.out.println("Hello " + response.getMessage()); //just a test
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return serverResponse;
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








    /** Home Security Proto: Implementation of Unary RCP Request*/
    // Client-side logic for interacting with the gRPC service.
    public void openDoorID (String doorID)
    {
        OpenRequest openDoorIDRequest = OpenRequest.newBuilder().setDoorID(doorID).build();
        OpenResponse openDoorIDResponse = smartDoorServicesBlockingStub.openDoor(openDoorIDRequest);
        System.out.println("Client-Side getting the answer " + openDoorIDResponse.getStatus() + doorID);
    }

    /** Home Security Proto: Implementation of Unary RCP Request*/
    public void closeDoorID (String doorID)
    {
        CloseRequest closeDoorIDRequest = CloseRequest.newBuilder().setDoorID(doorID).build();
        CloseResponse closeDoorIDResponse = smartDoorServicesBlockingStub.closeDoor(closeDoorIDRequest);
        System.out.println("Client-Side getting the answer: " + closeDoorIDResponse.getStatus() + doorID);
    }

    /** Home Security Proto: Implementation of Unary RCP Request*/
    public void turnOffAlarm ()
    {
        TurnOffAlarmRequest turnOffAlarmRequest = TurnOffAlarmRequest.newBuilder().setTurnOff("Alarm Off").build();
        TurnOffAlarmResponse turnOffAlarmResponse = smartAlarmServicesBlockingStub.turnOffAlarm(turnOffAlarmRequest);
        System.out.println("Client-Side getting the answer: " + turnOffAlarmResponse.getStatusOff());

    }

    /** Home Security Proto: Implementation of Unary RCP Request */
    public void turnOnAlarm()
    {
        TurnOnAlarmRequest turnOnAlarmRequest = TurnOnAlarmRequest.newBuilder().setTurnOn("Alarm On").build();
        TurnOnAlarmResponse turnOnAlarmResponse = smartAlarmServicesBlockingStub.turnOnAlarm(turnOnAlarmRequest).next();
        System.out.println("Alarm activation request sent." + turnOnAlarmResponse.getStatusOn());
    }

    /** Environment Management Proto (Forecast): Implementation of Unary RCP */
    public void forecast()
    {
        /*
        ForecastRequest forecastRequestToday = ForecastRequest.newBuilder()
                .setMsgRequest("Please tell me the forecast for Today").build();
        ForecastResponse forecastResponseToday = environmentMgmtServicesBlockingStub.forecast(forecastRequestToday);
        System.out.println("From the Server: The forecast for Today is " + forecastResponseToday.getMsgResponse() + " ºC");

        //Building....
        ForecastRequest forecastRequestTomorrow = ForecastRequest.newBuilder()
                .setMsgRequestTomorrow("Please tell me the forecast for Tomorrow").build();


         */
    }

    /** Environment Management Proto (Switch ON): Implementation of Unary RCP */






    /*
    public int switchOn (int temperature)
    {
        switchOnRequest switchOnRequest = com.CA.gRPC.switchOnRequest.newBuilder().setTemperature(temperature).build();

        switchOnResponse switchOnResponse = environmentMgmtServicesBlockingStub.switchOn(switchOnRequest).next();
        System.out.println("From the Server: Your temperature has been set to: " + switchOnResponse.getStatusTemperature() + "ºC");


        return temperature;

    }

     */















    public static void main(String[] args) throws StatusException
    {

        //Instance Variables
        String host = "localhost";
        int port = 8081;

        //SmartServer myServer = new SmartServer(port);

        SmartClient myClient = new SmartClient(host, port);
        try
        {
            XYChart.Series<Number, Number> series = new XYChart.Series<>();
            myClient.setPointUser(1 , series);
        }

        catch (StatusException e)
        {
            e.printStackTrace();
        }







    }
}