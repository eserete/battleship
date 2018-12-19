package com.example.battleship.memory;

import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.stereotype.Component;

@Component
public class MemoryGameService extends ConcurrentMapCache {

    public MemoryGameService() {
        super("MemoryGameRepository");
    }


}