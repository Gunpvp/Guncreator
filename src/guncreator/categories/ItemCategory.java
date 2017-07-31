package guncreator.categories;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import org.bukkit.Material;
import guncreator.JGunSound;
import guns.weopons.data.ItemData;

public class ItemCategory extends Category<ItemData> {

	private JTextField material_name;
	private JTextField lore;
	private JGunSound sound;

	public ItemCategory() {
		super("ITEM");
	}

	@Override
	public EditPanel<ItemData> createEditPanel() {
		
		EditPanel<ItemData> panel = new EditPanel<ItemData>() {

			@Override
			protected ItemData generateData() {
				
				return new ItemData(Material.valueOf(material_name.getText().toUpperCase()), lore.getText(), sound.getGunSound());
				
			}

			@Override
			public void initWithData(ItemData data) {
				// TODO Auto-generated method stub
				
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
		
		//weapon sound
		sound = new JGunSound("Waffen");
		sound.setBounds(10, 110, 400, 300);
		panel.add(sound);
		
		return panel;
	}

	@Override
	public boolean isEverythingFilledOut() {
		return false;
	}

}
