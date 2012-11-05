
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class HeightPanel extends JPanel {
	// This is the height buttons
	private JRadioButton shorty, average, tall;
	
	public HeightPanel() {
		//create the buttons
		shorty = new JRadioButton("Short");
		average = new JRadioButton("Average");
		tall = new JRadioButton("Tall");
		//set average as default
		average.setSelected(true);
		//add buttons to the panel
		setBorder(new TitledBorder (new EtchedBorder(), "Height"));
		add(shorty);
		add(average);
		add(tall);
	}
}