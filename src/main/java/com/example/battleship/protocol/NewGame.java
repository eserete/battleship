package com.example.battleship.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

class NewGame {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("spaceship_protocol")
    private SpaceshipProtocol spaceshipProtocol;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public SpaceshipProtocol getSpaceshipProtocol() {
        return spaceshipProtocol;
    }

    public void setSpaceshipProtocol(SpaceshipProtocol spaceshipProtocol) {
        this.spaceshipProtocol = spaceshipProtocol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewGame that = (NewGame) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(spaceshipProtocol, that.spaceshipProtocol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, fullName, spaceshipProtocol);
    }
}
