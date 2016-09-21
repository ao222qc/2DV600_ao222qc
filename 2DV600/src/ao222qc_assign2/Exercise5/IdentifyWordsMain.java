package ao222qc_assign2.Exercise5;

/**
 * Created by Adam on 2016-09-20.
 */

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class IdentifyWordsMain
{
    public static void main(String args[])
    {
        String path = "C:\\Users\\Adam\\IdeaProjects\\2DV600\\src\\ao222qc_assign2\\Exercise5\\HistoryOfProgramming.txt";

        try
        {
            Scanner input = new Scanner(System.in);

            File textFile = new File(path);
            if(!textFile.exists())
            {
                throw new FileNotFoundException("File cannot be found. Please make sure your path is correct.");
            }

            input = new Scanner(textFile);
            File file = new File("C:\\Users\\Adam\\IdeaProjects\\2DV600\\src\\ao222qc_assign2\\Exercise5\\words.txt");
            FileWriter writer;

            try
            {
                file.createNewFile();
                writer = new FileWriter(file);

                while(input.hasNextLine())
                {
                    writer.write(input.nextLine().replaceAll("[^A-Za-z\\s]", "") + "\n");
                }
                writer.flush();
                writer.close();
            }
            catch (IOException e)
            {
                System.out.println("Could not create file or filewriter.");
            }

        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }


    }
}
