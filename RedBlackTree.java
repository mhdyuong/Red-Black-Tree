package edu.cpp.cs.cs241.prog_assgmnt_4;

/**
 * Write a description of class RedBlackTree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedBlackTree<K extends Comparable<K>, V> implements Tree<K,V> 
{

    Node<K,V> root;

    int size = 0;

    public RedBlackTree()
    {
        root  = null;
    }

    public Node<K,V> createNode(K key, V value)
    {
        Node<K,V> noValue = new Node<>(null, null, null, Node.Color.BLACK, null);
        Node<K,V> noValue2 = new Node<>(null, null, null, Node.Color.BLACK, null);
        Pair<K,V> pair = new Pair<>(key, value);
        Node<K,V> n = new Node<>(noValue, noValue2, null,  Node.Color.RED, pair);
        noValue.setParent(n);
        noValue2.setParent(n);
        return n;
    }

    public Node<K,V> addBST(K key, V value)
    {
        Node<K,V> n = createNode(key, value);
        Node<K,V> current = root;
        Node<K,V> prev = null;
        if (root == null)
        {
            n.setColor(Node.Color.BLACK);
            root = n;
        }
        else
        {
            while(current != null && current.getPair() != null)
            {
                prev = current;
                if( key.compareTo(current.getPair().getKey()) <= 0)
                {
                    current = current.getLeftChild();
                }
                else
                {
                    current = current.getRightChild();
                }
            }
            if(key.compareTo(prev.getPair().getKey()) <= 0)
            {
                prev.setLeftChild(n);
            }
            else
            {
                prev.setRightChild(n);
            }
            n.setParent(prev);
        }
        size++;
        return n;
    }

    public void leftRotation(Node<K,V> n)
    {
        Node<K,V> t = null;
        if( n == root)
        {
            Node<K,V> temp = root.getRightChild();
            root.setRightChild(temp.getLeftChild());
            root.getRightChild().setParent(root);
            root.setParent(temp);
            temp.setParent(null);
            temp.setLeftChild(root);
            root = temp;
        }
        else
        {
            //System.out.println("The value of n is " + n.getPair().getValue());
            Node temp = n.getRightChild();
            n.getRightChild().setParent(n.getParent());
            //System.out.println("The value of n's rightChild parent is " + n.getRightChild().getParent().getPair().getValue());
            n.getParent().setLeftChild(n.getRightChild());
            n.getParent().getLeftChild().setLeftChild(n);
            n.setParent(temp);
        }

    }

    public void rightRotation(Node<K,V> n)
    {
        if( n == root)
        {
            Node<K,V> temp = root.getLeftChild();
            root.setLeftChild(temp.getRightChild());
            root.getLeftChild().setParent(root);
            root.setParent(temp);
            temp.setParent(null);
            temp.setRightChild(root);
            root = temp;
        }
        else
        {
            Node temp = n.getLeftChild();//21
            //printTree();
            //System.out.println("the 1st print out.");
            n.getParent().setLeftChild(n.getLeftChild());
            //System.out.println("the 2nd print out.");
            //printTree();
            n.getLeftChild().setRightChild(n);
            n.setParent(temp);
            //n.getParent().setLeftChild(n.getLeftChild());
            //System.out.println("the 3rd print out.");
            printTree();
        }
    }

    public void fixTreeAdd(Node<K,V> n)
    {
        if( n == root)
        {
            root.setColor(Node.Color.BLACK);
        }
        else if( n.getUncle().isRed() )
        {
            n.getParent().setColor(Node.Color.BLACK);
            n.getUncle().setColor(Node.Color.BLACK);
            n.getParent().getParent().setColor(Node.Color.RED);
            fixTreeAdd(n.getParent().getParent());
        }
        else if ( !n.getUncle().isRed() && !n.isExternalNode() )
        {
            if( n.getParent().getRightChild().equals(n) )
            {
                leftRotation(n.getParent());
                //System.out.println("Value of n left " + n.getLeftChild().getPair().getValue());
                //fixTreeAdd(n.getLeftChild());
            }
            else if ( n.getParent().getLeftChild().equals(n) )
            {
                //rightRotation(n.getParent());
                //fixTreeAdd(n.getRightChild());
            }
        }
        //         else if (!n.getUncle().isRed() && n.isExternalNode() )
        //         {
        //             if( n.getParent().getRightChild().equals(n) )
        //             {
        //                 //leftRotation(n.getParent().getParent());
        //                 //System.out.println("Value of n " + n.getPair().getValue());
        //                 //System.out.println("Value of n pp " + n.getParent().getParent().getPair().getValue());
        //                 //n.setColor(Node.Color.RED);
        //                 // n.getParent().getLeftChild().setColor(Node.Color.RED);
        //                 //n.getParent().setColor(Node.Color.BLACK);
        //             }
        //             else if( n.getParent().getLeftChild().equals(n) )
        //             {
        //                 System.out.println("Value of n " + n.getPair().getValue());
        //                 System.out.println("Value of n pp " + n.getParent().getParent().getPair().getValue());
        //                 rightRotation(n.getParent().getParent());
        //                
        //                 //n.setColor(Node.Color.RED);
        //                 //n.getParent().getRightChild().setColor(Node.Color.RED);
        //                 //n.getParent().setColor(Node.Color.BLACK);
        //             } 
        //             fixTreeAdd(root);
        //         }
    }

    public void add(K key, V value)
    {
        Node<K,V> n = addBST(key, value);

        if( n.isRed() && n.getParent().isRed() )
        {

            fixTreeAdd(n);
        }

    }

    public void printTree()
    {
        for( int x = 0; x < 9; x++)
        {
            Node<K,V> n = root;
            String path = Integer.toBinaryString(x+1);
            path = path.substring(1, path.length());
            for(int i = 0; i < path.length(); i++)
            {
                if(path.charAt(i) == '1')
                    n = n.getRightChild();
                else
                    n = n.getLeftChild();
            }
            if( n.getPair() != null)
            {
                System.out.print("The " + (x+1) + "th value is: " + n.getPair().getValue());
            }
            if( n.getPair() == null)
            {
                System.out.print("The " + (x+1) + "th value has no value");
            }

            if(n.isRed())
            {
                System.out.println(" The "+ (x+1) + "th node is RED.");
            }
            else
            {
                System.out.println(" The "+ (x+1) + "th node is BLACK.");
            }
        }

    }
}
