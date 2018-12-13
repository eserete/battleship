package com.example.battleship.api;

import com.example.battleship.util.Matrices;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class BoardTest {

    private int[][] newBoard;

    @Before
    public void setUp() {
        newBoard = new int[16][16];
        for (int[] row : newBoard) {
            Arrays.fill(row, 0);
        }
    }

    @Test
    public void noMoreSpaceShipsToPlace_true() {
        for (int[] row : newBoard) {
            Arrays.fill(row, 0);
        }
        LinkedList<Spaceship> spaceships = new LinkedList<>();
        Board board = new Board(
                newBoard,
                spaceships
        );
        boolean allShipsPlaced = board.placeSpaceShipsOnBoard();
        assertTrue(allShipsPlaced);
    }

    @Test
    public void oneShipPlacedSuccessfully_true() {
        LinkedList<Spaceship> spaceships = new LinkedList<>();
        spaceships.add(Spaceship.ANGLE);
        Board board = new Board(
                newBoard,
                spaceships
        );
        boolean allShipsPlaced = board.placeSpaceShipsOnBoard();
        Matrices.print(board.get());
        assertTrue(allShipsPlaced);
    }

    @Test
    public void allShipsPlacedSuccessfully_true() {
        Board board = new Board();
        boolean allShipsPlaced = board.placeSpaceShipsOnBoard();
        Matrices.print(board.get());
        assertTrue(allShipsPlaced);
    }

    @Test
    public void newBoard_ok() {
        Board board = new Board();
        Matrices.print(board.get());
        boolean allShipsPlaced = board.placeSpaceShipsOnBoard();
        Matrices.print(board.get());
        assertTrue(allShipsPlaced);
    }

}
