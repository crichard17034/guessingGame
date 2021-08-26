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
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.TextField;
import javafx.application.Platform;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import java.lang.Object;
import java.util.Random;

/**
 *
 * @author crichard
 */
public class GuessingGame extends Application {
    
    Random rnd = new Random();
    private int targetNum = rnd.nextInt(100) +1;
    
    
    @Override
    public void start(Stage primaryStage) {
        TextField txtField = new TextField();
        Button submitBtn = new Button();
        Button playAgain = new Button();
        Button quitBtn = new Button();
        Text messageBox = new Text();
        Rectangle messageBorder = new Rectangle(30, 20, 450, 50);
        Image upArrow = new Image("images/upArrow.png");
        Image downArrow = new Image("images/downArrow.png");
        Image blank = new Image("images/blank.png");
        Image questionMark = new Image("images/questionMark.png");
        Image star = new Image("images/star.png");
        ImageView arrowView = new ImageView(blank);
        Rectangle imageBorder = new Rectangle(245, 80, 110, 110);
        Color azure = Color.AZURE;
        Color lightBlue = Color.LIGHTBLUE;
        Color aqua = Color.DARKTURQUOISE;

        
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
                        messageBox.setText("You've successfully guessed the "
                                + "number!");
                        playAgain.setVisible(true);
                        submitBtn.setVisible(false);
                        txtField.setVisible(false);
                        arrowView.setImage(star);
                        targetNum = rnd.nextInt(100) +1;
                    }
                    else
                    {
                        if(inputNum > targetNum)
                        {
                            messageBox.setText("Try guessing lower.");
                            arrowView.setImage(downArrow);
                        }
                        else
                        {
                            messageBox.setText("Try guessing higher.");
                            arrowView.setImage(upArrow);
                        }
                    }
                }
                catch(NumberFormatException invalidNum)
                {
                    messageBox.setText("Please enter a valid number.");
                    arrowView.setImage(questionMark);
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
                messageBox.setText("Guess a number from 1 to 100 and "
                    + "see if luck is on your side today!");
                submitBtn.setVisible(true);
                txtField.setVisible(true);
                arrowView.setImage(blank);
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
        submitBtn.setDefaultButton(true);
        
        quitBtn.setLayoutX(530);
        quitBtn.setLayoutY(245);
        quitBtn.setCancelButton(true);
        
        messageBox.setLayoutX(75);
        messageBox.setLayoutY(50);        
        messageBox.setText("Guess a number from 1 to 100 and "
            + "see if luck is on your side today!");
        
        arrowView.setLayoutX(250);
        arrowView.setLayoutY(85);
        
        playAgain.setLayoutX(260);
        playAgain.setLayoutY(245);
        
        messageBorder.setFill(azure);
        messageBorder.setStroke(lightBlue);
        imageBorder.setFill(aqua);
        
        AnchorPane root = new AnchorPane();
        root.getChildren().add(submitBtn);
        root.getChildren().add(quitBtn);
        root.getChildren().add(playAgain);
        root.getChildren().add(txtField);
        root.getChildren().add(messageBorder);       
        root.getChildren().add(messageBox);
        root.getChildren().add(imageBorder);
        root.getChildren().add(arrowView);
        
        Scene scene = new Scene(root, 600, 300);
        
        primaryStage.setTitle("Guessing Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
