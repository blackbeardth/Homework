import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.Label;
import java.awt.Frame;
import java.awt.Button;

class MyFrame extends Frame implements ActionListener {


	Label label1;
	Label label2;
	Button button1;
	Button button2;

	MyFrame() {

		label1 = new Label("Yes");
		label1.setBounds(250, 340, 100, 25);
		label1.setVisible(false);

		label2 = new Label("Yes");
		label2.setBounds(250, 340, 100, 25);
		label2.setVisible(false);

		Button button1 = new Button("Yes");
		button1.setBounds(150, 240, 75, 25);

		Button button2 = new Button("No");
		button2.setBounds(250, 240, 75, 25);

		this.setSize(500, 500);
		this.setVisible(true);
		this.setLayout(null);
		this.add(label1);
		this.add(label2);
		this.add(button1);
		this.add(button2);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Frame frame = (Frame)e.getSource();
				frame.dispose();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			label1.setVisible(true);
			label2.setVisible(false);
		} else if (e.getSource() == button2)
			label2.setVisible(true);
			label1.setVisible(false);
	}
}


class Main {
	public static void main(String ...args) {
		new MyFrame();
	}
}
