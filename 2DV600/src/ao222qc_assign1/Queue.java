package ao222qc_assign1;

/**
 * Created by Adam on 2016-09-09.
 */
import java.util.Iterator;

public class Queue implements QueueInterface
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

    public void enqueue(Object obj)
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

    public Object dequeue() throws IndexOutOfBoundsException
    {
        try
        {
            if (isEmpty())
            {
                throw new IndexOutOfBoundsException("List is empty so you cannot dequeue.");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
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

    public Object first() throws IndexOutOfBoundsException
    {
        try
        {
            if (isEmpty())
            {
                throw new IndexOutOfBoundsException("List is empty so you cannot fetch the first value.");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        return head.getObjectVal();
    }

    public Object last() throws IndexOutOfBoundsException
    {
        try
        {
            if(isEmpty())
            {
                throw new IndexOutOfBoundsException("List is empty so you cannot fetch the last value.");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        return tail.getObjectVal();
    }

    public boolean contains(Object o)
    {
        Iterator<Object> iterator = iterator();

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

    private class QueueIterator implements Iterator<Object>
    {
        private Node node = head;
        public boolean hasNext()
        {
            return node != null;
        }
        public Object next()
        {
            if(node != null)
            {
                Object objVal = node.getObjectVal();
                node = node.next;
                return objVal;
            }
            else
            {
                throw new IndexOutOfBoundsException();
            }
        }
    }




}
