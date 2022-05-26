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
import model.Pessoa;

public class UpdateScreen extends JPanel implements VisualWindow {

	private FrameBase frameb;
	private JLabel textTop, textId, textName, textAge, textCpf;
	private JTextArea taList;
	private JTextField tfSetId, tfName, tfAge, tfCpf;
	private JButton btSubmit, btGoBack, btSelect, btUpdate;

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
		setBackground(Color.GRAY);

	}

	@Override
	public void setComponents() {
		textTop = new JLabel("LISTA DE USUARIOS");
		textTop.setBounds(350, 10, 200, 30);
		add(textTop);

		taList = new JTextArea();
		taList.setEditable(false);
		taList.setBounds(200, 50, 425, 250);
		add(taList);

		btSubmit = new JButton("Listar Usuarios");
		btSubmit.setBounds(10, 10, 175, 25);
		add(btSubmit);

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

		btGoBack = frameb.getButtonGoBack4();
		btGoBack.setBounds(50, 500, 200, 30);
		add(btGoBack);

		btUpdate = frameb.getButtonUpdateAndClose();
		btUpdate.setBounds(500, 500, 200, 30);

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

		btSelect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				add(textName);
				add(tfName);
				add(textAge);
				add(tfAge);
				add(textCpf);
				add(tfCpf);
				add(btUpdate);
				frameb.repaint();

				Integer id = Integer.parseInt(tfSetId.getText());
				Pessoa pessoa;

				try {
					pessoa = Register.getUser(id);
					tfName.setText(pessoa.getNome());
					tfAge.setText(Integer.toString(pessoa.getIdade()));
					tfCpf.setText(pessoa.getCpf());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				remove(textName);
				remove(tfName);
				remove(textAge);
				remove(tfAge);
				remove(textCpf);
				remove(tfCpf);
				remove(btUpdate);
				
			}
		});

	}

}
