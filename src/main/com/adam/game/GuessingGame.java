package com.adam.game;

public class GuessingGame {
    public String guess(int guessedNumber) {
        return (guessedNumber == getRandomNumber()) ? "You got it" : "You didn't get it";
    }

    public int getRandomNumber() {
        int num = (int) Math.ceil(Math.random() * 10);
        return num;
    }
}
