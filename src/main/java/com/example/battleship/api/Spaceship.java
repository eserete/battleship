package com.example.battleship.api;

public enum Spaceship {
    WINGER(new int[][]{
            {1, 0, 1},
            {1, 0, 1},
            {0, 1, 0},
            {1, 0, 1},
            {1, 0, 1},
    }),
    ANGLE(new int[][]{
            {1, 0, 0},
            {1, 0, 0},
            {1, 0, 0},
            {1, 1, 1},
    }),
    A_CLASS(new int[][]{
            {0, 1, 0},
            {1, 0, 1},
            {1, 1, 1},
            {1, 0, 1},

    }),
    B_CLASS(new int[][]{
            {1, 1, 0},
            {1, 0, 1},
            {1, 1, 0},
            {1, 0, 1},
            {1, 1, 0},
    }),
    S_CLASS(new int[][]{
            {0, 1, 1, 0},
            {1, 0, 0, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 1},
            {0, 1, 1, 0},
    });

    private int[][] format;

    Spaceship(int[][] format) {
        this.format = format;
    }

    public int[][] get() {
        return format;
    }

}
