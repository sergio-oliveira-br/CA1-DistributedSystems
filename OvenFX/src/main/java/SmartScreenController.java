import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class SmartScreenController
{

    @FXML
    private Button button;

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        System.out.println("Button clicked! kkkk");

    }

    @FXML
    private CheckBox checkB;

    @FXML
    public void myCheck(ActionEvent event)
    {
        System.out.println("This is test");
    }
}
