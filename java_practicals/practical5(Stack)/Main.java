/*
	Write a program to implement stack. Use exception
	handling to manage overflow and underflow conditions.

	Written by Chirag Wadhwa for University of Delhi
*/
class Main {
	public static void main(String ...args) {

		Stack ob = new Stack(5);
		try {
			ob.pop();// Stack is empty
		} catch (StackException err) {
			err.showException();
		} 
		try {
			ob.push(3);
			ob.push(7);
			ob.push(-11);
			ob.push(1);
			ob.push(34);
			ob.push(2);// Stack is full
		} catch (StackException err) {
			err.showException();
		} finally {
			System.out.println("Program has ended.");
		}
	}
}