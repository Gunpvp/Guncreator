package guncreator.categories;

import java.awt.Color;
import java.io.Serializable;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public abstract class EditPanel<DATA extends Serializable> extends JPanel {
	
	protected DATA data;
	
	public EditPanel() {
		super();
		super.setBackground(Color.WHITE);
		super.setBorder(new EtchedBorder(Color.GRAY, Color.BLACK));
		super.setBorder(new CompoundBorder(super.getBorder(), new EmptyBorder(10, 10, 10, 10)));
	}
	
	public DATA getData() {
		return generateData();
	}

	protected abstract DATA generateData();
	public abstract void initWithData(DATA data);

}
