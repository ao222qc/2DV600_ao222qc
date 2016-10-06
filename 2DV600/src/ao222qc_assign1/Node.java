package ao222qc_assign1;

/**
 * Created by Adam on 2016-09-09.
 */
public class Node
{
    Object obj;
    Node next = null;

    public Node(Object obj)
    {
        this.obj = obj;
    }

    public Object getObjectVal()
    {
        return this.obj;
    }
}
