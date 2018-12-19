package com.example.battleship.core;

import com.example.battleship.core.spaceship.Spaceship;
import com.example.battleship.util.Matrices;
import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class BoardBuilderTest {

    private Board BOARD_WITH_SPACESHIPS;

    @Before
    public void setup() {
        BOARD_WITH_SPACESHIPS = new Board.BoardBuilder().withSpaceships().build();
    }

    @Test
    public void newBoard_ok() {
        Matrices.print(BOARD_WITH_SPACESHIPS.getStatus());
        BOARD_WITH_SPACESHIPS.getSpaceships().stream().map(Spaceship::getStatus).forEach(Matrices::print);
        assertFalse(BOARD_WITH_SPACESHIPS.getSpaceships().isEmpty());
    }

    @Test
    public void newBoard_WithBoardStatus_ok() {
        assertNotNull(BOARD_WITH_SPACESHIPS.getStatus());
    }

    @Test
    public void newBoard_SpaceshipsWithCoordinates_ok() {
        Matrices.print(BOARD_WITH_SPACESHIPS.getStatus());
        assertTrue(BOARD_WITH_SPACESHIPS.getSpaceships()
                .stream()
                .allMatch(spaceship ->
                        Objects.nonNull(spaceship.getCoordinates())));
    }

}
