package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class FrameBase extends JFrame implements VisualWindow {

	public CardLayout cl;
	private PanelBase baseJP;
	private JButton btList, btRegister, btGoBack, btGoBack2, btSubmit, btRemove;

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
		btList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				activateThirdScreen();

			}
		});
		btRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				activateSecondScreen();

			}
		});
		btGoBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				activateInitialScreen();

			}
		});
		btGoBack2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				activateInitialScreen();

			}
		});
		btSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				activateInitialScreen();

			}
		});
		btRemove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				activateRemoveScreen();				
			}
		});

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

	public JButton getButtonList() {
		btList = new JButton("Lista de Usuarios");
		return btList;
	}

	public JButton getButtonRegister() {
		btRegister = new JButton("Cadastrar Novo Usuario");
		return btRegister;
	}

	public JButton getButtonGoBack() {
		btGoBack = new JButton("Voltar");
		return btGoBack;
	}

	public JButton getButtonGoBack2() {
		btGoBack2 = new JButton("Voltar");
		return btGoBack2;
	}

	public JButton getButtonSubmit() {
		btSubmit = new JButton("CADASTRAR");
		return btSubmit;
	}
	
	public JButton getButtonRemove() {
		btRemove = new JButton("Remover Usuario");
		return btRemove;
	}
}