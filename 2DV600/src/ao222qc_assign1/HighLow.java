package ao222qc_assign1; /**
 * Created by Adam on 2016-08-29.
 */

import java.util.Random;
import java.util.Scanner;

public class HighLow {

    private int random_number;
    private int amount_of_guesses;
    private static final int MAX_GUESSES = 10;

    public void HighLow()
    {
        this.RandomizeNumber();
        this.MakeGuess();

    }

    private void RandomizeNumber()
    {
        Random rand = new Random();

        // 0 till 49, min 1, max 98 + 1
        int random_integer = rand.nextInt(50);

        this.random_number = (random_integer * 2) + 1;

        System.out.print(this.random_number);
    }

    private void MakeGuess()
    {
        Scanner scanner = new Scanner(System.in);
        int guess;

        System.out.printf("Make a guess between 1 and 100!");

        while(true)
        {
            if(amount_of_guesses < MAX_GUESSES)
            {
                guess = scanner.nextInt();
                amount_of_guesses += 1;

                if (guess > random_number) {
                    System.out.print("Hint: Lower");
                } else if (guess < random_number) {
                    System.out.print("Hint: Higher");
                } else {
                    System.out.print("Correct, after " + amount_of_guesses + " guesses!");
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
