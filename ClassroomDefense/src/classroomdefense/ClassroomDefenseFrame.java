package classroomdefense;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
    private int money;
    private int currentWave = 1;
    private int chosenWeaponPrice;
    private Wave wave;
    private String weaponChoice = null;
    private ImageIcon weaponIcon = null;
    private javax.swing.Timer tim;
    
    private JButton easyButton;
    private JButton mediumButton;
    private JButton hardButton;
    private JButton backButton;
    private JButton weaponOneButton;
    private JButton weaponTwoButton;
    private JButton weaponThreeButton;
    private JButton startWaveButton;
    private ArrayList<JButton> towerSpaces;
    
    private ImageIcon board = new ImageIcon("images/classroom_defense1.png");
    private ImageIcon soldierIcon = new ImageIcon("images/cartoon-soldier-010.jpg");
    private ImageIcon berserkerIcon = new ImageIcon("images/466345504.jpg");
    private ImageIcon tankIcon = new ImageIcon("images/tank10.png");
    
    private JLabel gameBoard;
    private JLabel enterNameLabel;
    private JLabel gameNameLabel;
    private JLabel gameScoreLabel;
    private JLabel gameMoneyLabel;
    private JLabel gameHealthLabel;
    private JLabel gameWaveLabel;
    private JLabel weaponsLabel;
    private JLabel w1Price;
    private JLabel w2Price;
    private JLabel w3Price;
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
        createComponents();
        createPanels();
        this.setSize(235, 505);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void createComponents()
    {
        createButtons();
        createTextField();
        enterNameLabel=new JLabel("Enter name");
        gameNameLabel=new JLabel("Name: "+playerName);
        gameScoreLabel=new JLabel("Score: "+playerScore);
        gameHealthLabel=new JLabel("Health: "+health);
        gameMoneyLabel=new JLabel();
        gameWaveLabel=new JLabel("Wave: "+currentWave);
        weaponsLabel=new JLabel("Weapons");
        gameBoard = new JLabel(board);
        w1Price = new JLabel("$10");
        w2Price = new JLabel("$20");
        w3Price = new JLabel("$30");
        directionsArea=new JTextArea(
                  "Enter your name and difficulty.\n\n"
                          
                + "When you're in the game \n"
                + "click one of the side buttons and \n"
                + "click a table on the map.\n"
                + "You'll need money to make these,\n"
                + "and you get that by killing enemies.\n"
                + "When you think you are ready,\n"
                + "click Next Wave to play!\n\n"
                          
                + "There are 10 levels\n"
                + "Keep a passing grade to win!\n");
        directionsArea.setEditable(false);
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
                if (action.equals("easy"))
                {
                    difficulty = "easy";
                    money = 30;
                    startGame();
                }
                else if (action.equals("medium"))
                {
                    difficulty="medium";
                    money = 20;
                    startGame();
                }
                else if (action.equals("hard"))
                {
                    difficulty="hard";
                    money = 10;
                    startGame();
                }
                if (action.equals("back"))
                {
                    gameScreenPanel.setVisible(false);
                    gameOptionsPanel.setVisible(false);
                    homePanel.setVisible(true);
                    cdf.setSize(235, 505);
                }
                else if (action.equals("weaponone"))
                {
                    chosenWeaponPrice = 10;
                    if (money>=chosenWeaponPrice)
                    {
                        weaponChoice = "w1";
                        weaponIcon = soldierIcon;
                    }
                }
                else if (action.equals("weapontwo"))
                {
                    chosenWeaponPrice = 20;
                    if (money>=chosenWeaponPrice)
                    {
                        weaponChoice = "w2";
                        weaponIcon = berserkerIcon;
                    }
                }
                else if (action.equals("weaponthree"))
                {
                    chosenWeaponPrice = 50;
                    if (money>=chosenWeaponPrice)
                    {
                        weaponChoice = "w3";
                        weaponIcon = tankIcon;
                    }
                }
                else if (weaponChoice!=null&&action.equals("thisspace"))
                {
                    if (towerSpaces.contains(e.getSource())&&towerSpaces.get(towerSpaces.indexOf(e.getSource())).getIcon()==null)
                    {
                        towerSpaces.get(towerSpaces.indexOf(e.getSource())).setIcon(weaponIcon);
                        weaponChoice = null;
                        weaponIcon = null;
                        money=money-chosenWeaponPrice;
                        gameMoneyLabel.setText("Bank: $"+money);
                    }
                    
                }
                else if (action.equals("moveEnemy"))
                {
                    Object obj = e.getSource();
                    if (obj instanceof Enemy)
                    {
                        tim.start();
                    }
                    if (obj == tim)
                    {
                        
                    }
                }
                else if (action.equals("startwave"))
                {
                    tim = new javax.swing.Timer(1000,this);
                    wave=new Wave(currentWave, difficulty);
                    for (int i=0;i<wave.enemies().size();i++)
                    {
                        // set position, direction, and speed
                        // of wave.enemies()[i], then delay a
                        // moment before the next increment
                    }
                    if (health>0)
                    {
                        money=money+wave.enemies().size();
                        playerScore=playerScore+wave.enemies().size();
                        currentWave++;
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
        easyButton=new JButton("easy");
        mediumButton=new JButton("medium");
        hardButton=new JButton("hard");
        backButton=new JButton("back");
        weaponOneButton=new JButton(soldierIcon);
        weaponTwoButton=new JButton(berserkerIcon);
        weaponThreeButton=new JButton(tankIcon);
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
        homePanel.add(easyButton);
        homePanel.add(mediumButton);
        homePanel.add(hardButton);
        homePanel.add(enterNameLabel);
        homePanel.add(nameField);
        homePanel.add(highScoreArea);
        highScoreArea.setEditable(false);
        homePanel.add(directionsArea);
        directionsArea.setEditable(false);
        easyButton.setBounds(130, 10, 80, 25);
        mediumButton.setBounds(130, 45, 80, 25);
        hardButton.setBounds(130, 80, 80, 25);
        enterNameLabel.setBounds(130, 125, 80, 25);
        nameField.setBounds(130, 150, 80, 25);
        highScoreArea.setBounds(10, 10, 100, 180);
        directionsArea.setBounds(10, 205, 200, 250);
        
        gameScreenPanel=new JPanel();
        gameScreenPanel.setLayout(null);
        gameScreenPanel.setVisible(false);
        gameScreenPanel.setBounds(0, 0, 750, 750);
        
        gameOptionsPanel=new JPanel();
        gameOptionsPanel.setLayout(null);
        gameOptionsPanel.setBackground(Color.gray);
        gameOptionsPanel.setLayout(null);
        gameOptionsPanel.setVisible(false);
        gameOptionsPanel.setBounds(760, 0, 200, 750);
        gameOptionsPanel.add(gameNameLabel);
        gameOptionsPanel.add(gameScoreLabel);
        gameOptionsPanel.add(gameHealthLabel);
        gameOptionsPanel.add(gameMoneyLabel);
        gameOptionsPanel.add(gameWaveLabel); 
        gameOptionsPanel.add(weaponsLabel);
        gameOptionsPanel.add(w1Price);
        gameOptionsPanel.add(w2Price);
        gameOptionsPanel.add(w3Price);
        gameOptionsPanel.add(backButton);
        gameOptionsPanel.add(weaponOneButton);
        gameOptionsPanel.add(weaponTwoButton);
        gameOptionsPanel.add(weaponThreeButton);
        gameOptionsPanel.add(startWaveButton);
        gameNameLabel.setBounds(0, 0, 100, 25);
        gameScoreLabel.setBounds(0, 25, 100, 25);
        gameHealthLabel.setBounds(0, 50, 100, 25);
        gameMoneyLabel.setBounds(0, 75, 100, 25);
        gameWaveLabel.setBounds(0, 475, 100, 25);
        weaponsLabel.setBounds(0, 165, 110, 35);
        w1Price.setBounds(75, 215, 30, 20);
        w2Price.setBounds(75, 275, 30, 20);
        w3Price.setBounds(75, 335, 30, 20);
        backButton.setBounds(105, 0, 80, 25);
        weaponOneButton.setBounds(0, 200, 70, 50);
        weaponTwoButton.setBounds(0, 260, 70, 50);
        weaponThreeButton.setBounds(0, 320, 70, 50);
        startWaveButton.setBounds(0, 500, 100, 50);
        
        this.add(gameScreenPanel);
        this.add(gameOptionsPanel);
        this.add(homePanel);
    }
    public void newBoard()
    {
        towerSpaces.clear();
        for (int X=0, Y=0, W=50, H=50, i=0;i<162;i++)
        {
            towerSpaces.add(i, new JButton());
            towerSpaces.get(i).setBounds(X, Y, W, H);
            towerSpaces.get(i).setContentAreaFilled(false);
            X=X+50;
            if      (X==750)     {X=0; Y=Y+50;}
            if      (Y<300 && X==150){X=X+150;}
            else if (Y<450 && X==150){X=X+450;}
            else if (Y>=450&& X==450){X=X+150;}
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
        gameNameLabel.setText("Name: "+playerName);
        gameMoneyLabel.setText("Bank: $"+money);
        towerSpaces = new ArrayList(162);
        gameScreenPanel.removeAll();
        gameScreenPanel.add(gameBoard);
        gameBoard.setBounds(0,0,750,750);
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
//@Override
//    public void paintComponent(Graphics g)
//    {
//        super.paintComponent(g);
//    
//        if ( y<300)
//        {
//           y=y+10;
//           
//        }
//        if ( y>=300 && x<=500)
//        {
//           x=x+10;
//           
//        }
//        if (x>=500)
//        {
//            
//            y=y+10;
//        }
//        
//       
//        
//        
//        g.fillRect(x, y, 20,20);
//        
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent ae) 
//    {
//        Object obj = ae.getSource();
//        if(obj == b1)
//        {
//            t1.start(); // t1.stop();  t1.setDelay(500);
//        }
//        if(obj == t1)
//        {
//            repaint(); //call paintComponent
//            //paintComponent is in charge of updating x and y 
//            // and drawing a rectangle
//        }
//        
//    }
