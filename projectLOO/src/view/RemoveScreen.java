package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import control.Register;

public class RemoveScreen extends JPanel implements VisualWindow {

	private FrameBase frameb;
	private JLabel textTop, textRemove;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField tfIdRemove;
	private JButton btGoBack, btRemove;
	private final String colunas[] = { "ID:", "Nome:", "Idade:", "Cargo:", "CPF:" };
	private String dados[][] = {};

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
	}

	@Override
	public void setComponents() {

		textTop = new JLabel("LISTA DE USUARIOS");
		textTop.setBounds(350, 10, 200, 30);
		add(textTop);

		try {
			dados = Register.getListUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		table = new JTable(dados, colunas);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(200, 50, 425, 400);
		add(scrollPane);

		textRemove = new JLabel("ID Usuario: ");
		textRemove.setBounds(10, 100, 175, 25);
		add(textRemove);

		tfIdRemove = new JTextField();
		tfIdRemove.setBounds(75, 100, 25, 25);
		add(tfIdRemove);

		btRemove = new JButton("Remover Usuario");
		btRemove.setBounds(10, 150, 175, 25);
		add(btRemove);

		btGoBack = new JButton("Voltar");
		btGoBack.setBounds(50, 500, 200, 30);
		add(btGoBack);
	}

	@Override
	public void setEvents() {

		btRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					int idUser = Integer.parseInt(tfIdRemove.getText());

					Register.removeUser(idUser);
				} catch (SQLException | NumberFormatException e1) {
					return;
				}
				try {
					dados = Register.getListUsers();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				frameb.activateInitialScreen();
			}
		});
		btGoBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frameb.activateInitialScreen();
			}
		});
	}

}
