package P3;
import P1.*;


public class Circle extends P1.Shape
{
	private double radius;

	public Circle(double r) {
		this.radius = r;
	}

	// Overriding function
	public double area() {
		if (this.radius > 0)
			return Math.pow(this.radius, 2) * 3.14;
		return -1;
	}
}