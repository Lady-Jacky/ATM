package com.example.atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import static javafx.scene.layout.Background.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ChoiceBox implements Initializable {
    @FXML
    private TextField amount;

    @FXML
    private TextField fives;

    @FXML
    private Label suffer;

    @FXML
    private TextField twenties;
    @FXML
    private javafx.scene.control.ChoiceBox<String> whichAccount;
    private String[] choices = {"Savings", "Checks"};
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        twenties.setStyle("-fx-text-inner-color: #000000;");
        fives.setStyle("-fx-text-inner-color: #000000;");
        amount.setStyle("-fx-text-inner-color: #000000;");
        whichAccount.getItems().addAll(choices);
        whichAccount.setOnAction(this::getAccount);
    }

    public void getAccount(ActionEvent event) {
        String choice = whichAccount.getValue();
        if(choice.equals("Savings")) {
            suffer.setText(choice + " account has $" + Accounts.getUserSavings());
        } else {
            suffer.setText(choice + " account has $" + Accounts.getUserChecks());
        }
    }
}
