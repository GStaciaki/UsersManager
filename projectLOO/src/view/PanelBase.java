package view;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class PanelBase extends JPanel implements VisualWindow {

	private FrameBase frameB;
	private InitialScreen initialJP;
	private SecondScreen secondJP;
	private ThirdScreen thirdJP;
	private RemoveScreen removeJP;

	public PanelBase(FrameBase frameB) {
		this.frameB = frameB;
		setLayouts();
		setComponents();
		setEvents();

	}

	@Override
	public void setLayouts() {
		setLayout(new CardLayout());
		setBackground(Color.GRAY);
		setVisible(true);

	}

	@Override
	public void setComponents() {
		initialJP = new InitialScreen(frameB);
		secondJP = new SecondScreen(frameB);
		thirdJP = new ThirdScreen(frameB);
		removeJP = new RemoveScreen(frameB);
		
		add(initialJP, "initial");
		add(secondJP, "second");
		add(thirdJP, "third");
		add(removeJP, "remove");
	}

	@Override
	public void setEvents() {
		// TODO Auto-generated method stub

	}

}
