package com.example.battleship.core.spaceship;

public interface Spaceship {

    public String getCoordinates();

    public boolean isDestroyed();

    int[][] getStatus();

    boolean hit(String shotCoordinates);

    void setBoardCoordinates(int row, int column);
}
