package ao222qc_assign2.Exercise5;

/**
 * Created by Adam on 2016-09-21.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
public class WordCount1Main
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

        HashSet<Word> hs = new HashSet();
        TreeSet<Word> ts = new TreeSet();
        try
        {
            File file = new File(path);
            Scanner input = new Scanner(file);

            while(input.hasNext())
            {
                Word w = new Word(input.next());
                hs.add(w);
                ts.add(w);
            }
            input.close();

            Iterator treeIterator = ts.iterator();

            while(treeIterator.hasNext())
            {
                System.out.println(treeIterator.next());
            }
            System.out.println("HashSet size: " + hs.size());
            System.out.println("TreeSet size: " + ts.size());
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
