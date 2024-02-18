// WAP to implement Bresenham's circle drawing algorithm.

// Written by Chirag Wadhwa for the University of Delhi

import java.awt.*;
import javax.swing.*;


class BresenhamCircleDrawing extends JPanel {
	private int c_x, c_y, radius;

	BresenhamCircleDrawing(int c_x, int c_y, int radius) {
		this.c_x = c_x;
		this.c_y = c_y;
		this.radius = radius;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawCircleBresenham(g, c_x, c_y, radius);
	}

	private void drawCircleBresenham(Graphics g, int c_x, int c_y, int radius) {
		int x = 0;
		int y = radius;
		int d = 1 - radius;
		drawCirclePoints(g, x, y, c_x, c_y);
		while (y > x) {
			if (d < 0) {
				d += 2 * x + 3;
				x += 1;
			} else {
				d += 2 * (x - y) + 5;
				x += 1;
				y -= 1;
			}
			drawCirclePoints(g, x, y, c_x, c_y);
		}
	}

	private void drawCirclePoints(Graphics g, int x, int y, int c_x, int c_y) {
		g.setColor(Color.RED);
		g.drawLine(Math.round(c_x + x), Math.round(c_y + y),
		           Math.round(c_x + x), Math.round(c_y + y));
		g.drawLine(Math.round(c_x + y), Math.round(c_y + x),
		           Math.round(c_x + y), Math.round(c_y + x));
		g.drawLine(Math.round(c_x + y), Math.round(c_y + -x),
		           Math.round(c_x + y), Math.round(c_y + -x));
		g.drawLine(Math.round(c_x + x), Math.round(c_y + -y),
		           Math.round(c_x + x), Math.round(c_y + -y));
		g.drawLine(Math.round(c_x + -x), Math.round(c_y + -y),
		           Math.round(c_x + -x), Math.round(c_y + -y));
		g.drawLine(Math.round(c_x + -y), Math.round(c_y + -x),
		           Math.round(c_x + -y), Math.round(c_y + -x));
		g.drawLine(Math.round(c_x + -y), Math.round(c_y + x),
		           Math.round(c_x + -y), Math.round(c_y + x));
		g.drawLine(Math.round(c_x + -x), Math.round(c_y + y),
		           Math.round(c_x + -x), Math.round(c_y + y));
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Bresenham Circle Drawing Algorithm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);

		int x = 150, y = 150, radius = 100; // center and radius for the circle

		BresenhamCircleDrawing panel = new BresenhamCircleDrawing(x, y, radius);
		frame.add(panel);

		frame.setVisible(true);
	}
}