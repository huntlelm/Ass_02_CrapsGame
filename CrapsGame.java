import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    public static void main(String[] args) {

        // Variables and scanner
        int die1 = 0;
        int die2 = 0;
        int dieSum = 0;
        int point = 0;
        String playAgain = "";
        boolean programDone = false;
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);

        do {
            // Roll the dice
            die1 = rnd.nextInt(6) + 1;
            die2 = rnd.nextInt(6) + 1;
            dieSum = die1 + die2;

            System.out.println("Die 1: " + die1 + " | Die 2: " + die2 + " | Total: " + dieSum);

            // Roll Outcomes
            if (dieSum == 2 || dieSum == 3 || dieSum == 12) {
                // Crapped out (Loss)
                System.out.println("You crapped out with a " + dieSum + ". You lose!");
            } else if (dieSum == 7 || dieSum == 11) {
                // Natural (Win)
                System.out.println("Natural! You won with a " + dieSum );
            } else {
                // The point (roll again)
                point = dieSum;
                System.out.println("The point is now " + point + ". Rolling for point...");

                boolean pointOrSeven = false;

                // Subsequent rolls until point is made or a 7 is rolled
                while (!(pointOrSeven)) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    dieSum = die1 + die2;

                    System.out.println("Die 1: " + die1 + " | Die 2: " + die2 + " | Total: " + dieSum);

                    if (dieSum == point) {
                        System.out.println("Congratulations! you rolled the point and win!");
                        pointOrSeven = true;
                    } else if (dieSum == 7) {
                        System.out.println("You rolled a seven and lost!");
                        pointOrSeven = true;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            // Prompt user to play again
            System.out.print("Do you want to play again? (Y or N): ");
            playAgain = in.nextLine();

            if (!(playAgain.equalsIgnoreCase("Y"))) {
                programDone = true;
            }

        } while (!programDone);

        System.out.println("Thanks for playing Craps!");
    }
}