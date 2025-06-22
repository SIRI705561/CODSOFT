import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 7;
        int totalScore = 0;
        int roundsPlayed = 0;
        boolean playAgain;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            roundsPlayed++;
            int numberToGuess = random.nextInt(100) + 1; // Random number from 1 to 100
            int attempts = 0;
            boolean hasWon = false;

            System.out.println("\nRound " + roundsPlayed + ": I'm thinking of a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts && !hasWon) {
                System.out.print("Enter your guess: ");
                int guess;
                try {
                    guess = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                    continue;
                }

                attempts++;

                if (guess < 1 || guess > 100) {
                    System.out.println("Please guess a number between 1 and 100.");
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    hasWon = true;
                    int points = 100 - (attempts * 10); // Score: 100 minus 10 per attempt
                    totalScore += points;
                    System.out.println("Correct! You guessed it in " + attempts + " attempts.");
                    System.out.println("You earned " + points + " points this round!");
                }
            }

            if (!hasWon) {
                System.out.println("Out of attempts! The number was " + numberToGuess + ".");
            }

            System.out.println("Your current score: " + totalScore + " points.");
            System.out.print("\nWould you like to play another round? (yes/no): ");
            playAgain = sc.nextLine().trim().toLowerCase().startsWith("y");

        } while (playAgain);

        System.out.println("\nGame Over! You played " + roundsPlayed + " round(s).");
        System.out.println("Final Score: " + totalScore + " points.");
        System.out.println("Thanks for playing!");
        sc.close();
    }
}