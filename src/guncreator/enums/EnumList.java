package guncreator.enums;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import guncreator.MainPanel;

public abstract class EnumList extends JPanel {
	
	private JList<?> list;
	private static int count = 0;

	public EnumList() {
		
		super(new BorderLayout());
		super.setBounds(600+310*count++, 0, 310, 900);
		
		list = new JList<>(getListData());
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(5);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				JList<?> list = (JList<?>) e.getSource();
				String copy = list.getModel().getElementAt(e.getFirstIndex()).toString();
				
				MainPanel.setInfoText("Copied: " + copy);
				StringSelection selection = new StringSelection(copy);
			    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			    clipboard.setContents(selection, selection);
			}
		});
		
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(250, 80));
		super.setBackground(Color.red);
		super.add(listScroller);
		
	}
	
	protected abstract Object[] getListData();
	
}
