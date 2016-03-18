package main;

import java.util.Scanner;

import data.ReaderData;

public class Driver {

	public static void main(String[] args) {

		ReaderData readerData = new ReaderData();
		readerData.loadDataFromfile("src/reader.csv");
		for (;;) {
			System.out.println("\n====***************************************====");
			System.out.println("Please enter one the below options (1/2/3/4)");
			System.out.println("1. Number of students registered for a Class: ");
			System.out.println("2. Number of students takes more than one Class? ");
			System.out.println("3. All of the above");
			System.out.println("4. Exit the program");
			System.out.println("5. Print Duplicate Characters");
			System.out.println("6. Fibonacci Iterative");
			System.out.println("7. Fibonacci Recursive");
			System.out.println("8. Reverse a String Iterative");
			System.out.println("9. Reverse a String Recursive");
			System.out.println("10. BuzzFizz Number");
			System.out.println("11. Occurance of a character in string");
			System.out.println("12. Palindrome");
			System.out.println("13. Reverse an array");
			System.out.println("====***************************************====\n");

			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter your choice: ");
			if (scan.hasNextInt()) {
				int number = scan.nextInt();
				int count = 0;
				switch (number) {
				case 1:
					readerData.getCountOfStrudentsPerClass();
					break;
				case 2:
					count = readerData.getStudentsIDWithMoreThanOneClass();
					System.out.println("The Number of student(s) who have taken more than one class: " + count);
					break;
				case 3:
					readerData.getCountOfStrudentsPerClass();
					count = readerData.getStudentsIDWithMoreThanOneClass();
					System.out.println("The Number of student(s) who have taken more than one class: " + count);
					break;
				case 4:
					System.out.println("Good Bye!");
					System.exit(0);
					break;
				case 5:
					readerData.printDuplicateCharacters("Character");
					break;
				case 6:
					for (int i = 0; i <= 15; i++) {
						System.out.print(readerData.printFibonacciNumbersIterative(i) + " ");
					}
					break;
				case 7:
					for (int i = 0; i <= 15; i++) {
						System.out.print(readerData.printFibonacciNumbersRecursive(i) + " ");
					}
					break;
				case 8:
					System.out.println(readerData.reverseAString("I am Awesome"));
					break;
				case 9:
					System.out.println(readerData.reverseAStringRecursive("I am Awesome"));
					break;
				case 10:
					System.out.println(readerData.buzzFizzNumber(2));
					break;
				case 11:
					System.out.println(readerData.occurrenceOfCharInString('a', "you are awesome"));
					break;
				case 12:
					System.out.println(readerData.palindrome("malayalam"));
					break;
				case 13:
					int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
					for (int i : data ) {
						System.out.print(i + " ");
					}
					System.out.println();
					int[] elements = readerData.reverseAnArray(data);
					for (int i :  elements) {
						System.out.print(i + " ");
					}
					System.out.println();
					break;
				default:
					System.out.println("Oops! You clicked wrong entry, Try again!");
					break;
				}
			} else {
				System.out.println("Oops! You clicked wrong entry, Try again!");
			}
		}
	}
}
