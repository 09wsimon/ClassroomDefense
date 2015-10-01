package classroomdefense;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class Wave 
{
    private int waveNumber;
    private String difficulty;
    private int enemyCount;
    private int enemyHealth;
    private int enemySpeed;
    private Enemy[] enemies;
    
    public Wave(int waveNumber, String difficulty)
    {
        this.waveNumber=waveNumber;
        this.difficulty=difficulty;
    }
    public Enemy[] enemies()
    {
        enemies = new Enemy[enemyCount];
        for (int i=0;i<enemyCount;i++)
        {
            enemies[i] = new Enemy(enemyHealth, enemySpeed);
        }
        return enemies;
    }
    public int getEnemyCount()
    {
        return enemyCount;
    }
    public int getEnemyHealth()
    {
        return enemyHealth;
    }
    public int getEnemySpeed()
    {
        return enemySpeed;
    }
}
