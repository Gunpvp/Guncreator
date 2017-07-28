package guncreator.categories;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import guns.weopons.data.ItemData;

public class ItemCategory extends Category<ItemData> {

	private JTextField material_name;
	private JTextField lore;
	private JTextField sound;
	private JSlider volume;
	private JSlider pitch;

	public ItemCategory() {
		super("ITEM");
	}

	@Override
	public EditPanel<ItemData> createEditPanel() {
		
		EditPanel<ItemData> panel = new EditPanel<ItemData>() {

			@Override
			protected ItemData generateData() {
				
				return null;
				
			}
			
		};
		
		panel.setLayout(null);
		
		JLabel text_material_name = new JLabel("Name des Materials:");
		text_material_name.setBounds(10, 10, 150, 30);
		panel.add(text_material_name);
		material_name = new JTextField();
		material_name.setBackground(Color.LIGHT_GRAY);
		material_name.setBounds(200, 10, 200, 30);
		panel.add(material_name);
		
		JLabel text_lore = new JLabel("Beschreibung des Items:");
		text_lore.setBounds(10, 60, 150, 30);
		panel.add(text_lore);
		lore = new JTextField();
		lore.setBackground(Color.LIGHT_GRAY);
		lore.setBounds(200, 60, 200, 30);
		panel.add(lore);
		
		JLabel text_sound = new JLabel("Waffe erhält Sound:");
		text_sound.setBounds(10, 110, 150, 30);
		panel.add(text_sound);
		sound = new JTextField();
		sound.setBackground(Color.LIGHT_GRAY);
		sound.setBounds(200, 110, 200, 30);
		panel.add(sound);
		
		JLabel text_volume = new JLabel("Sound Volume:");
		text_volume.setBounds(10, 160, 150, 30);
		panel.add(text_volume);
		volume = new JSlider(0,10);
		volume.setBackground(Color.GREEN);
		volume.setBounds(200, 160, 200, 30);
		panel.add(volume);
		volume.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_volume.setText("Sound Volume: " + slider.getValue());
	        }
	    });
		
		JLabel text_pitch = new JLabel("Sound Pitch:");
		text_pitch.setBounds(10, 210, 150, 30);
		panel.add(text_pitch);
		pitch = new JSlider(0,100);
		pitch.setBounds(200, 210, 200, 30);
		pitch.setBackground(Color.GREEN);
		panel.add(pitch);
		pitch.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_pitch.setText("Sound Pitch: " + slider.getValue());
	        }
	    });
		
		return panel;
	}

	@Override
	public boolean isEverythingFilledOut() {
		return false;
	}

}
