package com.example.atm;

import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import java.io.IOException;

import java.io.IOException;

import static javafx.scene.layout.Background.*;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private String username;
    private String password;

    public void account(ActionEvent event) throws IOException {
        Parent mainMenu = FXMLLoader.load(getClass().getResource("accountsstuff.fxml"));
        scene = new Scene(mainMenu, 723, 576);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void logIn(ActionEvent event) throws IOException {
        Text user = new Text("Username: ");
        user.setX(100);
        user.setY(90);
        Text pass = new Text("Password: ");
        pass.setX(100);
        pass.setY(200);
        Group root = new Group();
        Scene menu = new Scene(root, 723, 576);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(menu);
        stage.show();
    }

    public void createAccount(ActionEvent event) throws IOException {
        Button create = new Button("Create");
        Group root = new Group();
        Scene menu = new Scene(root, 723, 576, Color.web("#373656", 1.0));
        Text createAccount = new Text("Create an Account");
        createAccount.setFont(Font.font("Jokerman", 64));
        createAccount.setFill(Color.WHITE);
        createAccount.setX(100);
        createAccount.setY(100);
        TextField username = new TextField();
        username.setPromptText("Create a username: ");
        username.setFocusTraversable(false);
        username.setBackground(fill(Color.web("#4c4c71", 1.0)));
        username.setStyle("-fx-text-inner-color: #FFFFFF;");
        username.setPrefSize(325, 50);
        username.setLayoutX(100);
        username.setLayoutY(150);
        TextField password = new TextField();
        password.setPromptText("Create a password: ");
        password.setFocusTraversable(false);
        password.setBackground(fill(Color.web("#4c4c71", 1.0)));
        password.setPrefSize(325, 50);
        password.setStyle("-fx-text-inner-color: #FFFFFF;");
        password.setLayoutX(100);
        password.setLayoutY(250);
        Text result = new Text();
        result.setDisable(true);
        result.setVisible(false);
        result.setX(100);
        result.setY(300);
        result.setFill(Color.WHITE);
        result.setFont(Font.font("Jokerman", 32));
        root.getChildren().addAll(username, password, create, createAccount, result);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(menu);
        stage.show();

        create.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println(username.getText());
                result.setText(Accounts.createAccount(username.getText(), password.getText()));
                result.setDisable(false);
                result.setVisible(true);
            }
        });
    }
}
