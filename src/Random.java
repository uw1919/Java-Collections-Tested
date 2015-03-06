/*
 * Random.java
 * 
 * @version
 * $Id: Simulator.java, Version 1.0 10/11/2014 $
 * 
 * @revision
 * $Log initial version $
 * 
 */

//import the required Collection implementations required in the program
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * This class uses implementations of Collections interface to print the
 * required output
 * 
 * @author Uday Vilas Wadhone
 * 
 *
 */
public class Random {

	// variable used to store random number
	double random;
	// make an object of type TreeSet
	TreeSet<Integer> treeSet = new TreeSet<>();
	// make an object of type HashSet
	HashSet<Integer> hashSet = new HashSet<>();
	// make an object of type LinkedList
	LinkedList<Integer> linkedList = new LinkedList<>();

	/**
	 * The main program takes the choice of the user and uses methods to
	 * calculate the required output
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		// create an object of type Random
		Random program = new Random();
		// output the options available to the user
		System.out.println("Select Option:");
		System.out.println("1. Random numbers in Ascending order. "
				+ "No repetitions"
						+ "\n2. Random Numbers without Repetitions. "
						+ "Constant Time performance"
						+ "\n3. Random numbers with repetitions."
						+ " Constant time performance\n");

		//make an object of type Scanner
		Scanner sc = new Scanner(System.in);
		//store the input as variable option
		int option = sc.nextInt();

		//call generate method to generate random numbers
		program.generate(option);
		//ask user if random numbers are to be printed
		System.out.println("Randomly generated numbers Stored. "
				+ "Enter 1 to Print");
		//store the choice entered by user as PrintChoice variable
		int PrintChoice = sc.nextInt();
		//print out the list of random numbers generated using PrintList method
		if (PrintChoice == 1) {
			program.PrintList(option);
		} else {
			//if option is not 1, exit the program
			System.out.println("System will exit");
			System.exit(0);
		}
		//close the scanner object
		sc.close();
	}

	/**
	 * Method to generate random numbers and add them to TreeSet/HashSet/Linked-
	 * List according to the option selected by the user
	 * 
	 * @param	 option		option selected by user
	 */
	void generate(int option) {
		/*
		 * for loop to generate 1000 random numbers and add them to required Set
		 * or List
		 */
		for (int i = 0; i < 1000; i++) {
			//variable value used to store the randomly generated number
			double value = Math.random() * 1000;
			//variable value is typecasted to Integer 
			int number = (int) value;
			/*
			 * according to user's option add the randomly generated number to
			 * Set or List 
			 */
			switch (option) {
			case 1:
				//add number to TreeSet
				treeSet.add(number);
				break;
			case 2:
				//add number to HashSet
				hashSet.add(number);
				break;
			case 3:
				//add number to LinkedList
				linkedList.add(number);
				break;
			}
		}
	}

	/**
	 * Method to print the list of numbers stored in the TreeSet/HashSet/Linked-
	 * List
	 * 
	 * @param	 option		
	 */
	void PrintList(int option) {
		//make an object of type Iterator to traverse through the List or Set
		Iterator<Integer> i = null;
		//according to the user's choice, use the interator to store numbers
		switch (option) {
		case 1:
			//make iterator object of TreeSet
			i = treeSet.iterator();
			break;
		case 2:
			//make iterator object of HashSet
			i = hashSet.iterator();
			break;
		case 3:
			//make iterator object of LinkedList
			i = linkedList.iterator();
			break;
		}
		int count = 1;
		//print out the list using the Interator
		while (i.hasNext()) {
			System.out.println((count++) + ": " + i.next().toString());
		}
	}

}
