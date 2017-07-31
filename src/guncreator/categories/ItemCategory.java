package guncreator.categories;

import org.bukkit.Material;

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
				
				return new ItemData(Material.valueOf(material.getValue().toUpperCase()), lore.getValue(), sound.getGunSound());
				
			}

			@Override
			public void initWithData(ItemData data) {
				
				material.setValue(data.getMaterial().toString().toUpperCase());
				lore.setValue(data.getLore());
				sound.setSound(data.getSound());
				
			}
			
		};
		
		material = new JInputField("Name des Materials:");
		panel.addComponent(material);
		
		lore = new JInputField("Beschreibung des Items:");
		panel.addComponent(lore);
		
		JAdjustbar bar = new JAdjustbar("Test Slider:", "Ticks", 0, 2, 0.1f);
		panel.addComponent(bar);
		
		JBox box = new JBox("Test Box:");
		panel.addComponent(box);
		
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
