package classroomdefense;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class ClassroomDefenseFrame extends JFrame
{
    private String playerName;
    private String difficulty;
    private int playerScore = 0;
    private int health = 100;
    private int money = 0;
    private int currentWave = 1;
    private Wave wave;
    
    private JButton easyButton;
    private JButton mediumButton;
    private JButton hardButton;
    private JButton backButton;
    private JButton weaponOneButton;
    private JButton weaponTwoButton;
    private JButton weaponThreeButton;
    private JButton startWaveButton;
    private JLabel gameBoard;
    private ArrayList<JButton> towerSpaces;
    ImageIcon board = new ImageIcon("images/classroom_defense1.png");
    private JLabel enterNameLabel;
    private JLabel gameNameLabel;
    private JLabel gameScoreLabel;
    private JLabel gameMoneyLabel;
    private JLabel gameHealthLabel;
    private JLabel gameWaveLabel;
    
    private JTextArea highScoreArea;
    private JTextArea directionsArea;
    
    private JTextField nameField;
    
    private ActionListener easyListener;
    private ActionListener mediumListener;
    private ActionListener hardListener;
    private ActionListener backListener;
    private ActionListener weaponOneListener;
    private ActionListener weaponTwoListener;
    private ActionListener weaponThreeListener;
    private ActionListener startWaveListener;
    private ActionListener thisSpaceListener;
    
    private JPanel homePanel;
    private JPanel gameScreenPanel;
    private JPanel gameOptionsPanel;
    
    private JFrame cdf = this;

    public ClassroomDefenseFrame()
    {
        this.createComponents();
        this.createPanels();
        this.setSize(235, 505);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void createComponents()
    {
        this.createButtons();
        this.createTextField();
        enterNameLabel=new JLabel("Enter name");
        gameNameLabel=new JLabel("Name: "+playerName);
        gameScoreLabel=new JLabel("Score: "+playerScore);
        gameHealthLabel=new JLabel("Health: "+health);
        gameMoneyLabel=new JLabel("$"+money);
        gameWaveLabel=new JLabel("Wave: "+currentWave);
        try 
        { 
            String one = ""; 
            String two = ""; 
            File file = new File("scores.txt");
            FileReader fr = new FileReader(file); 
            BufferedReader in = new BufferedReader(fr); 
            while ((one = in.readLine()) != null) 
            { 
                two = two + one +"\n"; 
            } 
            highScoreArea = new JTextArea(two); 
        }
        catch (FileNotFoundException ex) 
        { 
            ex.printStackTrace(); 
        }
        catch (IOException e)
        { 
            e.printStackTrace(); 
        }
        directionsArea=new JTextArea("...\n\nEnter your name and difficulty.\n\nWhen you're in the game \nclick one of the side buttons and \nclick a table on the map.  \nYou'll need money to make these, \nand you get that by killing enemies. \nWhen you think you are ready, \nclick Next Wave to play!\n\nThere are 10 levels\nKeep a passing grade to win!\n...");   
    }
    
    private String weaponChoice = null;
    
    private void createButtons()
    {
        class AddRemoveListener implements ActionListener
        {
            private String action;
            
            public AddRemoveListener(String action)
            {
                this.action=action.toLowerCase();
            }
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (action.equals("easy"))
                {
                    startGame();
                    difficulty = "easy";
                }
                else if (action.equals("medium"))
                {
                    startGame();
                    difficulty="medium";
                }
                else if (action.equals("hard"))
                {
                    startGame();
                    difficulty="hard";
                }
                
                
                if (action.equals("back"))
                {
                    gameScreenPanel.setVisible(false);
                    gameOptionsPanel.setVisible(false);
                    homePanel.setVisible(true);
                    cdf.setSize(235, 505);
                    //newBoard();
                }
                else if (action.equals("weaponone"))
                {
                    //if (money>=weapon1.cost)
                    //{
                        weaponChoice = "w1";
                    //}
                }
                else if (action.equals("weapontwo"))
                {
                    //if (money>=weapon2.cost)
                    //{
                        weaponChoice = "w2";
                    //}
                }
                else if (action.equals("weaponthree"))
                {
                    //if (money>=weapon3.cost)
                    //{
                        weaponChoice = "w3";
                    //}
                }
                else if (weaponChoice!=null&&action.equals("thisspace"))
                {
                    if (towerSpaces.contains(e.getSource()))
                    {
                        towerSpaces.get(towerSpaces.indexOf(e.getSource())).setText(weaponChoice);
                    }
                    //money=money-weaponChoice.cost;
                    weaponChoice = null;
                }
                else if (action.equals("startwave"))
                {
                    wave=new Wave(currentWave, difficulty);
                    
                    for (int i=0;i<wave.getEnemyCount();i++)
                    {
                        // set position, direction, and speed
                        // of wave.enemies()[i], then delay a
                        // moment before the next increment
                    }
                    if (health>0)
                    {
                        currentWave++;
                        //money+some
                        //score+some
                    }
                    else
                    {
                        //youlose
                        String enteredString=nameField.getText();
                        highScores.high(enteredString);
                    }
                }
            }
        }
        ImageIcon board = new ImageIcon("images/classroom_defense1.png");
        gameBoard = new JLabel(board);
        
        easyButton=new JButton("easy");
        mediumButton=new JButton("medium");
        hardButton=new JButton("hard");
        backButton=new JButton("back");
        weaponOneButton=new JButton("weaponone");
        weaponTwoButton=new JButton("weapontwo");
        weaponThreeButton=new JButton("weaponthree");
        startWaveButton=new JButton("startwave");
        
        easyListener = new AddRemoveListener("easy");
        mediumListener = new AddRemoveListener("medium");
        hardListener = new AddRemoveListener("hard");
        backListener = new AddRemoveListener("back");
        weaponOneListener = new AddRemoveListener("weaponone");
        weaponTwoListener = new AddRemoveListener("weapontwo");
        weaponThreeListener = new AddRemoveListener("weaponthree");
        startWaveListener = new AddRemoveListener("startwave");
        thisSpaceListener = new AddRemoveListener("thisspace");
        
        easyButton.addActionListener(easyListener);
        mediumButton.addActionListener(mediumListener);
        hardButton.addActionListener(hardListener);
        backButton.addActionListener(backListener);
        weaponOneButton.addActionListener(weaponOneListener);
        weaponTwoButton.addActionListener(weaponTwoListener);
        weaponThreeButton.addActionListener(weaponThreeListener);
        startWaveButton.addActionListener(startWaveListener);
        
        
        
        //newBoard();
    }
    private void createTextField()
    {
        final int FIELD_WIDTH=9;
        nameField=new JTextField(FIELD_WIDTH);
    }
    private void createPanels()
    {
        homePanel=new JPanel();
        homePanel.setLayout(null);
        
        gameScreenPanel=new JPanel();
        gameScreenPanel.setLayout(null);
        gameScreenPanel.setVisible(false);
        gameScreenPanel.setBounds(0, 0, 750, 750);
        this.gameBoard.setBounds(0,0,750,750);
        
        gameOptionsPanel=new JPanel();
        gameOptionsPanel.setLayout(null);
        gameOptionsPanel.setBackground(Color.red);
        gameOptionsPanel.setLayout(null);
        gameOptionsPanel.setVisible(false);
        gameOptionsPanel.setBounds(760, 0, 200, 750);

        
        homePanel.add(this.easyButton);
        this.easyButton.setBounds(130, 10, 80, 25);
        homePanel.add(this.mediumButton);
        this.mediumButton.setBounds(130, 45, 80, 25);
        homePanel.add(this.hardButton);
        this.hardButton.setBounds(130, 80, 80, 25);
        homePanel.add(this.enterNameLabel);
        this.enterNameLabel.setBounds(130, 125, 80, 25);
        homePanel.add(this.nameField);
        this.nameField.setBounds(130, 150, 80, 25);
        homePanel.add(this.highScoreArea);
        this.highScoreArea.setBounds(10, 10, 100, 180);
        homePanel.add(this.directionsArea);
        this.directionsArea.setBounds(10, 205, 200, 250);
        
        gameOptionsPanel.add(this.backButton);
        this.backButton.setBounds(105, 0, 80, 25);
        
        gameOptionsPanel.add(this.weaponOneButton);
        this.weaponOneButton.setBounds(0, 150, 110, 35);
        gameOptionsPanel.add(this.weaponTwoButton);
        this.weaponTwoButton.setBounds(0, 195, 110, 35);
        gameOptionsPanel.add(this.weaponThreeButton);
        this.weaponThreeButton.setBounds(0, 240, 110, 35);
        gameOptionsPanel.add(this.startWaveButton);
        this.startWaveButton.setBounds(0, 500, 100, 50);
        gameOptionsPanel.add(this.gameNameLabel);
        this.gameNameLabel.setBounds(0, 0, 100, 25);
        gameOptionsPanel.add(this.gameScoreLabel);
        this.gameScoreLabel.setBounds(0, 25, 100, 25);
        gameOptionsPanel.add(this.gameHealthLabel);
        this.gameHealthLabel.setBounds(0, 50, 100, 25);
        gameOptionsPanel.add(this.gameMoneyLabel);
        this.gameMoneyLabel.setBounds(0, 75, 100, 25);
        gameOptionsPanel.add(this.gameWaveLabel);
        this.gameWaveLabel.setBounds(0, 475, 100, 25);
        
        
        this.add(gameScreenPanel);
        this.add(gameOptionsPanel);
        this.add(homePanel);
    }
    public void newBoard()
    {
        towerSpaces.clear();
        for (int x=0, y=0, w=50, h=50, i=0;i<162;i++)
        {
            towerSpaces.add(i, new JButton(""+i));
            towerSpaces.get(i).setBounds(x, y, w, h);
            towerSpaces.get(i).setContentAreaFilled(false);
            towerSpaces.get(i).setFont(new Font("Arial", Font.PLAIN, 9));
            x=x+50;
            if (x==750)
            {
                x=0;
                y=y+50;
            }
            if (y<300&&x==150)
            {           
                x=x+150;
            }
            else if (y<450&&x==150)
            {    
                x=x+450;
            }
            else if (y>=450&&x==450)
            {    
                x=x+150;
            }
            towerSpaces.get(i).addActionListener(thisSpaceListener);
        }
    }
    public void startGame()
    {
        homePanel.setVisible(false);
        gameScreenPanel.setVisible(true);
        gameOptionsPanel.setVisible(true);
        cdf.setSize(960, 790);
        cdf.setTitle("Duck Defense");
        playerName = nameField.getText();
        gameNameLabel.setText(playerName);
        towerSpaces = new ArrayList(162);
        gameScreenPanel.removeAll();
        gameScreenPanel.add(this.gameBoard);
        newBoard();
        for (int i=0;i<162;i++)
        {
            gameScreenPanel.add(towerSpaces.get(i));
            gameScreenPanel.setComponentZOrder(towerSpaces.get(i), 0);
        }
    }
    public static void main(String[] args)
    {
        @SuppressWarnings("unused")
        JFrame testFrame = new ClassroomDefenseFrame();
    }
}
