package ao222qc_assign1;

/**
 * Created by Adam on 2016-08-31.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Histogram {

    public static void main(String args[])
    {
        int oneTwentyFive = 0;
        int twentySixFifty = 0;
        int fiftyOneSeventyFive = 0;
        int seventySixOneHundred = 0;
        int oneHundredAndOneFifty = 0;
        int OneHundredAndFiftyOneTwoHundred = 0;
        int smallerOrBigger = 0;

        try
        {
            String path = "";

            if (args[0] != null)
            {
                path = args[0].toString();
            }
            else
            {
                //ERROR M8 NO PATH PROVIDED
            }
            Scanner input = new Scanner(System.in);
            File numbersFile = new File(path);
            input = new Scanner(numbersFile);

            while(input.hasNext())
            {
                if(input.hasNextInt())
                {
                    int currentNumber = input.nextInt();

                    if(currentNumber >= 1 && currentNumber <= 200)
                    {
                        if(currentNumber <= 25)
                        {
                            oneTwentyFive++;
                        }
                        else if(currentNumber <= 50)
                        {
                            twentySixFifty++;
                        }
                        else if(currentNumber <= 75)
                        {
                            fiftyOneSeventyFive++;
                        }
                        else if(currentNumber <= 100)
                        {
                            seventySixOneHundred++;
                        }
                        else if(currentNumber <= 150)
                        {
                            oneHundredAndOneFifty++;
                        }
                        else
                        {
                            OneHundredAndFiftyOneTwoHundred++;
                        }
                    }
                    else
                    {
                        smallerOrBigger++;
                    }
                }
                else
                {
                    input.next();
                }
            }

            System.out.println("1-25: " + oneTwentyFive);
            System.out.println("26-50: " + twentySixFifty);
            System.out.println("51-75: "+fiftyOneSeventyFive);
            System.out.println("76-100: " + seventySixOneHundred);
            System.out.println("101-150: " + oneHundredAndOneFifty);
            System.out.println("151-200: " + OneHundredAndFiftyOneTwoHundred);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
