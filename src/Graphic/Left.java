/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphic;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
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
//the Left-object of the borderpane
public class Left extends VBox{
    
    
    private Label headingLabel = new Label("Ange 4 fasta nummer:");
    private HBox spaceHbox = new HBox();
    
    private HBox[] hboxLabelArray = new HBox[4];
    private Label[] rowNumberlabelArray = new Label[4];
    private Label[] excludedLabelArray = new Label[4];
    private int[] excludedNumbersArray = new int[4];
    
    private Spinner spinner = new Spinner();
    private Slider slider = new Slider();
    private DatePicker dp1 = new DatePicker();
    
    private Button[] chooseNumberbutton = new Button[4];
    private NumberChooser numberChooser = new NumberChooser(this);
    private Button[] buttonArray; 
    
    private Right right1;
    private Center center1;
    
    private Button ranButton;
    private Button clearButton;
    
    
    public Left(Right right, Center center){
        
        this.right1 = right;
        this.center1 = center;
        this.ranButton = right1.getRanButton();
        this.clearButton = right1.getClearButton();
        
        this.buttonArray = numberChooser.getButtonArray();
        
        //padding settings
        this.setPadding(new Insets(10, 10, 10, 15));  
        this.setSpacing(1);
        
        Font headingFont ;
        headingFont = Font.font("Arial", FontWeight.BOLD, 15);
        
        headingLabel.setFont(headingFont);
        headingLabel.setTextFill(Color.RED);
        this.getChildren().add(headingLabel);
        
        //a HBox for filling up space
        spaceHbox = new HBox();
        spaceHbox.setPadding(new Insets(10, 10, 10, 100));
        this.getChildren().add(spaceHbox);
        
        Font labelFont ;
        labelFont = Font.font("Arial", FontWeight.BOLD, 15);
        
        //create objects of Hbox-array and setting properties
        for(int z = 0 ; z < hboxLabelArray.length ; z++){
            hboxLabelArray[z] = new HBox();
            hboxLabelArray[z].setPadding(new Insets(10, 10, 10, 10));
            hboxLabelArray[z].setSpacing(25);
            hboxLabelArray[z].setFillHeight(true); 
            hboxLabelArray[z].autosize();
            hboxLabelArray[z].setAlignment(Pos.CENTER_LEFT);
            
        }
        
        //create objects of rownumberlabel and setting the settings of those
        for(int z = 0 ; z < rowNumberlabelArray.length ; z++){
            rowNumberlabelArray[z] = new Label();
            rowNumberlabelArray[z].setText(" " + (Integer.toString(z+1)) + " ");
            rowNumberlabelArray[z].setFont(labelFont);
            BackgroundFill background_fill = new BackgroundFill(Color.LIGHTBLUE,  CornerRadii.EMPTY, Insets.EMPTY); 
            Background background = new Background(background_fill);
            rowNumberlabelArray[z].setBackground(background);
        }
        
        //create 4 objects of the labels for excluded numbers
        for(int x = 0 ; x < excludedLabelArray.length ; x++){
            excludedLabelArray[x] = new Label();
            excludedLabelArray[x].setText("     ");
            excludedLabelArray[x].setFont(labelFont);
            excludedNumbersArray[x] = (-1);
        }
        
        
        //create 4 buttons to click for the user to choose the excluded numbers
        for (int j = 0 ; j < chooseNumberbutton.length ; j++){
            chooseNumberbutton[j] = new Button();
            chooseNumberbutton[j].setText("Välj nummer");
        }
        
        //add the 4 buttons to the hboxes
        for(int i = 0 ; i < hboxLabelArray.length ; i++){
            hboxLabelArray[i].getChildren().add(rowNumberlabelArray[i]);
            hboxLabelArray[i].getChildren().add(excludedLabelArray[i]);
            if (i == 0){
                hboxLabelArray[i].getChildren().add(chooseNumberbutton[0]);
            }
            else if (i == 1){
                hboxLabelArray[i].getChildren().add(chooseNumberbutton[1]);
            }
            else if (i == 2){
                hboxLabelArray[i].getChildren().add(chooseNumberbutton[2]);
            }
            else if (i == 3){
                hboxLabelArray[i].getChildren().add(chooseNumberbutton[3]);
            }
            //setting color for the rownumbers and excluded labels
            rowNumberlabelArray[i].setStyle("-fx-border-color: yellow;");
            excludedLabelArray[i].setStyle("-fx-border-color: yellow;");
        }
        
       chooseButtonListener();
        
       this.getChildren().addAll(hboxLabelArray);
        
       numberChooser.initButtonArray();
    }
    
    //adding listeners for the 4 choose-number buttons
    public void chooseButtonListener(){
        for(int x = 0 ; x < chooseNumberbutton.length ; x++){
	        chooseNumberbutton[x].setOnMouseClicked(event -> {
                    for(int loopIndex = 0 ; loopIndex < chooseNumberbutton.length ; loopIndex++){
                        
                        if(event.getSource() == chooseNumberbutton[loopIndex]){
                            numberChooser.initNumberChooser(loopIndex);
                            numberChooser.showNumberChooser();
                        }
                        
                        else {
                             
                        }
                    }
                    
                });
        }
        
        
    }
    
    
    public Label[] getExcludedLabelArray(){
        return this.excludedLabelArray;
    }
    
    public int[] getExcludedNumbersArray(){
        return this.excludedNumbersArray;
    }
    
    
    public NumberChooser getNumberChooser(){
        return this.numberChooser;
    }
    
}