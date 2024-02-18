// WAP to clip a polygon using Sutherland Hodgman algorithm.

// Written by Chirag Wadhwa for the University of Delhi

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class SutherlandHogmanPolygonClipping extends JPanel {
	private static final int TOP = 0x1;
	private static final int BOTTOM = 0x2;
	private static final int RIGHT = 0x4;
	private static final int LEFT = 0x8;

	private static boolean clipped;
	private double xmin, ymin, xmax, ymax; // Bounds of clipping rectangle
	private int edges; // Number of edges in polygon
	private int poly[]; // Coordinates of the Polygon

	SutherlandHogmanPolygonClipping(double xmin, double ymin, double xmax, double ymax, int edges, int[] poly, boolean clipped) {
		this.xmin = xmin;
		this.ymin = ymin;
		this.xmax = xmax;
		this.ymax = ymax;
		this.edges = edges;
		this.clipped = clipped;

		this.poly = new int[24];
		for (int i = 0; i < 2 * edges; i++)
			this.poly[i] = poly[i];

		poly[2 * edges] = poly[0];
		poly[2 * edges + 1] = poly[1];
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawRectangle(g, this.xmin, this.ymin, this.xmax, this.ymax);
		if (this.clipped) {
			for (int i = 0; i < this.edges; i++)
				clipPolygon(g, poly[2 * i], poly[(2 * i) + 1],
				            poly[(2 * i) + 2], poly[(2 * i) + 3]);
		} else
			drawPolygon(g, this.edges, this.poly);
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

	private void clipPolygon(Graphics g, double x1, double y1,
	                         double x2, double y2) {
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
					x = x1 + (x2 - x1) * (ymax - y1) / (y2 - y1);
					y = ymax;
				} else if ((outcodeout & BOTTOM) != 0) {
					x = x1 + (x2 - x1) * (ymin - y1) / (y2 - y1);
					y = ymin;
				} else if ((outcodeout & LEFT) != 0) {
					x = xmin;
					y = y1 + (y2 - y1) * (xmin - x1) / (x2 - x1);
				} else {
					x = xmax;
					y = y1 + (y2 - y1) * (xmax - x1) / (x2 - x1);
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
	}

	private void drawRectangle(Graphics g, double xmin, double ymin,
	                           double xmax, double ymax) {
		double width = xmax - xmin;
		double height = ymax - ymin;

		g.drawRect((int)Math.round(xmin), (int)Math.round(ymin),
		           (int)Math.round(width), (int)Math.round(height));
	}

	private void drawPolygon(Graphics g, int edges, int[] poly) {
		int[] xPoints = new int[edges];
		int[] yPoints = new int[edges];
		for (int i = 0; i < edges; i++) {
			xPoints[i] = poly[2 * i];
			yPoints[i] = poly[(2 * i) + 1];
		}
		g.drawPolygon(xPoints, yPoints, edges);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Sutherland Hogman Polygon Clipping Algorithm (Unclipped)");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(520, 520);
		frame.setLocationRelativeTo(null);

		int edges = 3; // number of edges of the polygon
		int[] poly = new int[24]; // array to hold the coordinates  of edges of the polygon
		double xmin = 100, ymin = 100,
		       xmax = 200, ymax = 200; // Bounds of Clipping Rectangle

		// Coordinates  of edges of the polygon
		poly[0] = 80;
		poly[1] = 125;
		poly[2] = 150;
		poly[3] = 150;
		poly[4] = 80;
		poly[5] = 180;

		SutherlandHogmanPolygonClipping unclippedPanel =
		    new SutherlandHogmanPolygonClipping(xmin, ymin, xmax, ymax,
		                                        edges, poly, false);
		frame.add(unclippedPanel);

		frame.setVisible(true);

		// Wait for the frame to close
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				JFrame newFrame = new JFrame("Sutherland Hogman Polygon Clipping Algorithm (Clipped)");
				newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				newFrame.setSize(520, 520);
				newFrame.setLocationRelativeTo(null);

				SutherlandHogmanPolygonClipping clippedPanel =
				    new SutherlandHogmanPolygonClipping(xmin, ymin, xmax, ymax,
				                                        edges, poly, true);
				newFrame.add(clippedPanel);

				newFrame.setVisible(true);
			}
		});
	}
}