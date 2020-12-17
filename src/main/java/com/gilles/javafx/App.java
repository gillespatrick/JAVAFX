package com.gilles.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
       Label label = new Label("Hello World");
      
      //Put the label in vbox
      VBox vbox = new VBox(label);
      vbox.setAlignment(Pos.CENTER);
      vbox.setPadding( new Insets(10));
      
      
        //Create s Scene with the borderPane as a root node
        Scene scene = new Scene(vbox);
        scene.getStylesheets().add("demo1.css");
        

        stage.setScene(scene);
        stage.show();
       
    }

    public static void main(String[] args) {
        launch();
    }

}