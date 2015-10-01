package classroomdefense;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class Enemy 
{
    private int health;
    private int speed;
    private ImageIcon image;
    
    public Enemy(int health, int speed)
    {
        this.health=health;
        this.speed=speed;
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
