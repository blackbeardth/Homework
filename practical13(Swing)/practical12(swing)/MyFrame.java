// Practical 13*12

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {

	JButton button1;
	JButton button2;
	JLabel infoLabel;
	JLabel cgpaLabel;

	MyFrame(String name, String course, int rollNo, String college, double cgpa) {

		button1 = new JButton("A"); //display personal info
		button2 = new JButton("B"); //dispaly CGPA

		button1.setFocusable(false);
		button2.setFocusable(false);

		button1.setBounds(150, 50, 100, 50);
		button2.setBounds(260, 50, 100, 50);

		button1.addActionListener(this);
		button2.addActionListener(this);

		infoLabel = new JLabel();
		cgpaLabel = new JLabel();

		infoLabel.setText("<html>Name: " + name + "<br/>" +
		                  "Course: " + course + "<br/>" +
		                  "roll No: " + rollNo + "<br/>" +
		                  "College: " + college + "</html>");
		cgpaLabel.setText("CGPA: " + cgpa);

		infoLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
		cgpaLabel.setFont(new Font("Consolas", Font.PLAIN, 20));

		infoLabel.setBounds(180, 200, 300, 100);
		cgpaLabel.setBounds(180, 300, 100, 100);

		infoLabel.setVisible(false);
		cgpaLabel.setVisible(false);

		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.add(button1);
		this.add(button2);
		this.add(infoLabel);
		this.add(cgpaLabel);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) 
			infoLabel.setVisible(true);
		else if (e.getSource() == button2) 
			cgpaLabel.setVisible(true);
	}
}