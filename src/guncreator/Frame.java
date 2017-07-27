package guncreator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	
	/**
	 * @author bernh 
	 */
	public static void main(String[] args) {
		new Frame();
	}
	
	public Frame() {
		super.setTitle("Guncreator v1.0");
		super.setBounds(0, 0, 600, 600);
		super.setResizable(false);
		super.setLocationRelativeTo(null);
		
		new MainPanel((JPanel) super.getContentPane());
		
		super.setVisible(true);
	}
	
}
