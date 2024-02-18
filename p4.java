// WAP to clip a line using Cohen and Sutherland line clipping algorithm.

// Written by Chirag Wadhwa for the University of Delhi

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class CohenSutherlandLineClipping extends JPanel {
	private static final int TOP = 0x1;
	private static final int BOTTOM = 0x2;
	private static final int RIGHT = 0x4;
	private static final int LEFT = 0x8;

	private static boolean clipped;
	private double x1, y1, x2, y2, xmin, ymin, xmax, ymax;

	CohenSutherlandLineClipping(double x1, double y1, double x2,
	                            double y2, double xmin, double ymin, double xmax,
	                            double ymax, boolean clipped) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.xmin = xmin;
		this.ymin = ymin;
		this.xmax = xmax;
		this.ymax = ymax;
		this.clipped = clipped;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (this.clipped)
			clipLine(g, x1, y1, x2, y2, xmin, ymin, xmax, ymax);
		else
			drawLineAndRectangle(g, x1, y1, x2, y2, xmin, ymin, xmax, ymax);
	}

	private int computeOutcode(double x, double y) {
		int code = 0;

		if (y > ymax)
			code |= TOP;
		else if (y < ymin)
			code |= BOTTOM;

		if (x > xmax)
			code |= RIGHT;
		else if (x < xmin)
			code |= LEFT;

		return code;
	}

	private void clipLine(Graphics g, double x1, double y1, double x2, double y2,
	                      double xmin, double ymin, double xmax, double ymax) {
		int accept = 0, done = 0;
		int outcode0, outcode1, outcodeout;

		outcode0 = computeOutcode(x1, y1);
		outcode1 = computeOutcode(x2, y2);

		do {
			if ((outcode0 | outcode1) == 0) {
				accept = 1;
				done = 1;
			} else if ((outcode0 & outcode1) != 0)
				done = 1;
			else {
				double x, y;
				outcodeout = (outcode0 != 0) ? outcode0 : outcode1;

				if ((outcodeout & TOP) != 0) {
					x = x1 + (ymax - y1) * (x2 - x1) / (y2 - y1);
					y = ymax;
				} else if ((outcodeout & BOTTOM) != 0) {
					x = x1 + (ymin - y1) * (x2 - x1) / (y2 - y1);
					y = ymin;
				} else if ((outcodeout & LEFT) != 0) {
					x = xmin;
					y = y1 + (xmin - x1) * (y2 - y1) / (x2 - x1);
				} else {
					x = xmax;
					y = y1 + (xmax - x1) * (y2 - y1) / (x2 - x1);
				}

				if (outcodeout == outcode0) {
					x1 = x;
					y1 = y;
					outcode0 = computeOutcode(x1, y1);
				} else {
					x2 = x;
					y2 = y;
					outcode1 = computeOutcode(x2, y2);
				}
			}
		} while (done == 0);

		if (accept != 0)
			g.drawLine((int)Math.round(x1), (int)Math.round(y1),
			           (int)Math.round(x2), (int)Math.round(y2));

		drawLineAndRectangle(g, x1, y1, x2, y2, xmin, ymin, xmax, ymax);
	}

	private void drawLineAndRectangle(Graphics g, double x1, double y1, double x2,
	                                  double y2, double xmin, double ymin, double
	                                  xmax, double ymax) {
		// g.drawLine((int)Math.round(xmin), (int)Math.round(ymin),
		//            (int)Math.round(xmax), (int)Math.round(ymin));
		// g.drawLine((int)Math.round(xmin), (int)Math.round(ymin),
		//            (int)Math.round(xmin), (int)Math.round(ymax));
		// g.drawLine((int)Math.round(xmin), (int)Math.round(ymax),
		//            (int)Math.round(xmax), (int)Math.round(ymax));
		// g.drawLine((int)Math.round(xmax), (int)Math.round(ymin),
		//            (int)Math.round(xmax), (int)Math.round(ymax));

		double width = xmax - xmin;
		double height = ymax - ymin;

		g.drawRect((int)Math.round(xmin), (int)Math.round(ymin),
		           (int)Math.round(width), (int)Math.round(height));

		g.drawLine((int)Math.round(x1), (int)Math.round(y1),
		           (int)Math.round(x2), (int)Math.round(y2));
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Cohen & Sutherland Line Clipping Algorithm (Unclipped)");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);

		int x1 = 100, y1 = 100, x2 = 300, y2 = 350; // Coordinates of line endpoints
		int xmin = 125, ymin = 125, xmax = 275, ymax = 300; // Bounds of Clipping Rectangle

		CohenSutherlandLineClipping unclippedPanel =
		    new CohenSutherlandLineClipping(x1, y1, x2, y2,
		                                    xmin, ymin, xmax, ymax, false);
		frame.add(unclippedPanel);

		frame.setVisible(true);

		// Wait for the frame to close
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				JFrame newFrame = new JFrame("Cohen & Sutherland Line Clipping Algorithm (Clipped)");
				newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				newFrame.setSize(500, 500);
				newFrame.setLocationRelativeTo(null);

				CohenSutherlandLineClipping clippedPanel =
				    new CohenSutherlandLineClipping(x1, y1, x2, y2,
				                                    xmin, ymin, xmax, ymax, true);
				newFrame.add(clippedPanel);

				newFrame.setVisible(true);
			}
		});
	}
}