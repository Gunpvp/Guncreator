package guncreator;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import guncreator.categories.Category;
import guncreator.categories.EditPanel;
import guncreator.categories.ExplosionCategory;
import guncreator.categories.ItemCategory;
import guncreator.categories.ShootCategory;

public class MainPanel {
	
	private static MainPanel instance;
	
	private JPanel panel;
	private EditPanel<? extends Serializable> before;
	private JPanel side_panel;
	private JPanel controll_panel;
	private List<Category<? extends Serializable>> categories = new ArrayList<>();
	
	private ItemCategory cat_item;
	private ShootCategory cat_shoot;
	private ExplosionCategory cat_explosion;
	
	public MainPanel(JPanel panel) {
		instance = this;
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

		side_panel.setBounds(0, 0, 150, 500);
		panel.add(side_panel);

		controll_panel.setBounds(0, 500, 600, 100);
		panel.add(controll_panel);
		
		/**
		 * fill controll panel with stuff
		 */
		JTextField field = new JTextField("NAME OF GUN");
		controll_panel.add(field);
		
		JButton save = new JButton("SAVE");
		controll_panel.add(save);
		JButton load = new JButton("LOAD");
		controll_panel.add(load);
		
		/**
		 * add categories
		 */
		cat_item = new ItemCategory();
		categories.add(cat_item);
		
		cat_shoot = new ShootCategory();
		categories.add(cat_shoot);
		
		cat_explosion = new ExplosionCategory();
		categories.add(cat_explosion);
		
		for (Category<? extends Serializable> category : categories) {
			JButton button = new JButton(category.getName());
			button.setBackground(Color.LIGHT_GRAY);
			button.setForeground(Color.BLACK);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (before != null) panel.remove(before);
					category.getEditPanel().setBounds(150,0,450,500);
					panel.add(category.getEditPanel());
					panel.validate();
					panel.repaint();
					before = category.getEditPanel();
				}
			});
			side_panel.add(button);
		}
		
	}
	
	public static MainPanel getInstance() {
		return instance;
	}
	
}
