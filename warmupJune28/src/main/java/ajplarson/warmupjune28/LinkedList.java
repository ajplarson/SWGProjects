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
public class LinkedList {

    Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void printList(LinkedList list) {
        Node currNode = list.head;
        System.out.println("The List: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }

        System.out.println();
    }

    public static LinkedList addLinkedList(LinkedList list, int data) {
        Node new_node = new Node(data);
        new_node.next = null;
        Node last = list.head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;
        return list;
    }

    public static LinkedList deleteByKey(LinkedList list, int key) {
        Node currNode = list.head, prev = null;
        if (currNode != null && currNode.data == key) {
            list.head = currNode.next;
            System.out.println(key);   
        }
        return list;
    }
}
