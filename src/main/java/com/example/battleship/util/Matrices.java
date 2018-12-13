package com.example.battleship.util;

import com.example.battleship.api.Spaceship;

public final class Matrices {

    private Matrices(){}

    static int[][] rotate(int[][] input) {
        int rows = input.length;
        int columns = input[0].length;
        int[][] output = new int[columns][rows];
        for (int currentRow = 0; currentRow < rows; currentRow++) {
            for (int currentCol = 0; currentCol < columns; currentCol++) {
                output[currentCol][rows - 1 - currentRow] = input[currentRow][currentCol];
            }
        }
        return output;
    }

    public static void print(int[][] input) {
        int columns = input[0].length;
        for (int[] anInput : input) {
            StringBuilder line = new StringBuilder();
            for (int currentCol = 0; currentCol < columns; currentCol++) {
                line.append((anInput[currentCol] == 0) ? "- " : "* ");
            }
            System.out.println(line);
        }
        System.out.println("\n");
    }

    public static int[][] rotate(Spaceship spaceship, int numberOfRotations) {
        int[][] result = spaceship.get();
        for (int i = 0; i < numberOfRotations; i++) {
            result = rotate(result);
        }
        return result;
    }
}
