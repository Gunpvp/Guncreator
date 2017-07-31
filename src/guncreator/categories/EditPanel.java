package guncreator.categories;

import java.awt.Color;
import java.awt.Component;
import java.io.Serializable;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public abstract class EditPanel<DATA extends Serializable> extends JPanel {
	
	protected DATA data;
	private int y = 10;
	
	public EditPanel() {
		super(null);
		super.setBackground(Color.WHITE);
		super.setBorder(new EtchedBorder(Color.GRAY, Color.BLACK));
		super.setBorder(new CompoundBorder(super.getBorder(), new EmptyBorder(10, 10, 10, 10)));
	}
	
	public void addComponent(Component comp) {
		
		
		comp.setBounds(10, y, 425, 50);
		
		if (comp instanceof JGunSound) {
			
			comp.setBounds(comp.getX(), comp.getY(), comp.getWidth(), 300);
			
			y+=310;
			
		} else {
			
			y+=60;
			
		}
		
		super.add(comp);
		
	}
	
	public DATA getData() {
		return generateData();
	}

	protected abstract DATA generateData();
	public abstract void initWithData(DATA data);

}
