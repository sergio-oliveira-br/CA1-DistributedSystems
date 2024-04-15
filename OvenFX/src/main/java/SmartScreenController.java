import com.CA.SmartClient;
import io.grpc.StatusException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.util.Duration;

import java.util.Optional;

public class SmartScreenController
{

    @FXML
    private Button sayHelloButton;

    @FXML
    private void sayHelloAction(ActionEvent event)
    {
        System.out.println("Hello Sergio");
    }




    @FXML
    private Button setTempButton;

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
        series = new XYChart.Series<>();
        series.setName("Temperature Ramp");
        myTempChart.getData().add(series);

        Timeline myTime = new Timeline(new KeyFrame(Duration.millis(2000), event -> dataMyGraph()));
        myTime.setCycleCount(Timeline.INDEFINITE);
        myTime.play();

    }

    //Method: This it's responsible to sent to Chart item by item
    @FXML
    private void dataMyGraph()
    {
        //submitTempAction();
    }



}
