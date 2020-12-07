package com.company;

import java.util.Random;
import java.util.Scanner;

public class Guess {

    private static final int GUESS_MIN_BOUND = 1;
    private static final int GUESS_MAX_BOUND = 100;
    private static final int NUMBER_OF_ATTEMPTS = 5;

    public void startGame() {
        int gameCount = 0;
        boolean endGame = false;
        int guessThisNumber = new Random().nextInt(GUESS_MAX_BOUND) + 1;

        Scanner scanner = new Scanner(System.in);
        while (gameCount <= NUMBER_OF_ATTEMPTS && !endGame) {
            int userInput = getUserInput(scanner,"Pick a number between " +
                                                        GUESS_MIN_BOUND + " and " + GUESS_MAX_BOUND);
            if (isValidInput(userInput)) {
                boolean guessedRight = playGame(guessThisNumber, userInput);
                if (guessedRight) {
                    endGame = true;
                } else {
                    gameCount++;
                    if (gameCount == NUMBER_OF_ATTEMPTS) {
                        System.out.println("You lose!");
                        System.out.println("The number to guess was: " + guessThisNumber);
                        endGame = true;
                    }
                }
            } else {
                System.out.println("Your guess is not between "
                                                +  GUESS_MIN_BOUND +  " and " + GUESS_MAX_BOUND + ", please try again");
            }
        }
    }


    public int getUserInput(Scanner scanner, String message) {
        int returnUserInput = 0;
        if(!message.equalsIgnoreCase("")){
            System.out.println(message);
        }
        String inputValue = scanner.nextLine();
        if (!inputValue.equals("")){
            returnUserInput = Integer.parseInt(inputValue);
        }

        return returnUserInput;

    }

    public boolean isValidInput(int userInput) {
        boolean returnValidInput = false;
        if (userInput >= GUESS_MIN_BOUND && userInput <= GUESS_MAX_BOUND) {
            returnValidInput = true;
        }
        return returnValidInput;

    }

    public boolean playGame(int guessThisNumber, int userInput) {
        boolean returnPlayGame = false;
        if (userInput > guessThisNumber) {
            System.out.println("Please pick a lower number");
        } else if (userInput < guessThisNumber) {
            System.out.println("Please pick a higher number");

        } else {
            System.out.println("“You win!");
            returnPlayGame = true;
        }
        return returnPlayGame;
    }
}
