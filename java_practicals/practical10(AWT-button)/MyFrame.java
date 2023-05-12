// Practical 10
import java.awt.event.*;
import java.awt.*;

class MyFrame extends Frame implements ActionListener {

	Button button1;
	Button button2;

	MyFrame() {

		button1 = new Button("Red");
		button2 = new Button("Blue");

		button1.setBounds(170, 220, 80, 50);
		button2.setBounds(260, 220, 80, 50);

		button1.setFocusable(false);
		button2.setFocusable(false);

		button1.setFont(new Font("Comic sans", Font.PLAIN, 25));
		button2.setFont(new Font("Comic sans", Font.PLAIN, 25));

		button1.addActionListener(this);
		button2.addActionListener(this);

		this.setSize(500, 500);
		this.add(button1);
		this.add(button2);
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

		if (e.getSource() == button1)
			this.setBackground(Color.red);
		else if (e.getSource() == button2)
			this.setBackground(Color.blue);
	}
}