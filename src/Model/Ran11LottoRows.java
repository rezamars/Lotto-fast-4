/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Graphic.Center;
import Graphic.Left;
import Graphic.Right;
import java.util.ArrayList;
import java.util.Random;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
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
    private int[] fixed4NumbersArray;
    
    private Label[] lottoLabelArray;
    private int[] lottoNumberArray= new int[77];
    private Random ran = new Random();
    private  boolean[] numberFlagArray = new boolean[35];
    
    private int[] amountOfEachNumber = new int[35];
    
    private int[][] savingIndexesArray= new int[11][7];;
    
    private int[] arrayOf31 = new int[31];
    private int[] twoDublicatesArray = new int[2];
    
    
    public Ran11LottoRows(Right right, Left left, Center center){
        
        this.left1 = left;
        this.right1 = right;
        this.center1 = center;
        this.ranButton = right1.getRanButton();
        this.lottoLabelArray = center1.getLottoLabelArray();
        this.fixed4NumbersArray = left1.get4FixedNumbersArray();
        
        for(int i = 0 ; i < 35 ; i++){
            amountOfEachNumber[i] = 0;
        }
        
        
        
        addRanButtonListener();
    }
    
    //adds listener to the ran-button, starts counting at click
    public void addRanButtonListener(){
        
        ranButton.setOnAction(e -> {
            fillTheLottoArrayWith0AndThefixedNumbers();
            randomize11Rows();
            sortArray7();
            setLottoLabelColours();
            fillThe11RowsInLabels();
        });
            
    }
    
    //handles the counting of amount of numbers chosen by the user
    //if 4 numbers chosen, the ranbutton becomes clickable
    public void setRanButtonEnabling(){
        
        int exCounter = 0;
        
        for(int x = 0 ; x < 4 ; x++){
            if (fixed4NumbersArray[x] != (-1)){
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
    
    public void fillTheLottoArrayWith0AndThefixedNumbers(){
        
        for (int i = 0 ; i < 77 ; i++){
            lottoNumberArray[i] = 0;
        }
        
        //int rowSquareIndex = 0;
        //int rowNumber = 1;
        int fixedNumberFromIndex = 0;
        int fixedNumberUntilIndex = 0;
        //int x = 0;
        //while ( x < 77){
        for(int x = 0 ; x<77 ; x+=7){
            
            if ( x == 0){
                fixedNumberFromIndex = 0;
                fixedNumberUntilIndex = 3;
            }
            else if( x == 7){
                fixedNumberFromIndex = 7;
                fixedNumberUntilIndex = 10;
            }
            else if( x == 14){
                fixedNumberFromIndex = 14;
                fixedNumberUntilIndex = 17;
            }
            else if( x == 21){
                fixedNumberFromIndex = 21;
                fixedNumberUntilIndex = 24;
            }
            else if( x == 28){
                fixedNumberFromIndex = 28;
                fixedNumberUntilIndex = 31;
            }
            else if( x == 35){
                fixedNumberFromIndex = 35;
                fixedNumberUntilIndex = 38;
            }
            else if( x == 42){
                fixedNumberFromIndex = 42;
                fixedNumberUntilIndex = 45;
            }
            else if( x == 49){
                fixedNumberFromIndex = 49;
                fixedNumberUntilIndex = 52;
            }
            else if( x == 56){
                fixedNumberFromIndex = 56;
                fixedNumberUntilIndex = 59;
            }
            else if( x == 63){
                fixedNumberFromIndex = 63;
                fixedNumberUntilIndex = 66;
            }
            else if( x == 70){
                fixedNumberFromIndex = 70;
                fixedNumberUntilIndex = 73;
            }
            
            int loopIter = 0;
            for(int k = fixedNumberFromIndex ; k <= fixedNumberUntilIndex ; k++){
                lottoNumberArray[k] = (fixed4NumbersArray[loopIter])+1;
                loopIter++;
            }
            
            
        }
        
    }
    
    //method for filling the lottoNumberArray-array
    //and making sure that every number (1-70) are represented once
    //and that 4 numbers are excluded (chosen by the user)
    public void randomize11Rows(){
        
        for (int i = 0 ; i < arrayOf31.length ; i++){
            arrayOf31[i] = 0;
        }
        
        for(int a = 0 ; a < arrayOf31.length ; a++){
            
            int ra = ran.nextInt(35);
            for(int t = 0 ; t<4 ; t++){ 
                if ((ra+1) != fixed4NumbersArray[t]+1){
                    arrayOf31[a] = (ra + 1);
                    
                }
            }
            
        }
        
        
        
        int x= 0;
        while( x<arrayOf31.length ){
            
            for(int i = 0 ; i<arrayOf31.length ; i++){
                
                if(((arrayOf31[x] == arrayOf31[i]) && (i!=x)) || ((fixed4NumbersArray[0]+1) == arrayOf31[i]) || 
                        ((fixed4NumbersArray[1]+1) == arrayOf31[i]) || ((fixed4NumbersArray[2]+1) == arrayOf31[i]) || 
                        ((fixed4NumbersArray[3]+1) == arrayOf31[i])){
                    int ra = ran.nextInt(35);
                    arrayOf31[i] = (ra + 1);
                    x=0;
                }
            }
            x++;
        }
        
        
        for(int u = 0 ; u < 31 ; u++){
            //System.out.println(arrayOf31[u]);
        }
        
        int twoRan1 = ran.nextInt(35);
        twoDublicatesArray[0] = twoRan1+1;
        int twoRan2 = ran.nextInt(35);
        twoDublicatesArray[1] = twoRan2+1;
        
        for(int i = 0 ; i < 2 ; i++){
            
            if( (twoDublicatesArray[0] == twoDublicatesArray[1]) || ((fixed4NumbersArray[0]+1) == twoDublicatesArray[i]) || 
                        ((fixed4NumbersArray[1]+1) == twoDublicatesArray[i]) || ((fixed4NumbersArray[2]+1) == twoDublicatesArray[i]) || 
                        ((fixed4NumbersArray[3]+1) == twoDublicatesArray[i]) || (twoDublicatesArray[i] == arrayOf31[30])){
                int ra = ran.nextInt(35);
                twoDublicatesArray[i] = ra+1;
            }
        }
        
        //System.out.println("---");
        
        for(int i = 0 ; i < 2 ; i++){
            System.out.println(twoDublicatesArray[i]);
        }
        
        System.out.println("------------------------");
        
        fillTheRestOfLottoArray();
        
    }
    
    public void fillTheRestOfLottoArray(){
        
        int randomNumberFromIndex = 0;
        int randomNumberUntilIndex = 0;
        int arrayOf31loopIter = 0;
        //while ( x < 77){
        for(int x = 0 ; x<77 ; x+=7){
            
            if ( x == 0){
                randomNumberFromIndex = 4;
                randomNumberUntilIndex = 6;
            }
            else if( x == 7){
                randomNumberFromIndex = 11;
                randomNumberUntilIndex = 13;
            }
            else if( x == 14){
                randomNumberFromIndex = 18;
                randomNumberUntilIndex = 20;
            }
            else if( x == 21){
                randomNumberFromIndex = 25;
                randomNumberUntilIndex = 27;
            }
            else if( x == 28){
                randomNumberFromIndex = 32;
                randomNumberUntilIndex = 34;
            }
            else if( x == 35){
                randomNumberFromIndex = 39;
                randomNumberUntilIndex = 41;
            }
            else if( x == 42){
                randomNumberFromIndex = 46;
                randomNumberUntilIndex = 48;
            }
            else if( x == 49){
                randomNumberFromIndex = 53;
                randomNumberUntilIndex = 55;
            }
            else if( x == 56){
                randomNumberFromIndex = 60;
                randomNumberUntilIndex = 62;
            }
            else if( x == 63){
                randomNumberFromIndex = 67;
                randomNumberUntilIndex = 69;
            }
            else if( x == 70){
                randomNumberFromIndex = 74;
                randomNumberUntilIndex = 76;
            }
            
            if( x == 70 ){
                lottoNumberArray[74] = arrayOf31[30];
                lottoNumberArray[75] = twoDublicatesArray[0];
                lottoNumberArray[76] = twoDublicatesArray[1];
            }
            else{
                for(int k = randomNumberFromIndex ; k <= randomNumberUntilIndex ; k++){
                lottoNumberArray[k] = arrayOf31[arrayOf31loopIter];
                arrayOf31loopIter++;
                }
            }
            
            
           
            
        }
        
        
        //setFlagArray();
        
        
        //fixTheRows();
    }
        
    public void setFlagArray(){
    
        for(int f = 0 ; f < 35 ; f++){
            numberFlagArray[f] = false;
        }
        
        for(int p = 0 ; p < 35 ; p++){
            for(int i = 0 ; i<77 ; i++){
                
                if (lottoNumberArray[i] == (p+1)){
                    numberFlagArray[p] = true;
                }
                else{
                    //fixTheRows(p+1);
                        
                }
                
            }
        }    
                
        printTheflagArray();  
        
        //sortArray11();
    }
    
    public void fixTheRows(){
        
        //making sure the 4 excluded numbers are not in the lottoNumberArray-array
        //making sure there is no dublicates
        
        
        /*
        int x= 0;
        while( x < 11 ){  
        for(int i = 0 ; i<11 ; i++){
            for(int y = 0 ; y<7 ; y++){    
        
            for(int j = 0 ; j<7 ; j++){ 
                /*
                for(int t = 0 ; t<4 ; t++){ 
                    if ((lottoNumberArray[i][j] == ((fixed4NumbersArray[t])+1))){
                    
                        int ra = ran.nextInt(35);
                        //lottoNumberArray[i][j] = (ra + 1);
                        //x = 0;
                        
                    }
                }
                
                int xynumber = lottoNumberArray[x][y];
                int ijnumber = lottoNumberArray[i][j];
                
                if ((lottoNumberArray[x][y] == lottoNumberArray[i][j]) && (i!=x) && (y!=j)){
                    int ra = ran.nextInt(35);
                    lottoNumberArray[i][j] = (ra + 1);
                    x = 0;
                    i = 0;
                    y = 0;
                    j = 0;
                    
                }
            }   
        }   
        }
        x++;
        }
        */
        
        //countAmountOfEachNumber();
        
    }
    
    public void countAmountOfEachNumber(){
        
        
        
        //replace();
         
         
        for(int i = 0 ; i < 35 ; i++){
           //System.out.println("i:" + i + " - amount: " + amountOfEachNumber[i]);
        }
         
        String orgStr = "10,3";
        int av = 1;
        String Str1 = "aa";
        String Str2 = "bb";
        
        int to = -1;        
        to = orgStr.indexOf(",");
        String str1 = "";
        String str2 = "";
        str1 = orgStr.substring(0, to);
        str2 = orgStr.substring(to+1);
        
        //System.out.println("str1: " + str1 + "---- str2: " + str2);
        
        
        for(int i = 0 ; i < 11 ; i++){
            for(int r = 0 ; r < 7 ; r++){
                //System.out.println("i:" + i + ", r:" + r + " - " + savingIndexesArray[i][r]);
            }
        }
        
        /*
        int a = 0;
        while( a < 11 ){  
            for(int q = 0 ; q < 11 ; q++){
                for(int w = 0 ; w < 7 ; w++){
                    for(int e = 0 ; e < 7 ; e++){
                        if ((lottoNumberArray[q][w] == lottoNumberArray[q][e]) && (w!=e)){
                            int switchNumber = 0;
                            switchNumber = lottoNumberArray[q][w];
                            lottoNumberArray[q][w] = lottoNumberArray[q][5];
                            lottoNumberArray[q][5] = switchNumber;
                            a = 0;
                            /*
                            int ra = ran.nextInt(35);
                            lottoNumberArray[q][w] = (ra + 1);
                            a = 0;
                            
                        }
                    }
                }
            }
            a++;
        }
        */
    }
    
    public void makingSure(){
        
        
        
        ArrayList<Integer> zeroList = new ArrayList<Integer>();
        ArrayList<Integer> oneList = new ArrayList<Integer>();
        ArrayList<Integer> twoList = new ArrayList<Integer>();
        ArrayList<Integer> moreThan2List = new ArrayList<Integer>();
        
        for(int i = 0 ; i < 35 ; i++){
            if(amountOfEachNumber[i] == 0){
                zeroList.add(i);
            }
            else if(amountOfEachNumber[i] == 1){
                oneList.add(i);
            }
            else if(amountOfEachNumber[i] == 2){
                twoList.add(i);
            }
            else if(amountOfEachNumber[i] > 2){
                moreThan2List.add(i);
            }
        }
        
        
        for(int i = 0 ; i < moreThan2List.size() ; i++){
            
        }
        
    }
    
    
    public void printTheflagArray(){
        for(int f = 0 ; f < 35 ; f++){
            System.out.println("FlagArray: " + numberFlagArray[f]);
        }  
        System.out.println("-----------------");
    }
    
    public void setLottoLabelColours(){
        
        int everyOtherIndex = 0;
        
        for(int i = 0 ; i < 77 ; i++){
            if((i>-1 && i<7)){
                BackgroundFill background_fill = new BackgroundFill(Color.LIGHTGREEN,  CornerRadii.EMPTY, Insets.EMPTY);
                Background background = new Background(background_fill);
                lottoLabelArray[i].setBackground(background);
            }
            else if((i>6 && i<14)){
                BackgroundFill background_fill = new BackgroundFill(Color.PINK,  CornerRadii.EMPTY, Insets.EMPTY);
                Background background = new Background(background_fill);
                lottoLabelArray[i].setBackground(background);
            }
            else if((i>13 && i<21)){
                BackgroundFill background_fill = new BackgroundFill(Color.LIGHTGREEN,  CornerRadii.EMPTY, Insets.EMPTY);
                Background background = new Background(background_fill);
                lottoLabelArray[i].setBackground(background);
            }
            else if((i>20 && i<28)){
                BackgroundFill background_fill = new BackgroundFill(Color.PINK,  CornerRadii.EMPTY, Insets.EMPTY);
                Background background = new Background(background_fill);
                lottoLabelArray[i].setBackground(background);
            }
            else if((i>27 && i<35)){
                BackgroundFill background_fill = new BackgroundFill(Color.LIGHTGREEN,  CornerRadii.EMPTY, Insets.EMPTY);
                Background background = new Background(background_fill);
                lottoLabelArray[i].setBackground(background);
            }
            else if((i>34 && i<42)){
                BackgroundFill background_fill = new BackgroundFill(Color.PINK,  CornerRadii.EMPTY, Insets.EMPTY);
                Background background = new Background(background_fill);
                lottoLabelArray[i].setBackground(background);
            }
            else if((i>41 && i<49)){
                BackgroundFill background_fill = new BackgroundFill(Color.LIGHTGREEN,  CornerRadii.EMPTY, Insets.EMPTY);
                Background background = new Background(background_fill);
                lottoLabelArray[i].setBackground(background);
            }
            else if((i>48 && i<56)){
                BackgroundFill background_fill = new BackgroundFill(Color.PINK,  CornerRadii.EMPTY, Insets.EMPTY);
                Background background = new Background(background_fill);
                lottoLabelArray[i].setBackground(background);
            }
            else if((i>55 && i<63)){
                BackgroundFill background_fill = new BackgroundFill(Color.LIGHTGREEN,  CornerRadii.EMPTY, Insets.EMPTY);
                Background background = new Background(background_fill);
                lottoLabelArray[i].setBackground(background);
            }
            else if((i>62 && i<70)){
                BackgroundFill background_fill = new BackgroundFill(Color.PINK,  CornerRadii.EMPTY, Insets.EMPTY);
                Background background = new Background(background_fill);
                lottoLabelArray[i].setBackground(background);
            }
            else if((i>69 && i<77)){
                BackgroundFill background_fill = new BackgroundFill(Color.LIGHTGREEN,  CornerRadii.EMPTY, Insets.EMPTY);
                Background background = new Background(background_fill);
                lottoLabelArray[i].setBackground(background);
            }
            //BackgroundFill background_fill = new BackgroundFill(Color.LIGHTBLUE,  CornerRadii.EMPTY, Insets.EMPTY); 
            //Background background = new Background(background_fill);
            //lottoLabelArray[i].setBackground(background);
            //lottoLabelArray[i].setStyle("-fx-border-color: red;");
            lottoLabelArray[i].setTextFill(Color.BLACK);
        }
        
        for(int i = 0 ; i < 77 ; i++){
            for(int t = 0 ; t<4 ; t++){ 
                if(lottoNumberArray[i] == fixed4NumbersArray[t]+1){
                    BackgroundFill background_fill = new BackgroundFill(Color.PINK,  CornerRadii.EMPTY, Insets.EMPTY); 
                    Background background = new Background(background_fill);
                    //lottoLabelArray[i].setBackground(background);
                    //lottoLabelArray[i].setStyle("-fx-border-color: pink;");
                    //lottoLabelArray[i].setTextFill(Color.GREEN);
                }
                
            }
            
        }
        
    }
    
    
    //Sorting every lottorow in acsending order
    public void sortArray7(){
        
        int temp = 0;
        
        for (int i = 0; i < 7; i++) {
            
            for (int j = i; j > 0; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 7 ; i < 14 ; i++) {
            
            for (int j = i; j > 7; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 14; i < 21; i++) {
            
            for (int j = i; j > 14; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 21; i < 28; i++) {
            
            for (int j = i; j > 21; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 28; i < 35; i++) {
            
            for (int j = i; j > 28; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 35; i < 42; i++) {
            
            for (int j = i; j > 35; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 42; i < 49; i++) {
            
            for (int j = i; j > 42; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 49; i < 56; i++) {
            
            for (int j = i; j > 49; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 56; i < 63 ; i++) {
            
            for (int j = i; j > 56; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 63 ; i < 70; i++) {
            
            for (int j = i; j > 63; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 70; i < 77; i++) {
            
            for (int j = i; j > 70; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
    }
    
    
    //filling the labels of the randomized kenorows
    public void fillThe11RowsInLabels(){
        
        int arrayIndex = 0;
        
        for(int w=0; w<77; w++){
            
            //for(int i=0; i<7; i++){

                lottoLabelArray[arrayIndex].setText(" " + (Integer.toString(lottoNumberArray[w])) + " ");
                arrayIndex++;
            //}
            
            
        }
        
        
    }
    
    
}
