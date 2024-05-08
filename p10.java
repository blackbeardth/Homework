import javax.swing.*;
import java.awt.*;

import java.util.Scanner;

class PolygonFill extends JPanel {
	private final int edges;
	private final int[] x;
	private final int[] y;

	PolygonFill(int edges, int[] x, int[] y) {
		this.edges = edges;
		this.x = x;
		this.y = y;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		scanLineFill(g);
	}

	private void scanLineFill(Graphics g) {
		g.setColor(Color.BLACK);

		int ymin = Integer.MAX_VALUE, ymax = Integer.MIN_VALUE, dy, dx, temp;
		int[] in_x = new int[100];
		double[] slope = new double[100];

		for (int i = 0; i < this.edges; i++) {
			if (y[i] > ymax)
				ymax = y[i];
			if (y[i] < ymin)
				ymin = y[i];
		}

		// Close the polygon by connecting the last vertex to the first one
		x[this.edges] = x[0];
		y[this.edges] = y[0];

		for (int i = 0; i < this.edges; i++)
			g.drawLine(x[i], y[i], x[i + 1], y[i + 1]);

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < this.edges; i++) {
			dy = y[i + 1] - y[i];
			dx = x[i + 1] - x[i];
			if (dy == 0)
				slope[i] = 1.0;
			else if (dx == 0)
				slope[i] = 0.0;
			else
				slope[i] = (double) dx / dy;
		}

		for (int i = ymin, k = 0; i <= ymax; i++) {
			for (int j = 0; j < edges; j++) {
				if ((y[j] <= i && y[j + 1] > i) || (y[j] > i && y[j + 1] <= i)) {
					in_x[k] = (int) (x[j] + slope[j] * (i - y[j]));
					k++;
				}
			}
		}

		for (int m = 0; m < k - 1; m++) {
			for (int l = 0; l < k - 1; l++) {
				if (in_x[l] > in_x[l + 1]) {
					temp = in_x[l];
					in_x[l] = in_x[l + 1];
					in_x[l + 1] = temp;
				}
			}
		}

		g.setColor(Color.BLUE);

		for (int p = 0; p < k; p += 2) {
			g.drawLine(in_x[p], ymin, in_x[p + 1], ymin);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Scan Line Fill Algorithm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int edges;
		int[] x, y;

		// Sample vertices for testing
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of vertices:");
		edges = scanner.nextInt();
		x = new int[edges];
		y = new int[edges];
		System.out.println("Enter the coordinates of edges:");
		for (int i = 0; i < edges; i++) {
			x[i] = scanner.nextInt();
			y[i] = scanner.nextInt();
		}
		scanner.close();

		PolygonFill polygonFill = new PolygonFill(edges, x, y);
		frame.add(polygonFill);
		frame.setSize(800, 800);
		frame.setVisible(true);
	}
}
