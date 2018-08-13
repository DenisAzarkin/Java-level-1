/*
 * lesson_01.java
 * Java. Level 1. Lesson 1. Homework
 * 
 * Task1 - Create an empty project in IntelliJ IDEA and set the main();
 * 	method.
 * Task2 - Create variables of all passed data types, and initialize
 * 	their values.
 * Task3 - Write a method that calculates the expression a*(b+(c/d))
 * 	and returns the result, where a, b, c, d are the input parameters of
 * 	this method.
 * Task4 - Write a method that takes two numbers at the input and checks
 * 	that their sum is between 10 and 20 (inclusive), if yes - return
 * 	true, otherwise - false.
 * Task5 - Write a method to which an integer is passed as a parameter,
 * 	the method should print to the console whether the positive number is
 * 	passed, or negative. Impotant: zero is considered a positive number.
 * Task6 - Write a method that takes an integer as a parameter, the
 * 	method must return true if the number is negative.
 * Task7 - Write a method that passed a string idicating the name as
 * 	a parameter, the method should uotput in the console the message
 * 	"Привет, указанное_имя!".
 * Task8 - Write a method that calculate a year is a leak-year, and
 * 	print a message to the console. Each 4 year is a leap year, except
 * 	for every 100, with each 400 being a leap-year.
 * 
 * @author Denis Azarkin
 * @version Aug 11, 2018
 */

public class lesson_01 {
	
	public static void main (String[] args) {
		System.out.println("Task 1 - Done");
		System.out.println("Task 2 - Done");
		System.out.println("Task 3 - " + task3(2,4,8,16));
		System.out.println("Task 4 - " + task4(7,8));
		System.out.println("Task 5 - " + task5(4));
		System.out.println("Task 6 - " + task6(-8));
		System.out.println("Task 7 - " + task7("Username"));
		System.out.println("Task 8 - " + task8(2020));
	}
	// Task 1
	static void task1 (String[] args) {
		return;
	}
	// Task 2
	static void task2 () {
		byte a = 8;
		short b = 16;
		int c = 32;
		long d = 64;
		float e = 3.1f;
		double f = 3.1415;
		boolean g = true;
		char h = 'A';
	}
	// Task 3
	static int task3 (int a, int b, int c, int d) {
		return(a*(b+(c/d)));
	}
	// Task 4
	static boolean task4 (int a, int b) {
		return (((10<=(a+b))&&((a+b)<=20)) ? true : false);
	}
	// Task 5
	static String task5 (int a) {
		return ((a>=0) ? "Positive number" : "Negative number");
	}
	// Task 6
	static boolean task6 (int a) {
		return ((a<0) ? true : false);
	}
	// Task 7
	static String task7 (String a) {
		return ("Привет, " + a + "!");
	}
	// Task 8
	static String task8 (int a) {
		if ((a%4)==0) {
			if ((a%100)==0) {
				if ((a%400)==0) {
					return(a + " is a leap-year");
				}
				else {
					return(a + " is not a leap-year");
				}
			}
			else {
				return(a + " is a leap-year");
			}
		}
		else {
			return(a + " is not a leap-year");
		}
	}
}
