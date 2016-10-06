package ao222qc_assign1;

/**
 * Created by Adam on 2016-08-30.
 */
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountChars {

    public static void main(String args[])
    {
        int upperCaseCounter = 0;
        int lowerCaseCounter = 0;
        int whiteSpaceCounter = 0;
        int otherCharsCounter = 0;
        int numberCounter = 0;

        try
        {
            String path = "";

            if(args.length > 0)
            {
                 path = args[0].toString();
            }
            else
            {
                throw new FileNotFoundException("No path has been provided. Please provide path to the main method.");
            }

            Scanner input = new Scanner(System.in);

            File textFile = new File(path);
            if(!textFile.exists())
            {
                throw new FileNotFoundException("File cannot be found. Please make sure your path is correct.");
            }
            System.out.println("Reading text file...");
            input = new Scanner(textFile);

            while(input.hasNextLine())
            {
                String line = input.nextLine();
                char currentChar;
                for(int i = 0; i < line.length(); i++)
                {
                    currentChar = line.charAt(i);

                    if(Character.isUpperCase(currentChar))
                    {
                        upperCaseCounter += 1;
                    }
                    else if(Character.isLowerCase(currentChar))
                    {
                        lowerCaseCounter += 1;
                    }
                    else if(Character.isWhitespace(currentChar))
                    {
                        whiteSpaceCounter += 1;
                    }
                    else if(Character.isDigit(currentChar))
                    {
                        numberCounter += 1;
                    }
                    else
                    {
                        otherCharsCounter += 1;
                    }
                }
            }
            input.close();

            System.out.println("Uppercase: " + upperCaseCounter);
            System.out.println("Lowecase: " + lowerCaseCounter);
            System.out.println("Whitespace: " + whiteSpaceCounter);
            System.out.println("Other characters: " + otherCharsCounter);
            System.out.println("Numbers: " + numberCounter);

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }


    }

}
