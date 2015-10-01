package classroomdefense;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

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
    private JButton gameBoard;
    //ImageIcon board = new ImageIcon("images/classroom_defense1.png");
    private JLabel enterNameLabel;
    private JLabel gameNameLabel;
    private JLabel gameScoreLabel;
    private JLabel gameMoneyLabel;
    private JLabel gameHealthLabel;
    private JLabel gameWaveLabel;
    
    private JTextArea highScoreArea;
    private JTextArea directionsArea;
    
    private JTextField nameField;
    
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
                String enteredString=nameField.getText();
                highScores.high(enteredString);
                if (action.equals("easy"))
                {
                    //set difficulty to easy
                    /*homePanel.setVisible(false);
                    gameScreenPanel.setVisible(true);
                    gameOptionsPanel.setVisible(true);
                    cdf.setSize(960, 750);
                    cdf.setTitle("Duck Defense");
                    playerName = nameField.getText();
                    gameNameLabel.setText(playerName);*/
                }
                else if (action.equals("medium"))
                {
                    //set difficulty to medium
                    /*homePanel.setVisible(false);
                    gameScreenPanel.setVisible(true);
                    gameOptionsPanel.setVisible(true);
                    cdf.setSize(960, 750);
                    cdf.setTitle("Duck Defense");
                    playerName = nameField.getText();
                    gameNameLabel.setText(playerName);*/
                }
                else if (action.equals("hard"))
                {
                    //set difficulty to hard
                    /*homePanel.setVisible(false);
                    gameScreenPanel.setVisible(true);
                    gameOptionsPanel.setVisible(true);
                    cdf.setSize(960, 750);
                    cdf.setTitle("Duck Defense");
                    playerName = nameField.getText();
                    gameNameLabel.setText(playerName)*/;
                }
                
                /**/homePanel.setVisible(false);
                gameScreenPanel.setVisible(true);
                gameOptionsPanel.setVisible(true);
                cdf.setSize(960, 750);
                cdf.setTitle("Duck Defense");
                playerName = nameField.getText();
                gameNameLabel.setText(playerName);
                
                if (action.equals("back"))
                {
                    gameScreenPanel.setVisible(false);
                    gameOptionsPanel.setVisible(false);
                    homePanel.setVisible(true);
                    cdf.setSize(235, 505);
                }
                else if (action.equals("weaponone"))
                {
                    
                }
                else if (action.equals("weapontwo"))
                {
                    
                }
                else if (action.equals("weaponthree"))
                {
                    
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
                    //if player survives round:
                    currentWave++;
                }
                
                
            }
        }
        ImageIcon board = new ImageIcon("images/classroom_defense1.png");
        gameBoard = new JButton(board);
        easyButton=new JButton("easy");
        mediumButton=new JButton("medium");
        hardButton=new JButton("hard");
        backButton=new JButton("back");
        weaponOneButton=new JButton("weaponone");
        weaponTwoButton=new JButton("weapontwo");
        weaponThreeButton=new JButton("weaponthree");
        startWaveButton=new JButton("startwave");
        ActionListener easyListener = new AddRemoveListener("easy");
        ActionListener mediumListener = new AddRemoveListener("medium");
        ActionListener hardListener = new AddRemoveListener("hard");
        ActionListener backListener = new AddRemoveListener("back");
        ActionListener weaponOneListener = new AddRemoveListener("weaponone");
        ActionListener weaponTwoListener = new AddRemoveListener("weapontwo");
        ActionListener weaponThreeListener = new AddRemoveListener("weaponthree");
        ActionListener startWaveListener = new AddRemoveListener("startwave");
        easyButton.addActionListener(easyListener);
        mediumButton.addActionListener(mediumListener);
        hardButton.addActionListener(hardListener);
        backButton.addActionListener(backListener);
        weaponOneButton.addActionListener(weaponOneListener);
        weaponTwoButton.addActionListener(weaponTwoListener);
        weaponThreeButton.addActionListener(weaponThreeListener);
        startWaveButton.addActionListener(startWaveListener);
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
        //gameScreenPanel.setBackground(Color.blue);
        gameScreenPanel.setLayout(null);
        gameScreenPanel.setVisible(false);
        gameScreenPanel.setBounds(0, 0, 750, 750);
        gameScreenPanel.add(this.gameBoard);
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
    public static void main(String[] args)
    {
        @SuppressWarnings("unused")
        JFrame testFrame = new ClassroomDefenseFrame();
    }
}