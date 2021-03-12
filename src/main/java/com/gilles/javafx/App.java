package com.gilles.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Metric Converter Application
 */
public class App extends Application {
    
    private TextField kiloTextField;
    private Label resultLabel;
    private RadioButton milesButton,feetButton,inchesButton;

    @Override
    public void start(Stage stage) {
      
        // Create label to display prompt
        Label promptLabel = new Label("Enter a distance in kilometer");
        
        // Crete a textfield input
        kiloTextField = new TextField();
        
        // Crete the radio button controld
        milesButton = new RadioButton("Convert to Miles");
        feetButton = new RadioButton("Convert to Feet");
        inchesButton = new RadioButton("Convert to Inches");
        
        // Select the milesButton
        //milesButton.isSelected(true);
        
        // Add the radiobutton controls to a togglegroup
        ToggleGroup radioGroup = new ToggleGroup();
        milesButton.setToggleGroup(radioGroup);
        feetButton.setToggleGroup(radioGroup);
        inchesButton.setToggleGroup(radioGroup);
        
        //Create the button to perform convertion
        Button calcButton = new Button("Convert");
        
        // Register the event handler
        calcButton.setOnAction(new CalcButtonHandler());
        
        // Create the label empty
        resultLabel = new Label();
        
        // Put the prompt label and the kilotextfield in a hbox
        HBox prompthbox = new HBox(10, promptLabel, kiloTextField);
        
        // Put the radiobutton in the hbox
        HBox radiohbox = new HBox(20, milesButton, feetButton, inchesButton);
        
        //Put everything in vbox
        VBox vbox = new VBox(10, prompthbox, radiohbox, calcButton, resultLabel);
        
        // Set the vbox alignment to center
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
       
        // Create the scene
        
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.setTitle("Metric Converter");
        stage.show();
        
       
    }

    public static void main(String[] args) {
        launch();
    }
    
    
    /**
     * Event handler class for Calcbutton 
     */
    
    class CalcButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            
            // Constant for the conversion factoers
            final double MILES_CONVERSION = 0.6214;
            final double FEET_CONVERSION = 3281.0;
            final double INCHES_CONVERSION = 39370.0;
            
            // V ariable the hold the result
            double result = 0;
            
            // Get the kilometers
            double kilometers = Double.parseDouble(kiloTextField.getText());
            
            // Perform the select conversion
            if (milesButton.isSelected())
                result = kilometers * MILES_CONVERSION;
            
            if (feetButton.isSelected())
                result = kilometers * FEET_CONVERSION;
            
            if (inchesButton.isSelected())
                result = kilometers * INCHES_CONVERSION;
            
            // Display the reult
            resultLabel.setText(String.format("%,.2f", result));
                
            
            
            
          
        }
    
        
    
    }
    

}