package ao222qc_assign1; /**
 * Created by Adam on 2016-08-29.
 */
import java.util.Scanner;

public class LargestK {

    public static void LargestK()
    {
        Scanner input_scanner = new Scanner(System.in);

        int max_val = input_scanner.nextInt();

        int total_sum = 0;
        int temp_val = 0;

        while((total_sum + (temp_val + 2)) <= max_val)
        {
            temp_val += 2;
            total_sum += temp_val;
        }
        System.out.print(temp_val);
    }
}
