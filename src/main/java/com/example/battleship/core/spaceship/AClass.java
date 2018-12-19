package com.example.battleship.core.spaceship;

public class AClass extends AbstractSpaceShip {

    private static int[][] initialStatus = new int[][]{
            {0, 1, 0},
            {1, 0, 1},
            {1, 1, 1},
            {1, 0, 1},
    };

    public AClass() {
        super(initialStatus);
    }

}
