package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Register;
import model.Estudante;
import model.Pessoa;
import model.Professor;
import model.TecnicoLab;

public class SecondScreen extends JPanel implements VisualWindow {

	private FrameBase frameb;
	private JButton btSubmit, btGoBack;
	private JTextField tfInputName, tfInputAge, tfInputCpf;
	private String[] l = { "Estudante", "Professor", "TecnicoLab" };
	private DefaultComboBoxModel<String> optionsCargo;
	private JComboBox<String> tfInputCargo;
	private JLabel textTop, textName, textAge, textCargo, textCpf;

	public SecondScreen(FrameBase frameb) {
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

		textTop = new JLabel("CADASTRO DE USUARIOS");
		textTop.setBounds(300, 10, 200, 30);
		add(textTop);

		textName = new JLabel("NOME:");
		textName.setBounds(50, 100, 200, 30);
		add(textName);

		tfInputName = new JTextField();
		tfInputName.setBounds(150, 100, 200, 30);
		add(tfInputName);

		textAge = new JLabel("IDADE:");
		textAge.setBounds(50, 150, 200, 30);
		add(textAge);

		tfInputAge = new JTextField();
		tfInputAge.setBounds(150, 150, 200, 30);
		add(tfInputAge);

		textCpf = new JLabel("CPF:");
		textCpf.setBounds(50, 200, 200, 30);
		add(textCpf);

		tfInputCpf = new JTextField();
		tfInputCpf.setBounds(150, 200, 200, 30);
		add(tfInputCpf);

		textCargo = new JLabel("CARGO:");
		textCargo.setBounds(50, 250, 200, 30);
		add(textCargo);

		optionsCargo = new DefaultComboBoxModel<String>(l);
		tfInputCargo = new JComboBox<String>(optionsCargo);
		tfInputCargo.setBounds(150, 250, 200, 30);
		add(tfInputCargo);

		btSubmit = frameb.getButtonSubmit();
		btSubmit.setBounds(500, 500, 200, 30);
		add(btSubmit);

		btGoBack = frameb.getButtonGoBack();
		btGoBack.setBounds(50, 500, 200, 30);
		add(btGoBack);

	}

	@Override
	public void setEvents() {
		btSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String name = tfInputName.getText();
				int age = Integer.parseInt(tfInputAge.getText());
				String CPF = tfInputCpf.getText();
				String cargo = (String) tfInputCargo.getSelectedItem();

				Pessoa pessoa = Register.getPessoaInstance();
				pessoa.setNome(name);
				pessoa.setIdade(age);
				pessoa.setCpf(CPF);

				switch (cargo) {

				case "Estudante":
					pessoa = new Estudante();
					break;
				case "Professor":
					pessoa = new Professor();
					break;
				case "TecnicoLab":
					pessoa = new TecnicoLab();
					break;
				}

				Register.pessoaRegister(pessoa);

				tfInputName.setText("");
				tfInputAge.setText("");
				tfInputCpf.setText("");
			}
		});

	}

}
