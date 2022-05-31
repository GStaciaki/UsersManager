package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import control.Register;

public class ListScreen extends JPanel implements VisualWindow {

	private FrameBase frameB;
	private JLabel textTop, textSort;
	private JButton btGoBack, btSortAge, btSortName, btSortCargo;
	private JTable table;
	private JScrollPane scrollPane;
	private final String colunas[] = { "ID:", "Nome:", "Idade:", "Cargo:", "CPF:" };
	private String dados[][] = {};

	public ListScreen(FrameBase frameB) {
		this.frameB = frameB;
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

		textSort = new JLabel("Listar Usuarios:");
		textSort.setBounds(50, 10, 175, 25);
		add(textSort);
		
		try {
			dados = Register.getListUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		table = new JTable(dados, colunas);
		add(createScrollPane());

		btSortAge = new JButton("Por Idade");
		btSortAge.setBounds(10, 50, 175, 25);
		add(btSortAge);

		btSortName = new JButton("Por Nome");
		btSortName.setBounds(10, 90, 175, 25);
		add(btSortName);

		btSortCargo = new JButton("Por Cargo");
		btSortCargo.setBounds(10, 130, 175, 25);
		add(btSortCargo);

		btGoBack = new JButton("Voltar");
		btGoBack.setBounds(50, 500, 200, 30);
		add(btGoBack);
	}

	@Override
	public void setEvents() {

		btSortAge.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dados = Register.getUsersByAge();
					table = new JTable(dados, colunas);
					add(createScrollPane());

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		btSortName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dados = Register.getUsersByName();
					table = new JTable(dados, colunas);
					add(createScrollPane());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btSortCargo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dados = Register.getUsersByCargo();
					table = new JTable(dados, colunas);
					add(createScrollPane());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btGoBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frameB.activateInitialScreen();
			}
		});
	}
	
	public JScrollPane createScrollPane() {
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(200, 50, 425, 400);
		
		return scrollPane;
	}

}
