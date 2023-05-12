//Practical 12

import java.awt.event.*;
import java.awt.*;

class MyFrame extends Frame implements ActionListener {

	Button button1;
	Button button2;
	Label nameLabel;
	Label courseLabel;
	Label rollNoLabel;
	Label collegeLabel;
	Label cgpaLabel;

	MyFrame(String name, String course, int rollNo, String college, double cgpa) {

		Frame frame = new Frame();

		button1 = new Button("A");
		button2 = new Button("B");

		button1.setFocusable(false);
		button2.setFocusable(false);

		button1.setBounds(150, 80, 100, 50);
		button2.setBounds(260, 80, 100, 50);

		button1.setFont(new Font(null,Font.PLAIN,20));
		button2.setFont(new Font(null,Font.PLAIN,20));

		button1.addActionListener(this);
		button2.addActionListener(this);

		nameLabel = new Label("Name: " + name);
		courseLabel = new Label("Course: " + course);
		rollNoLabel = new Label("Roll no: " + rollNo);
		collegeLabel = new Label("College: " + college);

		cgpaLabel = new Label("CGPA: " + cgpa);

		nameLabel.setFont(new Font(null, Font.PLAIN, 20));
		courseLabel.setFont(new Font(null, Font.PLAIN, 20));
		rollNoLabel.setFont(new Font(null, Font.PLAIN, 20));
		collegeLabel.setFont(new Font(null, Font.PLAIN, 20));
		cgpaLabel.setFont(new Font(null, Font.PLAIN, 20));

		nameLabel.setBounds(200, 150, 200, 30);
		courseLabel.setBounds(200, 180, 200, 30);
		rollNoLabel.setBounds(200, 210, 200, 30);
		collegeLabel.setBounds(200, 240, 200, 30);
		cgpaLabel.setBounds(200, 280, 100, 30);

		nameLabel.setVisible(false);
		courseLabel.setVisible(false);
		rollNoLabel.setVisible(false);
		collegeLabel.setVisible(false);
		cgpaLabel.setVisible(false);

		this.setSize(500, 500);
		this.add(button1);
		this.add(button2);
		this.add(nameLabel);
		this.add(courseLabel);
		this.add(rollNoLabel);
		this.add(collegeLabel);
		this.add(cgpaLabel);
		this.setBackground(Color.lightGray);
		this.setLayout(null);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Frame frame = (Frame)e.getSource();
				frame.dispose();
			}
		});
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1){
			nameLabel.setVisible(true);
			courseLabel.setVisible(true);
			rollNoLabel.setVisible(true);
			collegeLabel.setVisible(true);
		}
		else if (e.getSource() == button2)
			cgpaLabel.setVisible(true);
	}
}