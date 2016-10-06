package ao222qc_assign1;

/**
 * Created by Adam on 2016-09-09.
 */

public class QueueTester
{
    public static void main(String args[])
    {
        Queue q = new Queue();
        System.out.println("Current size: "+q.size());
        System.out.println("Is empty : " + q.isEmpty());
        q.enqueue("Hello world.");
        System.out.println("Adding string...");
        System.out.println("Printing first value in queue... : " + q.first());
        System.out.println("Is empty : " + q.isEmpty());
        q.enqueue(123);
        System.out.println("Adding integer...");
        System.out.println("Printing last value in queue... : " + q.last());
        System.out.println("Dequeuing... " +q.dequeue());
        System.out.println("Printing new first object... : " + q.first());
        q.enqueue("Hello world is back.");
        System.out.println("Adding new string value and printing last value in queueu : " + q.last());
        System.out.println("Does the queue contain the integer 123 ? : "+ q.contains(123));

        System.out.println("Amount of objects queued: " + q.size());
        System.out.println("Will now dequeue twice to get an empty list...");
        System.out.println("Objects removed : " + q.dequeue() +  ", " +q.dequeue());
        System.out.println("Trying to dequeue empty queue : " + q.dequeue());
        System.out.println("Trying to get first in empty queue : " + q.first());
        System.out.println("Trying to get last in empty queue : " + q.last());


    }
}
