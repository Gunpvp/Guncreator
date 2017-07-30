package guncreator.categories;

import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import guncreator.JGunSound;
import guns.weopons.data.ScopeData;

public class ScopeCategory extends Category<ScopeData>{

	private JCheckBox scope;
	private JCheckBox see_in_night;
	private JSlider zoom_amount;
	private JSlider spread;
	private JGunSound toggle_sound;
	
	public ScopeCategory() {
		super("SCOPE");

	}

	@Override
	public EditPanel<ScopeData> createEditPanel() {
		
		 	EditPanel<ScopeData> panel = new EditPanel<ScopeData>() {

			@Override
			protected ScopeData generateData() {
				
				return new ScopeData(scope.isSelected(), zoom_amount.getValue(), see_in_night.isSelected(), spread.getValue()/10, toggle_sound.getGunSound());
			}

			@Override
			public void initWithData(ScopeData data) {
				
				
			}
			
		};
		 
		panel.setLayout(null);
	
		//scope (zoom) available
		JLabel text_scope = new JLabel("Zoom möglich:");
		text_scope.setBounds(10, 10, 150, 30);
		panel.add(text_scope);
		scope = new JCheckBox();
		scope.setBackground(Color.GREEN);
		scope.setBounds(200, 10, 30, 30);
		panel.add(scope);
		
		//zoom amount
		JLabel text_zoom_amount = new JLabel("Zoomweite:");
		text_zoom_amount.setBounds(10, 60, 150, 30);
		panel.add(text_zoom_amount);
		zoom_amount = new JSlider(0,20);
		zoom_amount.setBackground(Color.GREEN);
		zoom_amount.setBounds(200, 60, 200, 30);
		panel.add(zoom_amount);
		zoom_amount.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_zoom_amount.setText("Zoomweite: " + slider.getValue());
	        }
		});
		
		//night vision
		JLabel text_see_in_night = new JLabel("Nachtsicht:");
		text_see_in_night.setBounds(10, 110, 150, 30);
		panel.add(text_see_in_night);
		see_in_night = new JCheckBox();
		see_in_night.setBackground(Color.GREEN);
		see_in_night.setBounds(200, 110, 30, 30);
		panel.add(see_in_night);
		
		//spread
		JLabel text_spread = new JLabel("Streuung:");
		text_spread.setBounds(10, 160, 150, 30);
		panel.add(text_spread);
		spread = new JSlider(0,500);
		spread.setBackground(Color.GREEN);
		spread.setBounds(200, 160, 200, 30);
		panel.add(spread);
		spread.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_spread.setText("Streuung: " + slider.getValue()/10);
	        }
		});
		
		//toggle sound
		toggle_sound = new JGunSound("Toggle");
		toggle_sound.setBounds(10, 210, 400, 300);
		toggle_sound.setBackground(Color.GREEN);
		panel.add(toggle_sound);
		
		return panel;
	}

	@Override
	public boolean isEverythingFilledOut() {

		return false;
	}

}
