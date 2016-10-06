package ao222qc_assign1; /**
 * Created by Adam on 2016-08-29.
 */
import java.util.Scanner;

public class LargestK {

    public static void main(String args[])
    {
        largestK();
    }

    public static void largestK()
    {
        Scanner inputScanner = new Scanner(System.in);

        int maxVal = inputScanner.nextInt();

        int totalSum = 0;
        int tempVal = 0;

        while((totalSum + (tempVal + 2)) <= maxVal)
        {
            tempVal += 2;
            totalSum += tempVal;
        }
        System.out.print(tempVal);
    }
}
