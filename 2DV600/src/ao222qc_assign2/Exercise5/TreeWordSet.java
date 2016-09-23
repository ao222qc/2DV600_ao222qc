package ao222qc_assign2.Exercise5;

import java.util.Iterator;

/**
 * Created by Adam on 2016-09-21.
 */
public class TreeWordSet implements WordSet
{
    private Node root;
    @Override
    public void add(Word word)
    {
        if(root == null)
        {
            root = new Node(word);
        }
        else
        {
            if (contains(word))
                return;
            root.add(word);
        }
    }


    public void print()
    {
        root.print();
    }

    @Override
    public boolean contains(Word word) { return root.contains(word); }

    @Override
    public int size()
    {
        return 0;
    }

    @Override
    public Iterator iterator()
    {
        return new TreeWordIterator();
    }

    class TreeWordIterator implements Iterator<Word>
    {
        Node currentNode;

        private TreeWordIterator()
        {
            currentNode = root;
            if(currentNode == null)
                return;
        }

        @Override
        public boolean hasNext()
        {
            return currentNode.left != null || currentNode.right != null;
        }

        @Override
        public Word next()
        {
            return null;
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
                    left = new Node(w);
                else
                    left.add(w);
            }
            else if(this.word.compareTo(w) < 0)
            {
                if(right == null)
                    right = new Node(w);
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
            System.out.println(" " + " " +word);
            if(right!= null)
                right.print();
        }

        @Override
        public String toString() {return word.toString();}
    }
}
