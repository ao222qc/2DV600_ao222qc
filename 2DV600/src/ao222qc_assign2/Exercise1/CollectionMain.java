package ao222qc_assign2.Exercise1;

import java.util.Iterator;

/**
 * Created by Adam on 2016-09-13.
 */
public class CollectionMain
{
    public static void main(String args[])
    {
        TestArrayIntList();
        TestArrayIntStack();
    }

    public static void TestArrayIntList()
    {
        ArrayIntList arr = new ArrayIntList();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        System.out.println("Adding values 1, 2 and 3.");
        System.out.println(arr.toString());
        arr.addAt(4, 0);
        System.out.println("Adding value 4 to index 0.");
        System.out.println(arr.toString());
        arr.remove(1);
        System.out.println("Removing index 1.");
        System.out.println(arr.toString());
        System.out.println("Index of 4 is "+ arr.indexOf(4));
    }

    public static void TestArrayIntStack()
    {
        System.out.println();
        ArrayIntStack arrIntStack = new ArrayIntStack();
        arrIntStack.push(2);
        arrIntStack.push(4);
        arrIntStack.push(6);
        System.out.println("Pushing values 2, 4, 6 to stack.");
        System.out.println(arrIntStack.toString());
        System.out.println("Pop: "+arrIntStack.pop());
        System.out.println("Peek: "+arrIntStack.peek());
        System.out.println("Pop: "+arrIntStack.pop());
        System.out.println("pop: "+arrIntStack.pop());
        System.out.println("Trying to pop empty stack.");

        try
        {
            System.out.println("pop: "+arrIntStack.pop());
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
