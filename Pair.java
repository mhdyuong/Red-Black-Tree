package edu.cpp.cs.cs241.prog_assgmnt_4;


public class Pair<K extends Comparable<K>,V>
{
    /**
     * CS 241: Data Structures and Algorithms II
     * Professor: Edwin Rodríguez
     *
     * Programming Assignment 0
     *
     * To create a generic Arraylist class.
     *
     * 
     * By: Michelle Duong
     */
    /**
     * Holds the key 
     */ private K key;
    /**
     * Holds the value associated with a particular key.
     */
    private V value;
    /**
     * Constructor for the Pair class
     */
    public Pair(K key, V value)
    {
        this.key = key;
        this.value = value;
    }
    /**
     * Returns the key.
     */
    public K getKey()
    {
        return key;
    }
    /**
     * Returns the value.
     */
  
    public V getValue()
    {
        return value;
    }
}