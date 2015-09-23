/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroomdefense;

/**
 *
 * @author 09wsimon
 */
import java.awt.*;
import java.awt.event.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.*;
import javax.swing.border.Border;

public class ClassroomDefense {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        
        int x;
        int y;
        for (x = 0; x < 10; x++)
            System.out.println("Is it working?");
        
        for (x = 0; x < 5; x++)
        {
            for (y = 0; y <= x; y++)
                System.out.print("*");
            System.out.println();
        }
        
        System.out.println("Hi?");
        ClassroomDefenseFrame frame = new ClassroomDefenseFrame();
    }
    
}

                 // XML Read
                 
                 try {
              de = new XMLDecoder(new BufferedInputStream(new FileInputStream("Info.xml")));
             }
           catch(Exception xx) {xx.printStackTrace();}
                                 
             
             try {
             
//             Read0 = (String)de.readObject();
//             n0 = (int)de.readObject();
             Read1 = (String)de.readObject();
             n1 = (int)de.readObject();
             
             
             
             Read2 = (String)de.readObject();
             n2 = (int)de.readObject();
             
             
             Read3 = (String)de.readObject();
             n3 = (int)de.readObject();
             
             
             
         }
             catch(Exception xx) {xx.printStackTrace();}
             
             try {
                 de.close();
             }
             catch(Exception xx) {xx.printStackTrace();}
             
             
             
             // XML Write
             
             try {
              xe = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Info.xml")));
             }
           catch(Exception xx) {xx.printStackTrace();}
             
        //read1,2 qand 3 PLUS  resultSt
         try {
             //IF STATEMENTS
             /*
             if ((n0>n1)&&(n0>n2)&&(n0>n3))
             {
             xe.writeObject(Read0);
             xe.writeObject(n0);
             xe.writeObject(Read1);
             xe.writeObject(n1);
             xe.writeObject(Read2);
             xe.writeObject(n2);
             }
             
             if ((n0<n1)&&(n0<n2)&&(n0<n3))
             {
                 xe.writeObject(Read1);
             xe.writeObject(n1);
             xe.writeObject(Read2);
             xe.writeObject(n2);
             xe.writeObject(Read3);
             xe.writeObject(n3);
             }
             if ((n0>n2)&&(n0>n3)&&(n0<n1))
             {
                  xe.writeObject(Read1);
             xe.writeObject(n1);
             xe.writeObject(Read0);
             xe.writeObject(n0);
             xe.writeObject(Read2);
             xe.writeObject(n2);
             
             
             xe.writeObject(Read0);
             xe.writeObject(n0);
             
             
             xe.writeObject(Read1);
            xe.writeObject(n1);
            
            
           
             xe.writeObject(Read2);
             xe.writeObject(n2);
             
             
             
            
         }
             
             catch(Exception xx) {xx.printStackTrace();}
        try {
            xe.close();
        }
        catch(Exception xx) {xx.printStackTrace();}
         
        
        
         }