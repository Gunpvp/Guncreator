package guncreator;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.bukkit.Sound;

import guns.weopons.data.GunSound;

public class JGunSound extends JPanel {

	private JTextField sound_name_1, sound_name_2;
	private JSlider volume_1, volume_2;
	private JSlider pitch_1, pitch_2;

	public JGunSound(String text_sound_1, String text_sound_2) {
		super(null);


		//sound 1
		JLabel lable_sound_1 = new JLabel(text_sound_1 + "Sound:");
		lable_sound_1.setBounds(0, 0, 150, 30);
		this.add(lable_sound_1);
		sound_name_1 = new JTextField();
		sound_name_1.setBackground(Color.LIGHT_GRAY);
		sound_name_1.setBounds(200, 0, 200, 30);
		this.add(sound_name_1);
		
		JLabel text_volume_1 = new JLabel(text_sound_1 + "Volume:");
		text_volume_1.setBounds(0, 50, 150, 30);
		this.add(text_volume_1);
		volume_1 = new JSlider(0,10);
		volume_1.setBackground(Color.GREEN);
		volume_1.setBounds(200, 50, 200, 30);
		this.add(volume_1 );
		volume_1.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_volume_1.setText(text_sound_1 + "Volume: " + slider.getValue());
	        }
	    });
		
		JLabel text_pitch_1 = new JLabel(pitch_1 + "Pitch:");
		text_pitch_1.setBounds(0, 100, 150, 30);
		this.add(text_pitch_1);
		pitch_1 = new JSlider(0,100);
		pitch_1.setBounds(200, 100, 200, 30);
		pitch_1.setBackground(Color.GREEN);
		this.add(pitch_1);
		pitch_1.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_pitch_1.setText(pitch_1 + "Pitch: " + slider.getValue());
	        }
	    });
		
		//sound 2
		JLabel lable_sound_2 = new JLabel(text_sound_2 + "Sound:");
		lable_sound_2.setBounds(0, 0, 150, 30);
		this.add(lable_sound_2);
		sound_name_2 = new JTextField();
		sound_name_2.setBackground(Color.LIGHT_GRAY);
		sound_name_2.setBounds(200, 0, 200, 30);
		this.add(sound_name_2);
		
		JLabel text_volume_2 = new JLabel(text_sound_2 + "Volume:");
		text_volume_2.setBounds(0, 50, 150, 30);
		this.add(text_volume_2);
		volume_2 = new JSlider(0,10);
		volume_2.setBackground(Color.GREEN);
		volume_2.setBounds(200, 50, 200, 30);
		this.add(volume_2 );
		volume_2.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_volume_2.setText(text_sound_2 + "Volume: " + slider.getValue());
	        }
	    });
		
		JLabel text_pitch_2 = new JLabel(pitch_2 + "Pitch:");
		text_pitch_2.setBounds(0, 100, 150, 30);
		this.add(text_pitch_2);
		pitch_2 = new JSlider(0,100);
		pitch_2.setBounds(200, 100, 200, 30);
		pitch_2.setBackground(Color.GREEN);
		this.add(pitch_2);
		pitch_2.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_pitch_2.setText(pitch_2 + "Pitch: " + slider.getValue());
	        }
	    });

	}

	public GunSound getGunSound1() {
		return new GunSound(Sound.valueOf(sound_name_1.getText().toUpperCase()), volume_1.getValue(),
				pitch_1.getValue());
	}

	public GunSound getGunSound2() {
		return new GunSound(Sound.valueOf(sound_name_2.getText().toUpperCase()), volume_2.getValue(),
				pitch_2.getValue());
	}

}
