import java.util.Random;
import java.util.Scanner;

public class NumberGuessing_Game{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 7;
        int score = 0;

        System.out.println("Welcome to the Number22 Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("\nI have generated a number between " + minRange + " and " + maxRange + ". Guess it!");

            boolean guessedCorrectly = false;
            int attempts = 0;

            while (!guessedCorrectly && attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Your guess is out of the valid range. Please guess again.");
                    continue;
                }

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the number " + generatedNumber + " correctly.");
                    guessedCorrectly = true;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }

                attempts++;
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + generatedNumber);
            }

            // Calculate score based on attempts
            if (guessedCorrectly) {
                int roundScore = maxAttempts - attempts + 1;
                score += roundScore;
                System.out.println("Round Score: " + roundScore);
            }

            // Ask user if they want to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.nextLine().trim().toLowerCase();

            if (!playChoice.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Game Over. Your total score is: " + score);
        scanner.close();
    }
}