package ao222qc_assign2.Exercise5;

/**
 * Created by Adam on 2016-09-21.
 */
import sun.reflect.generics.tree.Tree;

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

        HashWordSet hws = new HashWordSet();
        TreeWordSet tws = new TreeWordSet();
        HashSet<Word> hs = new HashSet();
        TreeSet<Word> ts = new TreeSet();

        tws.add(new Word("c"));
        tws.add(new Word("a"));
        tws.add(new Word("d"));
        tws.add(new Word("b"));
        //tws.print();

        Iterator it = tws.iterator();
        //while(it.hasNext())
        //{
            System.out.println(it.next());
        //}




        //Iterator iterator = tws.iterator();

        //iterator.next();

        try
        {

            File file = new File(path);
            Scanner input = new Scanner(file);

            while(input.hasNext())
            {
                Word w = new Word(input.next());
                hws.add(w);
                hs.add(w);
                ts.add(w);
               // tws.add(w);
            }
            input.close();

            System.out.println("HasWordSet size: " + hws.size());
            System.out.println("HashSet size: " + hs.size());
            System.out.println("TreeSet size: " + ts.size());
           // tws.print();

            /*Iterator it = hws.iterator();
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
            }*/
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
