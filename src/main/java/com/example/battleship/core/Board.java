package com.example.battleship.core;

import com.example.battleship.core.spaceship.*;
import com.example.battleship.util.Matrices;

import java.util.*;

public class Board {

    private int[][] status;

    private List<Spaceship> spaceships;

    public String[] receiveSalvo(String[] salvo) {
        String[] result = new String[salvo.length];
        for (int i = 0; i < salvo.length; i++) {
            int finalI = i;
            spaceships.forEach(spaceship -> {
                if (spaceship.hit(salvo[finalI])) {
                    result[finalI] = "hit";
                }
            });
        }
        return result;
    }

    private Board(int[][] status, List<Spaceship> spaceships) {
        this.status = status;
        this.spaceships = spaceships;
    }

    int[][] getStatus() {
        return status;
    }

    List<Spaceship> getSpaceships() {
        return spaceships;
    }

    final static class BoardBuilder {

        BoardBuilder withSpaceships() {
            if (placeSpaceShipsOnBoard()) {
                return this;
            }
            throw new RuntimeException("Could not place spaceships on board");
        }

        private int[][] board;
        private BoardBuilder child;
        private final Spaceship spaceship;
        private static final int BOARD_SIZE = 16;
        private static final int MAX_TRIES = 5;
        private static final Random RANDOM = new Random();

        private final LinkedList<Spaceship> shipsToPlace;

        BoardBuilder() {
            this(
                    newBoard(),
                    new LinkedList<>(Arrays.asList(
                            new AClass(),
                            new SClass(),
                            new Winger(),
                            new Angle(),
                            new BClass()
                    ))
            );
        }

        private BoardBuilder(
                int[][] board,
                LinkedList<Spaceship> shipsToPlace) {
            this.board = board;
            this.shipsToPlace = shipsToPlace;
            if (!shipsToPlace.isEmpty()) {
                this.spaceship = shipsToPlace.removeFirst();
            } else {
                this.spaceship = null;
            }
        }

        private static int[][] newBoard() {
            int[][] newBoard = new int[BOARD_SIZE][BOARD_SIZE];
            for (int[] row : newBoard) {
                Arrays.fill(row, 0);
            }
            return newBoard;
        }

        private boolean placeSpaceShipsOnBoard() {
            if (spaceship == null)
                return true;
            int[][] spaceShipCells = spaceship.getStatus();
            int boardRow = RANDOM.nextInt(BOARD_SIZE);
            int boardColumn = RANDOM.nextInt(BOARD_SIZE);
            if (BoardHelper.canShipBePlacedOnBoard(board, spaceShipCells, boardRow, boardColumn)) {
                spaceship.setBoardCoordinates(boardRow, boardColumn);
                int[][] newBoard = BoardHelper.placeShipOnBoard(board, spaceShipCells, boardRow, boardColumn);
                child = new BoardBuilder(newBoard, shipsToPlace);
                int tries = 0;
                while (tries < MAX_TRIES) {
                    boolean success = child.placeSpaceShipsOnBoard();
                    if (success)
                        return true;
                    tries++;
                }
                return false;
            } else {
                return placeSpaceShipsOnBoard();
            }
        }

        private int[][] getBoard() {
            return Optional.ofNullable(child).map(BoardBuilder::getBoard).orElse(board);
        }

        private List<Spaceship> getSpaceships() {
            return Optional.ofNullable(child).map(BoardBuilder::getSpaceships)
                    .map(spaceships -> {
                        spaceships.add(spaceship);
                        return spaceships;
                    })
                    .orElse(new ArrayList<>());
        }

        Board build() {
            return new Board(getBoard(), getSpaceships());
        }

        static final class BoardHelper {

            private BoardHelper() {
            }

            static int[][] placeShipOnBoard(int[][] board, int[][] spaceShip, int xAxis, int yAxis) {
                board = Matrices.copy2dArray(board);
                for (int spaceShipRow = 0; spaceShipRow < spaceShip.length; spaceShipRow++) {
                    for (int spaceShipCol = 0; spaceShipCol < spaceShip[spaceShipRow].length; spaceShipCol++) {
                        int cellValue = spaceShip[spaceShipRow][spaceShipCol];
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

            static boolean canShipBePlacedOnBoard(int[][] board, int[][] spaceShip, int xAxis, int yAxis) {
                for (int spaceShipRow = 0; spaceShipRow < spaceShip.length; spaceShipRow++) {
                    for (int spaceShipCol = 0; spaceShipCol < spaceShip[spaceShipRow].length; spaceShipCol++) {
                        int cellValue = spaceShip[spaceShipRow][spaceShipCol];
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

    }
}
