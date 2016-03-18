

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
    static String[][] dead = new String[14][14];
    static String[][] special = new String[14][14];
    public static void main(String[] args) throws IOException{  
        createSpielfeld();
        FrameAPI.initFrame();
        FrameAPI.initString(arr.length, arr);
        FrameAPI.setPlayground();
        do{
            if(FrameAPI.newRound){
                int o = (int) (Math.random() * 4);
                if(o>3){
                    moveUnicorns();
                    moveFuechse();
                    moveHasen();
                }
                else{
                    moveHasen();
                    moveUnicorns();
                    moveFuechse();
                }
                Tot();
                Paaren();
                //Datei();

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
        
        
        for(int j=0;j<arr.length-5;j++){
            int x1 = (int) (Math.random() * 10); 
            
            arr[x1][j] = "H";
            hasen[x1][j] = "H"; 
            
            
           
        }
        
        
        for(int j=0;j<arr.length;j++){
            int x1 = (int) (Math.random() * 10);
            
            arr[x1][j] = "F";
            fuechse[x1][j] = "F";
        }
        for(int j=0;j<arr.length;j++){
            int x1 = (int) (Math.random() * 10); 
            
            arr[x1][j] = "U";
            unicorns[x1][j] = "U"; 
        
        
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
         int r = (int) (Math.random() * 4);
         
         for(int v=0;v<14;v++){
            for(int b=0;b<14;b++){
                move[b][v] = arr[b][v];
                
            }
         }
         for(int v=0;v<14;v++){
            for(int b=0;b<14;b++){
             if(move[v][12].equals("H")){
               arr[v][b] = ".";
               arr[v][1] =  "H";
                }
             if(move[12][b].equals("H")){
               arr[v][b] = ".";
               arr[1][b] =  "H";
                }
             if(r<3){
                if(move[v][b].equals("H")){
                    arr[v][b] = ".";
                    arr[v][b+1] = "H";
                }
             }
             if(r>2){
                if(move[v][b].equals("H")){
                    arr[v][b] = ".";
                    arr[v+1][b] = "H";
                }        
                    
                } 
             
            }    
         }
         
        
    }
     private static void moveFuechse(){
         int r = (int) (Math.random() * 4);
         for(int v=0;v<14;v++){
            for(int b=0;b<14;b++){
                move[b][v] = arr[b][v];
                
            }
         }
         for(int v=0;v<14;v++){
            for(int b=0;b<14;b++){
                if(move[12][b].equals("F")){
                 arr[v][b] = ".";
                 arr[1][b] =  "F";
                }
                 if(move[v][12].equals("F")){
                 arr[v][b] = ".";
                 arr[v][1] =  "F";
             
             if(r<3){
                if(move[v][b].equals("F")){
                    arr[v][b] = ".";
                    arr[v+1][b] = "F";
                }    
             } 
             if(r>2){
                if(move[v][b].equals("F")){
                    arr[v][b] = ".";
                    arr[v][b+1] = "F";
                }    
             }        
                    
                
                
         }        
         }
        }
         
     }
     private static void moveUnicorns(){
         int r = (int) (Math.random() * 4);
         for(int v=0;v<14;v++){
            for(int b=0;b<14;b++){
                move[b][v] = arr[b][v];
                
            }
         }
         for(int v=0;v<14;v++){
            for(int b=0;b<14;b++){
                if(move[12][b].equals("U")){
                 arr[v][b] = ".";
                 arr[1][b] =  "U";
                }
                 if(move[v][12].equals("U")){
                 arr[v][b] = ".";
                 arr[v][1] =  "U";
             
             if(r<3){
                if(move[v][b].equals("U")){
                    arr[v][b] = ".";
                    arr[v+1][b] = "U";
                }    
             } 
             if(r>2){
                if(move[v][b].equals("U")){
                    arr[v][b] = ".";
                    arr[v][b+1] = "U";
                }    
             }        
                    
                
                
         }        
         }
        }
         
     }
     private static void Tot(){
         for(int v=0;v<14;v++){
            for(int b=0;b<14;b++){
                dead[b][v] = arr[b][v];
                
                if(dead[v][b].equals("F")){
                    if(dead[v+1][b].equals("H")){
                        arr[v][b] = "G";
                    }
                    if(dead[v-1][b].equals("H")){
                        arr[v][b] = "G";
                    }
                    if(dead[v][b+1].equals("H")){
                        arr[v][b] = "G";
                    }
                    if(dead[v][b-1].equals("H")){
                        arr[v][b] = "G";
                    }
                    
                }
               
                
                
                
            }     
       }           
     }
     private static void Paaren(){
          int r = (int) (Math.random() * 2);
          for(int v=0;v<14;v++){
            for(int b=0;b<14;b++){
                dead[b][v] = arr[b][v];
             if(r == 1){    
                if(dead[v][b].equals("H")){
                    if(dead[v+1][b].equals("H")){
                        arr[v+2][b] = "H";
                    }
                    if(dead[v-1][b].equals("H")){
                        arr[v-2][b] = "H";
                    }
                    if(dead[v][b+1].equals("H")){
                        arr[v][b+2] = "H";
                    }
                    if(dead[v][b-1].equals("H")){
                        arr[v][b-2] = "H";
                    }
                    
                }
             }        
            }     
       }           
      for(int v=0;v<14;v++){
            for(int b=0;b<14;b++){
                dead[b][v] = arr[b][v];
                 
                if(dead[v][b].equals("F")){
                    if(dead[v+1][b].equals("F")){
                        arr[v+2][b] = "F";
                    }
                    if(dead[v-1][b].equals("F")){
                        arr[v-2][b] = "F";
                    }
                    if(dead[v][b+1].equals("F")){
                        arr[v][b+2] = "F";
                    }
                    if(dead[v][b-1].equals("F")){
                        arr[v][b-2] = "F";
                    }  
                }
            }             
        }              
     } 
     private static void UnicornSpecial(){
         int r = (int) (Math.random() * 4);
         for(int v=0;v<14;v++){
            for(int b=0;b<14;b++){
                special[b][v] = arr[b][v];
                
            }
         }
         for(int v=0;v<14;v++){
            for(int b=0;b<14;b++){
                if(special[v][b].equals("U")){
                    if(special[v-1][b].equals("H")){
                        arr[v+1][b] = "H";
                    }
                    if(special[v+1][b].equals("H")){
                        arr[v-1][b] = "H";
                    }
                    if(special[v][b+1].equals("H")){
                        arr[v][b-1] = "H";
                    }
                    if(special[v][b-1].equals("H")){
                        arr[v][b+1] = "H";
                    }
                }
                
            }
        }
         
     } 
     private static void Datei() throws IOException {
       FileWriter writer = new FileWriter("C:\\Hase.txt", true);
        writer.write("LULULULULULULULULULULULULULULULLULULULULULULU");
        writer.close();
        
        
        
        
        FileReader fr = new FileReader("C:\\Hase.txt");
        BufferedReader reader = new BufferedReader(fr);
        String string1 = reader.readLine();
        while(null!=string1){
           
           string1 = reader.readLine();
           reader.close();
           
        }
    }
}
     

         
     


    
     
 
    

