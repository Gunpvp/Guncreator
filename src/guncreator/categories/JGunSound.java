package guncreator.categories;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
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
		super(new GridLayout(6, 2));
		super.setBorder(new EtchedBorder(Color.GRAY, Color.BLACK));
		super.setBorder(new CompoundBorder(super.getBorder(), new EmptyBorder(10, 10, 10, 10)));
		super.validate();
		super.repaint();
		
		//sound 1
		JLabel lable_sound_1 = new JLabel(text_sound_1 + " Sound:");
		this.add(lable_sound_1);
		sound_name_1 = new JTextField();
		this.add(sound_name_1);
		
		JLabel text_volume_1 = new JLabel(text_sound_1 + " Volume:");
		this.add(text_volume_1);
		volume_1 = new JSlider(0,10);
		this.add(volume_1 );
		volume_1.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_volume_1.setText(text_sound_1 + " Volume: " + slider.getValue());
	        }
	    });
		
		JLabel text_pitch_1 = new JLabel(text_sound_1 + " Pitch:");
		this.add(text_pitch_1);
		pitch_1 = new JSlider(0,100);
		this.add(pitch_1);
		pitch_1.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_pitch_1.setText(text_sound_1 + " Pitch: " + slider.getValue());
	        }
	    });
		
		//sound 2
		JLabel lable_sound_2 = new JLabel(text_sound_1 + " Sound 2:");
		this.add(lable_sound_2);
		sound_name_2 = new JTextField();
		this.add(sound_name_2);
		
		JLabel text_volume_2 = new JLabel(text_sound_1 + " Volume 2:");
		this.add(text_volume_2);
		volume_2 = new JSlider(0,10);
		this.add(volume_2);
		volume_2.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_volume_2.setText(text_sound_1 + " Volume 2: " + slider.getValue());
	        }
	    });
		
		JLabel text_pitch_2 = new JLabel(text_sound_1 + " Pitch 2:");
		this.add(text_pitch_2);
		pitch_2 = new JSlider(0,100);
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
	
	public void setSound(GunSound sound) {
		
		sound_name_1.setText(sound.getSounds().get(0).getSound().toString().toUpperCase());
		volume_1.setValue(sound.getSounds().get(0).getVolume());
		pitch_1.setValue(sound.getSounds().get(0).getPitch());
		
		if (sound.getSounds().size()>1) {
			sound_name_2.setText(sound.getSounds().get(1).getSound().toString().toUpperCase());
			volume_2.setValue(sound.getSounds().get(1).getVolume());
			volume_2.setValue(sound.getSounds().get(1).getVolume());
			pitch_2.setValue(sound.getSounds().get(1).getPitch());
		}
	}
}
