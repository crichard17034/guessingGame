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
import javafx.scene.text.*;
import javafx.scene.image.Image;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.TextField;
import javafx.application.Platform;
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
        int targetNum = rnd.nextInt(100) +1;
        TextField txtField = new TextField();
        Button submitBtn = new Button();
        Button playAgain = new Button();
        Button quitBtn = new Button();
        Text messageBox = new Text();
        submitBtn.setText("Submit Number");
        submitBtn.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent checkGuess) 
            {
                try
                {
                    String initialNum = txtField.getText();
                    int inputNum = Integer.parseInt(initialNum);
                    
                    if(inputNum == targetNum)
                    {
                        
                    }
                    else
                    {
                        if(inputNum > targetNum)
                        {
                            messageBox.setText("Try guessing lower.");
                        }
                        else
                        {
                            messageBox.setText("Try guessing higher.");
                        }
                    }
                }
                catch(Exception e)
                {
                    messageBox.setText("Please enter a valid number.");
                }
                
                txtField.setText("");
            }
        });        
        
        playAgain.setText("Play Again");
        playAgain.setVisible(false);
        playAgain.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent resetGame) 
            {
                playAgain.setVisible(false);
                
            }
        });
        
        quitBtn.setText("Quit");
        quitBtn.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent quit) 
            {
                Platform.exit();
            }
        });
        
        
        txtField.setLayoutX(225);
        txtField.setLayoutY(200);
        
        submitBtn.setLayoutX(250);
        submitBtn.setLayoutY(245);
        
        quitBtn.setLayoutX(530);
        quitBtn.setLayoutY(245);
        
        messageBox.setLayoutX(75);
        messageBox.setLayoutY(50);        
        messageBox.setText("Guess a number from 1 to 100 and "
            + "see if luck is on your side today!");
        
        AnchorPane root = new AnchorPane();
        root.getChildren().add(submitBtn);
        root.getChildren().add(quitBtn);
        root.getChildren().add(playAgain);
        root.getChildren().add(txtField);
        root.getChildren().add(messageBox);
        
        Scene scene = new Scene(root, 600, 300);
        
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
