import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class Movies extends JPanel {
	
	private JTextField movies1, movies2, movies3;
	
	public Movies() {
		//JLabel label = new JLabel("Enter your three favorite movies");
		JLabel num1 = new JLabel("1");
		JLabel num2 = new JLabel("2");
		JLabel num3 = new JLabel("3");
		//3 favorite movies
		movies1 = new JTextField(10);
		movies2 = new JTextField(10);
		movies3 = new JTextField(10);
		movies1.setFont(new Font("SansSerif", Font.BOLD, 12));
		movies2.setFont(new Font("SansSerif", Font.BOLD, 12));
		movies3.setFont(new Font("SansSerif", Font.BOLD, 12));
		add(num1);
		add(movies1);
		add(num2);
		add(movies2);
		add(num3);
		add(movies3);
		setBorder(new TitledBorder (new EtchedBorder(), "Movies"));
		setLayout(new GridLayout(3, 2));
		//add(label);
	}

}
