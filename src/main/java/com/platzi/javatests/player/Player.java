package com.platzi.javatests.player;

public class Player {

    private Dice dice;
    private int minNumToWin;

    public Player(Dice dice, int minNumToWin) {
        this.dice = dice;
        this.minNumToWin = minNumToWin;
    }

    public boolean play() {
        int diceNum = dice.roll();
        return diceNum >= minNumToWin;
    }
}
