package com.example.atm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


import static javafx.scene.layout.Background.*;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private String username;
    private String password;

    private Parent withdrew;


    public void account(ActionEvent event) throws IOException {
        Parent mainMenu = FXMLLoader.load(getClass().getResource("accountsstuff.fxml"));
        scene = new Scene(mainMenu, 723, 576);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void logIn(ActionEvent event) throws IOException {
        Parent mainMenu = FXMLLoader.load(getClass().getResource("accountsstuff.fxml"));
        Button logIn = new Button("Log In");
        logIn.setPrefSize(125, 50);
        logIn.setLayoutX(400);
        logIn.setLayoutY(410);
        Button back = new Button("Back");
        back.setPrefSize(125, 50);
        back.setLayoutX(200);
        back.setLayoutY(410);
        Group root = new Group();
        Scene menu = new Scene(root, 723, 576, Color.web("#373656", 1.0));
        Text logIntoAccount = new Text("Login");
        logIntoAccount.setUnderline(true);
        logIntoAccount.setFont(Font.font("Jokerman", 50));
        logIntoAccount.setFill(Color.WHITE);
        logIntoAccount.setX(130);
        logIntoAccount.setY(125);
        TextField username = new TextField();
        username.setPromptText("Create a username: ");
        username.setFocusTraversable(false);
        username.setBackground(fill(Color.web("#4c4c71", 1.0)));
        username.setStyle("-fx-text-inner-color: #FFFFFF;");
        username.setPrefSize(325, 50);
        username.setLayoutX(200);
        username.setLayoutY(200);
        TextField password = new TextField();
        password.setPromptText("Enter a password: ");
        password.setFocusTraversable(false);
        password.setBackground(fill(Color.web("#4c4c71", 1.0)));
        password.setPrefSize(325, 50);
        password.setStyle("-fx-text-inner-color: #FFFFFF;");
        password.setLayoutX(200);
        password.setLayoutY(300);
        Text result = new Text();
        result.setDisable(true);
        result.setVisible(false);
        result.setX(200);
        result.setY(375);
        result.setFill(Color.WHITE);
        result.setFont(Font.font("Leger", 16));
        root.getChildren().addAll(username, password, logIn, back, logIntoAccount, result);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(menu);
        stage.show();
        withdrew = FXMLLoader.load(getClass().getResource("stuff.fxml"));

        back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                scene = new Scene(mainMenu);
                stage.setScene(scene);
            }
        });

        logIn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (Accounts.checkInfo(username.getText(), password.getText())) {
                    Group root = new Group();
                    Scene atm = new Scene(root, 723, 576, Color.web("#373656", 1.0));
                    Text savingsAmount = new Text("Cash: $" + String.format("%.2f", Accounts.getUserSavings()));
                    Text welcome = new Text("Welcome, \n" + username.getText());
                    welcome.setFill(Color.WHITE);
                    welcome.setFont(Font.font("Leger", 16));
                    welcome.setY(50);
                    welcome.setX(50);
                    savingsAmount.setY(150);
                    savingsAmount.setX(50);
                    savingsAmount.setFont(Font.font("Leger", 36));
                    Rectangle box1 = new Rectangle(250, 75);
                    box1.setFill(Color.web("#4B4A75"));
                    box1.setX(40);
                    box1.setY(100);
                    savingsAmount.setFill(Color.WHITE);
                    Button deposit = new Button("Deposit");
                    deposit.setTextFill(Color.web("#EDF2F4"));
                    deposit.setPrefSize(150, 75);
                    deposit.setLayoutX(40);
                    deposit.setLayoutY(230);
                    deposit.setBackground(Background.fill(Color.web("#4B4A75")));
                    Button withdraw = new Button("Withdraw");
//                    withdraw.setTextFill(Color.web("#EDF2F4"));
                    withdraw.setPrefSize(150, 75);
                    withdraw.setLayoutX(230);
                    withdraw.setLayoutY(230);
                    withdraw.setBackground(Background.fill(Color.web("#4B4A75")));
                    root.getChildren().addAll(welcome, box1, savingsAmount, deposit, withdraw);
                    stage.setScene(atm);
                    stage.show();

                    withdraw.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                            Scene withdraw = new Scene(withdrew);
                            stage.setScene(withdraw);
                            stage.show();
                        }
                    });

                } else {
                    result.setText(Accounts.checkLogIn(username.getText(), password.getText()));
                    result.setDisable(false);
                    result.setVisible(true);
                }
            }
        });
    }

    public void createAccount(ActionEvent event) throws IOException {
        Parent mainMenu = FXMLLoader.load(getClass().getResource("accountsstuff.fxml"));
        Button create = new Button("Create");
        create.setPrefSize(125, 50);
        create.setLayoutX(400);
        create.setLayoutY(410);
        Button back = new Button("Back");
        back.setPrefSize(125, 50);
        back.setLayoutX(200);
        back.setLayoutY(410);
        Group root = new Group();
        Scene menu = new Scene(root, 723, 576, Color.web("#373656", 1.0));
        Text createAccount = new Text("Create an Account");
        createAccount.setUnderline(true);
        createAccount.setFont(Font.font("Jokerman", 50));
        createAccount.setFill(Color.WHITE);
        createAccount.setX(130);
        createAccount.setY(125);
        TextField username = new TextField();
        username.setPromptText("Create a username: ");
        username.setFocusTraversable(false);
        username.setBackground(fill(Color.web("#4c4c71", 1.0)));
        username.setStyle("-fx-text-inner-color: #FFFFFF;");
        username.setPrefSize(325, 50);
        username.setLayoutX(200);
        username.setLayoutY(200);
        TextField password = new TextField();
        password.setPromptText("Create a password: ");
        password.setFocusTraversable(false);
        password.setBackground(fill(Color.web("#4c4c71", 1.0)));
        password.setPrefSize(325, 50);
        password.setStyle("-fx-text-inner-color: #FFFFFF;");
        password.setLayoutX(200);
        password.setLayoutY(300);
        Text result = new Text();
        result.setDisable(true);
        result.setVisible(false);
        result.setX(200);
        result.setY(375);
        result.setFill(Color.WHITE);
        result.setFont(Font.font("Leger", 16));
        root.getChildren().addAll(username, password, create, back, createAccount, result);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(menu);
        stage.show();

        create.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                result.setText(Accounts.createAccount(username.getText(), password.getText()));
                result.setDisable(false);
                result.setVisible(true);
            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                scene = new Scene(mainMenu);
                stage.setScene(scene);
            }
        });
    }
}
