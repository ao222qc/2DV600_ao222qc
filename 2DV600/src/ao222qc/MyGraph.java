package ao222qc;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by Adam on 2016-09-27.
 */
public class MyGraph<E> implements DirectedGraph<E>
{

    private Map<E, MyNode<E>> item2node = new HashMap<E, MyNode<E>>();
    Set<Node<E>> heads = new HashSet<Node<E>>();
    Set<Node<E>> tails = new HashSet<Node<E>>();

    public MyGraph(){}  //Empty constructor

    @Override
    public Node<E> addNodeFor(E item)
    {
        if(item == null)
            throw new NullPointerException();

        if (containsNodeFor(item))
        {
            return getNodeFor(item);
        }
        else
        {
            MyNode<E> myNode = new MyNode<>(item);
            heads.add(myNode);
            tails.add(myNode);
            item2node.put(item, myNode);
            return myNode;
        }
    }

    /**
     * Returns the node representing <tt>item</tt>.
     * Exception is thrown if <tt>item</tt> is null or if no
     * node representing <tt>item</tt> is found.
     * @param item
     * @return Node representing <tt>item</tt>
     */
    @Override
    public Node<E> getNodeFor(E item)
    {
        if (item == null )
        {
            throw new NullPointerException("Item is null.");
        }
        else
        {
            if(!item2node.containsKey(item))
                throw new NullPointerException("Node does not exist");
        }

        return item2node.get(item);
    }
    /**
     * Adds an edge between the nodes represented by <tt>from</tt>
     * and <tt>to</tt>  if not added before. The nodes representing
     * <tt>from</tt> and <tt>to</tt> are added if not added before.
     * Exception is thrown if <tt>from</tt> or <tt>to</tt> is null.
     * It returns <tt>true</tt> if edge not added before, otherwise <tt>false</tt>.
     * @param from, source node
     * @param to, target node
     * @return <tt>true</tt> if edge not added before, otherwise <tt>false</tt>.
     */
    @Override
    public boolean addEdgeFor(E from, E to)
    {
            if (from == null || to == null)
                throw new RuntimeException("Cannot add between non-existant items.");

            MyNode<E> source = (MyNode<E>)addNodeFor(from);
            MyNode<E> target = (MyNode<E>)addNodeFor(to);

            if(source.hasSucc(target) || target.hasPred(source))
                return false;

            source.addSucc(target);
            target.addPred(source);

            tails.remove(source);
            heads.remove(target);

        return true;
    }

    /**
     * Returns <tt>true</tt> if the node representing <tt>item</tt> is
     * contained in the graph, otherwise <tt>false</tt>.
     * Exception is thrown if <tt>item</tt> is null.
     * @param item, node to be checked.
     */
    @Override
    public boolean containsNodeFor(E item)  //Use iterator later
    {
        if(item == null)
            throw new NullPointerException("Item is null");
        MyNode<E> node = item2node.get(item);

        return item2node.containsValue(node);
    }

    @Override
    public int nodeCount()
    {
        return item2node.size();
    }

    @Override
    public Iterator<Node<E>> iterator()
    {
        List<Node<E>> nodeList = new ArrayList<Node<E>>(item2node.values());
        return nodeList.iterator();
    }

    @Override
    public Iterator<Node<E>> heads()
    {
        return heads.iterator();
    }

    @Override
    public int headCount()
    {
        return heads.size();
    }

    @Override
    public Iterator<Node<E>> tails()
    {
        return tails.iterator();
    }

    @Override
    public int tailCount()
    {
        int edges = 0;
        for(MyNode<E> node : item2node.values())
        {
            if(node.outDegree() <= 0)
                edges++;
        }
        return edges;
    }

    @Override
    public List<E> allItems()
    {
        List<E> tempList = new ArrayList<E>();

        for(MyNode<E> m : item2node.values())
        {
            tempList.add(m.item());
        }
        return tempList;
    }

    @Override
    public int edgeCount()
    {
        int edges = 0;

        for(MyNode<E> node : item2node.values()){
            edges+=node.outDegree();
        }
        return edges;
    }

    /**
     * Removes the node represented by <tt>item</item> and
     * all its connecting edges. Exception is thrown if <tt>item</tt>
     * is null  or if no node representing <tt>item</tt> is found.
     *
     * @param item, node to be removed.
     */
    @Override
    public void removeNodeFor(E item) //LEFT OFF HERE!!!!
    {
        if(item == null)
            throw new NullPointerException("Nuuull");

        if(!item2node.containsKey(item))
            throw new NullPointerException("Does not exist");

        MyNode<E> n = (MyNode<E>)getNodeFor(item);

        try
        {
            if (n == null)
                throw new Exception("No node with this value.");


            item2node.remove(item);
            if(heads.contains(n))
                heads.remove(n);
            if(tails.contains(n))
                tails.remove(n);
            n.disconnect();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Returns <tt>true</tt> if an edge between the nodes represented
     * by <tt>from</tt> and <tt>to</tt> is added to the graph.
     * Exception is thrown if <tt>from</tt> or <tt>to</tt> is null.
     * @param from, source node item
     * @param to, target node item
     * @return <tt>true</tt> if edge in graph, otherwise <tt>false</tt>.
     */
    @Override
    public boolean containsEdgeFor(E from, E to)
    {
        if (from == null || to == null)
            throw new RuntimeException("Null values");

        if(containsNodeFor(from) && containsNodeFor(to)){
            MyNode<E> fromTemp = (MyNode<E>)getNodeFor(from);
            MyNode<E>   toTemp = (MyNode<E>)getNodeFor(to);

            return fromTemp.hasSucc(toTemp) && toTemp.hasPred(fromTemp);
        }
        return false;
    }

    /**
     * Removes the edge between the nodes represented
     * by <tt>from</tt> and <tt>to</tt> if it exist.
     * Returns <tt>true</tt> if an edge between the nodes represented
     * by <tt>from</tt> and <tt>to</tt>  is found and successfully removed.
     * Exception is thrown if <tt>from</tt> or <tt>to</tt> is null.
     * @param from, source node item
     * @param to, target node item
     * @return <tt>true</tt> if edge in graph and successfully removed, otherwise <tt>false</tt>.
     */
    @Override
    public boolean removeEdgeFor(E from, E to)
    {
        MyNode<E> fromTemp = null;
        MyNode<E> toTemp = null;

        if(from == null ||to == null)
            throw new RuntimeException("Null values");


        if(!containsNodeFor(from) || !containsNodeFor(to) )
            return false;

        fromTemp = (MyNode<E>) getNodeFor(from);
        toTemp = (MyNode<E>) getNodeFor(to);

        if(containsEdgeFor(from, to))
        {
            fromTemp.removeSucc(toTemp);
            toTemp.removePred(fromTemp);

            if(fromTemp.isHead())
                heads.add(fromTemp);
            else if(fromTemp.isTail())
                tails.add(fromTemp);
            if(toTemp.isHead())
                heads.add(toTemp);
            else if(toTemp.isTail())
                tails.add(toTemp);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public String toString()
    {
        StringBuilder strB = new StringBuilder();

        Iterator it = iterator();

        while(it.hasNext())
        {
            strB.append(it.next().toString());
        }
        return strB.toString();
    }
}


/*	private void build_small_cyclic() {
		DirectedGraph<Integer> dg = createEmptyGraph();
		addEdge(dg,0,1);addEdge(dg,0,2);
		addEdge(dg,1,3);addEdge(dg,2,3);
		addEdge(dg,2,2); // reflexive
		addEdge(dg,3,1); //cycle
		addEdge(dg,3,4);addEdge(dg,4,5);addEdge(dg,5,3); //cycle
		addEdge(dg,4,6); //leaf

		small_cyclic = dg;
	}*/

/*Iterator<Node<E>> predIt = n.predsOf();

            while(predIt.hasNext())
            {
                MyNode<E> myNode = (MyNode<E>)predIt.next();
                if(containsEdgeFor(myNode.item(), n.item()))
                {
                    removeEdgeFor(myNode.item(), n.item());
                }
            }
            Iterator<Node<E>> succIt = n.succsOf();

            while(succIt.hasNext())
            {
                MyNode<E> myNode = (MyNode<E>)succIt.next();
                if(containsEdgeFor(n.item(), myNode.item()))
                    removeEdgeFor(n.item(), myNode.item());
            }*/