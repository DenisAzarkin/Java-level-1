/*
 * TicTacToe.java
 * Java. Level 1. Lesson 4. Homework
 * 
 * Task 1 - Полностью разобраться с кодом, попробовать переписать с
 *   нуля, стараясь не подглядывать в методичку;
 * Task 2 - Переделать проверку победы, чтобы она не была реализована
 *   просто набором условий, например, с использованием циклов.
 * Task 2 - * Попробовать переписать логику проверки победы, чтобы он
 *   работала
 *   для поля 5х5 и количества фишек 4. Очень желательно не делать это
 *   просто набором условий для каждой из возможных ситуаций;
 * Task 4 - *** Доработать искусственный интеллект, чтобы он мог
 *   блокировать
 *   ходы игрока.
 * 
 * @author Denis Azarkin
 * @version Aug 24, 2018
 */

import java.util.Random;
import java.util.Scanner;

class TicTacToe {
    final int SIZE = 3; // Set 5 for 5x5
    final char DOT_X = 'x';
    final char DOT_O = 'o';
    final char DOT_EMPTY = '.';
    char[][] map = new char[SIZE][SIZE];
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    
    public static void main (String[] args) {
        new TicTacToe();
    }
    
    TicTacToe() {
        initMap();
        printMap();
        while (true) {
            
            humanTurn();
            if (checkWin(DOT_X)) {
                System.out.println("YOU WON!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry DRAW!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("AI WON!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry DRAW!");
                break;
            }
            
        }
        System.out.println("GAME OVER.");
        printMap();
    }
    
    void initMap() {
        for (int i = 0 ; i < SIZE; i++) {
            for (int j = 0 ; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    
    void printMap() {
        for (int i = 0 ; i < SIZE; i++) {
            for (int j = 0 ; j < SIZE; j++) 
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }
    
    void humanTurn() {
        int x, y;
        do {
            System.out.println("Enter X and Y (1..3):");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }
    
    void aiTurn(){
        int x, y;
        do {
            x = rand.nextInt(SIZE); // 0...2
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O;
    }
    
    boolean checkWin(char dot) {
        int d = 0;
        int t = 0;
        // check horisontals
        for (int i = 0; i < SIZE; i++) {
            t = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == dot) {
                    if (t == SIZE - 1) { // Set 2 for SIZE = 5
                        return true;
                    }
                    t++;
                }
            }
        }
        //check verticals
        for (int i = 0; i < SIZE; i++) {
            t = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == dot) {
                    if (t == SIZE - 1) { // Set 2 for SIZE = 5
                        return true;
                    }
                    t++;
                }
            }
        }
        //check diagonals
        t = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == dot) {
                    if (i == j) {
                        if (d == SIZE - 1) { // Set 2 for SIZE = 5
                            return true;
                        }
                        d++;
                    }
                    if (i + j == SIZE - 1) {
                        if (t == SIZE - 1) { // Set 2 for SIZE = 5
                            return true;
                        }
                        t++;
                    }
                }
            }
        }
        return false;
    }
    
    boolean isMapFull() {
        for (int i = 0 ; i < SIZE; i++) 
            for (int j = 0 ; j < SIZE; j++) 
                if(map[i][j] == DOT_EMPTY)
                    return false;
        return true;
    }
    
    boolean isCellValid (int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }
}


