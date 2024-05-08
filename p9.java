// WAP to draw Hermite/Bezier curve.

// Written by Chirag Wadhwa for University of Delhi

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.Scanner;
import java.io.IOException;

class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class HermiteCurve extends JPanel {
	private Point p1, p4;
	private double r1, r4;

	HermiteCurve(Point p1, Point p4, double r1, double r4) {
		this.p1 = p1;
		this.p4 = p4;
		this.r1 = r1;
		this.r4 = r4;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		hermite(g);
	}

	private void hermite(Graphics g) {
		g.setColor(Color.BLACK);

		double x, y, t;
		for (t = 0.0; t <= 1.0; t +=  0.00005) {
			x = (2 * Math.pow(t, 3) - 3 * Math.pow(t, 2) + 1) * p1.x +
			    (-2 * Math.pow(t, 3) + 3 * Math.pow(t, 2)) * p4.x +
			    (Math.pow(t, 3) - 2 * Math.pow(t, 2) + t) * r1 +
			    (Math.pow(t, 3) - Math.pow(t, 2)) * r4;
			y = (2 * Math.pow(t, 3) - 3 * Math.pow(t, 2) + 1) * p1.y +
			    (-2 * Math.pow(t, 3) + 3 * Math.pow(t, 2)) * p4.y +
			    (Math.pow(t, 3) - 2 * Math.pow(t, 2) + 1) * r1 +
			    (Math.pow(t, 3) - Math.pow(t, 2)) * r4;
			g.drawLine((int)Math.round(x), (int)Math.round(y),
			           (int)Math.round(x), (int)Math.round(y));
		}
		g.drawOval(p1.x - 3, p1.y - 3, 6, 6);
		g.drawOval(p4.x - 3, p4.y - 3, 6, 6);
	}
}

class BezierCurve extends JPanel {
	private int[] x;
	private int[] y;

	BezierCurve(int[] x, int[] y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		bezier(g);
	}

	private void bezier(Graphics g) {
		g.setColor(Color.BLACK);

		for (double t = 0.0; t < 1.0; t += 0.00005) {
			double xt = Math.pow(1 - t, 3) * x[0] + 3 * t * Math.pow(1 - t, 2) * x[1] +
			            3 * Math.pow(t, 2) * (1 - t) * x[2] + Math.pow(t, 3) * x[3];
			double yt = Math.pow(1 - t, 3) * y[0] + 3 * t * Math.pow(1 - t, 2) * y[1] +
			            3 * Math.pow(t, 2) * (1 - t) * y[2] + Math.pow(t, 3) * y[3];
			g.drawLine((int)Math.round(xt), (int)Math.round(yt),
			           (int)Math.round(xt), (int)Math.round(yt));
		}

		for (int i = 0; i < 4; i++) {
			g.drawOval(x[i] - 3, y[i] - 3, 6, 6);
		}
	}
}

class p9 {
	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);

		JFrame frame1 = new JFrame("Hermite Curve");
		frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		Point p1 = new Point(100, 100);
		Point p4 = new Point(225, 150);
		double r1 = 0, r4 = 70; // Control point radii
		HermiteCurve hcurve = new HermiteCurve(p1, p4, r1, r4);

		frame1.add(hcurve);
		frame1.setSize(400, 300);
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);

		// Wait for the frame to close
		frame1.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				JFrame frame2 = new JFrame("Bezier Curve");
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				int[] x = {100, 150, 200, 275};
				int[] y = {100, 170, 210, 120};
				BezierCurve bcurve = new BezierCurve(x, y);

				frame2.add(bcurve);
				frame2.setSize(400, 300);
				frame2.setLocationRelativeTo(null);
				frame2.setVisible(true);
			}
		});
	}
}