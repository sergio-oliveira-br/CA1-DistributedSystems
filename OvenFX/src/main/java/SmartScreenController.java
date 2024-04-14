import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;

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
    private void initialize()
    {

        XYChart.Series<Number,Number> series = new XYChart.Series<Number, Number>();
        series.setName("Example");

        series.getData().add(new XYChart.Data<Number, Number>(10, 10));
        series.getData().add(new XYChart.Data(2, 3));
        series.getData().add(new XYChart.Data(3, 5));
        series.getData().add(new XYChart.Data(4, 8));
        series.getData().add(new XYChart.Data(5, 13));


        myTempChart.getData().add(series);

    }


}
