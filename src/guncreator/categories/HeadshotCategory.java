package guncreator.categories;

import guns.weapons.data.HeadshotData;

public class HeadshotCategory extends Category<HeadshotData> {

	private JBox headshot;
	private JBox firework;
	private JAdjustbar bonus_damage;
	private JGunSound shooter_sound;
	private JGunSound victim_sound;
	
	public HeadshotCategory() {
		super("HEADSHOT");
	}

	@Override
	public EditPanel<HeadshotData> createEditPanel() {
		
		 	EditPanel<HeadshotData> panel = new EditPanel<HeadshotData>() {

			@Override
			protected HeadshotData generateData() {
								
				return new HeadshotData(headshot.getValue(), bonus_damage.getValue(), firework.getValue(), shooter_sound.getGunSound(), victim_sound.getGunSound());
				
			}

			@Override
			public void initWithData(HeadshotData data) {
				shooter_sound.setSound(data.getShooterSound());
				victim_sound.setSound(data.getVictimSound());
				headshot.setValue(data.isHeadshotEnabled());
				firework.setValue(data.isFireworkEnabled());
				bonus_damage.setValue(((int)data.getBounsDamage()));
			}
			
		};
		
		headshot = new JBox("Headshot möglich");
		panel.addComponent(headshot);
		
		firework = new JBox("Feuerwerk");
		panel.addComponent(firework);
		
		bonus_damage = new JAdjustbar("Bonusschaden", "halbe Herzen", 0, 30, 1);
		panel.addComponent(bonus_damage);

		shooter_sound = new JGunSound("Shooter Sound");
		panel.addComponent(shooter_sound);
		
		victim_sound = new JGunSound("Victim Sound");
		panel.addComponent(victim_sound);
		
		return panel;
	}

	@Override
	public boolean isEverythingFilledOut() {
		return (shooter_sound.isDataValid() && victim_sound.isDataValid()) || !headshot.getValue();
	}

}
