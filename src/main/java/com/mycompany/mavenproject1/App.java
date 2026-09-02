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
        register.setDisable(true);
        if (firstNameText.getText() != "" && lastNameText.getText() != "" && emailText.getText() != "" && passwordText.getText() != "") {
            register.setDisable(false);
        }
        Boolean digit = false;
        Boolean character = false;
        String letters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        register.setOnAction(e -> {
            if ((emailText.getText().contains("@") && emailText.getText().contains(".c"))) {
            for (int a = 0; a < emailText.getText().length(); a++) {
                
            }
        }
        });
        var clear = new Button("Clear");
        
        var check = new Label("");
        
        
        
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}