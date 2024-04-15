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

        //Process user input
        result.ifPresent(number ->
        {
            try
            {
                int intValue = Integer.parseInt(number);
                System.out.println("You entered: " + intValue);

            }
            catch (NumberFormatException e) {
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
        series.setName("Example");
        myTempChart.getData().add(series);

        Timeline myTime = new Timeline(new KeyFrame(Duration.millis(2000), event -> toChart()));
        myTime.setCycleCount(Timeline.INDEFINITE);
        myTime.play();

    }

    @FXML
    private void toChart()
    {
        tempRamp();
    }


    int x = 0;
    int y = 0;
    private void tempRamp()
    {
        for(int i = 0; i < 1; i++)
        {
            series.getData().add(new XYChart.Data<>(x++, y++));
        }
    }

}
