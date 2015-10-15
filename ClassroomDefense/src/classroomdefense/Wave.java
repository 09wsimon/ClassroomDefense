package classroomdefense;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
public class Wave 
{
    private int waveNumber;
    private String difficulty;
    private int enemyCount;
    private ArrayList<Enemy> enemies;
    
    public Wave(int waveNumber, String difficulty)
    {
        this.waveNumber=waveNumber;
        this.difficulty=difficulty;
        enemyCount = 10+(3*waveNumber);
    }
    public ArrayList enemies()
    {
        enemies = new ArrayList(enemyCount);
        for (int i=0;i<enemyCount;i++)
        {
            enemies.add(new Enemy());
        }
        return enemies;
    }
}
