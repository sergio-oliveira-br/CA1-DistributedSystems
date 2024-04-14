import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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




}
