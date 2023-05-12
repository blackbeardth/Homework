//practical 13*9

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyFrame extends JFrame 
{
	MyFrame() {

		JLabel label = new JLabel("Hello!");
		label.setBounds(210, 210, 100, 30);
		label.setFont(new Font("Consolas", Font.PLAIN, 25));
		label.setForeground(Color.red);

		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.pink);
		this.setLocationRelativeTo(null);
		this.add(label);
		this.setVisible(true);
	}
}