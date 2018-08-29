/*
 * TicTacToeAi.java
 * Java. Level 1. Lesson 4. Homework
 * 
 * Не хватило времени доделать 4 задание с ИИ, но начал примерно так:
 *   изменил метод aiTurn() так, чтобы O вставал третьим, если
 *   в строке два X
 * 
 * @author Denis Azarkin
 * @version Aug 24, 2018
 */

import java.util.Random;
import java.util.Scanner;

class TicTacToeAi {
    int memoryForStepX = 0;
    //int t = 0;
    final int SIZE = 3;
    final char DOT_X = 'x';
    final char DOT_O = 'o';
    final char DOT_EMPTY = '.';

    char[][] map = new char[SIZE][SIZE];
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    
    public static void main (String[] args) {
        new TicTacToeAi();
    }
    
    TicTacToeAi() {
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
        int i, j;
        do {
            System.out.println("Enter X and Y (1..3):");
            j = sc.nextInt() - 1;
            i = sc.nextInt() - 1;
        } while (!isCellValid(j, i));
        map[i][j] = DOT_X;
    }
    
    void aiTurn(){
        int x, y;
        int t = 0;
        // check horisontals
        for (int i = 0; i < SIZE; i++) {
            t = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_X) {
                    memoryForStepX++;
                    if (t == SIZE - 2) {
                        for (int k = 0; k < SIZE; k++) {
                            if (map[i][k] == DOT_EMPTY) {
                                map[i][k] = DOT_O;
                            }
                        }
                    }
                    if (memoryForStepX == 1) {
                        do {
                            x = rand.nextInt(SIZE); // 0...2
                            y = rand.nextInt(SIZE);
                        } while (!isCellValid(x, y));
                        map[y][x] = DOT_O;
                    }
                    t++;
                }
            }
        }
        // vertical
        t = 0;
        for (int i = 0; i < SIZE; i++) {
            t = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == DOT_X) {
                    memoryForStepX++;
                    if (t == SIZE - 2) {
                        for (int k = 0; k < SIZE; k++) {
                            if (map[k][i] == DOT_EMPTY) {
                                map[k][i] = DOT_O;
                            }
                        }
                    }
                    if (memoryForStepX == 1) {
                        do {
                            x = rand.nextInt(SIZE); // 0...2
                            y = rand.nextInt(SIZE);
                        } while (!isCellValid(x, y));
                        map[y][x] = DOT_O;
                    }
                    t++;
                }
            }
        }
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


