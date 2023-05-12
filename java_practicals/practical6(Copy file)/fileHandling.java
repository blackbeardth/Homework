/*
	Write a program that copies content of one file to another.
	Pass the names of the files through command line arguments.

	Written by Chirag wadhwa for University of Delhi.
*/
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;


class fileHandling {
	public static void main(String ...args) {
		try {
			File rFile = new File(args[0]);
			Scanner sc = new Scanner(rFile);
			FileWriter wFile = new FileWriter(args[1]);

			while (sc.hasNextLine()) {
				String data = sc.nextLine();
				wFile.write(data + "\n");
			}

			System.out.println("Content was copied sucessfully.");
			sc.close();
			wFile.close();
		} catch (IOException err) {
			System.out.println("An error has occured.");
			err.printStackTrace();
		}

	}
}