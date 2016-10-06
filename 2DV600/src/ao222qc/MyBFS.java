package ao222qc;

import graphs.BFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by Adam on 2016-09-29.
 */
public class MyBFS<E> implements BFS<E>
{
    private List<Node<E>> result = new ArrayList<>();
    private Set<Node<E>> visited = new HashSet<>();
    private List<Node<E>> toVisit = new ArrayList<>();

    /**
     * Returns the nodes visited by a breadth-first search starting from
     * the given root node. Each visited node is also attached with
     * a breadth-first number.
     */
    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root)
    {
        result.clear();
        visited.clear();
        toVisit.clear();

        toVisit.add(root);

        while(!toVisit.isEmpty())
        {
            Node<E> current = toVisit.remove(0);
            visited.add(current);
            if(!result.contains(current))
            {
                result.add(current);
                current.num = result.size();
            }
            Iterator<Node<E>> it = current.succsOf();
            while(it.hasNext())
            {
                Node<E> n = it.next();
                if(!visited.contains(n))
                {
                    toVisit.add(n);
                }
            }
        }
        return result;
    }

    /**
     * Returns the nodes visited by a breadth first search starting from
     * an arbitrary set of nodes. All nodes are visited. Each visited node is
     * also attached with a breadth-first number.
     */
    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph)
    {
        result.clear();
        visited.clear();
        toVisit.clear();

        graph.heads().forEachRemaining(toVisit::add);   //search all heads first.

        while(!toVisit.isEmpty())
        {
            Node<E> current = toVisit.remove(0);
            visited.add(current);
            if(!result.contains(current))
            {
                result.add(current);
                current.num = result.size();
            }
            Iterator<Node<E>> it = current.succsOf();
            while(it.hasNext())
            {
                Node<E> n = it.next();
                if(!visited.contains(n))
                {
                    toVisit.add(n);
                }
            }
        }

        return result;
    }
}
