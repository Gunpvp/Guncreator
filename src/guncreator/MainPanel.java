package guncreator;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import guncreator.categories.AmmoCategory;
import guncreator.categories.BurstfireCategory;
import guncreator.categories.Category;
import guncreator.categories.EditPanel;
import guncreator.categories.EffectCategory;
import guncreator.categories.ExplosionCategory;
import guncreator.categories.HeadshotCategory;
import guncreator.categories.ItemCategory;
import guncreator.categories.ReloadCategory;
import guncreator.categories.ScopeCategory;
import guncreator.categories.ShootingCategory;
import guncreator.categories.SneakCategory;
import guncreator.parser.Parser;
import guns.weopons.data.GunData;

public class MainPanel {
	
	private JPanel panel;
	private EditPanel<? extends Serializable> before;
	private JPanel side_panel;
	private JPanel controll_panel;
	private List<Category<? extends Serializable>> categories = new ArrayList<>();
	
	private ItemCategory cat_item;
	private ShootingCategory cat_shoot;
	private ExplosionCategory cat_explosion;
	private HeadshotCategory cat_headshot;
	private ReloadCategory cat_reload;
	private SneakCategory cat_sneak;
	private BurstfireCategory cat_burstfire;
	private AmmoCategory cat_ammo;
	private ScopeCategory cat_scope;
	private EffectCategory cat_effect;

	private JTextField name_of_gun;
	
	public MainPanel(JPanel panel) {
		this.panel = panel;
		this.init();
	}
	
	public void init() {
		
		panel.setBackground(Color.GREEN);
		panel.setLayout(null);
		
		/**
		 * create panels
		 */
		side_panel = new JPanel();
		side_panel.setBackground(Color.DARK_GRAY);
		side_panel.setLayout(new FlowLayout());
		
		controll_panel = new JPanel();
		controll_panel.setBackground(Color.WHITE);
		controll_panel.setLayout(new FlowLayout());

		side_panel.setBounds(0, 0, 150, 850);
		panel.add(side_panel);

		controll_panel.setBounds(0, 850, 600, 100);
		panel.add(controll_panel);
		
		/**
		 * fill controll panel with stuff
		 */
		name_of_gun = new JTextField("NAME OF GUN");
		controll_panel.add(name_of_gun);
		
		JButton save = new JButton("SAVE");
		
		save.addActionListener(e -> {
			
			GunData data = generateGunData();
			if (data != null) Parser.saveToFile(new File("weapons/" + data.getName() + ".weapon"), data);
			
		});
		
		controll_panel.add(save);
		
		JButton load = new JButton("LOAD");
		
		load.addActionListener(e -> {
			
			fillWithContent(Parser.loadFromFile(new File("weapons/" + name_of_gun.getText() + ".weapon")));
			
		});
		
		controll_panel.add(load);
		
		/**
		 * add categories
		 */
		cat_item = new ItemCategory();
		categories.add(cat_item);
		
		cat_shoot = new ShootingCategory();
		categories.add(cat_shoot);
		
		cat_explosion = new ExplosionCategory();
		categories.add(cat_explosion);
		
		cat_headshot = new HeadshotCategory();
		categories.add(cat_headshot);
		
		cat_reload = new ReloadCategory();
		categories.add(cat_reload);
		
		cat_sneak = new SneakCategory();
		categories.add(cat_sneak);

		cat_burstfire = new BurstfireCategory();
		categories.add(cat_burstfire);
		
		cat_ammo = new AmmoCategory();
		categories.add(cat_ammo);
		
		cat_scope = new ScopeCategory();
		categories.add(cat_scope);
		
		for (Category<? extends Serializable> category : categories) {
			JButton button = new JButton(category.getName());
			button.setBackground(Color.LIGHT_GRAY);
			button.setForeground(Color.BLACK);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (before != null) panel.remove(before);
					category.getEditPanel().setBounds(150,0,450,850);
					panel.add(category.getEditPanel());
					panel.validate();
					panel.repaint();
					before = category.getEditPanel();
				}
			});
			side_panel.add(button);
		}
		
	}
	
	/**
	 * 
	 * generates gun data from fields
	 * 
	 * @return generated gun data
	 */
	private GunData generateGunData() {
		
		if (!name_of_gun.getText().isEmpty()) {
			
			boolean valid = true;
			
			for (Category<? extends Serializable> cat : categories) {
				if (!cat.isEverythingFilledOut()) valid = false;
			}
			
			if (valid) {
				
				return new GunData(name_of_gun.getText(),
						cat_item.getEditPanel().getData(), 
						cat_shoot.getEditPanel().getData(),
						cat_reload.getEditPanel().getData(),
						cat_ammo.getEditPanel().getData(), 
						cat_sneak.getEditPanel().getData(), 
						cat_scope.getEditPanel().getData(), 
						cat_burstfire.getEditPanel().getData(),
						cat_headshot.getEditPanel().getData(),
						cat_explosion.getEditPanel().getData(),
						cat_effect.getEditPanel().getData());
				
			} else {
				JOptionPane.showMessageDialog(null, "Fülle zuerst alle Felder aus!");
			}
			
		}
		
		return null;
		
	}
	
	/**
	 * 
	 * init editpanels with data
	 * 
	 * @param data about gun
	 */
	private void fillWithContent(GunData data) {
		
		cat_item.getEditPanel().initWithData(data.getItemdata());
		cat_shoot.getEditPanel().initWithData(data.getShootdata());
		cat_reload.getEditPanel().initWithData(data.getReloaddata());
		cat_ammo.getEditPanel().initWithData(data.getAmmodata());
		cat_sneak.getEditPanel().initWithData(data.getSneakdata());
		cat_scope.getEditPanel().initWithData(data.getScopedata());
		cat_burstfire.getEditPanel().initWithData(data.getBurstfiredata());
		cat_headshot.getEditPanel().initWithData(data.getHeadshotdata());
		cat_explosion.getEditPanel().initWithData(data.getExplosion());
		cat_effect.getEditPanel().initWithData(data.getEffect());
		
	}
	
}
