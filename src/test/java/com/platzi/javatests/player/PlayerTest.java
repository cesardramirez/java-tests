package com.platzi.javatests.player;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PlayerTest {

    @Test
    public void playerLoses_whenNumberIsTooLow() {
        Dice dice = mock(Dice.class);
        // simulate a die that always returns 2
        when(dice.roll()).thenReturn(2);

        Player player = new Player(dice, 3);
        // the player will lose
        assertFalse(player.play());
    }

    @Test
    public void playerWins_whenNumberIsEqualOrHigh() {
        Dice dice = mock(Dice.class);
        // simulate a die that always returns 5
        when(dice.roll()).thenReturn(5);

        Player player = new Player(dice, 3);
        // the player will win
        assertTrue(player.play());
    }
}