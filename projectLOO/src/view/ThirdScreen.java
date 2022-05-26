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
	private JLabel textTop, textSort;
	private JTextArea taList;
	private JButton btGoBack, btSortAge, btSortName, btSortCargo;

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

		textSort = new JLabel("Listar Usuarios:");
		textSort.setBounds(50, 10, 175, 25);
		add(textSort);

		btSortAge = new JButton("Por Idade");
		btSortAge.setBounds(10, 50, 175, 25);
		add(btSortAge);

		btSortName = new JButton("Por Nome");
		btSortName.setBounds(10, 90, 175, 25);
		add(btSortName);

		btSortCargo = new JButton("Por Cargo");
		btSortCargo.setBounds(10, 130, 175, 25);
		add(btSortCargo);

		btGoBack = frameB.getButtonGoBack2();
		btGoBack.setBounds(50, 500, 200, 30);
		add(btGoBack);
	}

	@Override
	public void setEvents() {
		
		btSortAge.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				taList.setText("");
				try {
					taList.append(Register.getUsersByAge());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		btSortName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				taList.setText("");
				try {
					taList.append(Register.getUsersByName());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btSortCargo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				taList.setText("");
				try {
					taList.append(Register.getUsersByCargo());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});

	}

}
