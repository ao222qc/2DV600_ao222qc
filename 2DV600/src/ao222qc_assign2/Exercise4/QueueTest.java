package ao222qc_assign2.Exercise4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Adam on 2016-09-20.
 */
public class QueueTest
{
    @Before
    public void setUp() throws Exception
    {

    }

    @After
    public void tearDown() throws Exception
    {

    }

    @Test
    public void size() throws Exception
    {
        Queue q = new Queue();
        assertEquals(0, q.size());
        q.enqueue(1234);
        assertEquals(1, q.size());

        Queue qq = new Queue();

        for(int i = 0; i < 50000; i++)
        {
            assertEquals(i, qq.size());
            qq.enqueue(i);
        }

        assertEquals(50000, qq.size());

    }

    @Test
    public void isEmpty() throws Exception
    {
        Queue q = new Queue();
        assertTrue(q.isEmpty());
        q.enqueue("Hej");
        assertFalse(q.isEmpty());
    }

    @Test
    public void enqueue() throws Exception
    {
        Queue q = new Queue();
        q.enqueue("hi");
        assertEquals("hi", q.dequeue());
        try
        {
            q.enqueue(1);
            q.enqueue(1.1);
            q.enqueue("hi");
            q.enqueue('h');
            q.enqueue(new Queue());
            q.enqueue(new int[10]);
            q.enqueue("What's up " + 1.1);
            assertTrue(true);
        }
        catch (Exception e)
        {
            fail("Some object could not be enqueued");
        }
    }

    @Test
    public void dequeue() throws Exception
    {
        Queue q = new Queue();
        try
        {
            q.dequeue();
            fail("Dequeuing empty queue did not throw Exception.");
        }
        catch (IndexOutOfBoundsException e)
        {
            assertTrue(true);
        }
        q.enqueue("hey there");
        assertEquals("hey there", q.dequeue());
    }

    @Test
    public void first() throws Exception
    {
        Queue q = new Queue();
        try
        {
            q.first();
            fail("Getting first value in empty queue did not throw Exception");
        }
        catch (IndexOutOfBoundsException e)
        {
            assertTrue(true);
        }

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(1, q.first());
    }

    @Test
    public void last() throws Exception
    {
        Queue q = new Queue();
        try
        {
            q.last();
            fail("Getting last value in empty queue did not throw Exception");
        }
        catch (IndexOutOfBoundsException e)
        {
            assertTrue(true);
        }
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(3, q.last());
    }

    @Test
    public void contains() throws Exception
    {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);

        assertTrue(q.contains(1));
        assertTrue(q.contains(2));
        assertFalse(q.contains(3));
    }

    @Test
    public void iterator() throws Exception
    {

    }

}