package com.example.atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ChoiceBox implements Initializable {

    @FXML
    private Label money;

    @FXML
    private javafx.scene.control.ChoiceBox<String> whichAccount;
    private String[] choices = {"Savings", "Checks"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        whichAccount.getItems().addAll(choices);
    }

    public void getAccount(ActionEvent event) {
        String choice = whichAccount.getValue();
        money.setText(choice + " has ");
    }
}
