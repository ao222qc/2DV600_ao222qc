package ao222qc_assign2.Exercise5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Adam on 2016-09-23.
 */
public class WordCount2Main
{
    public static void main(String args[])
    {
        String path = "";
        if(args.length <= 0)
        {
            System.out.println("No file provided.");
        }
        else
            path = args[0];

        HashWordSet hws = new HashWordSet();
        TreeWordSet tws = new TreeWordSet();

        try
        {
            File file = new File(path);
            Scanner input = new Scanner(file);

            while(input.hasNext())
            {
                Word w = new Word(input.next());
                hws.add(w);
                tws.add(w);
            }
            input.close();

            Iterator it = tws.iterator();
            while(it.hasNext())
            {
                System.out.println(it.next());
            }

            System.out.println("HasWordSet size: " + hws.size());
            System.out.println("TreeWordSet size : " + tws.size());
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
