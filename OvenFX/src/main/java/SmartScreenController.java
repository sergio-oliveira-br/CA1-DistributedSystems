import com.CA.SmartClient;
import com.CA.SmartServer;
import io.grpc.StatusException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


import javax.swing.*;
import java.io.IOException;
import java.util.Optional;

public class SmartScreenController
{
    /** Step 1: This button makes you connection to the Server */
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
    }


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
    }

    @FXML
    private TextFlow myText;

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
    }


    @FXML
    private LineChart<Number, Number> myTempChart;
    @FXML
    private XYChart.Series<Number, Number> series;
    @FXML
    private XYChart.Series<Number, Number> temp;

    //https://docs.oracle.com/javafx/2/charts/line-chart.htm
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

        //Guide
        Text guideStep1 = new Text("Welcome to CA Distributed System.");
        Text guideStep2 = new Text("\nConnect to Server by clicking the 'Connect' button.");


        myText.getChildren().add(guideStep1);
        myText.getChildren().add(guideStep2);

    }
}
