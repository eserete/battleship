package com.example.battleship.core.spaceship;

import com.example.battleship.util.Matrices;

import java.util.Random;

public abstract class AbstractSpaceShip implements Spaceship {

    private static final Random RANDOM = new Random();

    boolean destroyed;

    private int[][] status;

    private String coordinates;

    private int boardCoordinateX;
    private int boardCoordinateY;

    AbstractSpaceShip(int[][] initialStatus) {
        this.status = Matrices.rotate(initialStatus, RANDOM.nextInt(4));
    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    @Override
    public String getCoordinates() {
        return coordinates;
    }

    @Override
    public int[][] getStatus() {
        return Matrices.copy2dArray(status);
    }

    @Override
    public boolean hit(String shotCoordinates) {
        int [] coordinates = Matrices.hexadecimalToCoordinate(shotCoordinates);
        int x = coordinates[0];
        int y = coordinates[1];
        return status[x][y] == 1;
    }

    @Override
    public void setBoardCoordinates(int row, int column) {
        this.boardCoordinateX = row;
        this.boardCoordinateY = column;
        this.coordinates = Matrices.coordinateToHexadecimal(row, column);
    }
}
