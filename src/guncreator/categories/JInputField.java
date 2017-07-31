package guncreator.categories;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class JInputField extends JPanel {
	
	private JLabel name;
	private JTextField field;
	
	public JInputField(String description) {
		
		super(new GridLayout(1, 2));
		super.setBorder(new EtchedBorder(Color.GRAY, Color.BLACK));
		super.setBorder(new CompoundBorder(super.getBorder(), new EmptyBorder(10, 10, 10, 10)));
		name = new JLabel(description);
		super.add(name);
		field = new JTextField();
		super.add(field);
		
	}
	
	public String getValue() {
		return this.field.getText();
	}
	
	public void setValue(String value) {
		this.field.setText(value);
	}
	
}
