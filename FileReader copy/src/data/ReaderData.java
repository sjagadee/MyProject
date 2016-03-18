package data;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import reader.ClassReader;

public class ReaderData {

	private ArrayList<ClassReader> readerList;

	public ReaderData() {
		readerList = new ArrayList<>();
	}

	public ClassReader getUsingRecordNumber(int i) {
		return readerList.get(i);
	}

	public int getNumberOfRecords() {
		return readerList.size();
	}

	// reads the file in the filepath. Creates reader objects and adds them to
	// readerList
	public void loadDataFromfile(String filePath) {
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(new FileReader(filePath));

			String line;
			ClassReader classReader;

			scanner.nextLine();
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				String[] results = line.split(",");
				String className = results[0];
				String professorName = results[1];
				Integer studentId = Integer.valueOf(results[2].replaceAll("\\s", ""));

				classReader = new ClassReader(className, professorName, studentId);
				readerList.add(classReader);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error " + e.getMessage());
		}
	}

	// This method would give us the count of the students per class
	public void getCountOfStrudentsPerClass() {
		Map<String, Integer> counts = new HashMap<String, Integer>();

		for (ClassReader reader : readerList) {
			if (counts.containsKey(reader.getclassName())) {
				counts.put(reader.getclassName(), counts.get(reader.getclassName()) + 1);
			} else {
				counts.put(reader.getclassName(), 1);
			}
		}

		for (Map.Entry<String, Integer> entry : counts.entrySet()) {
			System.out.println("Number of students registered for " + entry.getKey() + " class = " + entry.getValue());
		}

	}

	// This method would give us the students who have taken more than one class
	// and return their count as well
	public int getStudentsIDWithMoreThanOneClass() {

		Map<String, Integer> counts = new HashMap<String, Integer>();
		int count = 0;

		for (ClassReader reader : readerList) {
			if (counts.containsKey(reader.getStudentID().toString())) {
				counts.put(reader.getStudentID().toString(), counts.get(reader.getStudentID().toString()) + 1);
			} else {
				counts.put(reader.getStudentID().toString(), 1);
			}
		}

		for (Map.Entry<String, Integer> entry : counts.entrySet()) {

			if (entry.getValue() > 1) {
				System.out.println("Student with ID : " + entry.getKey() + ", Has registered for more than one class ("
						+ entry.getValue() + ")");
				count++;
			}

		}

		return count;
	}

	// This code would find the duplicate elements in a string and would print
	// them
	public void printDuplicateCharacters(String word) {
		char[] characters = word.toCharArray();

		Map<Character, Integer> charMap = new HashMap<Character, Integer>();

		for (Character ch : characters) {
			if (charMap.containsKey(ch)) {
				charMap.put(ch, charMap.get(ch) + 1);
			} else {
				charMap.put(ch, 1);
			}
		}

		for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}

	}

	// This code would find the fibonacci numbers of the given number in
	// iterative manner
	public int printFibonacciNumbersIterative(int number) {
		if (number == 0) {
			return 0;
		} else if (number == 1) {
			return 1;
		} else if (number == 2) {
			return 1;
		} else {
			int fib1 = 1, fib2 = 1, fib = 0;
			for (int i = 3; i <= number; i++) {
				fib = fib1 + fib2;
				fib1 = fib2;
				fib2 = fib;
			}
			return fib;
		}
	}

	// This code would find the fibonacci number using recursive method
	public int printFibonacciNumbersRecursive(int number) {
		if (number == 0) {
			return 0;
		} else if (number == 1) {
			return 1;
		} else if (number == 2) {
			return 1;
		} else {
			return printFibonacciNumbersRecursive(number - 1) + printFibonacciNumbersRecursive(number - 2);
		}
	}

	// reversing string iteratively
	public String reverseAString(String data) {
		String newString = "";

		int len = data.length();
		for (int i = len - 1; i >= 0; i--) {
			newString += data.charAt(i);
		}

		return newString;
	}

	// reversing a string recursively
	public String reverseAStringRecursive(String str) {

		if (str.length() < 2) {
			return str;
		} else {
			return reverseAStringRecursive(str.substring(1)) + str.charAt(0);
		}

	}
	
	// reversing an array
	public int[] reverseAnArray(int[] elements) {
		
		int left = 0;
		int right = elements.length -1;
		
		while (left < right) {
			
			int temp = elements[left];
			elements[left] = elements[right];
			elements[right] = temp;
		
			left++;
			right--;
		}
		
		return elements;
		
	}
	
	// BuzzFizz Solution
	public String buzzFizzNumber(int number) {
		if(number % 15 == 0) {
			return "BuzzFizz";
		} else if (number % 3 == 0) {
			return "Buzz";
		} else if (number % 5 == 0) {
			return "Fizz";
		} else {
			return Integer.toString(number);
		}
	}

	//Occurrence of a character in a string
	public String occurrenceOfCharInString(char string, String string2) {
		int count=0;
		for(int i = 0; i< string2.length(); i++){
			if(string2.charAt(i) == string){
				count++;
			}
		}
		
		return Integer.toString(count);
	}
	
	//Palindrome
	public String palindrome(String inputString) {
		String reverseString = this.reverseAStringRecursive(inputString);
		if(inputString.equals(reverseString)) {
			return "Is palindrome";
		} else {
			return "Not a palindrome";
		}
	}
	
	//anagrams
	public boolean isAnagram(String first, String second){
		char[] character = first.toCharArray();
		StringBuilder sbSecond = new StringBuilder(second);
		
		for(char ch : character){
			int index = sbSecond.indexOf("" + ch);
			if(index != -1) {
				sbSecond.deleteCharAt(index);
			} else {
				return false;
			}
		}
		return sbSecond.length() == 0 ? true : false;
	}
	
	// if the number is prime or not
	public boolean isPrime(int number) {
		int sqrt = (int) (Math.sqrt(number) + 1);
		for(int i =2; i< sqrt ; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}

}
