package Numberproject;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 5; // Set the maximum number of attempts
        int totalRounds = 3; // Set the total number of rounds
        int bestScore = Integer.MAX_VALUE;
        int totalScore = 0;

        boolean playAgain = true;
        while (playAgain) {
            int currentRound = 1;

            while (currentRound <= totalRounds) {
                System.out.println("Round " + currentRound + " / " + totalRounds);
                int secretNumber = random.nextInt(100) + 1;
                int attempts = 0;
                boolean hasGuessedCorrectly = false;

                System.out.println("Welcome to the Number Guessing Game!");
                System.out.println("Try to guess the secret number between 1 and 100.");
                System.out.println("You have " + maxAttempts + " attempts.");

                while (!hasGuessedCorrectly && attempts < maxAttempts) {
                    System.out.print("Enter your guess: ");
                    int guess = scanner.nextInt();
                    attempts++;

                    if (guess < secretNumber) {
                        System.out.println("Too low! Try again.");
                    } else if (guess > secretNumber) {
                        System.out.println("Too high! Try again.");
                    } else {
                        hasGuessedCorrectly = true;
                        System.out.println("Congratulations! You've guessed the secret number " + secretNumber + " correctly in " + attempts + " attempts.");

                        // Calculate score based on attempts
                        int roundScore = calculateScore(attempts);
                        System.out.println("Round Score: " + roundScore);
                        totalScore += roundScore;

                        if (attempts < bestScore) {
                            bestScore = attempts;
                            System.out.println("New best score! You solved it in " + attempts + " attempts.");
                        }
                    }
                }

                if (!hasGuessedCorrectly) {
                    System.out.println("Sorry, you've run out of attempts. The secret number was " + secretNumber + ".");
                }

                currentRound++;
            }

            System.out.println("End of game. Total score: " + totalScore);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Your best score was " + (bestScore == Integer.MAX_VALUE ? "N/A" : bestScore) + " attempts.");
        scanner.close();
    }

    // Custom method to calculate score based on attempts
    private static int calculateScore(int attempts) {
        if (attempts <= 3) {
            return 10;
        } else if (attempts <= 5) {
            return 7;
        } else if (attempts <= 7) {
            return 5;
        } else {
            return 3;
        }
    }
}



