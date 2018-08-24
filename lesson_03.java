/*
 * lesson_03.java
 * Java. Level 1. Lesson 3. Homework
 * 
 * Task 1 - Написать программу, которая загадывает случайное число от 0
 * 	до 9, и пользователю дается 3 попытки угадать это число. При каждой
 * 	попытке компьютер должен сообщить больше ли указанное пользователем
 * 	число чем загаданное, или меньше. После победы или проигрыша
 * 	выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»
 * 	(1 – повторить, 0 – нет).
 * Task 2 - Создать массив из слов String[] words = {"apple", "orange",
 *	 "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
 * 	"cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
 * 	"mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
 * 	"pineapple", "pumpkin", "potato"};
 * 	При запуске программы компьютер загадывает слово, запрашивает ответ 
 * 	у пользователя, сравнивает его с загаданным словом и сообщает
 * 	правильно ли ответил пользователь. Если слово не угадано, компьютер
 * 	показывает буквы которые стоят на своих местах.
 * 	apple – загаданное
 * 	apricot - ответ игрока
 * 	ap############# (15 символов, чтобы пользователь не мог узнать длину
 * 	слова)
 * 	Для сравнения двух слов посимвольно, можно пользоваться:
 * 	String str = "apple";
 * 	str.charAt(0); - метод, вернет char, который стоит в слове str на
 * 	первой позиции
 * 	Играем до тех пор, пока игрок не отгадает слово
 * 	Используем только маленькие буквы
 * 
 * @author Denis Azarkin
 * @version Aug 19, 2018
 */
 
import java.util.Random;
import java.util.Scanner;

public class lesson_03 {
	// Main menu
	public static void main (String[] args) {
		Scanner chGame = new Scanner(System.in);
		boolean flagChooseGame = true;
		while (flagChooseGame) {
			System.out.println("Menu:");
			System.out.println("1. - Game 1 Guess the number");
			System.out.println("2. - Game 2 Guess the words");
			System.out.println("0. - Exit");
			System.out.print("> ");
			int b = chGame.nextInt();
			switch (b) {
				case 1 :
					guessTheNumber();
					break;
				case 2 :
					guessTheWords();
					break;
				case 0 :
					flagChooseGame = false;
					break;
				default :
					System.out.println("Input incorrect!");
			}
		}
	}
	// Game 1
	static void guessTheNumber () {
		Random rndNum = new Random();
		Scanner inputNum = new Scanner(System.in);
		Scanner scAnswer = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			int n = rndNum.nextInt(10);
			for (int i = 1; i < 4; i++) {
				System.out.println("Attempt " + i);
				System.out.print("Input number: ");
				int a = inputNum.nextInt();
				if (a > n) {
					System.out.println("This umber is less");
				}
				if (a < n) {
					System.out.println("This number is greater");
				}
				if (a == n) {
					System.out.println("You won!");
					break;
				}
			}
			System.out.println("You fail!");
			// Exit game
			boolean flagTryAgain = true;
			while (flagTryAgain) {
				System.out.print("Try again? 1 - Yes / 0 - No: ");
				int b = scAnswer.nextInt();
				switch (b) {
					case 1 :
						flag = true;
						flagTryAgain = false;
						break;
					case 0 :
						flagTryAgain = false;
						flag = false;
						break;
					default:
						System.out.println("Input incorrect!");
				}
			}
		}
	}
	// Game 2
	static void guessTheWords () {
			String[] words = {"apple", "orange", "lemon", "banana",
			"apricot", "avocado", "broccoli", "carrot", "cherry",
			"garlic", "grape", "melon", "leak", "kiwi", "mango",
			"mushroom", "nut", "olive", "pea", "peanut", "pear",
			"pepper", "pineapple", "pumpkin", "potato"};
		Random rndWord = new Random();
		Scanner inputWord = new Scanner(System.in);
		Scanner scAnswer = new Scanner(System.in);
		String w = ""; // Var for input word
		boolean flag = true;
		
		while (flag) {
			int r = rndWord.nextInt(words.length-1);
			boolean flag2 = true;
			System.out.println("Guess the word!");
			while (flag2) {
				System.out.print("Input the word: ");
				w = inputWord.nextLine();
				if (w.equals(words[r])) {
					System.out.println("You won!");
					flag2 = false;
				}
				else {
					System.out.println("You fail!");
					System.out.println(words[r].substring(0, 2)
					+ "###############");
				}
			}
			// Exit game
			boolean flagTryAgain = true;
			while (flagTryAgain) {
				System.out.print("Try again? 1 - Yes / 0 - No: ");
				int b = scAnswer.nextInt();
				switch (b) {
					case 1 :
						flag = true;
						flagTryAgain = false;
						break;
					case 0 :
						flagTryAgain = false;
						flag = false;
						break;
					default:
						System.out.println("Input incorrect!");
				}
			}
		}
	}
}
