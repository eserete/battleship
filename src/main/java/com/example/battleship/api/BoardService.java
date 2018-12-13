package com.example.battleship.api;

import java.util.Arrays;

final class BoardService {

    static int[][] newBoard() {
        int[][] newBoard = new int[16][16];
        for (int[] row : newBoard) {
            Arrays.fill(row, 0);
        }
        return newBoard;
    }

    int[][] placeShipOnBoard(int[][] board, int[][] cells, int xAxis, int yAxis) {
        for (int spaceShipRow = 0; spaceShipRow < cells.length; spaceShipRow++) {
            for (int spaceShipCol = 0; spaceShipCol < cells[spaceShipRow].length; spaceShipCol++) {
                int cellValue = cells[spaceShipRow][spaceShipCol];
                if (cellValue == 0)
                    continue;
                int boardX = spaceShipRow + xAxis;
                int boardY = spaceShipCol + yAxis;
                int boardCell = board[boardX][boardY];
                if (boardCell == 1)
                    throw new IllegalArgumentException(String.format("This place is not empty %d:%d", boardX, boardY));
                board[boardX][boardY] = cellValue;
            }
        }
        return board;
    }

    int[][] placeShipOnBoard(int[][] board, Spaceship spaceship, int xAxis, int yAxis) {
        return this.placeShipOnBoard(board, spaceship.get(), xAxis, yAxis);
    }

    boolean canShipBePlacedOnBoard(int[][] board, Spaceship spaceship, int xAxis, int yAxis) {
        return this.canShipBePlacedOnBoard(board, spaceship.get(), xAxis, yAxis);
    }

    boolean canShipBePlacedOnBoard(int[][] board, int[][] cells, int xAxis, int yAxis) {
        for (int spaceShipRow = 0; spaceShipRow < cells.length; spaceShipRow++) {
            for (int spaceShipCol = 0; spaceShipCol < cells[spaceShipRow].length; spaceShipCol++) {
                int cellValue = cells[spaceShipRow][spaceShipCol];
                if (cellValue == 0)
                    continue;
                int boardX = spaceShipRow + xAxis;
                int boardY = spaceShipCol + yAxis;
                boolean brokeXBoardLimit = boardX >= board.length;
                if (brokeXBoardLimit) {
                    return false;
                }
                boolean brokeYBoardLimit = boardY >= board[boardX].length;
                if (brokeYBoardLimit)
                    return false;
                int boardCell = board[boardX][boardY];
                if (boardCell == 1)
                    return false;
            }
        }
        return true;
    }

}
