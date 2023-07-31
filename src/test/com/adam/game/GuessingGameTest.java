package com.adam.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuessingGameTest {

    public static final int GAME_RANDOMNESS_TRIES = 100;
    private GuessingGame GAME;

    @BeforeEach
    void setUp() {
        GAME = new GuessingGame();
    }

    @Test
    public void testSimpleWin() {
        int randomNum = GAME.getRandomNumber();
        String message = GAME.guess(randomNum);
        assertEquals("You got it in 1 try", message);
    }

    @Test
    public void testOneWrongPositiveGuess() {
        int randomNum = GAME.getRandomNumber();
        String message = GAME.guess(randomNum + 1);
        assertEquals("You didn't get it - you're too high", message);
    }

    @Test
    public void testOneWrongNegativeGuess() {
        String message = GAME.guess(-1);
        assertEquals("You didn't get it - you're too low", message);
    }

    @Test
    public void testRandomNumberGeneration() {
        //1 2 3 4 5 6 7 8 9 10
        //1 1 1 1 0 1 0 1 0 1 = 10
        int[] randomNumbersCount = new int[10];
        for (int i = 0; i < GAME_RANDOMNESS_TRIES; i++) {
            //creating a local GAME object; to override -> use this.GAME
            GuessingGame GAME = new GuessingGame();
            int randomNumber = GAME.getRandomNumber();
            randomNumbersCount[randomNumber - 1] = 1;
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += randomNumbersCount[i];
        }

        assertEquals(10, sum);
    }

    @Test
    public void testFourWrongGuesses() {
        GAME.guess(-1);
        GAME.guess(-1);
        GAME.guess(-1);
        String lastGuessMessage = GAME.guess(-1);

        assertEquals("You didn't get it and you've had 4 tries. Game over.", lastGuessMessage);
    }

    @Test
    public void testThreeWrongGuessesAndOneCorrect() {
        int correctAnswer = GAME.getRandomNumber();

        GAME.guess(-1);
        GAME.guess(-1);
        GAME.guess(-1);
        String fourthGuessMessage = GAME.guess(correctAnswer);

        assertEquals("You got it in 4 tries", fourthGuessMessage);
    }

    @Test
    public void testTwoWrongGuessesAndOneCorrect() {
        int correctAnswer = GAME.getRandomNumber();

        GAME.guess(-1);
        GAME.guess(-1);
        String thirdGuessMessage = GAME.guess(correctAnswer);

        assertTrue(thirdGuessMessage.contains("3"), "Should indicate 3 tries");
        assertTrue(thirdGuessMessage.contains("You got it"), "Should indicate that we got the right number");
    }

    @Test
    public void testTenWrongGuesses() {
        GAME.guess(-1);
        GAME.guess(-1);
        GAME.guess(-1);
        GAME.guess(-1);
        GAME.guess(-1);
        GAME.guess(-1);
        GAME.guess(-1);
        GAME.guess(-1);
        GAME.guess(-1);
        String lastGuessMessage = GAME.guess(-1);

        assertEquals("Sorry, you are limited to only 4 tries. Game over.", lastGuessMessage);
    }


}
