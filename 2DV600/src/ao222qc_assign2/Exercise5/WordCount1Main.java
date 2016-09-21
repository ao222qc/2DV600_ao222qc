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
        String path = "C:\\Users\\Adam\\IdeaProjects\\2DV600\\src\\ao222qc_assign2\\Exercise5\\words.txt";

        HashWordSet hws = new HashWordSet();
        HashSet<Word> hs = new HashSet();
        TreeSet<Word> ts = new TreeSet();

        Word w = new Word("helloo");
        Word w2 = new Word("helloo");

        System.out.println(w.compareTo(w2));



        /*
        try
        {

            File file = new File(path);
            Scanner input = new Scanner(file);

            while(input.hasNext())
            {
                Word w = new Word(input.next());
                hws.add(w);
                //hs.add(w);
                //ts.add(w);
            }
            input.close();

            System.out.println("HasWordSet size: " + hws.size());
            //System.out.println("HashSet size: " + hs.size());
            //System.out.println("TreeSet size: " + ts.size());

            Iterator it = hws.iterator();
            int count = 0;
            while(it.hasNext())
            {
                count++;
                System.out.println(it.next());
            }
            System.out.println(count);

            Iterator it = ts.iterator();
            while(it.hasNext())
            {
                System.out.println(it.next());
            }



        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        */

    }
}
