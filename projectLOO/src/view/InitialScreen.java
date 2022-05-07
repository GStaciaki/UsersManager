package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InitialScreen extends JPanel implements VisualWindow {

	private FrameBase frameb;
	private JButton btRegister, btList;

	public InitialScreen(FrameBase frameb) {
		this.frameb = frameb;
		setLayouts();
		setComponents();
		setEvents();

	}

	@Override
	public void setLayouts() {
		setLayout(null);
		setVisible(true);
		setBackground(Color.gray);

	}

	@Override
	public void setComponents() {

		btRegister = frameb.getButtonRegister();
		btRegister.setBounds(50, 300, 300, 50);
		add(btRegister);

		btList = frameb.getButtonList();
		btList.setBounds(400, 300, 300, 50);
		add(btList);
	}

	@Override
	public void setEvents() {

	}

}
