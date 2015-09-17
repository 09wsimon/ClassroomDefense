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
