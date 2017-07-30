package guncreator.categories;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import org.bukkit.Material;
import guncreator.JGunSound;
import guncreator.utils.EnumChecker;
import guns.weopons.data.AmmoData;

public class AmmoCategory extends Category<AmmoData>{

	private JTextField material;
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
				
				return new AmmoData(Material.valueOf(material.getText().toUpperCase()), out_of_ammo_sound.getGunSound(), shoot_with_no_ammo_sound.getGunSound());				
			}

			@Override
			public void initWithData(AmmoData data) {
				
				material.setText(data.getMaterial().toString().toUpperCase());
				
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
		
		//out of ammo
		out_of_ammo_sound = new JGunSound("Out of Ammo");
		out_of_ammo_sound.setBounds(10, 60, 400, 300);
		out_of_ammo_sound.setBackground(Color.GREEN);
		panel.add(out_of_ammo_sound);
		
		//shoot with no ammo sound
		shoot_with_no_ammo_sound = new JGunSound("No Ammo");
		shoot_with_no_ammo_sound.setBounds(10, 360, 400, 300);
		shoot_with_no_ammo_sound.setBackground(Color.GREEN);
		panel.add(shoot_with_no_ammo_sound);
		
		return panel;
	}
	@Override
	public boolean isEverythingFilledOut() {
		return EnumChecker.isValidMaterial(material.getText()) && out_of_ammo_sound.isValid() && shoot_with_no_ammo_sound.isValid();
	}

}
