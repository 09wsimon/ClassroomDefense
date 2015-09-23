/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroomdefense;

import java.io.*;
/**
 *
 * @author 09wsimon
 */
public class HighScores {
       public static void High (String newName){
        try{
            String verify, putData;
            File file = new File("highscores.txt");
            String name = newName;
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(newName);
            bw.flush();
            bw.close();
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while( ( line = br.readLine()) != null){
                System.out.println(line);
            } 
        }catch(IOException e){
        e.printStackTrace();
        }    
         } 
}      