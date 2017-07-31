package guncreator.categories;

import org.bukkit.Material;

import guncreator.utils.EnumChecker;
import guns.weopons.data.ItemData;

public class ItemCategory extends Category<ItemData> {

	private JGunSound sound;
	private JInputField material;
	private JInputField lore;

	public ItemCategory() {
		super("ITEM");
	}

	@Override
	public EditPanel<ItemData> createEditPanel() {
		
		EditPanel<ItemData> panel = new EditPanel<ItemData>() {

			@Override
			protected ItemData generateData() {
				
				return new ItemData(Material.valueOf(material.getValue()), lore.getValue(), sound.getGunSound());
				
			}

			@Override
			public void initWithData(ItemData data) {
				
				material.setValue(data.getMaterial().toString());
				lore.setValue(data.getLore());
				sound.setSound(data.getSound());
				
			}
			
		};
		
		material = new JInputField("Name des Materials:");
		panel.addComponent(material);
		
		lore = new JInputField("Beschreibung des Items:");
		panel.addComponent(lore);
		
		//weapon sound
		sound = new JGunSound("Waffen");
		panel.addComponent(sound);
		
		return panel;
	}

	@Override
	public boolean isEverythingFilledOut() {
		return sound.isDataValid() && EnumChecker.isValidMaterial(material.getValue()) && !lore.getValue().isEmpty();
	}

}
