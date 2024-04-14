import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ScreenGUI extends Application
{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
   public void start(Stage primaryStage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(ScreenGUI.class.getResource("SmartScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        primaryStage.setTitle("Hello!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }




}
