package ao222qc_assign2.Exercise1;

import ao222qc_assign2.da1031.*;

import java.util.Iterator;

/**
 * Created by Adam on 2016-09-13.
 */
public class ArrayIntList extends AbstractIntCollection implements IntList
{
    public ArrayIntList()
    {

    }

    @Override
    public void add(int n)
    {
        try
        {
            values[size()] = n;
            size++;
            if (size() == values.length)
            {
                resize();
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addAt(int n, int index) throws IndexOutOfBoundsException
    {
        if (index >= size() || index < 0)
        {
            throw new IndexOutOfBoundsException("Cannot write to this index.");
        }
        size++;
        if (size() == values.length)
        {
            resize();
        }
        for(int i = size()-1; i > index; i--)
        {
            values[i] = values[i-1];
        }
        values[index] = n;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException
    {
        if (index >= size() || index < 0)
        {
            throw new IndexOutOfBoundsException("Index does not exist");
        }
        size--;
        for(int i = index; i < size(); i++)
        {
            values[i] = values[i+1];
        }
    }

    @Override
    public int get(int index) throws IndexOutOfBoundsException
    {
        if (index >= size() || index < 0)
        {
            throw new IndexOutOfBoundsException("Index does not exist.");
        }
        return values[index];
    }

    @Override
    public int indexOf(int n)
    {
        try
        {
            for(int i = 0; i < size(); i++)
            {
                if(values[i] == n)
                {
                    return i;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return -1;
    }
}