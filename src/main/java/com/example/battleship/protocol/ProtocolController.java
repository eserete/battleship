package com.example.battleship.protocol;

import com.example.battleship.core.Salvo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/protocol")
public class ProtocolController {

    private final GameService gameService;

    @Autowired
    public ProtocolController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/game/new")
    @ResponseStatus(HttpStatus.CREATED)
    public NewGameResponse newGame(NewGame newGameRequest) {
        return gameService.createNew(newGameRequest);
    }

    @PutMapping("/game/{gameId}")
    public SalvoResponse receiveSalvoOfShots(Salvo salvo) {
        return new SalvoResponse();
    }
}
