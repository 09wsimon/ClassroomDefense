package classroomdefense;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ClassroomDefenseFrame extends JFrame
{
    private JButton easyButton;
    private JButton mediumButton;
    private JButton hardButton;
    private JButton backButton;
    
    private JLabel enterNameLabel;
    
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
        highScoreArea=new JTextArea("High Scores\n1. Score 1\n2. Score 2\n3. Score 3\n4. Score 4\n5. Score 5\n6. Score 6\n7. Score 7\n8. Score 8\n9. Score 9\n10. Score 10\n");
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
                if (action.equals("easy"))
                {
                    //set difficulty to easy
//                    remove(homePanel);
//                    add(gameScreenPanel, "Left");
//                    add(gameOptionsPanel, "Right");
//                    validate();
//                    repaint();
                    homePanel.setVisible(false);
                    gameScreenPanel.setVisible(true);
                    gameOptionsPanel.setVisible(true);
                    cdf.setSize(710, 700);
                }
                else if (action.equals("medium"))
                {
                    //set difficulty to medium
                    homePanel.setVisible(false);
                    gameScreenPanel.setVisible(true);
                    gameOptionsPanel.setVisible(true);
                    cdf.setSize(710, 700);
                }
                else if (action.equals("hard"))
                {
                    //set difficulty to hard
                    homePanel.setVisible(false);
                    gameScreenPanel.setVisible(true);
                    gameOptionsPanel.setVisible(true);
                    cdf.setSize(710, 700);
                }
                else if (action.equals("back"))
                {
                    gameScreenPanel.setVisible(false);
                    gameOptionsPanel.setVisible(false);
                    homePanel.setVisible(true);
                    cdf.setSize(235, 505);
                }
            }
        }
        easyButton=new JButton("easy");
        mediumButton=new JButton("medium");
        hardButton=new JButton("hard");
        backButton=new JButton("back");
        ActionListener easyListener = new AddRemoveListener("easy");
        ActionListener mediumListener = new AddRemoveListener("medium");
        ActionListener hardListener = new AddRemoveListener("hard");
        ActionListener backListener = new AddRemoveListener("back");
        easyButton.addActionListener(easyListener);
        mediumButton.addActionListener(mediumListener);
        hardButton.addActionListener(hardListener);
        backButton.addActionListener(backListener);
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
        gameScreenPanel.setBackground(Color.blue);
        gameScreenPanel.setLayout(null);
        gameScreenPanel.setVisible(false);
        gameScreenPanel.setBounds(0, 0, 500, 700);
        
        gameOptionsPanel=new JPanel();
        gameOptionsPanel.setLayout(null);
        gameOptionsPanel.setBackground(Color.red);
        gameOptionsPanel.setLayout(null);
        gameOptionsPanel.setVisible(false);
        gameOptionsPanel.setBounds(510, 0, 200, 700);

        
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