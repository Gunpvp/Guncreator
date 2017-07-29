package guncreator.categories;

import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.bukkit.Sound;

import guns.weopons.data.GunSound;
import guns.weopons.data.HeadshotData;

public class HeadshotCategory extends Category<HeadshotData> {

	private JCheckBox headshot;
	private JCheckBox firework;
	private JSlider bonus_damage;
	private JTextField shooter_sound;
	private JSlider shooter_volume;
	private JSlider shooter_pitch;
	private JTextField victim_sound;
	private JSlider victim_volume;
	private JSlider victim_pitch;
	
	public HeadshotCategory() {
		super("HEADSHOT");
	}

	@Override
	public EditPanel<HeadshotData> createEditPanel() {
		
		 	EditPanel<HeadshotData> panel = new EditPanel<HeadshotData>() {

			@Override
			protected HeadshotData generateData() {
				
				GunSound shooter = new GunSound(Sound.valueOf(shooter_sound.getText().toUpperCase()), shooter_volume.getValue(), shooter_pitch.getValue());
				GunSound victim = new GunSound(Sound.valueOf(victim_sound.getText().toUpperCase()), victim_volume.getValue(), victim_pitch.getValue());
				
				return new HeadshotData(headshot.isSelected(), bonus_damage.getValue()/10, firework.isSelected(), shooter, victim);
				
			}

			@Override
			protected void initWithAmmo(HeadshotData data) {

				
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
	            text_bonus_damage.setText("Bonus Schaden: " + slider.getValue()/10);
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
		JLabel text_shooter_sound = new JLabel("Shooter Sound:");
		text_shooter_sound.setBounds(10, 160, 150, 30);
		panel.add(text_shooter_sound);
		shooter_sound = new JTextField();
		shooter_sound.setBackground(Color.LIGHT_GRAY);
		shooter_sound.setBounds(200, 160, 200, 30);
		panel.add(shooter_sound);
		
		JLabel text_shooter_volume = new JLabel("Shooter Volume:");
		text_shooter_volume.setBounds(10, 210, 150, 30);
		panel.add(text_shooter_volume);
		shooter_volume = new JSlider(0,10);
		shooter_volume.setBackground(Color.GREEN);
		shooter_volume.setBounds(200, 210, 200, 30);
		panel.add(shooter_volume);
		shooter_volume.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_shooter_volume.setText("Shooter Volume: " + slider.getValue());
	        }
	    });
		
		JLabel text_shooter_pitch = new JLabel("Shooter Pitch:");
		text_shooter_pitch.setBounds(10, 260, 150, 30);
		panel.add(text_shooter_pitch);
		shooter_pitch = new JSlider(0,100);
		shooter_pitch.setBounds(200, 260, 200, 30);
		shooter_pitch.setBackground(Color.GREEN);
		panel.add(shooter_pitch);
		shooter_pitch.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_shooter_pitch.setText("Shooter Pitch: " + slider.getValue());
	        }
	    });
		
		//Shooter Sound
		JLabel text_victim_sound= new JLabel("Victim Sound:");
		text_victim_sound.setBounds(10, 310, 150, 30);
		panel.add(text_victim_sound);
		victim_sound = new JTextField();
		victim_sound.setBackground(Color.LIGHT_GRAY);
		victim_sound.setBounds(200, 310, 200, 30);
		panel.add(victim_sound);
		
		JLabel text_victim_volume = new JLabel("Victim Volume:");
		text_victim_volume.setBounds(10, 360, 150, 30);
		panel.add(text_victim_volume);
		victim_volume = new JSlider(0,10);
		victim_volume.setBackground(Color.GREEN);
		victim_volume.setBounds(200, 360, 200, 30);
		panel.add(victim_volume );
		victim_volume.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_victim_volume.setText("Victim Volume: " + slider.getValue());
	        }
	    });
		
		JLabel text_victim_pitch = new JLabel("Victim Pitch:");
		text_victim_pitch.setBounds(10, 410, 150, 30);
		panel.add(text_victim_pitch);
		victim_pitch = new JSlider(0,100);
		victim_pitch.setBounds(200, 410, 200, 30);
		victim_pitch.setBackground(Color.GREEN);
		panel.add(victim_pitch);
		victim_pitch.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_victim_pitch.setText("Victim Pitch: " + slider.getValue());
	        }
	    });
		
		
		return panel;
	}

	@Override
	public boolean isEverythingFilledOut() {
		return false;
	}

}
