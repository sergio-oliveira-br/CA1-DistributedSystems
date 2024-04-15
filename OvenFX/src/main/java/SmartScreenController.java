import com.CA.SmartClient;
import io.grpc.StatusException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


import java.util.Optional;

public class SmartScreenController
{

    @FXML
    private Button sayHelloButton;

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

            try {
                StringBuilder greetingMessage = myClient.greet(name);
                Text messageText = new Text(greetingMessage + "\n");
                myText.getChildren().add(messageText);
            } catch (StatusException e) {
                throw new RuntimeException(e);
            }
        });
    }


    @FXML
    private Button setTempButton;

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
        series = new XYChart.Series<>();
        series.setName("Temperature Ramp");
        myTempChart.getData().add(series);


        temp = new XYChart.Series<Number, Number>();
        temp.setName("Set Point");
        myTempChart.getData().add(temp);





    }
}
