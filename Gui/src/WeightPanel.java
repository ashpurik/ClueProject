import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class WeightPanel extends JPanel {
	// This is the height buttons
	private JRadioButton thinn, average1, hefty;
	
	public WeightPanel() {
		//create the buttons
		thinn = new JRadioButton("Thin");
		average1 = new JRadioButton("Average");
		hefty = new JRadioButton("Hefty");
		//set average as default
		average1.setSelected(true);
		setBorder(new TitledBorder (new EtchedBorder(), "Weight"));
		add(thinn);
		add(average1);
		add(hefty);
	}
}