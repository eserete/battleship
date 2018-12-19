package com.example.battleship.core.spaceship;

public class BClass extends AbstractSpaceShip {

    private static int[][] initialStatus = new int[][]{
            {1, 1, 0},
            {1, 0, 1},
            {1, 1, 0},
            {1, 0, 1},
            {1, 1, 0},
    };

    public BClass() {
        super(initialStatus);
    }
}
