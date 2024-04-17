import com.CA.SmartClient;
import com.CA.SmartServer;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


import javax.swing.*;
import java.io.IOException;
import java.util.Optional;

public class SmartScreenController
{
    @FXML
    private LineChart<Number, Number> myTempChart;
    @FXML
    private XYChart.Series<Number, Number> series;
    @FXML
    private XYChart.Series<Number, Number> temp;
    @FXML
    private TextFlow myText;

    /** Used to configure the initial state of the user interface
     *  and controller-related elements after initialization by JavaFX */
    @FXML
    private void initialize()
    {
        //This is the temperature Ramp showing dot by dot
        series = new XYChart.Series<>();
        series.setName("Temperature Ramp");
        myTempChart.getData().add(series);

        //This is the line that should display "dot by dot" the set point from the user
        temp = new XYChart.Series<Number, Number>();
        temp.setName("Set Point");
        myTempChart.getData().add(temp);


        //This is my ChoiceBox List -> https://www.youtube.com/watch?app=desktop&v=PPwVwpdYFeU&themeRefresh=1
        choiceBoxButton.setItems(FXCollections.observableArrayList("Main Door", "Back Door",
                                                                         "Front Gate", "Bedroom", "Office"));

        //Guide
        Text guideStep1 = new Text("Welcome to CA Distributed System.");
        myText.getChildren().add(guideStep1);

        Text guideStep2 = new Text("\nConnect to Server by clicking the 'Connect' button.");
        myText.getChildren().add(guideStep2);

        //Disabling the buttons
        sayHelloButton.setDisable(true);
        setTempButton.setDisable(true);
        disconnectButton.setDisable(true);
        //stopStreamButton.setDisable(true);





    }


    @FXML
    private Button connectionButton;
    /** Step 1: This button makes you connection to the Server
     * Approach: Does not apply to RPC */
    @FXML
    private void connectionAction(ActionEvent event)
    {
        SmartServer myServer = new SmartServer(8081);
        try {
            myServer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //myServer.blockUntilShutdown();

        Text guideStep3 = new Text("\nYour connection to the server is active");
        myText.getChildren().add(guideStep3);

        //Disabling the buttons
        connectionButton.setDisable(true);

        //Enabling the buttons
        sayHelloButton.setDisable(false);

    }






    @FXML
    private Button sayHelloButton;
    /** Step 2: This button "SayHello" makes you connection to the Server
     *  Approach: RPC Unary Request */
    @FXML
    private void sayHelloAction(ActionEvent event)
    {
        TextInputDialog myName = new TextInputDialog();
        myName.setTitle("CA - Distributed System");
        myName.setHeaderText("Welcome to Smart Oven");
        myName.setContentText("Please enter your name");

        //Display the dialog box and wait for user input
        Optional<String> result = myName.showAndWait();

        //Process
        result.ifPresent(name ->
        {
            SmartClient myClient = new SmartClient("localhost", 8081);

            try
            {
                StringBuilder greetingMessage = myClient.greet(name);
                Text messageText = new Text("\n" + greetingMessage + "\n");
                myText.getChildren().add(messageText);
            } catch (StatusException e) {
                throw new RuntimeException(e);
            }
        });

        //Disabling the buttons
        sayHelloButton.setDisable(true);


        //Enabling the buttons
        setTempButton.setDisable(false);

    }








    @FXML
    private Button setTempButton;
    /** Step 3: This button "setTemp" send numbers from the server to client
     *  Approach: RPC Stream Server
     *  Reference: <a href="https://docs.oracle.com/javafx/2/charts/line-chart.htm">...</a> */
    @FXML
    private void submitTempAction(ActionEvent event)
    {
        //Create a dialog box to request user input
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Input Dialog");
        dialog.setHeaderText("Please enter a number:");
        dialog.setContentText("Number:");

        //Display the dialog box and wait for user input
         Optional<String> result = dialog.showAndWait();

        // Process user input
        result.ifPresent(number ->
        {
            try
            {
                int setPoint = Integer.parseInt(number);
                SmartClient myClient = new SmartClient("localhost", 8081);
                myClient.setPointUser(setPoint, series);

                for(int i = 0; i < 50; i++)
                {
                    temp.getData().add(new XYChart.Data<Number, Number>(i, setPoint));
                }

                Text messageText = new Text("Set point set to: " + setPoint +"\n");
                myText.getChildren().add(messageText);
            }
            catch (NumberFormatException | StatusException e)
            {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        });

        //Disabling the buttons
        sayHelloButton.setDisable(true);

        //Enabling the buttons
        //disconnectButton.setDisable(false);
    }














    @FXML
    private Button disconnectButton;
    /** Step 5: This button ends (stop running) the connection to the Server
     * Approach: Does not apply to RPC */
    @FXML
    private void disconnectAction(ActionEvent event) throws InterruptedException
    {
        //Initialize Stub
        String host = "localhost";
        int port = 8081;

        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        SmartServer myServer = new SmartServer(8081);

        channel.shutdown();
        myServer.stop();

        Text guideStep5 = new Text("\nYou have been disconnected from the server");
        myText.getChildren().add(guideStep5);

        //Disabling the buttons
        sayHelloButton.setDisable(true);
        setTempButton.setDisable(true);
        disconnectButton.setDisable(true);

        //Enabling the buttons
        connectionButton.setDisable(false);

    }



    @FXML
    private Button openDoorButton;
    @FXML
    private void openDoorAction(ActionEvent event)
    {
        String doorID = choiceBoxButton.getValue();
        SmartClient myClient = new SmartClient("localhost", 8081);
        myClient.openDoorID(doorID); //this will send to my Terminal

        //this will send to my Text - I know is not the right thing, but is a contingency.
        Text messageText = new Text("\nYour " + doorID +" was opened");
        myText.getChildren().add(messageText);
    }

    @FXML
    private Button closeDoorButton;
    @FXML
    private void closeDoorAction(ActionEvent event)
    {
        String doorID = choiceBoxButton.getValue();
        SmartClient myClient = new SmartClient("localhost", 8081);
        myClient.closeDoorID(doorID); //this will send to my Terminal

        //this will send to my Text - I know is not the right thing, but is a contingency.
        Text messageText = new Text("\nYour " + doorID +" was closed");
        myText.getChildren().add(messageText);
    }

    @FXML
    private ChoiceBox<String> choiceBoxButton;
    @FXML
    private void choiceBoxAction(ActionEvent event)
    {
        //There is an array list the shows few options to user close or open the door
    }

    @FXML
    private Button turnOnAlarmButton;
    @FXML
    private void turnOnAlarmAction(ActionEvent event)
    {
        SmartClient myClient = new SmartClient("localhost", 8081);
        myClient.turnOnAlarm();

        Text messageText = new Text("\nThe alarm had been ACTIVATED");
        myText.getChildren().add(messageText);

    }


    @FXML
    private Button stopStreamAlarmButton;
    /** This button "stop" ends the stream request started on button Activate Alarm
     *  Approach: Unary RPC  */
    @FXML
    private void stopStreamAlarmAction(ActionEvent event)
    {
        SmartClient myClient = new SmartClient("localhost", 8081);
        myClient.turnOffAlarm(); //this will send to my Terminal






        Text messageText = new Text("\nThe alarm had been disabled");
        myText.getChildren().add(messageText);
    }




}
