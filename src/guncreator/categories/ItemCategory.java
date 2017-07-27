package guncreator.categories;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import guns.weopons.data.ItemData;

public class ItemCategory extends Category<ItemData> {

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
		
		JLabel text_material_name = new JLabel("Name des Material:");
		text_material_name.setBounds(10, 10, 150, 30);
		panel.add(text_material_name);
		JTextField material_name = new JTextField();
		material_name.setBounds(200, 10, 200, 30);
		panel.add(material_name);
		
		JLabel text_lore = new JLabel("Beschreibung des Items:");
		text_lore.setBounds(10, 60, 150, 30);
		panel.add(text_lore);
		JTextField lore = new JTextField();
		lore.setBounds(200, 60, 200, 30);
		panel.add(lore);
		
		JLabel text_sound = new JLabel("Sound bei :");
		text_sound.setBounds(10, 110, 150, 30);
		panel.add(text_sound);
		JTextField sound_name = new JTextField("");
		lore.setBounds(200, 110, 200, 30);
		panel.add(lore);
		
		return panel;
	}

	@Override
	public boolean isEverythingFilledOut() {
		return false;
	}

}
