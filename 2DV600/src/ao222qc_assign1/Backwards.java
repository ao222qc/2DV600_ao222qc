package ao222qc_assign1; /**
 * Created by Adam on 2016-08-29.
 */
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Backwards {

    public static void main(String args[])
    {
        String userInput = readInputString();
        Reverse(userInput);
    }

    public static String readInputString()
    {
        Scanner inputScanner = new Scanner(System.in);
        return inputScanner.nextLine();
    }


    public static void Reverse(String str)
    {
        StringBuffer sb = new StringBuffer(str);

        System.out.printf(sb.reverse().toString());
    }
}
