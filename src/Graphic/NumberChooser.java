/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphic;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Reza
 */
//this class handles the window that the user can click which numbers
//he or she choses to exclude from the 70 numbers
public class NumberChooser {
    
    private BorderPane borderPane = new BorderPane();
    private Stage numberChooserStage = new Stage();
    private Scene ncScene = new Scene(borderPane, 290, 80);
    private Button[] buttonArray = new Button[35];
    private Left left1;
    private Label[] excludedLabelArray;
    private int excludeIndex = 0;
    private  String strAdd = "  ";
    private int[] excludeNumbersArray;
    private HBox[] hboxArray = new HBox[7];
    
    private NumberChooser numberChooser;
    
    
    public NumberChooser(Left left){
        
        this.left1 = left;
        this.excludeNumbersArray = left1.getExcludedNumbersArray();
        this.excludedLabelArray = left1.getExcludedLabelArray();
        this.numberChooser = left1.getNumberChooser();
        
    }
    
    public void initButtonArray(){
        
        //create new objects of the hboxes
        for (int h = 0 ; h < hboxArray.length ; h++){
            hboxArray[h] = new HBox();
        }
        
        Font buttonFont ;
        buttonFont = Font.font("Arial", FontWeight.BOLD, 10);
        
        //adding the buttons to the layout
        for (int y = 0 ; y < buttonArray.length ; y++){
            buttonArray[y] = new Button("" + (y+1) + "");
            if(y<10){
                buttonArray[y].setText(" " + (y+1) + " ");
                hboxArray[0].getChildren().add(buttonArray[y]);
            }
            else if((y>9) && (y<20)){
                hboxArray[1].getChildren().add(buttonArray[y]);
            }
            else if((y>19) && (y<30)){
                hboxArray[2].getChildren().add(buttonArray[y]);
            }
            else if((y>29) && (y<35)){
                hboxArray[3].getChildren().add(buttonArray[y]);
            }
            /*
            else if((y>39) && (y<50)){
                hboxArray[4].getChildren().add(buttonArray[y]);
            }
            else if((y>49) && (y<60)){
                hboxArray[5].getChildren().add(buttonArray[y]);
            }
            else if((y>59) && (y<70)){
                hboxArray[6].getChildren().add(buttonArray[y]);
            }
            */
            
            buttonArray[y].setFont(buttonFont);
        }
        
    }
    
    //addes the hboxes to the window and sets some settings and properties
    public void initNumberChooser(int index){
        
        excludeIndex = index;
        
        numberChooserStage.setTitle("Välj nummer!");
        
        VBox topd = new VBox();
        topd.setPadding(new Insets(0, 10, 0, 10));  
        topd.setSpacing(1);
        
        topd.getChildren().addAll(hboxArray);
        
        borderPane.setTop(topd);
        
        numberChooserStage.setScene(ncScene);
        
        addExcludeButtonListener();
        
    }
    
    public void showNumberChooser(){
        numberChooserStage.show();
    }
    
    
    //adds listener to the buttons in numberchooser
    //sends the index of the button clicked to the method that 
    //handles enabling and disabling of the numbers that the user
    //wants to exclude
    public void addExcludeButtonListener(){
	     
        for(int x = 0 ; x < buttonArray.length ; x++){
                
	        buttonArray[x].setOnMouseClicked(event -> {
                    
                    showNumberChooser();
                    for(int loopIndex = 0 ; loopIndex < buttonArray.length ; loopIndex++){
                        
                        if(event.getSource() == buttonArray[loopIndex]){
                            
                            if (loopIndex < 9){
                                strAdd = "  " + Integer.toString(loopIndex+1) + " ";
                            }
                            else {
                                strAdd = "" + Integer.toString(loopIndex+1) + " ";
                            }
                            excludedLabelArray[excludeIndex].setText(strAdd);
                            setExcludeNumberInNumberArrayAndDisable(excludeIndex, loopIndex);
                            
                            //this.left1.getRan6Rows().setRanButtonEnabling();
                            
                            numberChooserStage.close();
                        }
                        
                        else {
                             
                        }
                    }
                    
                    
                });
        }
    }     
    
    //saves the number that the user want to exclude from the kenorows
    //enables and disables the numbers the user chooses
    public void setExcludeNumberInNumberArrayAndDisable(int exIndex, int number){
        
        int a = 0;
        a = excludeNumbersArray[exIndex];
        
        if (a != -1){
            buttonArray[a].setDisable(false);
        }
        
        excludeNumbersArray[exIndex] = number;
        buttonArray[number].setDisable(true);
    }
    
    public Button[] getButtonArray(){
        return this.buttonArray;
    }
    
    
}
