// WAP to apply various 3D transforamtions on a 3D object.

// Written by Chirag Wadhwa for the University of Delhi

import javax.swing.*;
import java.awt.*;

import java.util.Scanner;
import java.io.IOException;

class ThreeDTransform extends JPanel {
	private double[][] edges;
	private int projectionChoice;

	ThreeDTransform(int projectionChoice) {
		this.edges = new double[][] {
			{100, 0, 0}, {100, 100, 0}, {0, 100, 0}, {0, 100, 100},
			{0, 0, 100}, {0, 0, 0}, {100, 0, 0}, {100, 0, 100},
			{100, 75, 100}, {75, 100, 100}, {100, 100, 75}, {100, 100, 0},
			{100, 100, 75}, {100, 75, 100}, {75, 100, 100}, {0, 100, 100},
			{0, 100, 0}, {0, 0, 0}, {0, 0, 100}, {100, 0, 100}
		};
		this.projectionChoice = projectionChoice;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawObj(g, this.edges);
	}

	private void drawObj(Graphics g, double[][] edges) {
		// Drawing logic for the object
		// g.setColor(Color.BLACK);
		// for (int i = 0; i < edges.length; i++) {
		// 	int nextIndex = (i + 1) % edges.length;
		// 	int x1 = (int) Math.round(edges[i][0]);
		// 	int y1 = (int) Math.round(edges[i][1]);
		// 	int x2 = (int) Math.round(edges[nextIndex][0]);
		// 	int y2 = (int) Math.round(edges[nextIndex][1]);
		// 	// Draw according to the selected projection
		// 	switch (this.projectionChoice) {
		// 	case 1: // Orthographic Projection on xy-plane
		// 		g.drawLine(x1, y1, x2, y2);
		// 		break;
		// 	case 2: // Axonometric Projection (Isometric)
		// 		// Apply axonometric projection
		// 		double axoX1 = x1 + edges[i][2] * Math.cos(2.3562);
		// 		double axoY1 = y1 + edges[i][2] * Math.sin(2.3562);
		// 		double axoX2 = x2 + edges[nextIndex][2] * Math.cos(2.3562);
		// 		double axoY2 = y2 + edges[nextIndex][2] * Math.sin(2.3562);
		// 		g.drawLine((int) Math.round(axoX1), (int) Math.round(axoY1),
		// 		           (int) Math.round(axoX2), (int) Math.round(axoY2));
		// 		break;
		// 	case 3: // Perspective Projection
		// 		// Apply perspective projection
		// 		double p = edges[i][0];
		// 		double q = edges[i][1];
		// 		double r = edges[i][2];
		// 		double persX1 = p / (p * x1 + q * y1 + r);
		// 		double persY1 = q / (p * x1 + q * y1 + r);
		// 		double persX2 = p / (p * x2 + q * y2 + r);
		// 		double persY2 = q / (p * x2 + q * y2 + r);
		// 		g.drawLine((int) Math.round(persX1), (int) Math.round(persY1),
		// 		           (int) Math.round(persX2), (int) Math.round(persY2));
		// 		break;
		// 	}
		// }
		g.setColor(Color.BLACK);

		int i;
		double[][] _edges = new double[20][3];
		double x1, y1, x2, y2;
		for (i = 0; i < 20; i++) {
			_edges[i][0] = edges[i][0];
			_edges[i][1] = edges[i][1];
			_edges[i][2] = edges[i][2];
		}

		switch (this.projectionChoice) {
		case 1:
			// Orthographic Parallel Projection - xy plane
			for (i = 0; i < 19; i++) {
				x1 = edges[i][0];
				y1 = edges[i][1];
				x2 = edges[i + 1][0];
				y2 = edges[i + 1][1];
				g.drawLine((int)Math.round(x1 + 320),
				           (int)Math.round(240 - y1),
				           (int)Math.round(x2 + 320),
				           (int)Math.round(240 - y2));
			}
			break;
		case 2:
			// Axonometric Projection - Isometric
			for (i = 0; i < 19; i++) {
				x1 = edges[i][0] + edges[i][2] * (Math.cos(2.3562));
				y1 = edges[i][1] - edges[i][2] * (Math.sin(2.3562));
				x2 = edges[i + 1][0] + edges[i + 1][2] * (Math.cos(2.3562));
				y2 = edges[i + 1][1] - edges[i + 1][2] * (Math.sin(2.3562));
				g.drawLine((int)Math.round(x1 + 320),
				           (int)Math.round(240 - y1),
				           (int)Math.round(x2 + 320),
				           (int)Math.round(240 - y2));
			}
			g.setColor(Color.RED);
			g.drawLine(320, 240, 320, 25);
			g.drawLine(320, 240, 550, 240);
			g.drawLine(320, 240, 150, 410);
			g.setColor(Color.BLACK);
			break;
		case 3:
			// Perspective Projection
			Scanner input = new Scanner(System.in);
			System.out.print("\nEnter p, q and r: ");
			int p = input.nextInt();
			int q = input.nextInt();
			int r = input.nextInt();

			for (i = 0; i < 20; i++) {
				_edges[i][0] /= (p * _edges[i][0] +
				                 q * _edges[i][1] +
				                 r * _edges[i][2] + 1);
				_edges[i][1] /= (p * _edges[i][0] +
				                 q * _edges[i][1] +
				                 r * _edges[i][2] + 1);
				_edges[i][2] /= (p * _edges[i][0] +
				                 q * _edges[i][1] +
				                 r * _edges[i][2] + 1);
			}

			for (i = 0; i < 19; i++) {
				x1 = _edges[i][0] + _edges[i][2] * (Math.cos(2.3562));
				y1 = _edges[i][1] - _edges[i][2] * (Math.sin(2.3562));
				x2 = _edges[i + 1][0] + _edges[i + 1][2] * (Math.cos(2.3562));
				y2 = _edges[i + 1][1] - _edges[i + 1][2] * (Math.sin(2.3562));

				g.drawLine((int)Math.round(x1 + 320),
				           (int)Math.round(240 - y1),
				           (int)Math.round(x2 + 320),
				           (int)Math.round(240 - y2));
			}
			break;
		}
	}

	void scale(int a, int b, int c) {
		for (int i = 0; i < edges.length; i++) {
			edges[i][0] *= a;
			edges[i][1] *= b;
			edges[i][2] *= c;
		}
	}

	void translate(int a, int b, int c) {
		for (int i = 0; i < edges.length; i++) {
			edges[i][0] += a;
			edges[i][1] += b;
			edges[i][2] += c;
		}
	}

	void rotate(int ch, double theta) {
		theta = Math.toRadians(theta);
		double[][] temp = new double[edges.length][3];
		for (int i = 0; i < edges.length; i++) {
			double x =  edges[i][0];
			double y =  edges[i][1];
			double z =  edges[i][2];

			switch (ch) {
			case 1: // x axis
				temp[i][0] = x;
				temp[i][1] = y * Math.cos(theta) - z * Math.sin(theta);
				temp[i][2] = y * Math.sin(theta) + z * Math.cos(theta);
				break;
			case 2: // y axis
				temp[i][0] = x * Math.cos(theta) + z * Math.sin(theta);
				temp[i][1] = y;
				temp[i][2] = -x * Math.sin(theta) + z * Math.cos(theta);
				break;
			case 3: // z axis
				temp[i][0] = x * Math.cos(theta) - y * Math.sin(theta);
				temp[i][1] = x * Math.sin(theta) + y * Math.cos(theta);
				temp[i][2] = z;
				break;
			}
		}
		edges = temp;
	}

	void reflect(int ch) {
		double[][] temp = new double[edges.length][3];
		for (int i = 0; i < edges.length; i++) {
			double x =  edges[i][0];
			double y =  edges[i][1];
			double z =  edges[i][2];

			switch (ch) {
			case 1: // x-axis
				temp[i][0] = x;
				temp[i][1] = -y;
				temp[i][2] = -z;
				break;
			case 2: // y-axis
				temp[i][0] = -x;
				temp[i][1] = y;
				temp[i][2] = -z;
				break;
			case 3: // z-axis
				temp[i][0] = -x;
				temp[i][1] = -y;
				temp[i][2] = z;
				break;
			}
		}
		edges = temp;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Projection: ");
		System.out.println("1. Orthographic Projection on xy plane");
		System.out.println("2. Axonometric projection (Isometric)");
		System.out.println("3. Perpective Projection");
		System.out.print("\nEnter choice: ");
		int projectionChoice = scanner.nextInt();

		// Create an instance of the panel with orthographic projection
		ThreeDTransform panel = new ThreeDTransform(projectionChoice);
		double[][] initialEdges = panel.edges.clone(); // Store the initial edges
		JFrame frame = new JFrame("3D Transformations");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		while (true) {
			int a, b, c, ch, theta;

			// Reset figure to initial input before each transformation
			panel.edges = initialEdges.clone();

			// Testing Translation
			System.out.println("\n3D TRANSLATION\n");
			System.out.print("Enter translation values (a, b, c): ");
			a = scanner.nextInt();
			b = scanner.nextInt();
			c = scanner.nextInt();
			panel.translate(a, b, c);
			panel.repaint();
			waitForEnter();

			// Reset figure to initial input before each transformation
			panel.edges = initialEdges.clone();

			// Testing Scaling
			System.out.println("\n3D SCALING\n");
			System.out.print("Enter scaling values (a, b, c): ");
			a = scanner.nextInt();
			b = scanner.nextInt();
			c = scanner.nextInt();
			panel.scale(a, b, c);
			panel.repaint();
			waitForEnter();

			// Reset figure to initial input before each transformation
			panel.edges = initialEdges.clone();

			// Testing Rotation
			System.out.println("\n3D ROTATION\n");
			System.out.print("Enter rotation axis (x = 1, y = 2, z = 3): ");
			ch = scanner.nextInt();
			System.out.print("Enter rotation angle (in degrees): ");
			theta = scanner.nextInt();
			panel.rotate(ch, theta);
			panel.repaint();
			waitForEnter();

			// Reset figure to initial input before each transformation
			panel.edges = initialEdges.clone();

			// Testing Reflection
			System.out.println("\n3D REFLECTION\n");
			System.out.print("Enter reflection axis (x = 1, y = 2, z = 3): ");
			ch = scanner.nextInt();
			panel.reflect(ch);
			panel.repaint();
			waitForEnter();

			// Ask if the user wants to continue
			System.out.print("Do you want to continue? ([y]es/[n]o): ");
			String continueOption = scanner.next();
			if (!continueOption.equalsIgnoreCase("y")) {
				System.out.println("Program over...");
				frame.dispose(); // Close the JFrame
				break;
			}
		}
	}

	private static void waitForEnter() {
		System.out.println("Press Enter to continue...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}