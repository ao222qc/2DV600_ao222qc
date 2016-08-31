package ao222qc_assign1; /**
 * Created by Adam on 2016-08-29.
 */
import java.util.Scanner;
public class CountDigits {

    public static void CountDigits()
    {
        Scanner input_scanner = new Scanner(System.in);

        int user_integer = input_scanner.nextInt();

        //String inputted_numbers_as_string = Integer.toString(user_integer);

        int amount_of_zeroes = 0;
        int amount_of_odds = 0;
        int amount_of_even = 0;
        int total_sum = 0;

        while(user_integer > 0)
        {
            int digit = user_integer % 10;
            total_sum += digit;
            if(digit == 0)
            {
                amount_of_zeroes += 1;
            }
            else if(digit % 2 != 0)
            {
                amount_of_odds += 1;
            }
            else
            {
                amount_of_even += 1;
            }

            user_integer /= 10;
        }

        System.out.printf("Zeroes: " + amount_of_zeroes + "\n"
                        + "Odd: " + amount_of_odds + "\n"
                        + "Even: " + amount_of_even + "\n"
                        + "Sum: " + total_sum);

    }

}
