package com.sebascompany.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessingGameTest {

    private GuessingGame game;

    @BeforeEach
    void setUp() {
        game = new GuessingGame();
    }

    @Test
    public void testSimpleWinningSituation() {
        int randomNum = game.getRandomNumber();
        String message = game.guess(randomNum);
        assertEquals("you got it! 1 try.", message);
    }

    @Test
    public void testOneWrongGuessNegativeSituation() {
        String message = game.guess(-5);
        assertEquals("you didn't get it! too low", message);
    }

    @Test
    public void testOneWrongGuessPositiveSituation() {
        int randomNum = game.getRandomNumber();
        String message = game.guess(randomNum + 1);
        assertEquals("you didn't get it! too high", message);
    }


    @Test
    public void testRandomNumberGeneration() {
        int[] randomNumCountArray = new int[11];
        for (int i = 0; i < 70; i++) {
            GuessingGame game = new GuessingGame();
            int randomNum = game.getRandomNumber();
            randomNumCountArray[randomNum] = 1;
        }
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            sum += randomNumCountArray[i];
        }
        assertEquals(10, sum);
    }


    @Test
    public void testFourWrongGuesses() {
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        String message = game.guess(-3);
        assertEquals("you did not get it. 4 tries are over", message);
    }

    @Test
    public void testThreeWrongGuessesAndOneCorrect() {
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        int correctAnswer = game.getRandomNumber();
        String message = game.guess(correctAnswer);
        assertEquals("you got it! 4 tries.", message);
    }


    @Test
    public void testTwoWrongGuessesAndOneCorrect() {
        game.guess(-3);
        game.guess(-3);
        int correctAnswer = game.getRandomNumber();
        String message = game.guess(correctAnswer);
        assertEquals("you got it! 3 tries.", message);
    }

    @Test
    public void testTenWrongGuesses() {
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);

        String message = game.guess(-3);
        assertEquals("Sorry. you only had 4 tries. and they are over!", message);
    }
}
