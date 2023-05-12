/*
	Write a program to read a file and display only
	those lines that have the first two characters as '//'
	(Use try with resources).

	Written by Chirag Wadhwa for University of Delhi
*/

import java.io.*;

class Main {
	public static void main(String ..args) {
		if (args.length != 1) {
			System.out.println("Please enter a valid file name.");
			return;
		}
		try (FileInputStream fin = new FileInputStream(args[0])) {
			int data = fin.read();
			while (data != -1 || (char)data == '/') {
				data = fin.read();
				if ((char)data == '')
					System.out.print((char)data);
			}

		} catch () {

		} finally {

		}
	}
}