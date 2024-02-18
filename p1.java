// WAP to implement and draw a line using
// Digital Differential Analyzer(DDA) algorithm.

// Written by Chirag Wadhwa for the University of Delhi

import javax.swing.*;
import java.awt.*;

class DDALineDrawing extends JPanel {

	private int x1, y1, x2, y2;

	DDALineDrawing(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	protected void paintComponent(Graphics g) {
		// this method is autromatically called by the Spring framework whenever
		// the panel needs tobe redrawn
		// it is responsible for rendering visual representation of panel's content
		super.paintComponent(g);
		drawLineDDA(g, x1, y1, x2, y2);
	}

	private void drawLineDDA(Graphics g, int x1, int y1, int x2, int y2) {
		int dx = x2 - x1;
		int dy = y2 - y1;
		float slope = (float)dy / (float)dx;
		int steps;
		float xIncrement, yIncrement, x = x1, y = y1;

		if (slope <= 1) {
			steps = Math.abs(dx);
			xIncrement = dx > 0 ? 1 : -1;
			yIncrement = dx > 0 ? slope : -slope;
		} else {
			steps = Math.abs(dy);
			xIncrement = dx > 0 ? (1 / slope) : (-1 / slope);
			yIncrement = 1;
		}

		g.setColor(Color.RED); // Set color to red

		g.drawLine(Math.round(x), Math.round(y), Math.round(x), Math.round(y)); // Start point

		for (int k = 0; k < steps; k++) {
			x += xIncrement;
			y += yIncrement;
			g.drawLine(Math.round(x), Math.round(y),
			           Math.round(x), Math.round(y));
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("DDA Line Drawing Algorithm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);

		int x1 = 100, y1 = 100, x2 = 350, y2 = 200; // Coordinates of line endpoints

		DDALineDrawing panel = new DDALineDrawing(x1, y1, x2, y2);
		frame.add(panel);

		frame.setVisible(true);
	}
}
