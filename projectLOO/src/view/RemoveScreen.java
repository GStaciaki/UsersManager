package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import control.Register;

public class RemoveScreen extends JPanel implements VisualWindow {

	private FrameBase frameb;
	private JLabel textTop, textRemove;
	private JTextArea taList;
	private JTextField tfIdRemove;
	private JButton btSubmit, btGoBack, btRemove;

	public RemoveScreen(FrameBase frameb) {
		this.frameb = frameb;
		setLayouts();
		setComponents();
		setEvents();
	}

	@Override
	public void setLayouts() {
		setLayout(null);
		setVisible(true);
		setBackground(Color.GRAY);
	}

	@Override
	public void setComponents() {

		textTop = new JLabel("LISTA DE USUARIOS");
		textTop.setBounds(350, 10, 200, 30);
		add(textTop);

		taList = new JTextArea();
		taList.setEditable(false);
		taList.setBounds(200, 50, 425, 400);
		add(taList);

		btSubmit = new JButton("Listar Usuarios");
		btSubmit.setBounds(10, 10, 175, 25);
		add(btSubmit);

		textRemove = new JLabel("ID Usuario: ");
		textRemove.setBounds(10, 100, 175, 25);
		add(textRemove);

		tfIdRemove = new JTextField();
		tfIdRemove.setBounds(75, 100, 25, 25);
		add(tfIdRemove);

		btRemove = new JButton("Remover Usuario");
		btRemove.setBounds(10, 150, 175, 25);
		add(btRemove);

		btGoBack = frameb.getButtonGoBack2();
		btGoBack.setBounds(50, 500, 200, 30);
		add(btGoBack);
	}

	@Override
	public void setEvents() {

		btSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				taList.setText("");
				try {
					taList.append(Register.getListUsers());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		btRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int idUser = Integer.parseInt(tfIdRemove.getText());
				try {
					Register.removeUser(idUser);
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
	}

}
