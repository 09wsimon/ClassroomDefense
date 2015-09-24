package classroomdefense;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ClassroomDefenseFrame extends JFrame
{
    private static final int FRAME_WIDTH = 235;
    private static final int FRAME_HEIGHT = 505;
    private JButton easyButton;
    private JButton mediumButton;
    private JButton hardButton;
    private JLabel enterNameLabel;
    private JTextArea highScoreArea;
    private JTextArea directionsArea;
    private JTextField nameField;

    public ClassroomDefenseFrame()
    {
        this.createComponents();
        this.createPanel();
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
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
                highScores.high(enteredString);
                if (action.equals("easy"))
                {
                    //set difficulty to easy
                }
                else if (action.equals("medium"))
                {
                    //set difficulty to medium
                }
                else if (action.equals("hard"))
                {
                    //set difficulty to hard
                }
            }
        }
        easyButton=new JButton("easy");
        mediumButton=new JButton("medium");
        hardButton=new JButton("hard");
        ActionListener easyListener = new AddRemoveListener("easy");
        ActionListener mediumListener = new AddRemoveListener("medium");
        ActionListener hardListener = new AddRemoveListener("hard");
        easyButton.addActionListener(easyListener);
        mediumButton.addActionListener(mediumListener);
        hardButton.addActionListener(hardListener);
    }

    private void createTextField()
    {
        final int FIELD_WIDTH=9;
        nameField=new JTextField(FIELD_WIDTH);
    }
    private void createPanel()
    {
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.add(this.easyButton);
        this.easyButton.setBounds(130, 10, 80, 25);
        panel.add(this.mediumButton);
        this.mediumButton.setBounds(130, 45, 80, 25);
        panel.add(this.hardButton);
        this.hardButton.setBounds(130, 80, 80, 25);
        panel.add(this.enterNameLabel);
        this.enterNameLabel.setBounds(130, 125, 80, 25);
        panel.add(this.nameField);
        this.nameField.setBounds(130, 150, 80, 25);
        panel.add(this.highScoreArea);
        this.highScoreArea.setBounds(10, 10, 100, 180);
        panel.add(this.directionsArea);
        this.directionsArea.setBounds(10, 205, 200, 250);
        this.add(panel);
    }
    public static void main(String[] args)
    {
        @SuppressWarnings("unused")
        JFrame testFrame = new ClassroomDefenseFrame();
    }
}