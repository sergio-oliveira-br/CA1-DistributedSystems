/*
  CA - Distributed System
  Author: Sergio Oliveira - x23170981@student.ncirl.ie
  Created: 13 Apr 2024

  Lecturer: Mark Cudden

  References:
    https://grpc.io/docs/languages/java/quickstart/
    https://grpc.io/docs/languages/java/basics/

    GUI
*/


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
