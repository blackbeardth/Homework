// Practical 13*10

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {

	JButton button1;
	JButton button2;

	MyFrame() {

		button1 = new JButton("Red");//red
		button2 = new JButton("Blue");//blue

		button1.setFocusable(false);
		button2.setFocusable(false);

		button1.setBounds(140, 150, 100, 50);
		button2.setBounds(260, 150, 100, 50);

		button1.addActionListener(this);
		button2.addActionListener(this);

		button1.setBackground(Color.black);
		button2.setBackground(Color.black);

		button1.setForeground(Color.white);
		button2.setForeground(Color.white);


		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.add(button1);
		this.add(button2);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			this.getContentPane().setBackground(Color.RED);
		} else if (e.getSource() == button2) {
			this.getContentPane().setBackground(Color.BLUE);
		}
	}
}