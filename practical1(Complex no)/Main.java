public class Main {
	public static void main(String[] args)
	{
		Complex c1 = new Complex(1, 5);
		Complex c2 = new Complex(2, 4);
		System.out.println("Complex 1: " +  c1);
		System.out.println("Complex 2: " + c2);
		System.out.println("Sum: " + c1.add(c2));
		System.out.println("product: " + c1.multiply(c2));
	}
}