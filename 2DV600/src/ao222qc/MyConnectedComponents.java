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
        MyDFS<E> myDFS = new MyDFS();
        Set<Node<E>> visited = new HashSet<>();
        Collection<Collection<Node<E>>> cc = new ArrayList<>();
        Deque<Node<E>> toVisit = new ArrayDeque<>();

        Iterator<Node<E>> it = dg.iterator();

        while(it.hasNext()) //For each node O(V)
        {
            Node<E> node = it.next();

            if(!visited.contains(node))
            {
                List<Node<E>> tempList = myDFS.dfs(dg, node); //O(V(V+E))
                LinkedHashSet<Node<E>> toAddList = new LinkedHashSet<>();

                for(Node<E> n : tempList) //another O(V)
                {
                    if(visited.add(n))
                    {
                        toAddList.add(n);
                        if(n.inDegree() > 0) //If has preds, call recursive function to add preds to toAddList.
                        {
                            addPreds(n, toAddList, visited, toVisit); //Another O(V+E)
                        }
                    }
                }
                //if(toAddList.size() > 0)
                //{
                    cc.add(toAddList);
                //}
            }
        }
        return cc;
    }

    /**
     * Function for adding predecessors of node. Called if node contains one or more indegrees (aka predeccessors).
     * @param node
     * @param toAddList
     * @return
     */
    public Collection<Node<E>> addPreds(Node<E> node, Set<Node<E>> toAddList, Set<Node<E>> visited, Deque<Node<E>> toVisit)
    {
        toVisit.clear();
        node.predsOf().forEachRemaining(toVisit::add);

        while(!toVisit.isEmpty())
        {
            node = toVisit.removeFirst();
            visited.add(node);

            if(toAddList.add(node))
            {
                node.num = toAddList.size();
                Iterator<Node<E>> predsIt = node.succsOf();
                while (predsIt.hasNext())
                {
                    Node<E> n = predsIt.next();

                    if (!visited.contains(n) && !toVisit.contains(n))
                    {
                        toVisit.add(n);
                    }
                }
            }
        }
        return toAddList;
    }
}

