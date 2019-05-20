package com.platzi.javatests.player;

import java.util.Random;

public class Dice {

    private int sides;

    public Dice(int sides) {
        this.sides = sides;
    }

    /**
     * (sides = 5): 0...5
     * @return (sides = 5): 1...5 (+1)
     */
    public int roll() {
        return new Random().nextInt(sides) + 1;
    }
}
