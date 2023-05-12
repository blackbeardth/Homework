// Practical 13*11

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class MyFrame extends KeyAdapter {

	JLabel label;
	JLabel label1;

	MyFrame() {

		label1 = new JLabel("Type any character key");
		label1.setBounds(150, 200, 400, 30);
		label1.setFont(new Font("Comic sans", Font.PLAIN, 20));

		label = new JLabel();
		label.setBounds(150, 200, 400, 30);
		label.setFont(new Font("Comic sans", Font.PLAIN, 20));

		JFrame frame = new JFrame();
		frame.addKeyListener(this);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.add(label1);
		frame.add(label);
		frame.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		label1.setVisible(false);
		label.setText("Typed character is: " + e.getKeyChar());
	}
}