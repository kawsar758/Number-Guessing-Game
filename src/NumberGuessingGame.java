// Save this file as NumberGuessingGame.java

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You will try to guess a number between 1 and 100.");
        System.out.println("Let's start!\n");

        int totalScore = 0;
        boolean playAgain;

        do {
            int randomNumber = random.nextInt(100) + 1; // Random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 10; // Set a limit on the number of attempts per round
            boolean guessedCorrectly = false;

            System.out.println("A new round begins! You have " + maxAttempts + " attempts to guess the number.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    int points = maxAttempts - attempts + 1; // Points based on remaining attempts
                    totalScore += points;
                    System.out.println("You earned " + points + " points. Total Score: " + totalScore);
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all attempts! The correct number was: " + randomNumber);
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thank you for playing! Your total score is: " + totalScore);
        scanner.close();
    }
}
