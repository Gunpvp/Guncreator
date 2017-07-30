package guncreator.categories;

import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import guns.weopons.data.SneakData;

public class SneakCategory extends Category<SneakData>{

	private JCheckBox sneak_depending;
	private JCheckBox block_recoil;
	private JSlider spread;
	
	public SneakCategory() {
		super("SNEAK");
		
	}

	@Override
	public EditPanel<SneakData> createEditPanel() {
		
		 	EditPanel<SneakData> panel = new EditPanel<SneakData>() {

			@Override
			protected SneakData generateData() {
				
				return new SneakData(sneak_depending.isSelected(), block_recoil.isSelected(), spread.getValue()/10);
				
			}

			@Override
			public void initWithData(SneakData data) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		panel.setLayout(null);
		
		//sneak depending
		JLabel text_sneak_depending = new JLabel("Sneak ändert Eigenschaften:");
		text_sneak_depending.setBounds(10, 10, 150, 30);
		panel.add(text_sneak_depending);
		sneak_depending = new JCheckBox();
		sneak_depending.setBackground(Color.GREEN);
		sneak_depending.setBounds(200, 10, 30, 30);
		panel.add(sneak_depending);
		
		//block recoil
		JLabel text_block_recoil = new JLabel("Rückstoß blockieren:");
		text_block_recoil.setBounds(10, 60, 150, 30);
		panel.add(text_block_recoil);
		block_recoil = new JCheckBox();
		block_recoil.setBackground(Color.GREEN);
		block_recoil.setBounds(200, 60, 30, 30);
		panel.add(block_recoil);
		
		//spread
		JLabel text_spread = new JLabel("Streuung:");
		text_spread.setBounds(10, 110, 150, 30);
		panel.add(text_spread);
		spread = new JSlider(0,500);
		spread.setBackground(Color.GREEN);
		spread.setBounds(200, 110, 200, 30);
		panel.add(spread);
		spread.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_spread.setText("Streuung: " + slider.getValue()/10);
	        }
		});
		
		return panel;
	}

	@Override
	public boolean isEverythingFilledOut() {
		return false;
	}

}
