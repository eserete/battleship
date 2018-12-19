package com.example.battleship.core.spaceship;

public class SClass extends AbstractSpaceShip {

    private static int[][] initialStatus = new int[][]{
            {0, 1, 1, 0},
            {1, 0, 0, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 1},
            {0, 1, 1, 0},
    };

    public SClass() {
        super(initialStatus);
    }
}
