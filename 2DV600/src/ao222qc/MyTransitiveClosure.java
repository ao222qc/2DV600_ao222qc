package ao222qc;

import graphs.DirectedGraph;
import graphs.Node;
import graphs.TransitiveClosure;

import java.util.*;

/**
 * Created by Adam on 2016-09-29.
 */
public class MyTransitiveClosure<E> implements TransitiveClosure<E>
{
    @Override
    public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg)
    {
        MyDFS<E> myDFS = new MyDFS<>();
        Map<Node<E>, Collection<Node<E>>> transitiveClosureMap = new HashMap<>();
        Iterator<Node<E>> iterator = dg.iterator();

        while(iterator.hasNext())
        {
            Node<E> node = iterator.next();
            transitiveClosureMap.put(node, myDFS.dfs(dg, node));
        }

        return transitiveClosureMap;
    }
}
