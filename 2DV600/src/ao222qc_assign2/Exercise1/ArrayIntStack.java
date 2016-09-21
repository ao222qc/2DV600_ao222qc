package ao222qc_assign2.Exercise1;
import ao222qc_assign2.da1031.*;

/**
 * Created by Adam on 2016-09-13.
 */
public class ArrayIntStack extends AbstractIntCollection implements IntStack
{
    @Override
    public void push(int n)
    {
        try
        {
            if (size() >= values.length)
            {
                resize();
            }
            //Add value to top of stack, increment top.
            values[size++] = n;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int pop() throws IndexOutOfBoundsException
    {
        if (size() <= 0)
        {
            throw new IndexOutOfBoundsException("Stack is empty, nothing to pop.");
        }
        //Return top value and decrement top(size).
         return values[size-=1];
    }

    @Override
    public int peek() throws IndexOutOfBoundsException
    {
        if (size() <= 0)
        {
            throw new IndexOutOfBoundsException("Stack is empty, nothing to peek at.");
        }
        return values[size()-1];
    }
}
