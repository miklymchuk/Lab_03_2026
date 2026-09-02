package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        // Elements that arrange parts of the scene.
        var root = new BorderPane();
        var grid = new GridPane();
        
        // Elements placed on the scene.
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
        
        var clear = new Button("Clear");
        
        var check = new Label("");
        
        // Functionality of register button, including checking for a valid email & password.
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
            
            for (int b = 0; b < passwordText.getText().length() && (digitCheck == false || characterCheck == false); b++) {
                    if (digits.contains(passwordText.getText().charAt(b) + "")) {
                        digitCheck = true;
                    }
                    if (letters.contains(passwordText.getText().charAt(b) + "")) {
                        characterCheck = true;
                    }
                }
           
            if (emailCheck == true && digitCheck == true && characterCheck == true) {
                check.setText("Your account has been registered.");
            } else {
                check.setText("Error: Your email or password is invalid. Your account has not been registered.");
            }
        });
        
        // Functionality of clear button
        clear.setOnAction(e -> {
            firstNameText.setText("");
            lastNameText.setText("");
            emailText.setText("");
            passwordText.setText("");
            register.setDisable(true);
        });
        
        // Functionality of checking if the register button should be enabled or disabled
        root.setOnKeyReleased(e -> {
            if (!(firstNameText.getText().isEmpty() || lastNameText.getText().isEmpty() || emailText.getText().isEmpty() || passwordText.getText().isEmpty())) {
                register.setDisable(false);
            } else {
                register.setDisable(true);
            }
        });
        
        // Adding elements to the grid
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
        
        // Making the grid look good
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(30, 30, 30, 30));
        grid.setHgap(10);
        grid.setVgap(10);
        
        // Putting the registration check label outside the grid makes sure it doesn't mess with the grid
        root.setBottom(check);
        check.setAlignment(Pos.TOP_CENTER);
        check.setTextAlignment(TextAlignment.CENTER);
        check.setWrapText(true);
        check.setPadding(new Insets(30, 30, 30, 30));
        
        
        var scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Account Creation:");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}