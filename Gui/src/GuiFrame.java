/*
 * Program to show communication between panels
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class GuiFrame extends JFrame {
	
	public GuiFrame()
	{
		// This is the panel that will show the messages, create it first
		//CommentPanel comment = new CommentPanel();
		// Pass the message panel into the other panel
		//InputPanel input = new InputPanel(comment);
		// Create a layout and add both panels to the JFrame
		setLayout(new BorderLayout());
		//add(input, BorderLayout.CENTER);
		//add(comment, BorderLayout.SOUTH);	
		JPanel buttonPanel = new JPanel();
		JPanel checkPanel = new JPanel();
		checkPanel.setLayout(new BoxLayout(checkPanel, BoxLayout.X_AXIS));
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		HeightPanel hpanel = new HeightPanel();
		WeightPanel wpanel = new WeightPanel();
		SmokePanel spanel = new SmokePanel();
		buttonPanel.add(hpanel);
		buttonPanel.add(wpanel);
		buttonPanel.add(spanel);
		add (buttonPanel, BorderLayout.EAST);
		Beverage bvg = new Beverage();
		Activities act = new Activities();
		checkPanel.add(bvg);
		checkPanel.add(act);
		add(checkPanel, BorderLayout.NORTH);
		Movies movie = new Movies();
		add(movie, BorderLayout.WEST);
		
		// Frame set up
		setTitle("Who Are You?");
		setSize(1000, 300);
	}
	
	public static void main(String[] args) 
	{
		JFrame frame = new GuiFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
