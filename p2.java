// WAP to implement the Bresenham's line drawing algorithm.

// Written by Chirag Wadhwa for the University of Delhi

import javax.swing.*;
import java.awt.*;

class BresenhamLineDrawing extends JPanel {
	private int x1, y1, x2, y2;

	BresenhamLineDrawing(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawLineBresenham(g, x1, y1, x2, y2);
	}

	private void drawLineBresenham(Graphics g, int x1, int y1, int x2, int y2) {

		int dx = x2 - x1;
		int dy = y2 - y1;

		float slope = (float)dy / (float)dx;

		if (slope >= 1 || slope <= 0) {
			System.out.println("Error: Slope must be between 0 and 1.");
			return;
		}

		int d = 2 * dy - dx;
		int del_E = 2 * dy;
		int del_NE = 2 * (dy - dx);

		int x = x1;
		int y = y1;

		g.setColor(Color.RED);
		g.drawLine(Math.round(x), Math.round(y), Math.round(x),
		           Math.round(y));

		while (x < x2) {
			if (d <= 0) {
				d += del_E;
				x += 1;
			} else {
				d += del_NE;
				x += 1;
				y += 1;
			}
			g.drawLine(Math.round(x), Math.round(y),
			           Math.round(x), Math.round(y));
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Bresenham Line Drawing Algorithm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);

		int x1 = 100, y1 = 100, x2 = 350, y2 = 200; // Coordinates of line endpoints

		BresenhamLineDrawing panel = new BresenhamLineDrawing(x1, y1, x2, y2);
		frame.add(panel);

		frame.setVisible(true);
	}
}