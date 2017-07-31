package guncreator.categories;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class JBox extends JPanel {
	
	private JLabel name;
	private JCheckBox box;
	
	public JBox(String description) {
		
		super(new GridLayout(1, 2));
		super.setBorder(new EtchedBorder(Color.GRAY, Color.BLACK));
		super.setBorder(new CompoundBorder(super.getBorder(), new EmptyBorder(10, 10, 10, 10)));
		name = new JLabel(description);
		super.add(name);
		box = new JCheckBox();
		super.add(box);
		
	}
	
	public boolean getValue() {
		return box.isSelected();
	}
	
	public void setValue(boolean value) {
		this.box.setSelected(value);
	}
	
}
