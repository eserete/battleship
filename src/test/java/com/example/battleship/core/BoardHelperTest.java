package com.example.battleship.core;

import com.example.battleship.core.Board.BoardBuilder;
import com.example.battleship.core.spaceship.AClass;
import com.example.battleship.core.spaceship.Angle;
import com.example.battleship.util.Matrices;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardHelperTest {

    @Test
    public void placeOnBoard_EmptySpaceship_EmptyBoard() {
        int [][] newBoard = BoardBuilder.BoardHelper
                .placeShipOnBoard(new BoardBuilder().build().getStatus(), new int[][]{}, 0, 0);
        Matrices.print(newBoard);
        assertTrue(Arrays.stream(newBoard).flatMapToInt(Arrays::stream).allMatch(value -> value == 0));
    }

    @Test
    public void placeOnBoard_OneBlock_ok() {
        int [][] newBoard = BoardBuilder.BoardHelper
                .placeShipOnBoard(new BoardBuilder().build().getStatus(), new int[][]{{1}}, 0, 0);
        int [][] expectedBoard = new BoardBuilder().build().getStatus();
        expectedBoard[0][0] = 1;
        Matrices.print(newBoard);
        assertTrue(Arrays.deepEquals(expectedBoard, newBoard));
    }

    @Test
    public void placeBlockAtSpecificPosition_ok() {
        int [][] newBoard = BoardBuilder.BoardHelper
                .placeShipOnBoard(new BoardBuilder().build().getStatus(), new int[][]{{1, 1}}, 3, 5);
        int [][] expectedBoard = new BoardBuilder().build().getStatus();
        expectedBoard[3][5] = 1;
        expectedBoard[3][6] = 1;
        Matrices.print(newBoard);
        assertTrue(Arrays.deepEquals(expectedBoard, newBoard));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void placeBlockOutOfBoundsOfTheBoard_IndexOutOfBoundsException() {
        int [][] newBoard = BoardBuilder.BoardHelper.placeShipOnBoard(new BoardBuilder().build().getStatus(), new int[][]{{1, 1}}, 1, 15);
        Matrices.print(newBoard);
    }

    @Test
    public void ignoreZeroValueOnBoard_ok() {
        int [][] newBoard = BoardBuilder.BoardHelper.placeShipOnBoard(new BoardBuilder().build().getStatus(), new int[][]{{1, 0}}, 3, 5);
        int [][] expectedBoard = new BoardBuilder().build().getStatus();
        expectedBoard[3][5] = 1;
        Matrices.print(newBoard);
        assertTrue(Arrays.deepEquals(expectedBoard, newBoard));
    }

    @Test
    public void ignoreZeroValueOnBoardAtBounds_ok() {
        int [][] spaceShip = new int[][]{
                {1, 0},
                {0, 0},
        };
        int [][] newBoard = BoardBuilder.BoardHelper.placeShipOnBoard(new BoardBuilder().build().getStatus(), spaceShip, 15, 15);
        int [][] expectedBoard = new BoardBuilder().build().getStatus();
        expectedBoard[15][15] = 1;
        Matrices.print(newBoard);
        assertTrue(Arrays.deepEquals(expectedBoard, newBoard));
    }

    @Test
    public void checkSpaceOnBoard_true() {
        boolean isThereSpace = BoardBuilder.BoardHelper.canShipBePlacedOnBoard(new BoardBuilder().build().getStatus(), new AClass().getStatus(), 0, 0);
        assertTrue(isThereSpace);
    }

    @Test
    public void checkSpaceOnBoard_false() {
        boolean isThereSpace = BoardBuilder.BoardHelper.canShipBePlacedOnBoard(new BoardBuilder().build().getStatus(), new Angle().getStatus(), 15, 15);
        assertFalse(isThereSpace);
    }

    @Test
    public void checkOverlapOnBoard_ok() {
        int[][] board = new BoardBuilder().build().getStatus();
        board = BoardBuilder.BoardHelper.placeShipOnBoard(board, new AClass().getStatus(), 0, 0);
        Matrices.print(board);
        boolean isThereSpace = BoardBuilder.BoardHelper.canShipBePlacedOnBoard(board, new AClass().getStatus(), 5, 5);
        assertTrue(isThereSpace);
    }

    @Test
    public void checkOverlapOnBoard_false() {
        int[][] board = new BoardBuilder().build().getStatus();
        board = BoardBuilder.BoardHelper.placeShipOnBoard(board, new AClass().getStatus(), 0, 0);
        boolean isThereSpace = BoardBuilder.BoardHelper.canShipBePlacedOnBoard(board, new AClass().getStatus(), 0, 0);
        assertFalse(isThereSpace);
    }


}
