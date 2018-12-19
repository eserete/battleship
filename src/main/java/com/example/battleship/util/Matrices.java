package com.example.battleship.util;

public final class Matrices {

    private Matrices(){}

    public static int[][] rotate(int[][] input) {
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

    public static int[][] copy2dArray(int[][] input) {
            int length = input.length;
            int[][] target = new int[length][input[0].length];
            for (int i = 0; i < length; i++) {
                System.arraycopy(input[i], 0, target[i], 0, input[i].length);
            }
            return target;
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

    public static int[][] rotate(int[][] input, int numberOfRotations) {
        int[][] result = copy2dArray(input);
        for (int i = 0; i < numberOfRotations; i++) {
            result = rotate(result);
        }
        return result;
    }

    public static int[] hexadecimalToCoordinate(String hexadecimal) {
        String [] coordinates = hexadecimal.split("x");
        int x = Integer.parseInt(coordinates[0],16);
        int y = Integer.parseInt(coordinates[1],16);
        return new int[] {x, y};
    }

    public static String coordinateToHexadecimal(int x, int y) {
        return String.format("%sx%s", Integer.toHexString(x), Integer.toHexString(y));
    }
}
