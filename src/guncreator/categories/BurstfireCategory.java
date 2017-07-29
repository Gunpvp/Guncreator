package guncreator.categories;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import guns.weopons.data.BurstfireData;

public class BurstfireCategory extends Category<BurstfireData>{

	private JSlider shots_per_burst;
	private JSlider delay_between;
	
	public BurstfireCategory() {
		super("BURSTFIRE");
	}

	@Override
	public EditPanel<BurstfireData> createEditPanel() {
		
		 	EditPanel<BurstfireData> panel = new EditPanel<BurstfireData>() {

			@Override
			protected BurstfireData generateData() {
				
				return null;
				
			}
		};
		 
		panel.setLayout(null);
		
		//shots per burst
		JLabel text_shots_per_burst = new JLabel("Schüsse pro Feuerstoß:");
		text_shots_per_burst.setBounds(10, 10, 150, 30);
		panel.add(text_shots_per_burst);
		shots_per_burst = new JSlider(0,10);
		shots_per_burst.setBackground(Color.GREEN);
		shots_per_burst.setBounds(200, 10, 200, 30);
		panel.add(shots_per_burst);
		shots_per_burst.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_shots_per_burst.setText("Schüsse pro Feuerstoß: " + slider.getValue());
	        }
		});
		
		//shot delay
		JLabel text_delay_between = new JLabel("Verzögerung:");
		text_delay_between.setBounds(10, 60, 150, 30);
		panel.add(text_delay_between);
		delay_between = new JSlider(0,10);
		delay_between.setBackground(Color.GREEN);
		delay_between.setBounds(200, 60, 200, 30);
		panel.add(delay_between);
		delay_between.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_delay_between.setText("Verzögerung: " + slider.getValue());
	        }
		});
		
		return panel;
		
	}

	@Override
	public boolean isEverythingFilledOut() {
		return false;
	}

}
