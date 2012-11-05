import javax.swing.JPanel;
import javax.swing.JTextField;


public class CommentPanel extends JPanel {
	private JTextField comment;
	
	public CommentPanel() {
		comment = new JTextField(40);
		add(comment);
	}
	
	public void setMessage(String message) {
		comment.setText(message);
	}
}
