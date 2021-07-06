package edu.cpp.cs.cs241.prog_assgmnt_4;

import java.util.*;
/**
 * Write a description of class Runner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Runner
{
    public static void main(String[] args)
    {
        RedBlackTree tree = new RedBlackTree<>();
        tree.add(42,42);
        tree.add(23,23);
        tree.add(52,52);
        tree.add(19,19);
        tree.add(21,21);
        tree.printTree();
    }
}
