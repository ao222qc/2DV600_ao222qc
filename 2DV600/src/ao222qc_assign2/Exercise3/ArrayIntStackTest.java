package ao222qc_assign2.Exercise3;

import ao222qc_assign2.Exercise1.ArrayIntStack;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Adam on 2016-09-16.
 */
public class ArrayIntStackTest
{
    private static int counter = 1;

    @Before
    public void setUp() throws Exception
    {
        System.out.println("Testing method : " + counter);
    }

    @After
    public void tearDown() throws Exception
    {
        System.out.println("Test " + counter + " is complete.");
        counter++;
    }

    @Test
    public void push() throws Exception
    {
        ArrayIntStack arrIntStack = new ArrayIntStack();
        arrIntStack.push(4);
        assertEquals(4, arrIntStack.peek());
    }

    @Test
    public void pop() throws Exception
    {
        ArrayIntStack arrIntStack = new ArrayIntStack();

        arrIntStack.push(80);
        int result = arrIntStack.pop();
        assertEquals(80, result);

        try
        {
            arrIntStack.pop();
            fail("Popping empty stack did not throw IndexOutOfBoundsException. Test failed.");
        }
        catch(IndexOutOfBoundsException e)
        {
            assertTrue(true);
        }
    }

    @Test
    public void peek() throws Exception
    {
        ArrayIntStack arrIntStack = new ArrayIntStack();
        try
        {
            arrIntStack.peek();
            fail("Peeking empty stack did not throw IndexOutOfBoundException.");
        }
        catch (IndexOutOfBoundsException e)
        {
            assertTrue(true);
        }
        arrIntStack.push(10);
        assertEquals(10, arrIntStack.peek());
    }
}