//practical 9

import java.awt.*;
import java.awt.event.*;

class MyFrame extends WindowAdapter{

	MyFrame() {

		Label label = new Label("Hello!!");
		label.setBounds(210, 230, 200, 30);
		label.setFont(new Font(null, Font.BOLD, 25));

		Frame frame = new Frame();
		frame.setSize(500, 500);
		frame.setTitle("Frame");
		frame.add(label);
		frame.setLayout(null);
        frame.addWindowListener(this);
        frame.setBackground(Color.pink);
        frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		Frame frame = (Frame)e.getSource();
		frame.dispose();
	}
}