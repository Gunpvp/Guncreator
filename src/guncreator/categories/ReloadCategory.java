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
import guns.weopons.data.ReloadData;

public class ReloadCategory extends Category<ReloadData> {

	private JCheckBox reload_ammo;
	private JCheckBox reload_individual;
	private JCheckBox fully_automatic;
	private JSlider reload_amount;
	private JSlider reload_duration;
	private JTextField reload_sound_start;
	private JSlider reload_sound_start_volume;
	private JSlider reload_sound_start_pitch;
	private JTextField reload_sound_finish;
	private JSlider reload_sound_finish_volume;
	private JSlider reload_sound_finish_pitch;
	
	public ReloadCategory() {
		super("RELOAD");
	}

	@Override
	public EditPanel<ReloadData> createEditPanel() {
		
		 	EditPanel<ReloadData> panel = new EditPanel<ReloadData>() {

			@Override
			protected ReloadData generateData() {
				
				GunSound sound_start = new GunSound(Sound.valueOf(reload_sound_start.getText().toUpperCase()), reload_sound_start_volume.getValue(), reload_sound_start_pitch.getValue());
				GunSound sound_finish = new GunSound(Sound.valueOf(reload_sound_finish.getText().toUpperCase()), reload_sound_finish_volume.getValue(), reload_sound_finish_pitch.getValue());
				
				return new ReloadData(reload_ammo.isSelected(), reload_individual.isSelected(), fully_automatic.isSelected(), reload_amount.getValue(), reload_duration.getValue(), sound_start, sound_finish);
				
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
		JLabel text_reload_sound_start = new JLabel("Reload Start Sound:");
		text_reload_sound_start.setBounds(10, 260, 150, 30);
		panel.add(text_reload_sound_start);
		reload_sound_start = new JTextField();
		reload_sound_start.setBackground(Color.LIGHT_GRAY);
		reload_sound_start.setBounds(200, 260, 200, 30);
		panel.add(reload_sound_start);
		
		JLabel text_reload_sound_start_volume = new JLabel("Start Volume:");
		text_reload_sound_start_volume.setBounds(10, 310, 150, 30);
		panel.add(text_reload_sound_start_volume);
		reload_sound_start_volume = new JSlider(0,10);
		reload_sound_start_volume.setBackground(Color.GREEN);
		reload_sound_start_volume.setBounds(200, 310, 200, 30);
		panel.add(reload_sound_start_volume );
		reload_sound_start_volume.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_reload_sound_start_volume.setText("Start Volume: " + slider.getValue());
	        }
	    });
		
		JLabel text_reload_sound_start_pitch = new JLabel("Start Pitch:");
		text_reload_sound_start_pitch.setBounds(10, 360, 150, 30);
		panel.add(text_reload_sound_start_pitch);
		reload_sound_start_pitch = new JSlider(0,100);
		reload_sound_start_pitch.setBounds(200, 360, 200, 30);
		reload_sound_start_pitch.setBackground(Color.GREEN);
		panel.add(reload_sound_start_pitch);
		reload_sound_start_pitch.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_reload_sound_start_pitch.setText("Start Pitch: " + slider.getValue());
	        }
	    });
		
		//Shooter Sound
		JLabel text_reload_sound_finish = new JLabel("Reload Finished Sound:");
		text_reload_sound_finish.setBounds(10, 410, 150, 30);
		panel.add(text_reload_sound_finish);
		reload_sound_finish = new JTextField();
		reload_sound_finish.setBackground(Color.LIGHT_GRAY);
		reload_sound_finish.setBounds(200, 410, 200, 30);
		panel.add(reload_sound_finish);
		
		JLabel text_reload_sound_finish_volume = new JLabel("Finished Volume:");
		text_reload_sound_finish_volume.setBounds(10, 460, 150, 30);
		panel.add(text_reload_sound_finish_volume);
		reload_sound_finish_volume = new JSlider(0,10);
		reload_sound_finish_volume.setBackground(Color.GREEN);
		reload_sound_finish_volume.setBounds(200, 460, 200, 30);
		panel.add(reload_sound_finish_volume );
		reload_sound_finish_volume.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_reload_sound_finish_volume.setText("Finished Volume: " + slider.getValue());
	        }
	    });
		
		JLabel text_reload_sound_finish_pitch = new JLabel("Finished Pitch:");
		text_reload_sound_finish_pitch.setBounds(10, 510, 150, 30);
		panel.add(text_reload_sound_finish_pitch);
		reload_sound_finish_pitch = new JSlider(0,100);
		reload_sound_finish_pitch.setBounds(200, 510, 200, 30);
		reload_sound_finish_pitch.setBackground(Color.GREEN);
		panel.add(reload_sound_finish_pitch);
		reload_sound_finish_pitch.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_reload_sound_finish_pitch.setText("Finished Pitch: " + slider.getValue());
	        }
	    });
		
		
		return panel;
	}
		
		

	@Override
	public boolean isEverythingFilledOut() {

		return false;
	}

}
