package P2;
import P1.*;

public class Rectangle extends P1.Shape
{
	private double length;
	private double breadth;

	public Rectangle(double l, double b) {
		this.length = l;
		this.breadth = b;
	}

	// Overriding function
	public double area() {
		if (this.length > 0 && this.breadth > 0 )
			return this.length * this.breadth;
		return -1;
	} 
}