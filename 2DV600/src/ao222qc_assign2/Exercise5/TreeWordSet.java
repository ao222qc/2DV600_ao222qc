package ao222qc_assign2.Exercise5;

import java.util.Iterator;

/**
 * Created by Adam on 2016-09-21.
 */
public class TreeWordSet implements WordSet
{
    private Node node;
    @Override
    public void add(Word word)
    {
        if(node == null)
        {
            node = new Node(word);
        }
        else
        {
           // if(word.compareTo(node.word))
        }

    }

    @Override
    public boolean contains(Word word)
    {
        return false;
    }

    @Override
    public int size()
    {
        return 0;
    }

    @Override
    public Iterator iterator()
    {
        return null;
    }

    private class Node
    {
        Node left, right;
        Word word;

        public Node(Word w){word = w;}

        @Override
        public String toString() {return word.toString();}
    }
}
