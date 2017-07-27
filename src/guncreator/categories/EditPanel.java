package guncreator.categories;

import java.awt.Color;
import java.io.Serializable;

import javax.swing.JPanel;

public abstract class EditPanel<DATA extends Serializable> extends JPanel {
	
	protected DATA data;
	
	public EditPanel() {
		super();
		super.setBackground(Color.GREEN);
	}
	
	public DATA getData() {
		return generateData();
	}

	protected abstract DATA generateData();

}
