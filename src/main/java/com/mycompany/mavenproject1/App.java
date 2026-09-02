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
        if (firstNameText.getText().isEmpty() && lastNameText.getText().isEmpty() && emailText.getText().isEmpty() && passwordText.getText().isEmpty()) {
            register.setDisable(false);
        }
        var clear = new Button("Clear");
        
        var check = new Label("");
        
        register.setOnAction(e -> {
            Boolean emailCheck = false;
            Boolean digitCheck = false;
            Boolean characterCheck = false;
            String letters = "abcdefghijklmnopqrstuvwxyz";
            String digits = "0123456789";
            String emailCheck2 = "";
            if (emailText.getText().contains("@")) {
                for (int a = 0; a < emailText.getText().length(); a++) {
                    if (emailText.getText().charAt(a) == '@') {
                        emailCheck2 = emailText.getText().substring(a, emailText.getText().length());
                        
                    }
                }
                if (emailCheck2.contains(".com") || emailCheck2.contains(".ca")) {
                    emailCheck = true;
                }
            }
            
            for (int b = 0; b < emailText.getText().length() && (digitCheck == false || characterCheck == false); b++) {
                if (digits.contains(passwordText.getText().substring(b, b + 1))) {
                    digitCheck = true;
                }
                if (letters.contains(passwordText.getText().substring(b, b + 1))) {
                    characterCheck = true;
                }
            }
            
            if (emailCheck == true) {
                System.out.println("email good");
            }
            if (digitCheck == true) {
                System.out.println("digit good");
            }
            if (characterCheck == true) {
                System.out.println("character good");
            }
            if (emailCheck == true && digitCheck == true && characterCheck == true) {
                check.setText("Your account has been registered.");
            } else {
                check.setText("Error: Your email or password is invalid. Your account has not been registered.");
            }
        });
        
        root.setCenter(grid);
        grid.add(firstName, 0, 0);
        grid.add(lastName, 0, 1);
        grid.add(email, 0, 2);
        grid.add(password, 0, 3);
        grid.add(firstNameText, 1, 0);
        grid.add(lastNameText, 1, 1);
        grid.add(emailText, 1, 2);
        grid.add(passwordText, 1, 3);
        grid.add(register, 0, 4);
        grid.add(clear, 1, 4);
        grid.add(check, 0, 5);
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}