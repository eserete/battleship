package com.example.battleship.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;

class NewGameResponse {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("game_id")
    private String gameId;

    private String starting;

}
