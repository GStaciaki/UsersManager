package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import control.Register;

public class ThirdScreen extends JPanel implements VisualWindow {

	private FrameBase frameB;
	private JLabel textTop;
	private JTextArea taList;
	private JButton btSubmit, btGoBack;

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
		textTop.setBounds(300, 10, 200, 30);
		add(textTop);
		
		taList = new JTextArea();
		taList.setEditable(false);
		taList.setBounds(175, 50, 400, 400);
		add(taList);

		btSubmit = new JButton("Listar Usuarios");
		btSubmit.setBounds(10, 10, 175, 25);
		add(btSubmit);
		
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
				taList.append(Register.getListStudent());
				
			}
		});

	}

}
