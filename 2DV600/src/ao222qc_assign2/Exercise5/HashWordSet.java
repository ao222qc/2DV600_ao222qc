package ao222qc_assign2.Exercise5;

import java.util.Iterator;

/**
 * Created by Adam on 2016-09-21.
 */
public class HashWordSet implements WordSet
{
    private int size;
    private Node[] buckets = new Node[8];

    public HashWordSet(){size = 0;}

    private int getBucketNumber(Word word)
    {
        int hc = word.hashCode();
        if(hc < 0) hc = -hc;
        //System.out.println(hc % buckets.length);
        return hc % buckets.length;
    }

    @Override
    public void add(Word word)
    {
        int pos = getBucketNumber(word);
        Node node = buckets[pos];
        while(node != null)
        {
            if(node.word.equals(word))
                return;
            else
                node = node.next;
        }
        node = new Node(word);
        node.next = buckets[pos];
        buckets[pos] = node;
        size++;
        if (size == buckets.length) rehash ();
    }

    public void rehash()
    {
        Node[] temp = buckets;
        buckets = new Node[2*temp.length];
        size = 0;
        for (Node n : temp)
        {
            if(n == null)
            {
                continue;
            }
            while(n != null)
            {
                add(n.word);
                n = n.next;
            }
        }
    }

    @Override
    public boolean contains(Word word)
    {
        int pos = getBucketNumber(word);
        Node node = buckets[pos];
        while (node != null)
        {
            if(node.word.equals(word))
            {
                return true;
            }
            else
            {
                node = node.next;
            }
        }
        return false;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public Iterator iterator()
    {
        return new HashWordSetIterator();
    }

    class HashWordSetIterator implements Iterator<Word>
    {
        private Node nextNode;
        private int index = 0;

        //Constructor starts us with the first bucket that contains a/more node(s).
        //Sets nextNode to the first val in the found bucket.
        public HashWordSetIterator()
        {
            try
            {
                while (buckets[index] == null && index < size)
                {
                    index++;
                }
                nextNode = buckets[index];
            }
            catch (NullPointerException e)
            {
                System.out.println(e.getMessage());
            }
        }

        @Override
        public boolean hasNext()
        {
            return nextNode != null;
        }

        @Override
        public Word next()
        {
            Node toReturn = nextNode;
            if(nextNode.next != null)
            {
                nextNode = nextNode.next;
            }
            else
            {
                index++;
                while(buckets[index] == null && index < size)
                {
                    index++;
                }
                nextNode = buckets[index];
            }
            return toReturn.word;
        }
    }

    private class Node
    {
        private Word word;
        Node next = null;

        public Node(Word w)
        {
            word = w;
        }

        public String toString()
        {
            return word.toString();
        }
    }
}
