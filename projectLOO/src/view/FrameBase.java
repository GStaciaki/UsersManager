package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class FrameBase extends JFrame implements VisualWindow {

	public CardLayout cl;
	private PanelBase baseJP;

	public FrameBase() {
		setLayouts();
		setComponents();
		setEvents();
		validate();
	}

	@Override
	public void setLayouts() {
		setSize(800, 600);
		setVisible(true);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	@Override
	public void setComponents() {

		baseJP = new PanelBase(this);
		cl = new CardLayout();
		cl = (CardLayout) baseJP.getLayout();

		add(baseJP, BorderLayout.CENTER);

	}

	@Override
	public void setEvents() {

	}

	public void activateInitialScreen() {
		cl.show(baseJP, "initial");
	}

	public void activateSecondScreen() {
		cl.show(baseJP, "second");
	}

	public void activateThirdScreen() {
		cl.show(baseJP, "third");
	}

	public void activateRemoveScreen() {
		cl.show(baseJP, "remove");
	}

	public void activateUpdateScreen() {
		cl.show(baseJP, "update");
	}

}