package ao222qc_assign2.Exercise5;

import ao222qc_assign2.Exercise4.Queue;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Adam on 2016-09-21.
 */
public class TreeWordSet implements WordSet
{
    private int size = 0;
    private Node root;
    public int leftHeight = 0;
    public int rightHeight = 0;


    //Word[] arrList; //ONLY used for testing balancing. Not used for any other solution in the assignment.


    @Override
    public void add(Word word)
    {
        if(root == null)
        {
            root = new Node(word);
            size++;
        }
        else
        {
            if (contains(word))
                return;
            size++;
            root.add(word);
        }

        //As mentioned, ONLY used for testing balancing.
        //Doesn't work anyway, sadly.
        /*if(max(leftHeight, rightHeight) > 0) //Balance if there's a difference when you add something, real picky.
        {
            balance();
        }*/
    }

    /*public void balance()
    {
        root = null;
        arrList = new Word[size];
        Iterator it = iterator();
        int count = 0;
        leftHeight = 0;
        rightHeight = 0;

        while(it.hasNext())
        {
            arrList[count] = (Word)it.next();
            count++;
        }
        //Adding values to new array, finding mid value and setting this to new root.
        add(arrList[arrList.length/2]);

        for(Word w : arrList)
        {
            add(w);
        }
    }
    */

    int max(int a, int b)
    {
        return (a >= b) ? a : b;
    }

    @Override
    public boolean contains(Word word) { return root.contains(word); }

    @Override
    public String toString()
    {
        String str = "";
        Iterator it = iterator();

        while(it.hasNext())
        {
            str += it.next();
        }
        return str;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public Iterator iterator()
    {
        return new TreeWordIterator();
    }

    class TreeWordIterator implements Iterator<Word>
    {
        Queue wordQueue = new Queue();  //Reusing Queue from Exercise 4.

        private TreeWordIterator()
        {
            try
            {
                if(root == null)
                    throw new NullPointerException("Tree has no values, root is empty");
                ascendingEnqueueWords(root);
            }
            catch (NullPointerException e)
            {
                System.out.println(e.getMessage());
            }
        }

        public void ascendingEnqueueWords(Node node) //Recursive left-to-right as in order print algorithm from slides, adding to queue.
        {
            if(node.left != null)
                ascendingEnqueueWords(node.left);
            wordQueue.enqueue(node.word);
            if(node.right!= null)
                ascendingEnqueueWords(node.right);
        }

        @Override
        public boolean hasNext()
        {
            return !wordQueue.isEmpty();
        }

        @Override
        public Word next()
        {
            return (Word)wordQueue.dequeue();
        }
    }

    private class Node
    {
        Node left = null, right = null;
        Word word;

        public Node(Word w){word = w;}

        public void add(Word w)
        {
            if(this.word.compareTo(w) > 0)
            {
                if(left == null)
                {
                    left = new Node(w);
                    leftHeight++;
                }
                else
                    left.add(w);
            }
            else if(this.word.compareTo(w) < 0)
            {
                if(right == null)
                {
                    right = new Node(w);
                    rightHeight++;
                }
                else
                    right.add(w);
            }
        }

        public boolean contains(Word w)
        {
            if(this.word.compareTo(w) > 0)
            {
                if (left == null)
                    return false;
                else
                    return left.contains(w);
            }
            else if (this.word.compareTo(w) < 0)
            {
                if (right == null)
                    return false;
                else
                    return right.contains(w);
            }
            return true;
        }

        public void print()
        {
            if(left != null)
                left.print();
            System.out.println(" " + word);
            if(right!= null)
                right.print();
        }
    }
}
