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
import model.Pessoa;

public class UpdateScreen extends JPanel implements VisualWindow {

	private FrameBase frameb;
	private JLabel textTop, textId, textName, textAge, textCpf;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField tfSetId, tfName, tfAge, tfCpf;
	private JButton btGoBack, btSelect, btUpdate;
	private final String colunas[] = { "ID:", "Nome:", "Idade:", "Cargo:", "CPF:" };
	private String dados[][] = {};

	public UpdateScreen(FrameBase frameb) {
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
		scrollPane.setBounds(200, 50, 425, 200);
		add(scrollPane);

		textId = new JLabel("ID Usuario: ");
		textId.setBounds(10, 100, 175, 25);
		add(textId);

		tfSetId = new JTextField();
		tfSetId.setBounds(75, 100, 25, 25);
		add(tfSetId);

		btSelect = new JButton("Selecionar Usuario");
		btSelect.setBounds(10, 150, 175, 25);
		add(btSelect);

		textName = new JLabel("Nome: ");
		textName.setBounds(10, 325, 175, 25);

		tfName = new JTextField();
		tfName.setBounds(50, 325, 175, 25);

		textAge = new JLabel("Idade: ");
		textAge.setBounds(250, 325, 175, 25);

		tfAge = new JTextField();
		tfAge.setBounds(300, 325, 175, 25);

		textCpf = new JLabel("CPF: ");
		textCpf.setBounds(500, 325, 175, 25);

		tfCpf = new JTextField();
		tfCpf.setBounds(550, 325, 175, 25);

		btGoBack = new JButton("Voltar");
		btGoBack.setBounds(50, 500, 200, 30);
		add(btGoBack);

		btUpdate = new JButton("Alterar");
		btUpdate.setBounds(500, 500, 200, 30);

	}

	@Override
	public void setEvents() {
		btSelect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int id;
				try {
					id = Integer.parseInt(tfSetId.getText());
				} catch (NumberFormatException ex) {
					return;
				}

				add(textName);
				add(tfName);
				add(textAge);
				add(tfAge);
				add(textCpf);
				add(tfCpf);
				add(btUpdate);
				frameb.repaint();

				Pessoa pessoa;

				try {
					pessoa = Register.getUser(id);
					tfName.setText(pessoa.getNome());
					tfAge.setText(Integer.toString(pessoa.getIdade()));
					tfCpf.setText(pessoa.getCpf());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		btUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Integer id = Integer.parseInt(tfSetId.getText());
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(tfName.getText());
				pessoa.setIdade(Integer.parseInt(tfAge.getText()));
				pessoa.setCpf(tfCpf.getText());
				try {
					Register.updateUser(pessoa, id);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				remove(textName);
				remove(tfName);
				remove(textAge);
				remove(tfAge);
				remove(textCpf);
				remove(tfCpf);
				remove(btUpdate);

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
