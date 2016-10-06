package ao222qc_assign1; /**
 * Created by Adam on 2016-08-29.
 */
import java.util.Scanner;
public class CountDigits {

    public static void main(String args[])
    {
        countDigits();
    }

    public static void countDigits()
    {
        Scanner inputScanner = new Scanner(System.in);

        int userInteger = inputScanner.nextInt();

        //String inputted_numbers_as_string = Integer.toString(user_integer);

        int amountofZeroes = 0;
        int amountOfOdds = 0;
        int amountOfEven = 0;
        int totalSum = 0;

        while(userInteger > 0)
        {
            //Get rest product modulu 10 to get the last digit of the number.
            int digit = userInteger % 10;
            totalSum += digit;
            if(digit == 0)
            {
                amountofZeroes += 1;
            }
            else if(digit % 2 != 0)
            {
                amountOfOdds += 1;
            }
            else
            {
                amountOfEven += 1;
            }

            //Divide int by 10 to remove last digit since it's already accounted for.
            userInteger /= 10;
        }

        System.out.printf("Zeroes: " + amountofZeroes + "\n"
                        + "Odd: " + amountOfOdds + "\n"
                        + "Even: " + amountOfEven + "\n"
                        + "Sum: " + totalSum);

    }

}
