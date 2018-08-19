/*
 * lesson_02.java
 * Java. Level 1. Lesson 2. Homework
 * 
 * Task 1 - Задать целочисленный массив, состоящий из элементов 0 и 1.
 * 	Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и
 * 	условия заменить 0 на 1, 1 на 0;
 * Task 2 - Задать пустой целочисленный массив размером 8. С помощью
 * 	цикла заполнить его значениями 0 3 6 9 12 15 18 21;
 * Task 3 - Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти
 * 	по нему циклом, и числа меньшие 6 умножить на 2;
 * Task 4 - Создать квадратный двумерный целочисленный массив
 * 	(количество строк и столбцов одинаковое), и с помощью цикла(-ов)
 * 	заполнить его диагональные элементы единицами;
 * Task 5 - ** Задать одномерный массив и найти в нем минимальный и
 * 	максимальный элементы (без помощи интернета);
 * Task 6 - ** Написать метод, в который передается не пустой одномерный
 * 	целочисленный массив, метод должен вернуть true если в массиве есть
 * 	место, в котором сумма левой и правой части массива равны. Примеры:
 * 	checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance
 * 	([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 10]) → true,
 * 	граница показана символами ||, эти символы в массив не входят.
 * Task 7 -**** Написать метод, которому на вход подается одномерный
 * 	массив и число n (может быть положительным, или отрицательным), при
 * 	этом метод должен сместить все элементымассива на n позиций. Для
 * 	усложнения задачи нельзя пользоваться вспомогательными массивами.
 * 
 * @author Denis Azarkin
 * @version Aug 15, 2018
 */

public class lesson_02 {
	public static void main (String[] args) {
		int arrTask1[] = {1,1,0,0,1,1,0,0};
		int arrTask2[] = new int[8];
		int arrTask3[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
		int arrTask4[][] = new int[3][3];
		int arrTask5[] = {2, 5, 3, 7, 4, 8, 9};
		int arrTask6[] = {1,1,1,2,1};
		int arrTask7[] = {1,2,3,4,5,6};
		doChangeArrayInt(arrTask1);
		doNullArrayInt(arrTask2);
		doLoopMultNum(arrTask3);
		doDoubleArrayDiag(arrTask4);
		doMinMaxArr(arrTask5);
		System.out.println("Task 6 - " + doCompareNumArray(arrTask6));
		doArrMove(arrTask7, 1); // 1 is default for n
	}
	// Task 1
	static void doChangeArrayInt (int arr[]) {
		int i = 0;
		System.out.print("Task 1 - ");
		for (i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				arr[i] = 0;
			}
			else {
				arr[i] = 1;
			}
			System.out.print("[" + arr[i] + "] ");
		}
		System.out.println();
	}
	// Task 2
	static void doNullArrayInt (int arr[]) {
		System.out.print("Task 2 - ");
		for (int i = 0, j = 0; i < 8; i++, j +=3) {
			arr[i] = j;
			System.out.print("[" + arr[i] + "] ");
		}
		System.out.println();
	}
	// Task 3
	static void doLoopMultNum (int arr[]) {
		System.out.print("Task 3 - ");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 6) {
				arr[i] *= 2;
			}
			System.out.print("[" + arr[i] + "]");
		}
		System.out.println();
	}
	// Task 4
	static void doDoubleArrayDiag (int arr[][]) {
		int t = 1;
		System.out.println("Task 4 - ");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = t++;
				if (j == i) arr[i][j] = 1;
				System.out.print("[" + arr[i][j] + "] ");
			}
			System.out.println();
		}
	}
	// Task 5
	static void doMinMaxArr (int arr[]) {
		int min, max;
		min = max = arr[0];
		int i = 0;
		System.out.println("Task 5 - ");
				for (i = 0; i < arr.length; i++) {
					System.out.print("[" + arr[i] + "]");
					if (min > arr[i]) {
						min = arr[i];
					}
					if (max < arr[i]) {
						max = arr[i];
					}
				}
		System.out.println(", Min = " + min + ", Max = " + max);
	}
	// Task 6
	static boolean doCompareNumArray (int arr[]) {
		int leftBitArr = 0; // Sum of left bit array
		int rightBitArr = 0; // Sum of rigth bit array
		int i = 0; // Count of left bit array
		int j = 0; // Count of right bit array
		// If the even length of the array
		if ((arr.length%2) != 0) {
			for (i = 0; i < (arr.length/2+1); i++) {
				leftBitArr = arr[i] + leftBitArr;
			}
			for (j = (arr.length-1); j != (arr.length/2); j--) {
				rightBitArr = arr[j] + rightBitArr;
			}
		}
		// If the even length of the array
		else {
			for (i = 0; i < (arr.length/2); i++) {
				leftBitArr = arr[i] + leftBitArr;
			}
			for (j = (arr.length-1); j != (arr.length/2-1); j--) {
				rightBitArr = arr[j] + rightBitArr;
			}
		}
		return leftBitArr == rightBitArr;
	}
	// Task 7
	static void doArrMove (int arr[], int n) {
		// Ex.: arr[] = {1,2,3,4,5,6} if (n = 1)
		int t = 0; // Temp var for first or last element of array
		int k = 0; // Counter for step loop
		int i = 0; // Var for iteration operations
		System.out.print("Task 7 - ");
		if (n>0) { // If n is positive
			while (k!=n) {
				k++;
				t = arr[arr.length-1]; //t=6
				for (i = 1; i < arr.length; i++) {
					arr[arr.length-i] = arr[(arr.length-i)-1];
				} //{1,2,3,4,5,5} for first step
				arr[0] = t;
			}
			
			t = 0; // Set default t
			k = 0; // Set default k
			i = 0; // Set default i
			
			while (i != arr.length) {
				System.out.print("[" + arr[i] + "]");
				i++;
			}
			i = 0; // Set default i
		}
		if (n<0) { // If n is negative
			while (k!=n) {
				k--;
				t = arr[0]; //t=1
				for (i = 0; i < arr.length-1; i++) {
					arr[i] = arr[i+1];
				} //{2,2,3,4,5,6} for first step
				arr[arr.length-1] = t;
			}
			
			t = 0; // Set default t
			k = 0; // Set default k
			i = 0; // Set default i
			
			while (i != arr.length) {
				System.out.print("[" + arr[i] + "]");
				i++;
			}
			i = 0; // Set default i
		}
		if (n == 0) { // If n is 0
			System.out.println("Input number != 0");
		}
	}
}
