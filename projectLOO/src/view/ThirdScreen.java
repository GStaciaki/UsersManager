package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import control.Register;

public class ThirdScreen extends JPanel implements VisualWindow {

	private FrameBase frameB;
	private JLabel textTop;
	private JTextArea taList;
	private JButton btSubmit, btGoBack, btRemove;

	public ThirdScreen(FrameBase frameB) {
		this.frameB = frameB;
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

		btRemove = new JButton("Remover Usuario");
		btRemove.setBounds(10, 50, 175, 25);
		add(btRemove);

		btGoBack = frameB.getButtonGoBack2();
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

	}

}
