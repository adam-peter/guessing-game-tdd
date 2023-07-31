package com.adam.game;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    private final int randomNumber = new Random().nextInt(10) + 1;
    private int numberOfGuesses = 0;

    public String guess(int guessedNumber) {
        numberOfGuesses++;

        String tryText = numberOfGuesses == 1 ? "try" : "tries";
        String winningMessage = String.format("You got it in %d %s", numberOfGuesses, tryText);
        String response;

        if (numberOfGuesses == 4 && guessedNumber != getRandomNumber()) {
            response = String.format("You didn't get it and you've had %d %s. Game over.", numberOfGuesses, tryText);
        } else if (numberOfGuesses > 4) {
            response = "Sorry, you are limited to only 4 tries. Game over.";
        } else {
            String tooHighLowText;
            if (guessedNumber < getRandomNumber()) {
                tooHighLowText = "low";
            } else {
                tooHighLowText = "high";
            }
            String loseText = String.format("You didn't get it - you're too %s", tooHighLowText);
            response = guessedNumber == getRandomNumber() ? winningMessage : loseText;
        }

        return response;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        Scanner scan = new Scanner(System.in);
        boolean loopShouldContinue = true;

        do {
            System.out.print("Enter a number: ");
            String input = scan.nextLine();
            if ("q".equals(input)) {
                loopShouldContinue = false;
                continue;
            }
            String output = game.guess(Integer.parseInt(input));
            System.out.println(output);

            if (output.contains("You got it") || output.contains("over")) {
                loopShouldContinue = false;
            }
        } while (loopShouldContinue);
    }
}
