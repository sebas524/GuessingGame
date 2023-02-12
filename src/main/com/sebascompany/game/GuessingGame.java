package com.sebascompany.game;

import org.w3c.dom.Text;

import java.util.Random;

public class GuessingGame {
    private final int randomNumber = new Random().nextInt(10) + 1;
    private int counter = 0;

    public String guess(int guessedNum) {

        counter++;
        String tryText = counter == 1 ? "try" : "tries";
        String winningMessage = String.format("you got it! %d %s.", counter, tryText);

        String response = null;

        if (counter == 4 && guessedNum != getRandomNumber()) {
            response = String.format("you did not get it. %d %s are over", counter, tryText);
        } else if (counter > 4) {
            response = "Sorry. you only had 4 tries. and they are over!";
        } else {
            String tooLowOrHighText = "";
            if (guessedNum < getRandomNumber()) {
                tooLowOrHighText = "too low";
            } else if (guessedNum > getRandomNumber()) {
                tooLowOrHighText = "too high";

            } else {
                tooLowOrHighText = "";
            }
            String loseText = String.format("you didn't get it! %s", tooLowOrHighText).trim();
            response = guessedNum == getRandomNumber() ? winningMessage : loseText;
        }

        return response;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public static void main(String[] args) {
        GuessingGame myGame = new GuessingGame();

        boolean loopShouldContinue = true;

        do {
            String input = System.console().readLine("enter a number:");
            if ("q".equals(input)) {
                return;
            }
            String output = myGame.guess(Integer.parseInt(input));
            System.out.println(output);
            if (output.contains("you got it") || output.contains("over")) {
                loopShouldContinue = false;
            }

        } while (loopShouldContinue);
    }
}

