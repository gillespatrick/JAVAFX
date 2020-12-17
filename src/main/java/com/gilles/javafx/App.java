package com.gilles.javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
       //Create some buttons
        Button b1 = new Button("this is center");
        Button b2 = new Button("this is Top");
        Button b3 = new Button("this is Bottom");
        Button b4 = new Button("this is left");
        Button b5 = new Button("this is rigth");

        // Add each button to its own contenair
        HBox centerHbox = new HBox(b1);
        HBox topHbox = new HBox(b2);
        HBox bottomHbox = new HBox(b3);
        VBox leftVbox = new VBox(b4);
        VBox rigthVbox = new VBox(b5);

        // Set the alignment for top and bottom
        topHbox.setAlignment(Pos.CENTER);
        bottomHbox.setAlignment(Pos.CENTER);

        //Create the borderPane
        BorderPane bp = new BorderPane();

        // Add the buttons to the borderPane regions
        bp.setCenter(centerHbox);
        bp.setTop(topHbox);
        bp.setBottom(bottomHbox);
        bp.setLeft(leftVbox);
        bp.setRight(rigthVbox);

        //Create s Scene with the borderPane as a root node
        Scene scene = new Scene(bp);
        

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}