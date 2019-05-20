package com.platzi.javatests.player;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerTest {

    @InjectMocks
    Player player;

    @Mock
    Dice dice;

    @Test
    public void playerLoses_whenNumberIsTooLow() {
        // simulate a die that always returns 2
        when(dice.roll()).thenReturn(2);

        player = new Player(dice, 3);
        // the player will lose
        assertFalse(player.play());
    }

    @Test
    public void playerWins_whenNumberIsEqualOrHigh() {
        // simulate a die that always returns 5
        when(dice.roll()).thenReturn(5);

        player = new Player(dice, 4);
        // the player will win
        assertTrue(player.play());
    }
}