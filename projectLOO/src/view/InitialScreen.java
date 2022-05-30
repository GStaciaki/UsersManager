package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InitialScreen extends JPanel implements VisualWindow {

	private FrameBase frameb;
	private JButton btRegister, btList, btRemove, btUpdate;

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
	}

	@Override
	public void setComponents() {

		btRegister = new JButton("Cadastrar Novo Usuario");
		btRegister.setBounds(50, 300, 300, 50);
		add(btRegister);

		btList = new JButton("Lista de Usuarios");
		btList.setBounds(400, 300, 300, 50);
		add(btList);

		btRemove = new JButton("Remover Usuario");
		btRemove.setBounds(50, 375, 300, 50);
		add(btRemove);

		btUpdate = new JButton("Alterar Usuario");
		btUpdate.setBounds(400, 375, 300, 50);
		add(btUpdate);
	}

	@Override
	public void setEvents() {

		btRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frameb.activateSecondScreen();
			}
		});
		btList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frameb.activateThirdScreen();
			}
		});
		btRemove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frameb.activateRemoveScreen();
			}
		});
		btUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frameb.activateUpdateScreen();
			}
		});
	}

}
