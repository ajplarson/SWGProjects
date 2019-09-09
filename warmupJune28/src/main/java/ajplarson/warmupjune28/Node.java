/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.warmupjune28;

/**
 *
 * @author ajplarson
 */
public class Node {
    private Node head;
    private Node next;
    private int number;
    void add(Node n, int i) {
         head = next;
        number = i;
        next = n;
    }
}
