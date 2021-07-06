package edu.cpp.cs.cs241.prog_assgmnt_4;


/**
 * CS 241: Data Structures and Algorithms II
 * Professor: Edwin Rodríguez
 *
 * Programming Assignment 1
 *
 * Assignment 1 is about the implementation of the Heap, a type of data structure. For this assignemnt, I implemented the heap as connected Nodes that have the reference
 * to threee other nodes (left child, right child, and parent). A heap can be implemented as an array, as well. The second part of this assignment is to create a 
 * restaurant application using our NodeHeap data structure. The Node Heap is used in place of a priority queue. 
 *
 * Michelle Duong
 *   
 */

public class Node<K extends Comparable<K>, V>
{
  
    private Node<K,V> leftChild;
 
    private Node<K,V> rightChild;
   
    private Node<K,V> parent;
 
    private Pair<K,V> pair;
    
    protected enum Color {RED, BLACK};
    
    private Color color;
    
    /**
     * Constructor method for the Node object that assigns values to the leftChild, rightChild, parent, and data variables.
     */
    public Node(Node<K,V> left, Node<K,V> right, Node<K,V> parent, Color c, Pair pair)
    {
        leftChild = left;
        rightChild = right;
        this.parent = parent;
        this.pair = pair;
        color = c;
    }
    
    public Node<K,V> getUncle()
    {
        Node<K,V> parent = this.getParent();
        Node<K,V> grandparent = parent.getParent();
        if( parent.equals(grandparent.getLeftChild()))
        {
            return grandparent.getRightChild();
        }
        return grandparent.getLeftChild();
    }
    
    public boolean isExternalNode()
    {
        Node temp = this.getParent();
        if(temp.getParent().getRightChild().equals(temp) )
        {
           if (temp.getRightChild().equals(this))
              return true;
        }
        if(temp.getParent().getLeftChild().equals(temp) )
        {
           if (temp.getLeftChild().equals(this))
              return true;
        }
        return false;
    }
    
    
    public void setColor(Color color)
    {
        this.color = color;
    }
    
    public boolean isRed()
    {
        if( color == Color.RED)
        {
            return true;
        }
        return false;
    }
    
    public Pair<K,V> getPair()
    {
        return pair;
    }

    /**
     * Sets a Node's reference leftChild to another node
     * Postcondition: a node's leftChild is updated to be n.
     * n is the parameter
     */
    public void setLeftChild(Node<K,V> n)
    {
        leftChild = n;
    }

    /**
     * Returns a node's leftChild.
     */
    public Node<K,V> getLeftChild()
    {
        return leftChild;
    }

    /**
     * Sets a Node's reference rightChild to another node
     * Postcondition: a node's rightChild is updated to be n.
     * n is the parameter
     */
    public void setRightChild(Node<K,V> n)
    {
        rightChild = n;
    }

    /**
     * Returns a node's rightChild.
     */
    public Node<K,V> getRightChild()
    {
        return rightChild;
    }

    /**
     * Returns a node's parent.
     */
    public Node<K,V> getParent()
    {
        return parent;
    }

    /**
     * Sets a Node's reference parent to another node
     * Postcondition: a node's parent is updated to be n.
     * n is the parameter
     */
    public void setParent(Node<K,V> n)
    {
        parent = n;
    }

   

   
}