/*	Design a class having a real part (x) and an
	imaginary part (y).Provide methods to perform
	the following operations:
		1) Add two complex number
		2) Multiply two complex numbers
		3) toString() method to display complex numbers
		   in the form: x +iy

	Written by Chirag Wadhwa for University of Delhi
*/

public class Complex {
	private int x;
	private int y;

	public Complex(int real, int imaginary) {
		this.x = real;
		this.y = imaginary;
	}

	public Complex add(Complex o) {
		return new Complex (
		           this.x + o.x,
		           this.y + o.y
		       );
	}

	public Complex multiply(Complex o) {
		return new Complex (
		           this.x * o.x + this.y * o.y,
		           this.x * o.y + o.x * this.y
		       );
	}

	public String toString() {
		return this.x + " + i" + this.y;
	}

/*	
	public static void main(String args[]) {
		Complex c1 = new Complex(1, 5);
		Complex c2 = new Complex(2, 4);
		System.out.println("Complex 1: " +  c1);
		System.out.println("Complex 2: " + c2);
		System.out.println("Sum: " + c1.add(c2));
		System.out.println("product: " + c1.multiply(c2));
	}
*/
}
