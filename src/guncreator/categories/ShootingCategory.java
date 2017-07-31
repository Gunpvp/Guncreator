package guncreator.categories;

import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import guncreator.JGunSound;
import guns.weopons.data.ShootingData;

public class ShootingCategory extends Category<ShootingData> {

	private JSlider delay_between_shots; 
	private JSlider recoil; //float
	private JSlider projectiles;
	private JSlider damage; //float
	private JSlider speed;
	private JCheckBox drag_down;
	private JSlider drag_distance;
	private JSlider spread; //float
	private JGunSound shoot_sound;	
	
	public ShootingCategory() {
		super("SHOOTING");
	}

	@Override
	public EditPanel<ShootingData> createEditPanel() {
		
		EditPanel<ShootingData> panel = new EditPanel<ShootingData>() {
			
			@Override
			protected ShootingData generateData() {
				
				return new ShootingData(delay_between_shots.getValue(), recoil.getValue()/10, projectiles.getValue(), damage.getValue()/10, speed.getValue(), drag_down.isSelected(), drag_distance.getValue(), spread.getValue()/10, shoot_sound.getGunSound());
			}

			@Override
			public void initWithData(ShootingData data) {
				
				
				
			}
		};
		
		panel.setLayout(null);
		
		//shot delay
		JLabel text_delay_between_shots = new JLabel("Schussverzögerung:");
		text_delay_between_shots.setBounds(10, 10, 150, 30);
		panel.add(text_delay_between_shots);
		delay_between_shots = new JSlider(0,100);
		delay_between_shots.setBackground(Color.GREEN);
		delay_between_shots.setBounds(200, 10, 200, 30);
		panel.add(delay_between_shots);
		delay_between_shots.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_delay_between_shots.setText("Schussverzögerung: " + slider.getValue());
	        }
		});
		
		//recoil
		JLabel text_recoil = new JLabel("Rückstoß:");
		text_recoil.setBounds(10, 60, 150, 30);
		panel.add(text_recoil);
		recoil = new JSlider(0,20);
		recoil.setBackground(Color.GREEN);
		recoil.setBounds(200, 60, 200, 30);
		panel.add(recoil);
		recoil.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_recoil.setText("Rückstoß: " + slider.getValue()/10f);
	        }
		});
		
		//projectile amount
		JLabel text_projectiles = new JLabel("Projektilanzahl:");
		text_projectiles.setBounds(10, 110, 150, 30);
		panel.add(text_projectiles);
		projectiles = new JSlider(0,10);
		projectiles.setBackground(Color.GREEN);
		projectiles.setBounds(200, 110, 200, 30);
		panel.add(projectiles);
		projectiles.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_projectiles.setText("Projektilanzahl: " + slider.getValue());
	        }
		});
		
		//damage
		JLabel text_damage = new JLabel("Schaden:");
		text_damage.setBounds(10, 160, 150, 30);
		panel.add(text_damage);
		damage = new JSlider(0,300);
		damage.setBackground(Color.GREEN);
		damage.setBounds(200, 160, 200, 30);
		panel.add(damage);
		damage.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_damage.setText("Schaden: " + slider.getValue()/10f);
	        }
		});
		
		
		//projectile speed
		JLabel text_speed = new JLabel("Projektilgeschw.:");
		text_speed.setBounds(10, 210, 150, 30);
		panel.add(text_speed);
		speed = new JSlider(0,15);
		speed.setBackground(Color.GREEN);
		speed.setBounds(200, 210, 200, 30);
		panel.add(speed);
		speed.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_speed.setText("Projektilgeschw.: " + slider.getValue());
	        }
		});
		
		//drag down
		JLabel text_drag_down = new JLabel("Drag Down:");
		text_drag_down.setBounds(10, 260, 150, 30);
		panel.add(text_drag_down);
		drag_down = new JCheckBox();
		drag_down.setBackground(Color.GREEN);
		drag_down.setBounds(200, 260, 30, 30);
		panel.add(drag_down);
		
		//drag distance
		JLabel text_drag_distance = new JLabel("Drag Distance:");
		text_drag_distance.setBounds(10, 310, 150, 30);
		panel.add(text_drag_distance);
		drag_distance = new JSlider(0,20);
		drag_distance.setBackground(Color.GREEN);
		drag_distance.setBounds(200, 310, 200, 30);
		panel.add(drag_distance);
		drag_distance.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_drag_distance.setText("Drag Distance: " + slider.getValue());
	        }
		});
		
		//spread
		JLabel text_spread = new JLabel("Streuung:");
		text_spread.setBounds(10, 360, 150, 30);
		panel.add(text_spread);
		spread = new JSlider(0,20);
		spread.setBackground(Color.GREEN);
		spread.setBounds(200, 360, 200, 30);
		panel.add(spread);
		spread.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	            JSlider slider = (JSlider)ce.getSource();
	            text_spread.setText("Streuung: " + slider.getValue()/10f);
	        }
		});
		
		//Shooter Sound
		shoot_sound = new JGunSound("Schuss");
		shoot_sound.setBounds(10, 410, 400, 300);
		shoot_sound.setBackground(Color.GREEN);
		panel.add(shoot_sound);
		
		return panel;
	}

	@Override
	public boolean isEverythingFilledOut() {
		return shoot_sound.isDataValid();
	}

}
