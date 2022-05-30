package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import control.Register;
import model.Cargos;
import model.Estudante;
import model.InvalidDataException;
import model.Pessoa;
import model.Professor;
import model.TecnicoLab;

public class RegistrationScreen extends JPanel implements VisualWindow {

	private FrameBase frameb;
	private JButton btSubmit, btGoBack;
	private JTextField tfInputName, tfInputAge, tfInputCpf;
	private Cargos[] values = Cargos.values();
	private DefaultComboBoxModel<Cargos> optionsCargo;
	private JComboBox<Cargos> tfInputCargo;
	private JLabel textTop, textName, textAge, textCargo, textCpf;

	public RegistrationScreen(FrameBase frameb) {
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

		textTop = new JLabel("CADASTRO DE USUARIOS");
		textName = new JLabel("NOME:");
		tfInputName = new JTextField();
		textAge = new JLabel("IDADE:");
		tfInputAge = new JTextField();
		textCpf = new JLabel("CPF:");
		tfInputCpf = new JTextField();
		textCargo = new JLabel("CARGO:");
		optionsCargo = new DefaultComboBoxModel<Cargos>(values);
		tfInputCargo = new JComboBox<Cargos>(optionsCargo);
		btSubmit = new JButton("CADASTRAR");
		btGoBack = new JButton("Voltar");

		textTop.setBounds(300, 10, 200, 30);
		textName.setBounds(50, 100, 200, 30);
		tfInputName.setBounds(150, 100, 200, 30);
		textAge.setBounds(50, 150, 200, 30);
		tfInputAge.setBounds(150, 150, 200, 30);
		textCpf.setBounds(50, 200, 200, 30);
		tfInputCpf.setBounds(150, 200, 200, 30);
		textCargo.setBounds(50, 250, 200, 30);
		tfInputCargo.setBounds(150, 250, 200, 30);
		btSubmit.setBounds(500, 500, 200, 30);
		btGoBack.setBounds(50, 500, 200, 30);

		add(textTop);
		add(textName);
		add(tfInputName);
		add(textAge);
		add(tfInputAge);
		add(textCpf);
		add(tfInputCpf);
		add(textCargo);
		add(tfInputCargo);
		add(btSubmit);
		add(btGoBack);
	}

	@Override
	public void setEvents() {
		btSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String name, CPF;
				int age;
				Pessoa pessoa;
				try {
					name = tfInputName.getText();
					age = Integer.parseInt(tfInputAge.getText());
					CPF = tfInputCpf.getText();
				} catch (IllegalArgumentException e) {
					JFrame errorFrame = new JFrame();
					errorFrame.setSize(400, 200);
					errorFrame.setVisible(true);
					errorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
					try {
						Thread.sleep(5000);
						errorFrame.setVisible(false);
						frameb.activateInitialScreen();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					return;
				}
				Cargos cargo = (Cargos) tfInputCargo.getSelectedItem();
				switch (cargo) {

				case ESTUDANTE:
					pessoa = new Estudante();
					break;
				case PROFESSOR:
					pessoa = new Professor();
					break;
				case TECLAB:
					pessoa = new TecnicoLab();
					break;
				default:
					pessoa = Register.getPessoaInstance();
				}

				pessoa.setNome(name);
				pessoa.setIdade(age);
				pessoa.setCpf(CPF);
				if (CPF.length() != 11) {
					throw new InvalidDataException("CPF Invalido");
				}

				try {
					Register.pessoaRegister(pessoa);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				tfInputName.setText("");
				tfInputAge.setText("");
				tfInputCpf.setText("");
				
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
