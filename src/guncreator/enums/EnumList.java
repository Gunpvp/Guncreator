package guncreator.enums;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import org.bukkit.Material;

public class EnumList extends JPanel {
	
	private JList<Material> list;

	public EnumList(int x_offset) {
		
		super(new BorderLayout());
		super.setBounds(600+x_offset, 0, 200, 1015);
		
		list = new JList<Material>(Material.values());
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(5);
		
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(250, 80));
		super.setBackground(Color.red);
		super.add(listScroller);
		
	}
	
}
