package view;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ErrorFrame extends JFrame{
	
	public ErrorFrame() {
				
		setSize(400, 200);
		setVisible(true);
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
