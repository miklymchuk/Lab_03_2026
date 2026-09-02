package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var root = new BorderPane();
        var grid = new GridPane();
        
        var firstName = new Label("First Name:");
        var lastName = new Label("Last Name:");
        var email = new Label("Email:");
        var password = new Label("Password:");
        
        var firstNameText = new TextField();
        var lastNameText = new TextField();
        var emailText = new TextField();
        var passwordText = new PasswordField();
        
        var register = new Button("Register");
        var clear = new Button("Clear");
        
        var check = new Label(" ");
        
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}