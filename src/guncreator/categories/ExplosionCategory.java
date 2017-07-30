package guncreator.categories;

import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import guncreator.JGunSound;
import guns.weopons.data.ExplosionData;

public class ExplosionCategory extends Category<ExplosionData> {

	private JCheckBox explosion;
	private JSlider radius;
	private JSlider knockback;
	private JSlider damage;
	private JGunSound shooter;
	
	public ExplosionCategory() {
		super("EXPLOSION");
	}

	@Override
	public EditPanel<ExplosionData> createEditPanel() {
		
		EditPanel<ExplosionData> panel = new EditPanel<ExplosionData>() {
			
			protected ExplosionData generateData() {
								
				return new ExplosionData(explosion.isSelected(), radius.getValue()/10, knockback.getValue()/10, damage.getValue()/10, shooter.getGunSound());
			}

			@Override
			public void initWithData(ExplosionData data) {

				
			}
			
		};
		
		panel.setLayout(null);
		
		//Explosion available
		JLabel text_explosion = new JLabel("Waffe erzeugt Explosion:");
		text_explosion.setBounds(10, 10, 150, 30);
		panel.add(text_explosion);
		explosion = new JCheckBox();
		explosion.setBackground(Color.GREEN);
		explosion.setBounds(200, 10, 30, 30);
		panel.add(explosion);
		
		//Radius
		JLabel text_radius = new JLabel("Explosionsradius:");
		text_radius.setBounds(10, 60, 150, 30);
		panel.add(text_radius);
		radius = new JSlider(0,500);
		radius.setBackground(Color.GREEN);
		radius.setBounds(200, 60, 200, 30);
		panel.add(radius);
		radius.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_radius.setText("Explosionsradius: " + slider.getValue()/10);
	        }
		});
		
		//Knockback
		JLabel text_knockback = new JLabel("Explosionsrückstoß:");
		text_knockback.setBounds(10, 110, 150, 30);
		panel.add(text_knockback);
		knockback = new JSlider(0,100);
		knockback.setBackground(Color.GREEN);
		knockback.setBounds(200, 110, 200, 30);
		panel.add(knockback);
		knockback.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_knockback.setText("Explosionsrückstoß: " + slider.getValue()/10);
	        }
		});
		
		//Damage
		JLabel text_damage = new JLabel("Explosionschaden:");
		text_damage.setBounds(10, 160, 150, 30);
		panel.add(text_damage);
		damage = new JSlider(0,200);
		damage.setBackground(Color.GREEN);
		damage.setBounds(200, 160, 200, 30);
		panel.add(damage);
		damage.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_damage.setText("Explosionschaden: " + slider.getValue()/10);
	        }
		});
		
		//out of ammo
		shooter = new JGunSound("Explosion");
		shooter.setBounds(10, 210, 400, 300);
		shooter.setBackground(Color.GREEN);
		panel.add(shooter);
		
		return panel;
	}

	@Override
	public boolean isEverythingFilledOut() {
		return false;
	}

}
