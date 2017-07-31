package guncreator.categories;

import guns.weopons.data.ExplosionData;

public class ExplosionCategory extends Category<ExplosionData> {

	private JBox explosion;
	private JAdjustbar radius;
	private JAdjustbar knockback;
	private JAdjustbar damage;
	private JGunSound shooter;
	
	public ExplosionCategory() {
		super("EXPLOSION");
	}

	@Override
	public EditPanel<ExplosionData> createEditPanel() {
		
		EditPanel<ExplosionData> panel = new EditPanel<ExplosionData>() {
			
			@Override
			protected ExplosionData generateData() {
								
				return new ExplosionData(explosion.getValue(), radius.getValue(), knockback.getValue(), damage.getValue(), shooter.getGunSound());
			}

			@Override
			public void initWithData(ExplosionData data) {
				explosion.setValue(data.isExploding());
				radius.setValue(data.getRadius());
				knockback.setValue(data.getKnockback());
				damage.setValue(data.getDamage());
				shooter.setSound(data.getShooter());
			}
			
		};
		
		explosion = new JBox("Waffe erzeugt Explosion");
		panel.addComponent(explosion);

		radius = new JAdjustbar("Radius", "Blocks", 0, 15, 1);
		panel.addComponent(radius);
		
		knockback = new JAdjustbar("Rückstoß", "Blocks", 0, 15, 1);
		panel.addComponent(knockback);
		
		damage = new JAdjustbar("Schaden", "halbe Herzen", 0, 30, 1);
		panel.addComponent(damage);
		
		shooter = new JGunSound("Explosions");
		panel.addComponent(shooter);
		
		return panel;
	}

	@Override
	public boolean isEverythingFilledOut() {
		return shooter.isDataValid() || !explosion.getValue();
	}

}
