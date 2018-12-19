package com.example.battleship.user;

import com.example.battleship.core.GameStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @GetMapping("/game/{gameId}")
    public GameStatus getStatus(String gameId){
        return null;
    }
}
