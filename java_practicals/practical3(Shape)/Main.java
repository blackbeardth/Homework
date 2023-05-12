/*
	Define an abstract class Shape in package P1. Inherit two more
	classes: Rectangle in package P2 and Circle in package P3. Write
	a program to ask the user for the type of shape and then using
	the concept of dynamic method dispatch, display the area of the
	appropriate subclass. Also write appropriate methods to read the
	data. The main() function should not be in any package.

	Written by Chirag Wadhwa for University of Delhi
*/
package P;

import java.util.Scanner;
import P1.*;
import P2.*;
import P3.*;

class Main {
	public static void main(String ...args) {
		inputAndThings();
	}

	public static void inputAndThings() {
		Scanner sc = new Scanner(System.in);
		Shape ob;
		
		//taking input
		System.out.print("Enter your shape{rectangle(r), circle(c)}: ");
		char input = sc.next().charAt(0);

		//checking input
		if (input == 'r' || input == 'R') {
			System.out.print("Enter length and breadth of the rectangle(in m): ");
			double l = sc.nextDouble();
			double b = sc.nextDouble();
			ob = new Rectangle(l, b);

			System.out.println("Area of rectangle is " + ob.area() + " sq m.");
		}

		else if (input == 'c' || input == 'C') {
			System.out.print("Enter radius of the circle(in m): ");
			double r = sc.nextDouble();
			ob = new Circle(r);

			System.out.println("Area of circle is " + ob.area() + " sq m.");
		}

		else {
			System.out.print("invalid input.");
			return;
		}

	}
}