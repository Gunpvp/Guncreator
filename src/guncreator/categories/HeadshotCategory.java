package guncreator.categories;

import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import guns.weopons.data.HeadshotData;

public class HeadshotCategory extends Category<HeadshotData> {

	private JCheckBox headshot;
	private JCheckBox firework;
	private JSlider bonus_damage;
	private JGunSound shooter_sound;
	private JGunSound victim_sound;
	
	public HeadshotCategory() {
		super("HEADSHOT");
	}

	@Override
	public EditPanel<HeadshotData> createEditPanel() {
		
		 	EditPanel<HeadshotData> panel = new EditPanel<HeadshotData>() {

			@Override
			protected HeadshotData generateData() {
								
				return new HeadshotData(headshot.isSelected(), bonus_damage.getValue()/10, firework.isSelected(), shooter_sound.getGunSound(), victim_sound.getGunSound());
				
			}

			@Override
			public void initWithData(HeadshotData data) {
				shooter_sound.setSound(data.getShooterSound());
				victim_sound.setSound(data.getVictimSound());
				headshot.setSelected(data.isHeadshotEnabled());
				firework.setSelected(data.isFireworkEnabled());
				bonus_damage.setValue(((int)data.getBounsDamage()*10));
			}
			
		};
		 
		panel.setLayout(null);
		
		//Headshot available
		JLabel text_headshot = new JLabel("Headshot möglich:");
		text_headshot.setBounds(10, 10, 150, 30);
		panel.add(text_headshot);
		headshot = new JCheckBox();
		headshot.setBackground(Color.GREEN);
		headshot.setBounds(200, 10, 30, 30);
		panel.add(headshot);
		
		//Bonus Damage
		JLabel text_bonus_damage = new JLabel("Bonus Schaden:");
		text_bonus_damage.setBounds(10, 60, 150, 30);
		panel.add(text_bonus_damage);
		bonus_damage = new JSlider(0,200);
		bonus_damage.setBackground(Color.GREEN);
		bonus_damage.setBounds(200, 60, 200, 30);
		panel.add(bonus_damage);
		bonus_damage.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_bonus_damage.setText("Bonus Schaden: " + slider.getValue()/10f);
	        }
		});
		
		//Firework Available
		JLabel text_firework = new JLabel("Feuerwerk Animation:");
		text_firework.setBounds(10, 110, 150, 30);
		panel.add(text_firework);
		firework = new JCheckBox();
		firework.setBackground(Color.GREEN);
		firework.setBounds(200, 110, 30, 30);
		panel.add(firework);
		
		
		//Shooter Sound
		shooter_sound = new JGunSound("Shooter");
		shooter_sound.setBounds(10, 160, 400, 300);
		shooter_sound.setBackground(Color.GREEN);
		panel.add(shooter_sound);
		
		//Victim Sound
		victim_sound = new JGunSound("Victim");
		victim_sound.setBounds(10, 460, 400, 300);
		victim_sound.setBackground(Color.GREEN);
		panel.add(victim_sound);
		
		
		return panel;
	}

	@Override
	public boolean isEverythingFilledOut() {
		return shooter_sound.isDataValid() && victim_sound.isDataValid();
	}

}
