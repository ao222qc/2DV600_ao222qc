package ao222qc;

import graphs.DirectedGraph;
import graphs.GML;
import graphs.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Adam on 2016-09-29.
 */
public class MyGML<E> extends GML<E>
{
    public MyGML(DirectedGraph<E> dg)
    {
        super(dg);
    }

    @Override
    public String toGML()
    {   // \t tab
        List<Node<E>> nodeWithEdgeList = new ArrayList<Node<E>>();
        String str = "";
        int count = 1;
        str += "graph [\n";
        Iterator it = graph.iterator();
        while(it.hasNext())
        {
            Node<E> node = (Node<E>)it.next();
            str += "\tnode [\n";
            str += "\t\tid " + count + "\n";
            str += "\t\tlabel \"" + node.item() + "\"\n";
            str +="\t]\n";
            node.num = count;
            count++;
        }

        Iterator newIt = graph.iterator();
        while(newIt.hasNext())
        {
            Node<E> source = (Node<E>)newIt.next();
            Iterator itte = source.succsOf();
            while(itte.hasNext())
            {
                Node<E> succNode = (Node<E>)itte.next();
                str += "\tedge [\n";
                str += "\t\tsource " + source.num;
                str += "\n\t\ttarget " + succNode.num;
                //str += "\n\t\tlabel " + "from " + node.item() + " to " + succNode.item();
                str += "\n\t]\n";
            }
        }

        str+="]";

        return str ;
    }
}
