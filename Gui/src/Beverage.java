import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Beverage extends JPanel {

	private JCheckBox tea, soda, coffee, water;
	
	public Beverage() {
		JLabel label = new JLabel("Select your preferred beverages");
		tea = new JCheckBox("Tea");
		soda = new JCheckBox("Soda");
		coffee = new JCheckBox("Coffee");
		water = new JCheckBox("Water");
		add(label);
		add(tea);
		add(soda);
		add(coffee);
		add(water);
	}
}
