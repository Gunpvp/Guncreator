package guncreator.categories;

import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import guncreator.JGunSound;
import guns.weopons.data.ReloadData;

public class ReloadCategory extends Category<ReloadData> {

	private JCheckBox reload_ammo;
	private JCheckBox reload_individual;
	private JCheckBox fully_automatic;
	private JSlider reload_amount;
	private JSlider reload_duration;
	private JGunSound reload_sound_start;
	private JGunSound reload_sound_finish;
	
	public ReloadCategory() {
		super("RELOAD");
	}

	@Override
	public EditPanel<ReloadData> createEditPanel() {
		
		 	EditPanel<ReloadData> panel = new EditPanel<ReloadData>() {

			@Override
			protected ReloadData generateData() {
								
				return new ReloadData(reload_ammo.isSelected(), reload_individual.isSelected(), fully_automatic.isSelected(), reload_amount.getValue(), reload_duration.getValue(), reload_sound_start.getGunSound(), reload_sound_finish.getGunSound());
				
			}

			@Override
			public void initWithData(ReloadData data) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		panel.setLayout(null);
		
		//reload ammo
		JLabel text_reload_ammo = new JLabel("Waffe nachladbar:");
		text_reload_ammo.setBounds(10, 10, 150, 30);
		panel.add(text_reload_ammo);
		reload_ammo = new JCheckBox();
		reload_ammo.setBackground(Color.GREEN);
		reload_ammo.setBounds(200, 10, 30, 30);
		panel.add(reload_ammo);
		
		//reload individual
		JLabel text_reload_individual = new JLabel("Nur einzeln nachladbar:");
		text_reload_individual.setBounds(10, 60, 150, 30);
		panel.add(text_reload_individual);
		reload_individual = new JCheckBox();
		reload_individual.setBackground(Color.GREEN);
		reload_individual.setBounds(200, 60, 30, 30);
		panel.add(reload_individual);
		
		//fully automatic
		JLabel text_fully_automatic = new JLabel("Waffe vollautomatisch:");
		text_fully_automatic.setBounds(10, 110, 150, 30);
		panel.add(text_fully_automatic);
		fully_automatic = new JCheckBox();
		fully_automatic.setBackground(Color.GREEN);
		fully_automatic.setBounds(200, 110, 30, 30);
		panel.add(fully_automatic);
		
		//reload amount
		JLabel text_reload_amount = new JLabel("Nachlademenge:");
		text_reload_amount.setBounds(10, 160, 150, 30);
		panel.add(text_reload_amount);
		reload_amount = new JSlider(0,100);
		reload_amount.setBackground(Color.GREEN);
		reload_amount.setBounds(200, 160, 200, 30);
		panel.add(reload_amount);
		reload_amount.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_reload_amount.setText("Nachlademenge: " + slider.getValue());
	        }
		});
		
		//reload duration
		JLabel text_reload_duration = new JLabel("Nachladezeit:");
		text_reload_duration.setBounds(10, 210, 150, 30);
		panel.add(text_reload_duration);
		reload_duration = new JSlider(0,20);
		reload_duration.setBackground(Color.GREEN);
		reload_duration.setBounds(200, 210, 200, 30);
		panel.add(reload_duration);
		reload_duration.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_reload_duration.setText("Nachladezeit: " + slider.getValue());
	        }
		});
		
		//reload sound start
		reload_sound_start = new JGunSound("Reload start");
		reload_sound_start.setBounds(10, 260, 400, 300);
		reload_sound_start.setBackground(Color.GREEN);
		panel.add(reload_sound_start);
		
		//Shooter Sound
		reload_sound_finish = new JGunSound("Reload finish");
		reload_sound_finish.setBounds(10, 560, 400, 300);
		reload_sound_finish.setBackground(Color.GREEN);
		panel.add(reload_sound_finish);
		
		
		return panel;
	}
		
		

	@Override
	public boolean isEverythingFilledOut() {

		return false;
	}

}
