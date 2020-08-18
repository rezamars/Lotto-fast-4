/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Graphic.Center;
import Graphic.Left;
import Graphic.Right;
import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 *
 * @author Reza
 */
//this class handles the generation (randomizing) of the 6 kenorows
public class Ran11LottoRows {
    
    private Right right1;
    private Left left1;
    private Center center1;
    private Button ranButton;
    private int[] excludeNumbersArray;
    
    private Label[] lottoLabelArray;
    private int[] lottoNumberArray= new int[77];
    private Random ran = new Random();
    
    
    public Ran11LottoRows(Right right, Left left, Center center){
        
        this.left1 = left;
        this.right1 = right;
        this.center1 = center;
        this.ranButton = right1.getRanButton();
        this.lottoLabelArray = center1.getLottoLabelArray();
        this.excludeNumbersArray = left1.getExcludedNumbersArray();
        
        addRanButtonListener();
    }
    
    //adds listener to the ran-button, starts counting at click
    public void addRanButtonListener(){
        
        ranButton.setOnAction(e -> {
            randomize6Rows();
            fillThe6RowsInLabels();
        });
            
    }
    
    //handles the counting of amount of numbers chosen by the user
    //if 4 numbers chosen, the ranbutton becomes clickable
    public void setRanButtonEnabling(){
        
        int exCounter = 0;
        
        for(int x = 0 ; x < 4 ; x++){
            if (excludeNumbersArray[x] != (-1)){
                exCounter++;
            }
        }
        
        if (exCounter == 4){
            ranButton.setDisable(false);
        }
        else{
            ranButton.setDisable(true);
        }
    }
    
    
    //method for filling the lottoNumberArray-array
    //and making sure that every number (1-70) are represented once
    //and that 4 numbers are excluded (chosen by the user)
    public void randomize6Rows(){
        
        for (int i = 0 ; i < 66 ; i++){
            lottoNumberArray[i] = 0;
        }
        
        //initial filling of the lottoNumberArray-array
        for(int x = 0 ; x < 66 ; x++){
            int ra = ran.nextInt(70);
            lottoNumberArray[x] = (ra + 1);
        }
        
        //making sure the 4 excluded numbers are not in the lottoNumberArray-array
        //making sure there is no dublicates
        int x= 0;
        while( x<66 ){
            
            for(int i = 0 ; i<66 ; i++){
                for (int t = 0 ; t < 4 ; t++){
                    if (lottoNumberArray[x] == ((excludeNumbersArray[t])+1)){
                        int ra = ran.nextInt(70);
                        lottoNumberArray[x] = (ra + 1);
                        x=0;
                    }
                }
                if(lottoNumberArray[x] == lottoNumberArray[i] && i!=x){
                    int ra = ran.nextInt(70);
                    lottoNumberArray[x] = (ra + 1);
                    x=0;
                }
                
            }
            x++;
        }
        
        sortArray11();
    }
    
    //Sorting every kenorow in acsending order
    public void sortArray11(){
        
        int temp = 0;
        
        for (int i = 0; i < 11; i++) {
            
            for (int j = i; j > 0; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 11; i < 22; i++) {
            
            for (int j = i; j > 11; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 22; i < 33; i++) {
            
            for (int j = i; j > 22; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 33; i < 44; i++) {
            
            for (int j = i; j > 33; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 44; i < 55; i++) {
            
            for (int j = i; j > 44; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 55; i < 66; i++) {
            
            for (int j = i; j > 55; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
    }
    
    //filling the labels of the randomized kenorows
    public void fillThe6RowsInLabels(){
        
        int arrayIndex = 0;
        
        for(int w=0; w<6; w++){
            
            for(int i=0; i<11; i++){

                lottoLabelArray[arrayIndex].setText((Integer.toString(lottoNumberArray[arrayIndex])) + ",");
                arrayIndex++;
            }
            
            
        }
        
        
    }
    
}
