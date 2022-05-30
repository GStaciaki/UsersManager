package view;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class PanelBase extends JPanel implements VisualWindow {

	private FrameBase frameB;
	private InitialScreen initialJP;
	private RegistrationScreen secondJP;
	private ListScreen thirdJP;
	private RemoveScreen removeJP;
	private UpdateScreen updateJP;

	public PanelBase(FrameBase frameB) {
		this.frameB = frameB;
		setLayouts();
		setComponents();
		setEvents();

	}

	@Override
	public void setLayouts() {
		setLayout(new CardLayout());
		setVisible(true);

	}

	@Override
	public void setComponents() {
		initialJP = new InitialScreen(frameB);
		secondJP = new RegistrationScreen(frameB);
		thirdJP = new ListScreen(frameB);
		removeJP = new RemoveScreen(frameB);
		updateJP = new UpdateScreen(frameB);

		add(initialJP, "initial");
		add(secondJP, "second");
		add(thirdJP, "third");
		add(removeJP, "remove");
		add(updateJP, "update");
	}

	@Override
	public void setEvents() {
		// TODO Auto-generated method stub

	}

}
