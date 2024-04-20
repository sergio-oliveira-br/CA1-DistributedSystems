import com.CA.SmartClient;
import com.CA.SmartServer;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;
import java.io.IOException;
import java.util.Optional;


public class SmartScreenController
{
    @FXML
    private XYChart.Series<Number, Number> series;
    @FXML
    private XYChart.Series<Number, Number> temp;


    @FXML
    private TextFlow myText;
    @FXML
    private LineChart<Number, Number> myTempChartLine;
    @FXML
    private XYChart.Series<Number, Number> airTemperatureSeries;

    /** Used to configure the initial state of the user interface
     *  and controller-related elements after initialization by JavaFX */
    @FXML
    private void initialize()
    {
        //This is the temperature Ramp showing dot by dot
        series = new XYChart.Series<>();
        //series.setName("Temperature Ramp");
        //myTempChartLine.getData().add(series);

        //This is the line that should display "dot by dot" the set point from the user
        temp = new XYChart.Series<Number, Number>();
        //temp.setName("Set Point");
        //myTempChartLine.getData().add(temp);

        //This refers the Air Temperature
        airTemperatureSeries = new XYChart.Series<Number, Number>();
        airTemperatureSeries.setName(" Air Temperature");
        myTempChartLine.getData().add(airTemperatureSeries);

        //This is my ChoiceBox List -> https://www.youtube.com/watch?app=desktop&v=PPwVwpdYFeU&themeRefresh=1
        choiceBoxButton.setItems(FXCollections.observableArrayList("Main Door", "Back Door",
                                                                         "Front Gate", "Bedroom", "Office"));

        //Guide
        Text guideStep1 = new Text("Welcome to CA Distributed System.");
        myText.getChildren().add(guideStep1);

        Text guideStep2 = new Text("\nConnect to Server by clicking the 'Connect' button.");
        myText.getChildren().add(guideStep2);

        //Disabling the buttons
        //sayHelloButton.setDisable(true);
        //setTempButton.setDisable(true);
        //disconnectButton.setDisable(true);
        //stopStreamButton.setDisable(true);

    }

                        /** Here starts the Connect and Disconnect Server functionalities */

    @FXML
    private Button connectionButton;
    /** This button makes you connection to the Server
     * Approach: Does not apply to RPC Proto Methods */
    @FXML
    private void connectionAction(ActionEvent event)
    {
        SmartServer myServer = new SmartServer(8081);
        try {
            myServer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Text guideStep3 = new Text("\nYour connection to the server is active");
        myText.getChildren().add(guideStep3);

        //Disabling the buttons
        connectionButton.setDisable(true);

        //Enabling the buttons
        sayHelloButton.setDisable(false);

    }

    @FXML
    private Button disconnectButton;
    /** This button ends (stop running) the connection to the Server
     * Approach: Does not apply to RPC Proto Methods */
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



                        /** Here starts new Service from Home Security Proto */


    @FXML
    private Button openDoorButton;
    /** This button (open Door) send a request and get an answer from the Server-Side
     * Approach: Unary Request - from Smart Door Services  - Home Security Proto */
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
    /** This button (close Door) send a request and get an answer from the Server-Side
     * Approach: Unary Request - from Smart Door Services - Home Security Proto*/
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



                    /** Here starts new Service from Home Security Proto */


    @FXML
    private Button turnOnAlarmButton;
    @FXML
    private Circle alarmOnGreen;
    @FXML
    private Circle alarmOffRed;
    /** This button (Turn On Alarm) sends a request and get several answers from the Server-Side
     * Approach: Server-Side Streaming - from  Smart Alarm Services - Home Security Proto */
    @FXML
    private void turnOnAlarmAction(ActionEvent event)
    {
        SmartClient myClient = new SmartClient("localhost", 8081);
        myClient.turnOnAlarm();

        Text messageText = new Text("\nThe alarm had been ACTIVATED");
        myText.getChildren().add(messageText);

        alarmOnGreen.setFill(Color.GREEN);
        alarmOffRed.setFill(Color.WHITE);

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

        //Setting Colors
        alarmOffRed.setFill(Color.RED);
        alarmOnGreen.setFill(Color.WHITE);
    }




                        /** Here starts new Service from Home Environment Mgmt Proto */


    /** This button "Forecast " sends a request and get an answer from the server.
     *  Approach: Unary Request - from Environment Mgmt Services - Environment Management Proto*/
    @FXML
    private void forecastTodayAction(ActionEvent event)
    {
        SmartClient myClient = new SmartClient("localhost", 8081);



        //ChoiceBox
        ChoiceBox<String> cityChoiceBox = new ChoiceBox<>();
        cityChoiceBox.getItems().addAll("Dublin", "Bray", "Swords", "Naas");
        cityChoiceBox.setValue("Dublin"); //default

        //ChoiceBox
        ChoiceBox<String> dayChoiceBox = new ChoiceBox<>();
        dayChoiceBox.getItems().addAll("Today", "Tomorrow", "Next Week");
        dayChoiceBox.setValue("Today"); //default

        //GridPane to hold the ChoiceBoxes
        GridPane grid = new GridPane();
        grid.addRow(0, new Label("City:"), cityChoiceBox);
        grid.addRow(1, new Label("Day:"), dayChoiceBox);


        // Create a dialog box to display the grid
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Request Forecast");
        dialog.setHeaderText("Please select the City and the Day");
        dialog.getDialogPane().setContent(grid);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);


        // Display the dialog box and wait for user input for day
        Optional<ButtonType> result = dialog.showAndWait();

        // Process user input
        result.ifPresent(buttonType ->
        {
            if (buttonType == ButtonType.OK)
            {
                // Get the selected city and day from the ChoiceBoxes
                String selectedCity = cityChoiceBox.getValue();
                String selectedDay = dayChoiceBox.getValue();

                // Call the method to request forecast with city and day
                int temperature = myClient.requestForecast(selectedCity, selectedDay);

                // Display a message indicating that the request has been sent
                Text messageText = new Text("\nServer has sent the forecast for " + selectedDay + " in " + selectedCity + ": " + temperature + " ºC");
                myText.getChildren().add(messageText);
            }
        });
    }


    /** This button "Switch On" sends a request and get stream answer from the server.
     *  Approach: Serve-Side Streaming - from Environment Mgmt Services - Environment Management Proto*/
    @FXML
    private void switchOnAction(ActionEvent event)
    {
        SmartClient myClient = new SmartClient("localhost", 8081);

        //Create a dialog box to request user input
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Air Temperature");
        dialog.setHeaderText("Please enter the Temperature that you want to set: ");
        dialog.setContentText("Temp ºC: ");

        //Display the dialog box and wait for user input
        Optional<String> result = dialog.showAndWait();

        // Process user input
        result.ifPresent(number ->
        {
            try
            {
                Text tempRequestUser = new Text("\nYour Temperature has been set to " + number + " ºC");
                myText.getChildren().add(tempRequestUser);

                int temperature = Integer.parseInt(number);
                myClient.switchOn(temperature);

                int[] time = {0}; //keep track of the variable reference

                // Create a timeline to add points to the chart at regular intervals
                timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
                    airTemperatureSeries.getData().add(new XYChart.Data<>(time[0]++, temperature));
                }));
                timeline.setCycleCount(1000); //Add points for 1000 seconds
                timeline.play();

                Text streamingMsg = new Text("\nThe Server is streaming the temperature requested" );
                myText.getChildren().add(streamingMsg);


            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        });

    }


    private Timeline timeline;
    /** This button "Switch Off " ends the streaming request (Switch On).
     *  Approach: Unary RPC - from Environment Mgmt Services - Environment Management Proto*/
    @FXML
    public void switchOffAction(ActionEvent event)
    {
        SmartClient myClient = new SmartClient("localhost", 8081);

        myClient.switchOff(); //this will send to my Terminal

        Text streamingMsg = new Text("\nTemperature streaming was stopped by the Server." );
        myText.getChildren().add(streamingMsg);

        //stop the chart
        timeline.stop();

    }




                        /** Here starts new Service from Domestic Utilities Proto */

    @FXML
    private Button energyMonitoringButton;
    /** This button "Energy Monitoring " display the streaming data from the server
     *  Approach: Server-Side Streaming  - from Domestic Utilities Services - Domestic Utility Proto*/
    @FXML
    private void energyMonitoringAction(ActionEvent event)
    {
        SmartClient myClient = new SmartClient("localhost", 8081);

        myClient.energyMonitor();
    }







    /** I'm not using this anymore */
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
    /** I'm not using this anymore */





}
