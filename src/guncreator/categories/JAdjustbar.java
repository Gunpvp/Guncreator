package guncreator.categories;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JAdjustbar extends JPanel {
	
	private JLabel name;
	private JSlider slider;
	private float divider;
	
	public JAdjustbar(String description, String value_prefix, int begin, int end, float steps) {
		
		super(new GridLayout(1, 2));
		
		this.divider = 1f/steps;
		
		super.setBorder(new EtchedBorder(Color.GRAY, Color.BLACK));
		super.setBorder(new CompoundBorder(super.getBorder(), new EmptyBorder(10, 10, 10, 10)));
		name = new JLabel(description + " " + (end*0.5f) + " " + value_prefix);
		super.add(name);
		slider = new JSlider(begin, (int) (end*divider));
		super.add(slider);
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				name.setText(description + " " + getValue() + " " + value_prefix);
			}
		});
		
	}
	
	public float getValue() {
		return this.slider.getValue()/divider;
	}
	
	public void setValue(float value) {
		this.slider.setValue((int) (value*divider));
	}
	
}
