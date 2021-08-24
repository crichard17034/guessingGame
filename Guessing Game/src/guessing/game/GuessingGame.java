/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessing.game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.TextField;
import java.lang.Object;
import java.util.Random;

/**
 *
 * @author crichard
 */
public class GuessingGame extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Random rnd = new Random();
        int targetNum;
        Button btn = new Button();
        TextField txtField = new TextField();
        
        
        btn.setText("Submit Number");
        btn.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) 
            {
                try
                {
                    String initialNum = txtField.getText();
                    int inputNum = Integer.parseInt(initialNum);
                    
                    if(inputNum == targetNum)
                    {
                        
                    }
                }
                catch
                {
                    
                }
            }
        });
        
        txtField.setLayoutX(150);
        
        AnchorPane root = new AnchorPane();
        root.getChildren().add(btn);
        root.getChildren().add(txtField);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Guessing Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
