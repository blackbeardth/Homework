//practical 8

import java.awt.*;
import java.awt.event.*;

class MyFrame extends Frame implements MouseListener {

	MyFrame() {

		Label label = new Label("Mouse Listener");
		label.setBounds(170, 210, 200, 30);
		label.setFont(new Font(null, Font.PLAIN, 25));

		this.setSize(500, 500);
		this.setTitle("Frame");
		this.addMouseListener(this);
		this.add(label);
		this.setLayout(null);
        this.addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowClosing(WindowEvent e) {
				Frame frame = (Frame)e.getSource();
				frame.dispose();
			}
		});
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse was clicked");
	}
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Mouse was pressed");
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Mouse was released");
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Mouse was entered");
	}
	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Mouse was exited");
	}
}