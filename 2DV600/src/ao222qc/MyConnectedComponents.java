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
    //private Set<Node<E>> visited = new HashSet<>();
    //private Collection<Collection<Node<E>>> cc = new ArrayList<>();
    private MyDFS<E> myDFS = new MyDFS();

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
        //visited.clear();
        //cc.clear();
        Set<Node<E>> visited = new HashSet<>();
        Collection<Collection<Node<E>>> cc = new ArrayList<>();

        Iterator<Node<E>> it = dg.iterator();

        while(it.hasNext())
        {
            Node<E> node = it.next();
            List<Node<E>> tempList = myDFS.dfs(dg, node);
            List<Node<E>> toAddList = new LinkedList<>();

            for(Node<E> n : tempList)
            {
                if(!visited.contains(n))
                {
                    visited.add(n);
                    toAddList.add(n);
                    if(n.inDegree() > 0) //If has preds, call recursive function to add preds to toAddList.
                    {
                        addPreds(n, toAddList, visited);
                    }
                }
            }
            if(toAddList.size() > 0)
            {
                cc.add(toAddList);
            }
        }
        return cc;
    }

    /**
     * Recursive function for adding predecessors of node. Called if node contains one or more indegrees (aka predeccessors).
     * @param node
     * @param toAddList
     * @return
     */
    public List<Node<E>> addPreds(Node<E> node, List<Node<E>> toAddList, Set<Node<E>> visited)
    {
        Iterator<Node<E>> predIt = node.predsOf();

        while(predIt.hasNext())
        {
            Node<E> n = predIt.next();

            if(!visited.contains(n))
            {
                visited.add(n);
                toAddList.add(n);
                toAddList = addPreds(n, toAddList, visited);
            }
        }
        return toAddList;
    }
}



