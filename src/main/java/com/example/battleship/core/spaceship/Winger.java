package com.example.battleship.core.spaceship;

public class Winger extends AbstractSpaceShip {

    private static int[][] initialStatus = new int[][]{
            {1, 0, 1},
            {1, 0, 1},
            {0, 1, 0},
            {1, 0, 1},
            {1, 0, 1},
    };

    public Winger() {
        super(initialStatus);
    }
}
