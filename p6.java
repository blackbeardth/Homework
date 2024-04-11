// WAP to apply various 2D transforamtions on a 2D object.

// Written by Chirag Wadhwa for the University of Delhi

import java.awt.*;
import javax.swing.*;

import java.util.Scanner;
import java.io.IOException;

class TwoDTransform extends JPanel {
	private final int COORD_SHIFT = 100;
	private int n;
	private double[][] figure;

	TwoDTransform(int n) {
		this.n = n;
		this.figure = inputFigure(n);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		drawFigure(g, this.figure, this.n);
	}

	double[][] inputFigure(int n) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter matrix for the 2-D shape(homogeneous):");
		double[][] figure = new double[n][3];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				figure[i][j] = Double.parseDouble(input.next());
			}
		}
		return figure;
	}

	void drawFigure(Graphics g, double[][] figure, int n) {
		for (int i = 0; i < n ; i++) {
			g.drawLine( (int)Math.round(this.COORD_SHIFT + figure[i][0]),
			            (int)Math.round(this.COORD_SHIFT + figure[i][1]),
			            (int)Math.round(this.COORD_SHIFT + figure[(i + 1) % n][0]),
			            (int)Math.round(this.COORD_SHIFT + figure[(i + 1) % n][1]));
		}
	}

	double[][] translate(double[][] figure, int dim, int m, int n) {
		double[][] _figure;
		int[][] T = {
			{1, 0, 0},
			{0, 1, 0},
			{m, n, 1}
		};

		_figure = new double [dim][];
		for (int i = 0; i < dim; i++) {
			_figure[i] = new double[3];
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < dim; k++) {
					_figure[i][j] += figure[i][k] * T[k][j];
				}
			}
		}
		return _figure;
	}

	double[][] rotate(double figure[][], int dim, double theta) {
		double[][] _figure;
		double[][] T = {
			{Math.cos(Math.toRadians(theta)), Math.sin(Math.toRadians(theta)), 0},
			{ -Math.sin(Math.toRadians(theta)), Math.cos(Math.toRadians(theta)), 0},
			{0, 0, 1}
		};

		_figure = new double[dim][];
		for (int i = 0; i < dim; i++) {
			_figure[i] = new double[3];
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < dim ; k++) {
					_figure[i][j] += figure[i][k] * T[k][j];
				}
			}
		}
		return _figure;
	}

	double[][] scale(double[][] figure, int dim, int m, int n) {
		double[][] _figure;
		int[][] T = {
			{m, 0, 0},
			{0, n, 0},
			{0, 0, 1}
		};

		_figure = new double[dim][];
		for (int i = 0; i < dim; i++) {
			_figure[i] = new double[3];
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < dim; k++) {
					_figure[i][j] += figure[i][k] * T[k][j];
				}
			}
		}
		// for (int i = 0; i < dim; i++) {
		//     _figure[i] = new double[3];
		//     for (int j = 0; j < 3; j++) {
		//         _figure[i][j] = figure[i][j] * T[j][j];
		//     }
		// }
		return _figure;
	}

	double[][] reflect(double[][] figure, int dim, int c) {
		double[][] _figure;
		int[][] T = {
			{1, 0, 0},
			{0, 1, 0},
			{0, 0, 1}
		};

		switch (c) {
		case 1: T[1][1] = -1; break;
		case 2: T[0][0] = -1; break;
		case 3:
			T[0][0] = 0;
			T[0][1] = 1;
			T[1][0] = 1;
			T[1][1] = 0;
			break;
		case 4:
			T[0][0] = -1;
			T[1][1] = -1;
		default:
			return figure;
		}

		_figure = new double [dim][];
		for (int i = 0; i < dim; i++) {
			_figure[i] = new double[3];
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < dim; k++) {
					_figure[i][j] += figure[i][k] * T[k][j];
				}
			}
		}
		return _figure;
	}

	double[][] shear(double[][] figure, int dim, int m, int n) {
		double[][] _figure;
		int[][] T = {
			{1, n, 0},
			{m, 1, 0},
			{0, 0, 1}
		};

		_figure = new double [dim][];
		for (int i = 0; i < dim; i++) {
			_figure[i] = new double[3];
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < dim; k++) {
					_figure[i][j] += figure[i][k] * T[k][j];
				}
			}
		}
		return _figure;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of vertices: ");
		int n = scanner.nextInt();

		TwoDTransform panel = new TwoDTransform(n);
		double[][] initialFigure = panel.figure.clone(); // Store the initial figure
		JFrame frame = new JFrame("2D Transformations");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		while (true) {
			// Reset figure to initial input before each transformation
			panel.figure = initialFigure.clone();

			// Testing translation
			System.out.println("\n2D TRANSLATION\n");
			System.out.print("Enter translation values (m, n): ");
			int m = scanner.nextInt();
			int nTranslate = scanner.nextInt();
			double[][] translatedFigure = panel.translate(panel.figure, n, m, nTranslate);
			panel.figure = translatedFigure;
			panel.repaint();
			waitForEnter();

			// Reset figure to initial input before each transformation
			panel.figure = initialFigure.clone();

			// Testing rotation
			System.out.println("\n2D ROTATION\n");
			System.out.print("Enter rotation angle (in degrees): ");
			double theta = scanner.nextDouble();
			double[][] rotatedFigure = panel.rotate(panel.figure, n, theta);
			panel.figure = rotatedFigure;
			panel.repaint();
			waitForEnter();

			// Reset figure to initial input before each transformation
			panel.figure = initialFigure.clone();

			// Testing scaling
			System.out.println("\n2D SCALING\n");
			System.out.print("Enter scaling values (m, n): ");
			int scaleM = scanner.nextInt();
			int scaleN = scanner.nextInt();
			double[][] scaledFigure = panel.scale(panel.figure, n, scaleM, scaleN);
			panel.figure = scaledFigure;
			panel.repaint();
			waitForEnter();

			// Reset figure to initial input before each transformation
			panel.figure = initialFigure.clone();

			// Testing reflection
			System.out.println("\n2D REFLECTION\n");
			System.out.print("Enter reflection type (1 for x-axis, 2 for y-axis, 3 for origin, 4 for both axes): ");
			int reflectionType = scanner.nextInt();
			double[][] reflectedFigure = panel.reflect(panel.figure, n, reflectionType);
			panel.figure = reflectedFigure;
			panel.repaint();
			waitForEnter();

			// Reset figure to initial input before each transformation
			panel.figure = initialFigure.clone();

			// Testing shear
			System.out.println("\n2D SHEARING\n");
			System.out.print("Enter shear values (m, n): ");
			int shearM = scanner.nextInt();
			int shearN = scanner.nextInt();
			double[][] shearedFigure = panel.shear(panel.figure, n, shearM, shearN);
			panel.figure = shearedFigure;
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