import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ScreenGUI extends Application
{

    public static void main(String[] args)
    {
        launch(args);

    }

    @Override
   public void start(Stage primaryStage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(ScreenGUI.class.getResource("SmartScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 770, 620);
        primaryStage.setTitle("Smart Screen");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
