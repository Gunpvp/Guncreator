package guncreator.categories;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import guns.weopons.data.AmmoData;

public class AmmoCategory extends Category<AmmoData>{

	private JTextField material;
	private JTextField out_of_ammo_sound;
	private JSlider out_of_ammo_sound_volume;
	private JSlider out_of_ammo_sound_pitch;
	private JTextField shoot_with_no_ammo_sound;
	private JSlider shoot_with_no_ammo_sound_volume;
	private JSlider shoot_with_no_ammo_sound_pitch;
	
	public AmmoCategory() {
		super("AMMO");
		
	}

	@Override
	public EditPanel<AmmoData> createEditPanel() {
		
		 	EditPanel<AmmoData> panel = new EditPanel<AmmoData>() {

			@Override
			protected AmmoData generateData() {
				
				return null;
				
			}
			
		};
		 
		panel.setLayout(null);

		//material
		JLabel text_material = new JLabel("Material (Item):");
		text_material.setBounds(10, 10, 150, 30);
		panel.add(text_material);
		material = new JTextField();
		material.setBackground(Color.LIGHT_GRAY);
		material.setBounds(200, 10, 200, 30);
		panel.add(material);
		
		//out of ammo sound
		JLabel text_out_of_ammo_sound = new JLabel("Out of Ammo Sound:");
		text_out_of_ammo_sound.setBounds(10, 60, 150, 30);
		panel.add(text_out_of_ammo_sound);
		out_of_ammo_sound = new JTextField();
		out_of_ammo_sound.setBackground(Color.LIGHT_GRAY);
		out_of_ammo_sound.setBounds(200, 60, 200, 30);
		panel.add(out_of_ammo_sound);
		
		JLabel text_out_of_ammo_sound_volume = new JLabel("Out of Ammo Volume:");
		text_out_of_ammo_sound_volume.setBounds(10, 110, 150, 30);
		panel.add(text_out_of_ammo_sound_volume);
		out_of_ammo_sound_volume = new JSlider(0,10);
		out_of_ammo_sound_volume.setBackground(Color.GREEN);
		out_of_ammo_sound_volume.setBounds(200, 110, 200, 30);
		panel.add(out_of_ammo_sound_volume);
		out_of_ammo_sound_volume.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_out_of_ammo_sound_volume.setText("Out of Ammo Volume: " + slider.getValue());
	        }
	    });
		
		JLabel text_out_of_ammo_sound_pitch = new JLabel("Out of Ammo Pitch:");
		text_out_of_ammo_sound_pitch.setBounds(10, 160, 150, 30);
		panel.add(text_out_of_ammo_sound_pitch);
		out_of_ammo_sound_pitch = new JSlider(0,100);
		out_of_ammo_sound_pitch.setBounds(200, 160, 200, 30);
		out_of_ammo_sound_pitch.setBackground(Color.GREEN);
		panel.add(out_of_ammo_sound_pitch);
		out_of_ammo_sound_pitch.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_out_of_ammo_sound_pitch.setText("Out of Ammo Pitch: " + slider.getValue());
	        }
	    });
		
		//shoot with no ammo sound
		JLabel text_shoot_with_no_ammo_sound = new JLabel("Shoot without Ammo Sound:");
		text_shoot_with_no_ammo_sound.setBounds(10, 210, 150, 30);
		panel.add(text_shoot_with_no_ammo_sound);
		shoot_with_no_ammo_sound = new JTextField();
		shoot_with_no_ammo_sound.setBackground(Color.LIGHT_GRAY);
		shoot_with_no_ammo_sound.setBounds(200, 210, 200, 30);
		panel.add(shoot_with_no_ammo_sound);
		
		JLabel text_shoot_with_no_ammo_sound_volume = new JLabel("Shoot without Ammo Volume:");
		text_shoot_with_no_ammo_sound_volume.setBounds(10, 260, 150, 30);
		panel.add(text_shoot_with_no_ammo_sound_volume);
		shoot_with_no_ammo_sound_volume = new JSlider(0,10);
		shoot_with_no_ammo_sound_volume.setBackground(Color.GREEN);
		shoot_with_no_ammo_sound_volume.setBounds(200, 260, 200, 30);
		panel.add(shoot_with_no_ammo_sound_volume);
		shoot_with_no_ammo_sound_volume.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_shoot_with_no_ammo_sound_volume.setText("Shoot without Ammo Volume: " + slider.getValue());
	        }
	    });
		
		JLabel text_shoot_with_no_ammo_sound_pitch = new JLabel("Shoot without Ammo Pitch:");
		text_shoot_with_no_ammo_sound_pitch.setBounds(10,310, 150, 30);
		panel.add(text_shoot_with_no_ammo_sound_pitch);
		shoot_with_no_ammo_sound_pitch = new JSlider(0,100);
		shoot_with_no_ammo_sound_pitch.setBounds(200, 310, 200, 30);
		shoot_with_no_ammo_sound_pitch.setBackground(Color.GREEN);
		panel.add(shoot_with_no_ammo_sound_pitch);
		shoot_with_no_ammo_sound_pitch.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_shoot_with_no_ammo_sound_pitch.setText("Shoot without Ammo Pitch: " + slider.getValue());
	        }
	    });
		
		return panel;
	}
	@Override
	public boolean isEverythingFilledOut() {
		
		return false;
	}

}
