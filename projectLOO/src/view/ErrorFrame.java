package view;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ErrorFrame extends JFrame implements VisualWindow {

	public ErrorFrame() {
		setSize(400, 200);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setComponents();
		setLocationRelativeTo(null);
	}

	@Override
	public void setLayouts() {

	}

	@Override
	public void setComponents() {

	}

	@Override
	public void setEvents() {
		// TODO Auto-generated method stub

	}
}
