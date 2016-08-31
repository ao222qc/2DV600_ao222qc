package ao222qc_assign1; /**
 * Created by Adam on 2016-08-29.
 */
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Backwards {

    public static void Reverse()
    {
        Scanner input_scanner = new Scanner(System.in);

        String user_input = input_scanner.nextLine();

        StringBuffer sb = new StringBuffer(user_input);

        System.out.printf(sb.reverse().toString());
    }
}
