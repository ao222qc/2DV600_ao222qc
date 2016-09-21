package ao222qc_assign2.Exercise3;

import ao222qc_assign2.Exercise1.ArrayIntList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Adam on 2016-09-20.
 */
public class ArrayIntListTest
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
    public void add() throws Exception
    {
        ArrayIntList arrIntList = new ArrayIntList();

        arrIntList.add(100);
        assertEquals(1, arrIntList.size());
        assertEquals(100, arrIntList.get(0));
    }


    @Test
    public void addAt() throws Exception
    {
        ArrayIntList arrIntList = new ArrayIntList();
        try
        {
            arrIntList.addAt(10, 0);
            fail("Adding at specific index in empty list did not throw IndexOutOfBoundException.");
        }
        catch (IndexOutOfBoundsException e)
        {
            assertTrue(true);
        }


        for(int i = 1; i <= 5; i++)
        {
            arrIntList.add(i);
        }
        arrIntList.addAt(100, 0);
        assertEquals(100, arrIntList.get(0));
        arrIntList.addAt(15, 2);
        assertEquals(15, arrIntList.get(2));
    }

    @Test
    public void remove() throws Exception
    {
        ArrayIntList arrIntList = new ArrayIntList();

        try
        {
            arrIntList.remove(0);
            fail("Removing value from empty list did not throw IndexOutOfBoundException");
        }
        catch (IndexOutOfBoundsException e)
        {
            assertTrue(true);
        }

        arrIntList.add(10);
        assertEquals(1, arrIntList.size());
        arrIntList.remove(0);
        assertEquals(0, arrIntList.size());
    }

    @Test
    public void get() throws Exception
    {
        ArrayIntList arrIntList = new ArrayIntList();

        try
        {
            arrIntList.get(0);
            fail("Getting element from empty list did not throw IndexOutOfBoundException");
        }
        catch (IndexOutOfBoundsException e)
        {
            assertTrue(true);
        }

        arrIntList.add(10);
        assertEquals(10, arrIntList.get(0));


    }

    @Test
    public void indexOf() throws Exception
    {
        ArrayIntList arrIntList = new ArrayIntList();
        arrIntList.add(10);
        arrIntList.add(15);
        arrIntList.add(20);
        assertEquals(2, arrIntList.indexOf(20));
        assertEquals(1, arrIntList.indexOf(15));
        assertEquals(-1, arrIntList.indexOf(33));
    }

}