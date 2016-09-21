package ao222qc_assign2.Exercise4;

/**
 * Created by Adam on 2016-09-09.
 */

import ao222qc_assign2.Exercise4.QueueInterface;

import java.util.Iterator;

public class Queue<E> implements QueueInterface<E>
{
    private int size = 0;
    private Node head = null;
    private Node tail = null;

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
       return head == null && tail == null;
    }

    public void enqueue(E obj)
    {
        if(isEmpty())
        {
            head = new Node(obj);
            tail = head;
        }
        else
        {
            tail.next = new Node(obj);
            tail = tail.next;
        }
        size++;
    }

    public E dequeue() throws IndexOutOfBoundsException
    {
        if (isEmpty())
        {
            throw new IndexOutOfBoundsException("List is empty so you cannot dequeue.");
        }

        Node first = this.head;
        this.head = this.head.next;
        if(this.head == null)
        {
            this.tail = null;
        }
        size--;
        return first.getObjectVal(); //gets actual value stored in node
    }

    public E first() throws IndexOutOfBoundsException
    {
        if (isEmpty())
        {
            throw new IndexOutOfBoundsException("List is empty so you cannot fetch the first value.");
        }

        return head.getObjectVal();
    }

    public E last() throws IndexOutOfBoundsException
    {
        if(isEmpty())
        {
            throw new IndexOutOfBoundsException("List is empty so you cannot fetch the last value.");
        }

        return tail.getObjectVal();
    }

    public boolean contains(E o)
    {
        Iterator<E> iterator = iterator();

        while(iterator.hasNext())
        {
            if(o == iterator.next())
            {
                return true;
            }
        }
        return false;
    }

    public Iterator iterator()
    {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<E>
    {
        private Node node = head;
        public boolean hasNext()
        {
            return node != null;
        }
        public E next()
        {
            if(node != null)
            {
                E objVal = node.getObjectVal();
                node = node.next;
                return objVal;
            }
            else
            {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    private class Node
    {
        E obj;
        Node next = null;

        public Node(E obj)
        {
            this.obj = obj;
        }

        public E getObjectVal()
        {
            return this.obj;
        }
    }





}
