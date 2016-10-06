package ao222qc_assign1;

/**
 * Created by Adam on 2016-08-31.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Histogram {

    static String[] histogramData = {"1-10    : | ", "11-20   : | ", "21-30   : | ", "31-40   : | ", "41-50   : | ", "51-60   : | ", "61-70   : | ", "71-80   : | ", "81-90   : |", "91-100  : | ", "101-200 : | "};

    public static void main(String args[])
    {
        if(args.length > 0)
        {
            readIntegers(args[0]);
            printHistogram();
        }
        else
        {
            System.out.println("No path was supplied, please make sure you provide a path to a file.");
        }
    }

    public static void printHistogram()
    {
        for(String x : histogramData)
        {
            System.out.println(x);
        }
    }

    public static void readIntegers(String path)
    {
        try
        {
            Scanner input = new Scanner(System.in);
            File numbersFile = new File(path);
            input = new Scanner(numbersFile);

            while(input.hasNext())
            {
                if(input.hasNextInt())
                {
                    int currentNumber = input.nextInt();

                    if(currentNumber >= 1 && currentNumber <= 10)
                    {
                        histogramData[0] += "*";
                    }
                    else if(currentNumber <= 20)
                    {
                        histogramData[1] += "*";
                    }
                    else if(currentNumber <= 30)
                    {
                        histogramData[2] += "*";
                    }
                    else if(currentNumber <= 40)
                    {
                        histogramData[3] += "*";
                    }
                    else if(currentNumber <= 50)
                    {
                        histogramData[4] += "*";
                    }
                    else if(currentNumber <= 60)
                    {
                        histogramData[5] += "*";
                    }
                    else if(currentNumber <= 70)
                    {
                        histogramData[6] += "*";
                    }
                    else if(currentNumber <= 80)
                    {
                        histogramData[7] += "*";
                    }
                    else if(currentNumber <= 90)
                    {
                        histogramData[8] += "*";
                    }
                    else if(currentNumber <= 100)
                    {
                        histogramData[9] += "*";
                    }
                    else if(currentNumber <= 200)
                    {
                        histogramData[10] += "*";
                    }
                }
                else
                {
                    input.next();
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
