/*
	Create an expception subclass UnderAge, which prints "Under Age"
	along with the age value when an object of UnderAge class is printed
	in the catch statement. Write a class exceptionDemo in which the method test()
	throws UnderAge exception if the variable age passed to it as argument is less than 18.
	Write main() method also to show working of the program.

	Written by Chirag Wadhwa for University Of Delhi
*/
import java.util.Scanner;

class Main {
	public static void main(String ...args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter your age: ");
		int age = sc.nextInt();

		try {
			ExceptionDemo ob = new ExceptionDemo();
			ob.test(age);
		} catch (UnderAge err) {
			err.showException();
		} finally {
			sc.close();
			System.out.println("Program over.");
		}
	}
}