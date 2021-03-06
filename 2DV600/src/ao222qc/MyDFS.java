package ao222qc;

import ao222qc_assign2.Exercise4.Queue;
import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;
import ao222qc_assign2.Exercise4.*;

import java.util.*;

/**
 * Created by Adam on 2016-09-29.
 */
public class MyDFS<E> implements DFS<E>
{
    private List<Node<E>> nodeList = new LinkedList<>();
    //private List<Node<E>> visited = new LinkedList<>();

    private int count;// = 1;

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root)
    {
        if(root == null)
            return null;
        Set<Node<E>> visited = new HashSet<>();
        List<Node<E>> result = new ArrayList<>();
        return dfsRecursion(visited, root, graph, result);

    }

    private List<Node<E>> dfsRecursion(Set<Node<E>> visited, Node<E> root, DirectedGraph<E> graph, List<Node<E>> result)
    {
        visited.add(root);
        root.num = visited.size();

        result.add(root);

        Iterator successors = root.succsOf();
        while(successors.hasNext())
        {
            MyNode n = (MyNode)successors.next();
            if(!visited.contains(n))
            {
                result = dfsRecursion(visited, n, graph, result);
            }
        }
        return result;

    }

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph)
    {
        Set<Node<E>> visited = new HashSet<>();
        List<Node<E>> result = new ArrayList<>();
        Iterator<Node<E>> iterator;

        if(graph.headCount() != 0)
        {
            iterator = graph.heads();

            while(iterator.hasNext())
            {
                result = dfsRecursion(visited, iterator.next(), graph, result);
            }
        }
        else
        {
            Node<E> node = graph.getNodeFor(graph.allItems().get(0));
            result = dfsRecursion(visited, node, graph, result);
        }

        return result;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root)
    {
        List<Node<E>> visistedList = new ArrayList<>();
        List<Node<E>> nodeList = new ArrayList<>();

        return postOrderRecursion(visistedList, nodeList, root);
    }

    private List<Node<E>> postOrderRecursion(List<Node<E>> visitedList, List<Node<E>> nodeList, Node<E> root)
    {
        if(root == null)
            return null;

        if(!visitedList.contains(root))
            visitedList.add(root);

        Iterator<Node<E>> successors = root.succsOf();

        while(successors.hasNext())
        {
            Node<E> node = successors.next();
            if(!visitedList.contains(node))
            {
                postOrderRecursion(visitedList, nodeList, node);
            }
        }
        if(!nodeList.contains(root))
        {
            root.num = nodeList.size()+1;
            nodeList.add(root);
        }

        return nodeList;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g)
    {
        List<Node<E>> visitedList = new ArrayList<>();
        List<Node<E>> nodeList = new ArrayList<>();
        Iterator<Node<E>> it;

        if(g.headCount() != 0)
        {
            it = g.heads();
        }
        else
        {
            it = g.iterator();
        }
        while(it.hasNext())
        {
            nodeList = postOrderRecursion(visitedList, nodeList, it.next());
        }

        return nodeList;
    }

    /**
     * Returns a list of ALL nodes in the graph ordered as
     * post-order of the depth first forest resulting from
     * depth first search starting at arbitrary start nodes.
     * </p>
     * The algorithm attaches a depth-first number if <tt>attach_dfs_number</tt>
     * is <tt>true</tt>, otherwise it attaches a post-order number.
     */
    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number)
    {
        return null;
    }

    @Override
    public boolean isCyclic(DirectedGraph<E> graph)
    {
        for(Node<E> node : postOrder(graph))
        {
            Iterator<Node<E>> iterator = node.succsOf();
            while(iterator.hasNext())
            {
                if(node.num <= iterator.next().num)
                    return true;
            }
        }
        return false;
    }

    @Override
    public List<Node<E>> topSort(DirectedGraph<E> graph)
    {
        if(isCyclic(graph))
            return null;

        List<Node<E>> result = new ArrayList<>();

        List<Node<E>> reversed = postOrder(graph);

        for(int i = reversed.size()-1; i >= 0; i--)
        {
            result.add(reversed.get(i));
        }
        return result;
    }
}
