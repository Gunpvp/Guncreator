package guncreator.categories;

import guns.weopons.data.ShootingData;

public class ShootingCategory extends Category<ShootingData> {

	private JAdjustbar delay_between_shots; 
	private JAdjustbar recoil; //float
	private JAdjustbar projectiles;
	private JAdjustbar damage; //float
	private JAdjustbar speed;
	private JBox drag_down;
	private JAdjustbar drag_distance;
	private JAdjustbar spread; //float
	private JGunSound shoot_sound;	
	
	public ShootingCategory() {
		super("SHOOTING");
	}

	@Override
	public EditPanel<ShootingData> createEditPanel() {
		
		EditPanel<ShootingData> panel = new EditPanel<ShootingData>() {
			
			@Override
			protected ShootingData generateData() {
				
				return new ShootingData((int)delay_between_shots.getValue(), recoil.getValue(), (int)projectiles.getValue(), damage.getValue(), (int) speed.getValue(), drag_down.getValue(), (int) drag_distance.getValue(), spread.getValue(), shoot_sound.getGunSound());
			}

			@Override
			public void initWithData(ShootingData data) {
				
				delay_between_shots.setValue(data.getDelayBetweenShots());
				recoil.setValue(data.getRecoil());
				projectiles.setValue(data.getProjectiles());
				damage.setValue(data.getDamage());
				speed.setValue(data.getSpeed());
				drag_down.setValue(data.isDraggingDown());
				drag_distance.setValue(data.getDragDistance());
				spread.setValue(data.getSpread());
				shoot_sound.setSound(data.getShootSound());
				
			}
		};
		
		//shot delay
		delay_between_shots = new JAdjustbar("Schussverzögerung:", "Ticks", 0, 100, 1);
		panel.addComponent(delay_between_shots);
		
		//recoil
		recoil = new JAdjustbar("Rückstoß:", "", 0,20, 1);
		panel.addComponent(recoil);
		
		//projectile amount
		projectiles = new JAdjustbar("Projektilanzahl:", "", 0, 10, 1);
		panel.addComponent(projectiles);
		
		//damage
		damage = new JAdjustbar("Schaden:", "halbe Herzen", 0,30, 0.1f);
		panel.addComponent(damage);
		
		
		//projectile speed
		speed = new JAdjustbar("Projektilgeschw.:", "", 0 , 15, 1);
		panel.addComponent(speed);
		
		//drag down
		drag_down = new JBox("Drag Down:");
		panel.addComponent(drag_down);
		
		//drag distance
		drag_distance = new JAdjustbar("Dag Distance:", "Blocks", 0,20, 1);
		panel.addComponent(drag_distance);
		
		//spread
		spread = new JAdjustbar("Streuung:", "", 0,50, 0.1f);
		panel.addComponent(spread);
		
		//Shooter Sound
		shoot_sound = new JGunSound("Schuss");
		panel.addComponent(shoot_sound);
		
		return panel;
	}

	@Override
	public boolean isEverythingFilledOut() {
		return shoot_sound.isDataValid();
	}

}
