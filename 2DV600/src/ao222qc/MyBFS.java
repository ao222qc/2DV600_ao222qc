package ao222qc;

import com.sun.deploy.util.OrderedHashSet;
import graphs.BFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by Adam on 2016-09-29.
 */
public class MyBFS<E> implements BFS<E>
{
    /**
     * Returns the nodes visited by a breadth-first search starting from
     * the given root node. Each visited node is also attached with
     * a breadth-first number.
     */
    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root)
    {
        LinkedHashSet<Node<E>> result = new LinkedHashSet<>();
        Deque<Node<E>> toVisit = new ArrayDeque<>();

        toVisit.add(root);

        while (!toVisit.isEmpty())
        {
            Node<E> current = toVisit.removeFirst();
            if(result.add(current))
            {
                current.num = result.size();

                Iterator<Node<E>> it = current.succsOf();
                while (it.hasNext())
                {
                    toVisit.add(it.next());
                }
            }
        }
        return new ArrayList(result);
    }

    /**
     * Returns the nodes visited by a breadth first search starting from
     * an arbitrary set of nodes. All nodes are visited. Each visited node is
     * also attached with a breadth-first number.
     */
    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph)
    {
        LinkedHashSet<Node<E>> result = new LinkedHashSet<>();
        Deque<Node<E>> toVisit = new ArrayDeque<>();

        if(graph.headCount() != 0)
        {
            graph.heads().forEachRemaining(toVisit::add);
        }
        else
        {
            toVisit.add(graph.getNodeFor(graph.allItems().get(0)));
        }

        while (!toVisit.isEmpty())
        {
            Node<E> current = toVisit.removeFirst();

            if(result.add(current))
            {
                current.num = result.size();
                Iterator<Node<E>> it = current.succsOf();
                while (it.hasNext())
                {
                    toVisit.add(it.next());
                }
            }
        }
        return new ArrayList(result);
    }
}
