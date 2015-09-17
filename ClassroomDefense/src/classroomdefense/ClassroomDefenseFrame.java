package classroomdefense;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ClassroomDefenseFrame extends JFrame
{
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;
	private JButton easyButton;
	private JButton mediumButton;
	private JButton hardButton;
	private JLabel enterNameLabel;
	private JLabel highScoreLabel;
	private JLabel directionsLabel;
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
		enterNameLabel=new JLabel("Enter your name here...");
		highScoreLabel=new JLabel("High Score");
		directionsLabel=new JLabel("...\n\nEnter your name and difficulty.\n\nWhen you're in the game click one of the side buttons and click a table on the map.  You'll need money to make these, and you get that by killing enemies. When you think you are ready, click Next Wave to play!\n\nThere are 10 levels\nKeep a passing grade to win!\n...");
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
		nameField.setText("Enter Player Name");
	}
	private void createPanel()
	{
		JPanel panel=new JPanel();
		panel.add(this.easyButton);
		panel.add(this.mediumButton);
		panel.add(this.hardButton);
		panel.add(this.enterNameLabel);
		panel.add(this.nameField);
		panel.add(this.highScoreLabel);
		panel.add(this.directionsLabel);
		this.add(panel);
	}
	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		JFrame testFrame = new ClassroomDefenseFrame();
	}
}