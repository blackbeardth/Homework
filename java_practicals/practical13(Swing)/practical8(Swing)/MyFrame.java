//Practical 13*8

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyFrame extends JFrame implements MouseListener {

	MyFrame() {

		JLabel label = new JLabel("Mouse Listener");
		label.setFont(new Font("Consolas", Font.BOLD, 20));

		this.setSize(500, 500);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseListener(this);
		this.add(label);
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//mouseClicked = Invoked when the mouse is clicked(pressed and released) on a component
		System.out.println("You clicked the mouse");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//keyPressed = Invoked when a mouse button has been pressed on a component
		System.out.println("You pressed the mouse");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//keyReleased = Invoked when a mouse button has been released on a component
		System.out.println("You released the mouse");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//mouseEntered = called whenever a button is released
		System.out.println("You entered the mouse");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//mouseExited = called whenever a button is released
		System.out.println("You exited the mouse");
	}
}