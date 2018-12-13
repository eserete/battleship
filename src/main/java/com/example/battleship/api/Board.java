package com.example.battleship.api;

import com.example.battleship.util.Matrices;

import java.util.*;

final class Board {

    private int[][] board;
    private Board child;
    private final Spaceship spaceship;
    private static final BoardService boardService = new BoardService();
    private static final Random random = new Random();

    private final LinkedList<Spaceship> shipsToPlace;

    Board() {
        this(
                newBoard(),
                new LinkedList<>(Arrays.asList(Spaceship.values()))
        );
    }

    Board(
            int[][] board,
            LinkedList<Spaceship> shipsToPlace) {
        this.board = board;
        this.shipsToPlace = shipsToPlace;
        if(!shipsToPlace.isEmpty()) {
            this.spaceship = shipsToPlace.removeFirst();
        } else {
            this.spaceship = null;
        }
    }

    private static int[][] newBoard() {
        int[][] newBoard = new int[16][16];
        for (int[] row : newBoard) {
            Arrays.fill(row, 0);
        }
        return newBoard;
    }

    boolean placeSpaceShipsOnBoard() {
        if (spaceship == null)
            return true;
        int[][] cells = Matrices.rotate(spaceship, random.nextInt(4));
        int row = random.nextInt(16);
        int column = random.nextInt(16);
        if (boardService.canShipBePlacedOnBoard(board, cells, row, column)) {
            int[][] newBoard = boardService.placeShipOnBoard(board, cells, row, column);
            child = new Board(newBoard, shipsToPlace);
            return child.placeSpaceShipsOnBoard();
        } else {
            return placeSpaceShipsOnBoard();
        }
    }

    int[][] get() {
        if(child == null) {
            return board;
        } else {
            return child.get();
        }
    }


}
