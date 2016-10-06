package ao222qc_assign1; /**
 * Created by Adam on 2016-08-29.
 */

import java.util.Random;
import java.util.Scanner;

public class HighLow {

    private static int randomNumber;
    private static int amountofGuesses;
    private static final int MAX_GUESSES = 10;

    public static void main(String args[])
    {
        randomizeNumber();
        makeGuess();

    }

    private static void randomizeNumber()
    {
        Random rand = new Random();

        // 0 till 49, min 1, max 98 + 1
        int randomInteger = rand.nextInt(50);

        randomNumber = (randomInteger * 2) + 1;
    }

    private static void makeGuess()
    {
        Scanner scanner = new Scanner(System.in);
        int guess;

        System.out.printf("Make a guess between 1 and 100!");

        while(true)
        {
            if(amountofGuesses < MAX_GUESSES)
            {
                guess = scanner.nextInt();
                amountofGuesses += 1;

                if (guess > randomNumber) {
                    System.out.print("Hint: Lower");
                } else if (guess < randomNumber) {
                    System.out.print("Hint: Higher");
                } else {
                    System.out.print("Correct, after " + amountofGuesses + " guesses!");
                    break;
                }
            }
            else
            {
                System.out.printf("You failed after 10 guesses.");
                break;
            }
        }

    }
}
