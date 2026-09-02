package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.scene.Scene;
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
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}