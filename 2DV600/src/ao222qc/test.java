package ao222qc;

import graphs.Node;

import java.util.List;

/**
 * Created by Adam on 2016-09-27.
 */
public class test
{
    public static void main(String args[])
    {
        MyGraph graph = new MyGraph();

        graph.addEdgeFor("a", "b");
        graph.addEdgeFor("a", "c");
        graph.addEdgeFor("b", "d");
        graph.addEdgeFor("c", "d");
        graph.addEdgeFor("d", "b");
        graph.addEdgeFor("d", "e");
        graph.addEdgeFor("e", "f");
        graph.addEdgeFor("f", "d");
        graph.addEdgeFor("e", "g");
        graph.addEdgeFor("y", "x");
        //System.out.println(graph);
        //MyGML<String> gml = new MyGML<>(graph);




        MyDFS<String> dfs = new MyDFS<>();

        //System.out.println(dfs.dfs(graph, graph.getNodeFor("a")));

        //System.out.println(dfs.postOrder(graph, graph.getNodeFor("a")));
        System.out.println(dfs.topSort(graph));


    }
}
