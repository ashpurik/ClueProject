import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Activities extends JPanel {

	private JCheckBox ski, snowboard, cycle, read, TV;
	
	public Activities() {
		JLabel label = new JLabel("Select your favorite activities");
		ski = new JCheckBox("Ski");
		snowboard = new JCheckBox("Snowboard");
		cycle = new JCheckBox("Cycle");
		read = new JCheckBox("Reading");
		TV = new JCheckBox("TV");
		add(label);
		add(ski);
		add(snowboard);
		add(cycle);
		add(read);
		add(TV);
	}
}
