package com.example.battleship.api;

import com.example.battleship.util.Matrices;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardServiceTest {

    private BoardService boardService = new BoardService();

    @Test
    public void placeOnBoard_EmptySpaceship_EmptyBoard() {
        int [][] newBoard = boardService.placeShipOnBoard(new Board().get(), new int[][]{}, 0, 0);
        Matrices.print(newBoard);
        assertTrue(Arrays.stream(newBoard).flatMapToInt(Arrays::stream).allMatch(value -> value == 0));
    }

    @Test
    public void placeOnBoard_OneBlock_ok() {
        int [][] newBoard = boardService.placeShipOnBoard(new Board().get(), new int[][]{{1}}, 0, 0);
        int [][] expectedBoard = new Board().get();
        expectedBoard[0][0] = 1;
        Matrices.print(newBoard);
        assertTrue(Arrays.deepEquals(expectedBoard, newBoard));
    }

    @Test
    public void placeBlockAtSpecificPosition_ok() {
        int [][] newBoard = boardService.placeShipOnBoard(new Board().get(), new int[][]{{1, 1}}, 3, 5);
        int [][] expectedBoard = new Board().get();
        expectedBoard[3][5] = 1;
        expectedBoard[3][6] = 1;
        Matrices.print(newBoard);
        assertTrue(Arrays.deepEquals(expectedBoard, newBoard));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void placeBlockOutOfBoundsOfTheBoard_IndexOutOfBoundsException() {
        int [][] newBoard = boardService.placeShipOnBoard(new Board().get(), new int[][]{{1, 1}}, 1, 15);
        Matrices.print(newBoard);
    }

    @Test
    public void ignoreZeroValueOnBoard_ok() {
        int [][] newBoard = boardService.placeShipOnBoard(new Board().get(), new int[][]{{1, 0}}, 3, 5);
        int [][] expectedBoard = new Board().get();
        expectedBoard[3][5] = 1;
        Matrices.print(newBoard);
        assertTrue(Arrays.deepEquals(expectedBoard, newBoard));
    }

    @Test(expected = IllegalArgumentException.class)
    public void overlapSpaceshipsOnBoard_Exception() {
        int [][] newBoard = boardService.placeShipOnBoard(new Board().get(), Spaceship.ANGLE, 0, 0);
        boardService.placeShipOnBoard(newBoard, Spaceship.ANGLE, 0, 0);
    }

    @Test
    public void ignoreZeroValueOnBoardAtBounds_ok() {
        int [][] spaceShip = new int[][]{
                {1, 0},
                {0, 0},
        };
        int [][] newBoard = boardService.placeShipOnBoard(new Board().get(), spaceShip, 15, 15);
        int [][] expectedBoard = new Board().get();
        expectedBoard[15][15] = 1;
        Matrices.print(newBoard);
        assertTrue(Arrays.deepEquals(expectedBoard, newBoard));
    }

    @Test
    public void checkSpaceOnBoard_true() {
        boolean isThereSpace = boardService.canShipBePlacedOnBoard(new Board().get(), Spaceship.A_CLASS, 0, 0);
        assertTrue(isThereSpace);
    }

    @Test
    public void checkSpaceOnBoard_false() {
        boolean isThereSpace = boardService.canShipBePlacedOnBoard(new Board().get(), Spaceship.ANGLE, 15, 15);
        assertFalse(isThereSpace);
    }

    @Test
    public void checkOverlapOnBoard_ok() {
        int[][] board = new Board().get();
        board = boardService.placeShipOnBoard(board, Spaceship.A_CLASS, 0, 0);
        Matrices.print(board);
        boolean isThereSpace = boardService.canShipBePlacedOnBoard(board, Spaceship.S_CLASS, 5, 5);
        assertTrue(isThereSpace);
    }

    @Test
    public void checkOverlapOnBoard_false() {
        int[][] board = new Board().get();
        board = boardService.placeShipOnBoard(board, Spaceship.A_CLASS, 0, 0);
        boolean isThereSpace = boardService.canShipBePlacedOnBoard(board, Spaceship.S_CLASS, 0, 0);
        assertFalse(isThereSpace);
    }


}
