package com.example.battleship.protocol;

import java.util.Objects;

class SpaceshipProtocol {

    private String hostname;

    private int port;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceshipProtocol that = (SpaceshipProtocol) o;
        return port == that.port &&
                Objects.equals(hostname, that.hostname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostname, port);
    }
}
