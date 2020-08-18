/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphic;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;

/**
 *
 * @author Reza
 */
//the right-object of the borderpane
public class Right extends VBox{
    
    private Button ranButton = new Button("Slumpa 6 rader");
    
    private HBox spaceHbox1 = new HBox();
    private HBox spaceHbox2 = new HBox();
    
    private HBox spaceHbox3 = new HBox();
    private HBox spaceHbox4 = new HBox();
    private Button clearButton = new Button("  Återställ  ");
    
    
    public Right(){
        
        this.setAlignment(Pos.TOP_CENTER);
        
        this.setPadding(new Insets(10, 10, 10, 10));  
        this.setSpacing(1);
        
        //get screenresolution
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double width = primaryScreenBounds.getWidth();
        
        //HBox that acts to fill up space
        spaceHbox1.setPadding(new Insets(10, 10, 100, (width/8)));
        this.getChildren().add(spaceHbox1);
        
        spaceHbox2.setPadding(new Insets(10, 10, 10, (width/8)));
        
       
        //setting properties and font of ranbutton
        ranButton.setDisable(true);
        ranButton.setStyle("-fx-text-fill: blue;");
        Font countButtonFont ;
        countButtonFont = Font.font("Arial", FontWeight.BOLD, 15);
        ranButton.setFont(countButtonFont);
        
        //add items to the screen
        this.getChildren().add(ranButton);
        this.getChildren().add(spaceHbox2);
          
        //setting font and color of clearbutton
        Font clearButtonFont ;
        clearButtonFont = Font.font("Arial", FontWeight.BOLD, 15);
        clearButton.setFont(clearButtonFont);
        clearButton.setStyle("-fx-text-fill: purple;");
        
        spaceHbox3.setPadding(new Insets(65, 10, 10, (width/8)));
        
        this.getChildren().add(spaceHbox3);
        this.getChildren().add(clearButton);
        
    }
    
    
    public Button getRanButton(){
        return this.ranButton;
    }
    
    public Button getClearButton(){
        return this.clearButton;
    }
    
}
