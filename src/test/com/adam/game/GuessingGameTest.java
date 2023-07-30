package com.adam.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessingGameTest {

    private GuessingGame GAME;

    @BeforeEach
    void setUp() {
        GAME = new GuessingGame();
    }

    @Test
    @Disabled
    public void testSimpleWin() {
        int randomNum = GAME.getRandomNumber();
        String message = GAME.guess(randomNum);
        assertEquals("You got it", message);
    }

    @Test
    public void testOneWrongPositiveGuess() {
        int randomNum = GAME.getRandomNumber();
        String message = GAME.guess(randomNum + 1);
        assertEquals("You didn't get it", message);
    }

    @Test
    public void testOneWrongNegativeGuess() {
        String message = GAME.guess(-1);
        assertEquals("You didn't get it", message);
    }

    @Test
    public void testRandomNumberGeneration() {
        //1 2 3 4 5 6 7 8 9 10
        //1 1 1 1 0 1 0 1 0 1 = 10
        int[] randomNumbersCount = new int[10];
        for (int i = 0; i < 100; i++) {
            int randomNumber = GAME.getRandomNumber();
            randomNumbersCount[randomNumber - 1] = 1;
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += randomNumbersCount[i];
        }
        System.out.println(sum);

        assertEquals(10, sum);
    }
}
