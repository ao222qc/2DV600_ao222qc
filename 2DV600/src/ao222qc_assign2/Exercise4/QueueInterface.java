
/**
 * QueueInterface.java
 * Updated with exceptions 9 sep 2015
 */

package ao222qc_assign2.Exercise4;

import java.util.Iterator;

public interface QueueInterface<E> extends Iterable<E>
{
	    int size();                          // current queue size 
	    
	    boolean isEmpty();                   // true if queue is empty
	    
	    void enqueue(E element);        // add element at end of queue
	    
	    E dequeue() throws IndexOutOfBoundsException;     // return and remove first element.
	    
	    E first() throws IndexOutOfBoundsException;       // return (without removing) first element
	    
	    E last() throws IndexOutOfBoundsException;        // return (without removing) last element
}

