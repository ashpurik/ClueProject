import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class InputPanel extends JPanel {
	// This is the panel that shows the comments
	private CommentPanel comment;
	

	// Save the reference to the comment panel, to be used in listener
	public InputPanel(CommentPanel comment)
	{
		this.comment = comment;
		//add(createComboPanel());
	}

	// Standard GUI components, nothing special here
	

	/*private class HobbyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// Based on GUI interaction, create an appropriate string
			//String myHobby = (String) hobby.getSelectedItem();
			// Use the method of the comment class to display the comment
			comment.setMessage("I like to " + myHobby);
		}
	}*/
}
