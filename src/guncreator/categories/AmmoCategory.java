package guncreator.categories;

import org.bukkit.Material;

import guncreator.utils.EnumChecker;
import guns.weapons.data.AmmoData;

public class AmmoCategory extends Category<AmmoData>{

	private JInputField material;
	private JGunSound out_of_ammo_sound;
	private JGunSound shoot_with_no_ammo_sound;
	
	public AmmoCategory() {
		super("AMMO");
		
	}

	@Override
	public EditPanel<AmmoData> createEditPanel() {
		
		 	EditPanel<AmmoData> panel = new EditPanel<AmmoData>() {

			@Override
			protected AmmoData generateData() {
				
				return new AmmoData(Material.valueOf(material.getValue()), out_of_ammo_sound.getGunSound(), shoot_with_no_ammo_sound.getGunSound());				
			}

			@Override
			public void initWithData(AmmoData data) {
				
				material.setValue(data.getMaterial().toString());
				out_of_ammo_sound.setSound(data.getOutOfAmmoSound());
				shoot_with_no_ammo_sound.setSound(data.getShootWithNoAmmoSound());
			}
			
		};
		 
		//material
		material = new JInputField("Material (Item):");
		panel.addComponent(material);
		
		//out of ammo
		out_of_ammo_sound = new JGunSound("Out of Ammo");
		panel.addComponent(out_of_ammo_sound);
		
		//shoot with no ammo sound
		shoot_with_no_ammo_sound = new JGunSound("No Ammo");
		panel.addComponent(shoot_with_no_ammo_sound);
		
		return panel;
	}
	@Override
	public boolean isEverythingFilledOut() {
		return EnumChecker.isValidMaterial(material.getValue()) && out_of_ammo_sound.isDataValid() && shoot_with_no_ammo_sound.isDataValid();
	}

}
