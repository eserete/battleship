package com.example.battleship.core.spaceship;

public class Angle extends AbstractSpaceShip {

    private static int[][] initialStatus = new int[][]{
            {1, 0, 0},
            {1, 0, 0},
            {1, 0, 0},
            {1, 1, 1},
    };

    public Angle() {
        super(initialStatus);
    }
}
