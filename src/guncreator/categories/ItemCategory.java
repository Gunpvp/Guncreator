package guncreator.categories;

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
		
		JInputField material = new JInputField("Name des Materials:");
		panel.addComponent(material);
		
		JInputField lore = new JInputField("Beschreibung des Items:");
		panel.addComponent(lore);
		
		//weapon sound
		sound = new JGunSound("Waffen");
		panel.addComponent(sound);
		
		return panel;
	}

	@Override
	public boolean isEverythingFilledOut() {
		return false;
	}

}
