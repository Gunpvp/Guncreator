package guncreator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	
	public static final int WIDTH = 1225;
	public static final int HEIGHT = 1015;
	
	/**
	 * @author bernh 
	 */
	public static void main(String[] args) {
		new Frame();
	}
	
	public Frame() {
		super.setTitle("Guncreator v1.0");
		super.setBounds(0, 0, WIDTH, HEIGHT);
		super.setResizable(false);
		super.setLocationRelativeTo(null);
		
		new MainPanel((JPanel) super.getContentPane());
		
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
