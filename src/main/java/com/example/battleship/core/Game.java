package com.example.battleship.core;

public class Game {

    private String id;

    private Player self;

    private Player opponent;

    private Protocol protocol;

    private GameStatus status;

    public String getId() {
        return id;
    }

    public Player getSelf() {
        return self;
    }

    public Player getOpponent() {
        return opponent;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public GameStatus getStatus() {
        return status;
    }
}
