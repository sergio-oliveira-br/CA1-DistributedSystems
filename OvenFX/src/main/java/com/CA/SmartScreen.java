package com.CA;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SmartScreen
{
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
