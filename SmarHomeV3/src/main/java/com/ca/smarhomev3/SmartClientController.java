package com.ca.smarhomev3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SmartClientController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}