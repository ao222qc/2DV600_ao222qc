package ao222qc;

import graphs.ConnectedComponents;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by Adam on 2016-09-29.
 */
public class MyConnectedComponents<E> implements ConnectedComponents<E>
{

    /**
     * Two nodes a and b are directly connected if their exist an edge (a,b)
     * or an edge (b,a). Two nodes a and k are connected if there exist a sequence
     * of nodes [a,b,c,d, ... j,k] such that [a,b], [b,c], [c,d], [d,e], ..., [j,k]
     * are all directly connected.
     * <p/>
     * Problem: find a partitioning of the graph nodes such that two nodes belongs to the
     * same partitioning if and only if they are connected.
     * </p>
     * The result is a collection of node collections.
     *
     * @author jonasl
     *
     */
    @Override
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg)
    {
        Collection<Collection<Node<E>>> mainList = new LinkedList<>();
        Set<Node<E>> visited = new HashSet<>();

        MyDFS<E> myDFS = new MyDFS<>();

        Iterator<Node<E>> iterator = dg.heads();

        while(iterator.hasNext())
        {
            Node<E> node = iterator.next();

            List<Node<E>> nodeList = new LinkedList<>();

            for(Node<E> n : myDFS.dfs(dg, node))
            {
                visited.add(n);
                nodeList.add(n);
            }

            mainList.add(nodeList);
        }
        return mainList;
    }
}
