package guncreator;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.bukkit.Sound;

import guncreator.utils.EnumChecker;
import guns.weopons.data.GunSound;

public class JGunSound extends JPanel {

	private JTextField sound_name_1, sound_name_2;
	private JSlider volume_1, volume_2;
	private JSlider pitch_1, pitch_2;

	public JGunSound(String text_sound_1) {
		super(null);
		
		//sound 1
		JLabel lable_sound_1 = new JLabel(text_sound_1 + " Sound:");
		lable_sound_1.setBounds(0, 0, 150, 30);
		this.add(lable_sound_1);
		sound_name_1 = new JTextField();
		sound_name_1.setBackground(Color.LIGHT_GRAY);
		sound_name_1.setBounds(190, 0, 200, 30);
		this.add(sound_name_1);
		
		JLabel text_volume_1 = new JLabel(text_sound_1 + " Volume:");
		text_volume_1.setBounds(0, 50, 150, 30);
		this.add(text_volume_1);
		volume_1 = new JSlider(0,10);
		volume_1.setBackground(Color.GREEN);
		volume_1.setBounds(190, 50, 200, 30);
		this.add(volume_1 );
		volume_1.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_volume_1.setText(text_sound_1 + " Volume: " + slider.getValue());
	        }
	    });
		
		JLabel text_pitch_1 = new JLabel(text_sound_1 + " Pitch:");
		text_pitch_1.setBounds(0, 100, 150, 30);
		this.add(text_pitch_1);
		pitch_1 = new JSlider(0,100);
		pitch_1.setBounds(190, 100, 200, 30);
		pitch_1.setBackground(Color.GREEN);
		this.add(pitch_1);
		pitch_1.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_pitch_1.setText(text_sound_1 + " Pitch: " + slider.getValue());
	        }
	    });
		
		//sound 2
		JLabel lable_sound_2 = new JLabel(text_sound_1 + " Sound 2:");
		lable_sound_2.setBounds(0, 150, 150, 30);
		this.add(lable_sound_2);
		sound_name_2 = new JTextField();
		sound_name_2.setBackground(Color.LIGHT_GRAY);
		sound_name_2.setBounds(190, 150, 200, 30);
		this.add(sound_name_2);
		
		JLabel text_volume_2 = new JLabel(text_sound_1 + " Volume 2:");
		text_volume_2.setBounds(0, 200, 150, 30);
		this.add(text_volume_2);
		volume_2 = new JSlider(0,10);
		volume_2.setBackground(Color.GREEN);
		volume_2.setBounds(190, 200, 200, 30);
		this.add(volume_2 );
		volume_2.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_volume_2.setText(text_sound_1 + " Volume 2: " + slider.getValue());
	        }
	    });
		
		JLabel text_pitch_2 = new JLabel(text_sound_1 + " Pitch 2:");
		text_pitch_2.setBounds(0, 250, 150, 30);
		this.add(text_pitch_2);
		pitch_2 = new JSlider(0,100);
		pitch_2.setBounds(190, 250, 200, 30);
		pitch_2.setBackground(Color.GREEN);
		this.add(pitch_2);
		pitch_2.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_pitch_2.setText(text_sound_1 + " Pitch 2: " + slider.getValue());
	        }
	    });

	}
	
	public boolean isDataValid() {
		return EnumChecker.isValidSound(sound_name_1.getText()) && EnumChecker.isValidSound(sound_name_2.getText());
	}
	
	public GunSound getGunSound() {
		if (!sound_name_2.getText().isEmpty()) {
			return new GunSound(Sound.valueOf(sound_name_1.getText().toUpperCase()), volume_1.getValue(),
					pitch_1.getValue()).addSound(Sound.valueOf(sound_name_2.getText().toUpperCase()), volume_2.getValue(),
					pitch_2.getValue());
		}else {
			return new GunSound(Sound.valueOf(sound_name_1.getText().toUpperCase()), volume_1.getValue(),
					pitch_1.getValue());
		}
	}
}
