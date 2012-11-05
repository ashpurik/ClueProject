import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class SmokePanel extends JPanel {
	// This is the height buttons
	private JRadioButton smokes, nosmoke;
	
	public SmokePanel() {
		//create the buttons
		smokes = new JRadioButton("Smokes");
		nosmoke = new JRadioButton("Doesn't smoke");
		//set average as default
		nosmoke.setSelected(true);
		//add buttons to the panel
		setBorder(new TitledBorder (new EtchedBorder(), "Smokes"));
		add(nosmoke);
		add(smokes);
	}
}