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
public class SceneController {
    private Stage stage;
    private Scene scene;
    private String username;
    private String password;
    Accounts account = new Accounts("Bobby", "123");

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
        Text user = new Text("Create a Username: ");
        user.setX(100);
        user.setY(90);
        Text pass = new Text("Create a Password: ");
        pass.setX(100);
        pass.setY(200);
        Button create = new Button("Create");
        Group root = new Group();
        Scene menu = new Scene(root, 723, 576);
        TextField username = new TextField();
        username.setPrefSize(200, 25);
        username.setLayoutX(100);
        username.setLayoutY(100);
        TextField password = new TextField();
        password.setPrefSize(200, 25);
        password.setLayoutX(100);
        password.setLayoutY(210);
        Text result = new Text();
        result.setDisable(true);
        result.setVisible(false);
        root.getChildren().addAll(user, pass, username, password, create, result);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(menu);
        stage.show();

        create.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                account.setAccount(username.getText(), password.getText());
                result.setDisable(false);
                result.setVisible(true);
                result.setText(Accounts.createAccount(username.getText(), password.getText()));
            }
        });
    }
}
