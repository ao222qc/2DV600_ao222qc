package ao222qc_assign1; /**
 * Created by Adam on 2016-08-29.
 */
import java.util.Scanner;
public class Diamond {

    public static void MakeDiamonds() {
        Scanner input_scanner = new Scanner(System.in);
        System.out.printf("Please insert an odd number to get your diamond.");

        try
        {
            int input = input_scanner.nextInt();

            if(input % 2 == 0)
            {
                throw new Exception();
            }

        int midPoint = input / 2;

        int dotVal = 1;
        int dotInterval = 2;
        for (int i = 0; i < input; i++)
        {
            for(int k = 0; k < (input - dotVal)/2; k++)
            {
                System.out.printf(" ");
            }
            for(int k = 0; k < dotVal; k++)
            {
                System.out.printf("*");
            }

            dotVal += dotInterval;

            if(dotVal == input)
            {
                dotInterval = -2;
            }
            System.out.printf("\n");
        }
        }
        catch(Exception e)
        {
            System.out.printf("You have not inputted an odd number.");
        }
    }
}
