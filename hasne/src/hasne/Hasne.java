

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hasne;

import frameapi.FrameAPI;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;
import frameapi.*;

/**
 *
 * @author victor.kemme
 */
public class Hasne 
{
    static String[][] move = new String[14][14];
    static String[][] arr = new String[14][14]; 
    static String[][] hasen = new String[14][14]; 
    static String[][] fuechse = new String[14][14]; 
    static String[][] unicorns = new String [14][14]; 
    public static void main(String[] args) throws IOException
            
    {  
        createSpielfeld();
        FrameAPI.initFrame();
        FrameAPI.initString(arr.length, arr);
        FrameAPI.setPlayground();
        do{
            if(FrameAPI.newRound){
                moveHasen();

                FrameAPI.initString(arr.length, arr);
                FrameAPI.setPlayground();
            }
        }while(!FrameAPI.allDead);
        
        
        System.out.println("Nächste Runde?"); 
        System.out.println();
        Scanner sc = new Scanner(System.in); 
        while(sc.next().equals("w")){ 
            System.out.println(" ");
            Spielfeld(); 
            System.out.println("Nächste Runde?");
            moveHasen();
        }
    }
    
    
   
    private static void createSpielfeld() throws IOException{ 
        for(int i = 0; i<arr.length; i++){
            for(int e = 0; e<arr.length; e++){
                arr[i][e] = ".";
                
            }
        } 
         for(int j=0;j<arr.length-1;j++){
           int x1 = (int) (Math.random() * 10); 
            
            arr[x1][j] = "U";
            unicorns[x1][j] = "U"; 
        }
         
        for(int j=0;j<arr.length-1;j++){
            int x1 = (int) (Math.random() * 10); 
            
            arr[x1][j] = "H";
            hasen[x1][j] = "H"; 
            
            
           
        }
        
        
        for(int j=0;j<arr.length-1;j++){
            int x1 = (int) (Math.random() * 10);
            
            arr[x1][j] = "F";
            fuechse[x1][j] = "F";
        }
       
      
            
        
        
        
         Ausgabe();
    }
     private static void Ausgabe(){
         
         for(int i = 0; i<arr.length; i++){
            for(int e = 0; e<arr.length; e++){
                System.out.print(arr[i][e] + " ");
            }
            System.out.println(); 
     }
    

    
    }
     private static void Spielfeld(){
         for(int i = 0; i<arr.length; i++){
            for(int e = 0; e<arr.length; e++){
                arr[i][e] = ".";
            }
        
        } 
        
        for(int j=0;j<arr.length;j++){
            for(int x1=0;x1<arr.length;x1++){
             
                if(hasen[x1][j] == "H"){
                    arr[x1][j] = "H";
                    
                }
               
                if(fuechse[x1][j] == "F"){
                    arr[x1][j] = "F";
                }
                if(unicorns[x1][j] == "U"){
                    arr[x1][j] = "U";
                }
            }
        }
        
      Ausgabe();
     }
     private static void moveHasen(){
         for(int v=0;v<14;v++){
            for(int b=0;b<14;b++){
                move[b][v] = arr[b][v];
                
            }
         }
         
         for(int v=0;v<14;v++){
            for(int b=0;b<14;b++){
                int r = (int) (Math.random() * 4); 
                if(r<3){
                 
                    if(move[v][b].equals("F")){
                    arr[v][b] = ".";
                    arr[v][b+1] = "F";
                    }
                }
                
                if(r>2){
                     if(move[v][b].equals("F")){
                     arr[v][b] = ".";
                     arr[v+1][b] = "F";
                
                    
               }
               }
                 if(move[v][12].equals("F")){
                 arr[v][b] = ".";
                 arr[v][0] =  "F";
                 } 
                 if(move[12][b].equals("F")){
                 arr[v][b] = ".";
                 arr[0][b] =  "F";
                 }   
                 
                
            }    
        } 
         for(int v=0;v<14;v++){
            for(int b=0;b<14;b++){
                move[b][v] = arr[b][v];
                
            }
         }
         for(int v=0;v<14;v++){
            for(int b=0;b<14;b++){
              
                
              
              int r = (int) (Math.random() * 4); 
              
              
              if(r<3){
              
                if(move[v][b].equals("H")){
                 arr[v][b] = ".";
                 arr[v+1][b] =  "H";
                }
                
             
            }
            if(r>2){         
            if(move[12][b].equals("H")){
            arr[v][b] = ".";
            arr[0][b+1] =  "H";
                }  
            }
            if(move[v][12].equals("H")){
            arr[v][b] = ".";
            arr[v][0] =  "H";
                }  
            if(move[12][b].equals("H")){
            arr[v][b] = ".";
            arr[0][b] =  "H";
                }  
            }        
        }for(int v=0;v<14;v++){
            for(int b=0;b<14;b++){
                move[b][v] = arr[b][v];
                
            }
         }
         
         for(int v=0;v<14;v++){
            for(int b=0;b<14;b++){
                int r = (int) (Math.random() * 4); 
                if(r<3){
                 
                    if(move[v][b].equals("U")){
                    arr[v][b] = ".";
                    arr[v][b+1] = "U";
                    }
                }
                
                if(r>2){
                     if(move[v][b].equals("U")){
                     arr[v][b] = ".";
                     arr[v+1][b] = "U";
                
                    
               }
               }
                 if(move[v][12].equals("U")){
                 arr[v][b] = ".";
                 arr[v][0] =  "U";
                 } 
                 if(move[12][b].equals("U")){
                 arr[v][b] = ".";
                 arr[0][b] =  "U";
                 }   
                 
                
            }    
        }         
     }
    
     private static void Datei() throws IOException {
       FileWriter writer = new FileWriter("H:\\Hase.txt", true);
        writer.write("E1b is Watching you");
        writer.close();
        
        
        
        
        FileReader fr = new FileReader("H:\\Hase.txt");
        BufferedReader reader = new BufferedReader(fr);
        String string1 = reader.readLine();
        while(null!=string1){
           
           string1 = reader.readLine();
           reader.close();
           
        }
     }
         
     }


    
     
 
    

