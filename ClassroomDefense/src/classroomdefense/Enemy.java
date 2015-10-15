package classroomdefense;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class Enemy extends JButton
{
    private int health;
    private ImageIcon image;
    
    public Enemy()
    {
        super();
        health=100;
        image = new ImageIcon("images/cartoon_duck-1979px_1.png");
        this.setIcon(image);
        this.setSize(50, 50);
    }
    public int getHealth()
    {
        return this.health;
    }
    public void setHealth(int newHealth)
    {
        this.health = newHealth;
    }
}
