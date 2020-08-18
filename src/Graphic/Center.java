/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphic;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Reza
 */
//the center-object of the borderpane
public class Center extends VBox{
    
    private Label headingLabel = new Label("Lottorader:");
    private HBox spaceHbox = new HBox();
    
    private HBox[] hboxLabelArray = new HBox[6];
    private Label[] rowNumberlabelArray = new Label[6];
    
    private Label[] kenoLabelArray = new Label[66];
    
    
    public Center(){
        
        
        this.setPadding(new Insets(10, 10, 10, 100));  
        this.setSpacing(1);
        
        //set properties for headinglabel and adding it to the layout
        Font headingFont ;
        headingFont = Font.font("Arial", FontWeight.BOLD, 20);
        headingLabel.setFont(headingFont);
        headingLabel.setTextFill(Color.RED);
        headingLabel.setAlignment(Pos.TOP_CENTER);
        this.getChildren().add(headingLabel);
        
        //a Hbox added to fill up space in the layout
        spaceHbox = new HBox();
        spaceHbox.setPadding(new Insets(10, 10, 10, 100));
        this.getChildren().add(spaceHbox);
        
        
        
        //create objects of Hbox-array and setting properties
        for(int z = 0 ; z < hboxLabelArray.length ; z++){
            hboxLabelArray[z] = new HBox();
            hboxLabelArray[z].setSpacing(10);
            hboxLabelArray[z].setPadding(new Insets(0, 0, 10, 0));
        }
        
        Font labelFont ;
        labelFont = Font.font("Arial", FontWeight.BOLD, 20);
        
        //objects of rownumbers, color, text, font
        for(int x = 0 ; x < rowNumberlabelArray.length ; x++){
            rowNumberlabelArray[x] = new Label();
            BackgroundFill background_fill = new BackgroundFill(Color.ORANGE,  CornerRadii.EMPTY, Insets.EMPTY); 
            Background background = new Background(background_fill);
            rowNumberlabelArray[x].setBackground(background);
            
            rowNumberlabelArray[x].setText(" " + Integer.toString((x+1)) + " ");
            
            rowNumberlabelArray[x].setFont(labelFont);
            rowNumberlabelArray[x].setAlignment(Pos.BOTTOM_CENTER);
            rowNumberlabelArray[x].setStyle("-fx-border-color: yellow;");
        }
        
        Font numberLabelFont ;
        numberLabelFont = Font.font("Arial", FontWeight.BOLD, 15);
        
        //creating objects of the kenonumber labelarray and setting properties
        for(int w = 0 ; w < kenoLabelArray.length ; w++){
            kenoLabelArray[w] = new Label();
            kenoLabelArray[w].setAlignment(Pos.TOP_CENTER);
            kenoLabelArray[w].setTextFill(Color.BLUE);
            kenoLabelArray[w].setFont(numberLabelFont);
        }
        
        int totalLabels = (rowNumberlabelArray.length +  kenoLabelArray.length);
        int squareNumber = 0; 
        int hboxIndex = 0;
        int kenoRowIndex = 0;
        
        //filling the keno rows-part of the grafics of center
        for (int addIndex = 0 ; addIndex < totalLabels ; addIndex++ ){
            switch (squareNumber) {
                case 0:
                    hboxLabelArray[hboxIndex].getChildren().add(rowNumberlabelArray[hboxIndex]);
                    squareNumber++;
                    break;
                case 1:
                    hboxLabelArray[hboxIndex].getChildren().add(kenoLabelArray[kenoRowIndex]);
                    squareNumber++;
                    kenoRowIndex++;
                    break;
                case 2:
                    hboxLabelArray[hboxIndex].getChildren().add(kenoLabelArray[kenoRowIndex]);
                    kenoRowIndex++;
                    squareNumber++;
                    break;
                case 3:
                    hboxLabelArray[hboxIndex].getChildren().add(kenoLabelArray[kenoRowIndex]);
                    kenoRowIndex++;
                    squareNumber++;
                    
                    break;
                case 4:
                    hboxLabelArray[hboxIndex].getChildren().add(kenoLabelArray[kenoRowIndex]);
                    kenoRowIndex++;
                    squareNumber++;
                    break;
                case 5:
                    hboxLabelArray[hboxIndex].getChildren().add(kenoLabelArray[kenoRowIndex]);
                    squareNumber++;
                    kenoRowIndex++;
                    break;
                case 6:
                    hboxLabelArray[hboxIndex].getChildren().add(kenoLabelArray[kenoRowIndex]);
                    kenoRowIndex++;
                    squareNumber++;
                    break;
                case 7:
                    hboxLabelArray[hboxIndex].getChildren().add(kenoLabelArray[kenoRowIndex]);
                    squareNumber++;
                    kenoRowIndex++;
                    break;
                case 8:
                    hboxLabelArray[hboxIndex].getChildren().add(kenoLabelArray[kenoRowIndex]);
                    kenoRowIndex++;
                    squareNumber++;
                    break;
                case 9:
                    hboxLabelArray[hboxIndex].getChildren().add(kenoLabelArray[kenoRowIndex]);
                    kenoRowIndex++;
                    squareNumber++;
                    break;
                case 10:
                    hboxLabelArray[hboxIndex].getChildren().add(kenoLabelArray[kenoRowIndex]);
                    kenoRowIndex++;
                    squareNumber++;
                    break;
                case 11:
                    hboxLabelArray[hboxIndex].getChildren().add(kenoLabelArray[kenoRowIndex]);
                    kenoRowIndex++;
                    hboxIndex++;
                    squareNumber = 0;
                    break;    
                default:
                    break;
            }
            
        }
        
        this.getChildren().addAll(hboxLabelArray);
       
    }
  
    public Label[] getKenorowArray(){
        return this.kenoLabelArray;
    }
    
    public Label[] getKenoLabelArray(){
        return this.kenoLabelArray;
    }
    
}
