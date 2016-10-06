package ao222qc;

import graphs.Node;

import java.util.*;

/**
 * Created by Adam on 2016-09-27.
 */

class MyNode<E> extends Node<E>
{
    private Set<Node<E>> predecessors = new HashSet<Node<E>>();
    private Set<Node<E>> successors = new HashSet<Node<E>>();

    public MyNode(E item)
    {
        super(item);
    }

    @Override
    public E item()
    {
        return super.item();
    }

    @Override
    public String toString()
    {
        String str = "";
        str+= "Node value: " + this.item() + ". ";
        str += "Predecessors : ";
        for(Node<E> n : predecessors)
        {
            str += n.item();
        }
        str += " Successors : ";
        for(Node<E> n : successors)
        {
            str += n.item() + " , ";
        }
        //str += "\n";
        return str;
    }

    @Override
    public boolean hasSucc(Node<E> node)
    {
        return this.successors.contains(node);
    }

    @Override
    public int outDegree()
    {
        return this.successors.size();
    }

    @Override
    public Iterator<Node<E>> succsOf()
    {
        return this.successors.iterator();
    }

    @Override
    public boolean hasPred(Node<E> node)
    {
        return this.predecessors.contains(node);
    }

    @Override
    public int inDegree()
    {
        return predecessors.size();
    }

    @Override
    public Iterator<Node<E>> predsOf()
    {
        return this.predecessors.iterator();
    }

    @Override
    protected void addSucc(Node<E> succ)
    {
        this.successors.add(succ);
    }

    @Override
    protected void removeSucc(Node<E> succ)
    {
        this.successors.remove(succ);
    }

    @Override
    protected void addPred(Node<E> pred)
    {
        this.predecessors.add(pred);
    }

    @Override
    protected void removePred(Node<E> pred)
    {
        this.predecessors.remove(pred);
    }

    @Override
    protected void disconnect()
    {
        for(Node<E> n : this.successors)
        {
            MyNode<E> node = (MyNode<E>) n;
            node.removePred(this);
        }

        for(Node<E> n : this.predecessors)
        {
            MyNode<E> node = (MyNode<E>) n;
            node.removeSucc(this);
        }
        this.successors.clear();
        this.predecessors.clear();
    }
}
