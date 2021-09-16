package com.learnJavaWithMosh;

import java.util.NoSuchElementException;

public class LinkedList {
    // Mosh: Move the Node class inside the LinkedList class and set the class to be private
    // Since Node is the implementation detail if the LinkedList class, and no where else should use it directly.
    // If it is public in another file outside the LinkedList, then it can be access anywhere in the package.
    // The LinkedList class (as we used in the java.util), take care of everything under the hood.
    // In this way, Node can only be used by LinkedList, and the LinkedList has access to the private variables inside
    // the Node class. Getters and setters are not needed.
    private class Node {
        private int value;
        private Node next; // Default initialization is null

        public Node(int value) {
            this.value = value;
        }
    }

    // Default initialization is null
    private Node first;
    private Node last;
    private int size;

/*    public LinkedList() {
        this.first = null;
        this.last = null;
    }*/

    // addFirst
    public void addFirst(int number){
        // A custom constructor is needed since it doesn't make sense to have a Node without a value
        var newNode = new Node(number);

        if(isEmpty())
            first = last = newNode; // Simplified one line writing
        else{ // Looks better than if... return without else.
            newNode.next = first;
            first = newNode;
        }
        size++;
    }
    // addLast
    public void addLast(int number) {
        var newNode = new Node(number);
        if(isEmpty())
            first = last = newNode;
        else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    // Mosh: makes the code more readable
    private boolean isEmpty() {
        return first == null;
    }

    // deleteFirst
    public void deleteFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if(first == last) {
            first = last = null;
            size--; // Don't forget. And can use if else and size-- at the end, see deleteLast.
            return; // Don't forget!!!
        }

        Node next = first.next;
        first.next = null;
        first = next;
        size--;
    }

    // deleteLast
    public void deleteLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
        } else {
            // Mosh: The following logic assumes that we have at least two nodes, since if we only have one node, there's
            // no previous node.
            var previous = getPrevious(last);
            last = previous;
            previous.next = null;
        }
        size--;
    }

    private Node getPrevious(Node node) {
        Node current = first;
        while(current != null) {
            if(current.next == node) return current;
            current = current.next;
        }
        return null;
    }
    // contains
    public boolean contains(int number) {
        /*Node current = first;
        while(current != null) {
            if(current.value == number) return true;
            current = current.next;
        }
        return false;*/
        return indexOf(number) != -1;
    }

    // indexOf
    public int indexOf(int number) {
        // Me: This line is unnecessary since curent != null already include this case
        // if(isEmpty()) return -1;
        int index = 0;
        Node current = first;
        while(current != null) {
            if(current.value == number) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public void print() {
        Node current = first;
        while(current != null){
            System.out.println(current.value);
            current = current.next;
        }
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        var array = new int[size];
        var current = first;
        int count = 0;
        while(current != null) {
            array[count++] = current.value;
            current = current.next;
        }
        return array;
    }

    // A <- B <- C  D -> E -> null
    // one = A, two = A.next, three = two.next    // A -> B -> C -> D -> E -> null
    // two.next = one                             // A <- B    C -> D -> E -> null
    // one = two, two = three, three = three.next // A <- B    C -> D -> E -> null
    // two.next = one                             // A <- B <- C    D -> E -> null
    //...
    // three = null, one, two                     // A <- B <- C <- D    E -> null
    // two.next = one                             // A <- B <- C <- D <- E    null
    // last = first, first = two

/*    public void reverse(){
        if(isEmpty()) return;
        if(first.next == null) return;

        var firstNode = first;
        var secondNode = firstNode.next;
        var thirdNode = secondNode.next;
        while(thirdNode != null) {
            secondNode.next = firstNode;
            firstNode = secondNode;
            secondNode = thirdNode;
            thirdNode = thirdNode.next;
        }

        secondNode.next = firstNode;
        last = first;
        last.next = null; // Don't forget!
        first = secondNode;
    }*/

    // Mosh's code
    // [A -> B -> C]
    //  p    c    n (n is needed, otherwise when B change the next, C will lose reference/can not find C)
    public void reverse() {
        if (isEmpty()) return;

        var previous = first;  // Me: variable name is better
        var current = first.next;
        while (current != null) {
            // Me: include "secondNode.next = firstNode;", include the case when only one item is in the list
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first; // Mosh: ADD Attention deficit disorder. Put related code together
        last.next = null; // Don't forget!
        first = previous;
    }

    // Mosh's comment
    // Find the Kth node from the end of a linked list in one pass
    // [10 -> 20 -> 30 -> 40 -> 50]
    //               *           *
    // K = 1 (50)
    // K = 2 (40)
    // K = 3 (30)
    // ...
    // Note: the distance between two pointers should be K - 1 instead of K.
    public int getKthFromTheEnd( int k ) {
        if(isEmpty())
            throw new IllegalStateException();
        /*if( k <= 0 ) {
            // Mosh: May not be necessary, because k = 0 or k = 1 both return the last element. May be over defensive.
            // Me: Whether to handle these two cases depends on the real scenario.
            throw new IllegalArgumentException();
        }*/
        var firstNode = first; // Mosh: define as a and b
        var secondNode = firstNode;
        for(int i = 1; i <= k - 1; i++) {
            secondNode = secondNode.next;
            if(secondNode == null) {
                throw new IllegalArgumentException();
            }
        }

        while(secondNode != last) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }

        return firstNode.value;
    }

    // [ 10 -> 20 -> 30 -> 40 -> 50]
    //               m1
    //               m2
    //                            t
    public void printMiddle() {
        Node[] m = new Node[2];
        if(isEmpty()) {
            throw new IllegalStateException();
        }
        m[0] = first;
        m[1] = first;
        var tail = first;
        var index = 0;
        while(tail != last) {
            tail = tail.next;
            m[index] = m[index].next;
            index = 1 - index;
        }

        if(m[0].value == m[1].value)
            System.out.println("The middle is " + m[0].value);
        else
            System.out.println("The middles are " + m[1].value + " and " + m[0].value);
    }

    public boolean hasLoop() {
        var slow = first;
        var fast = first;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public static LinkedList createWithLoop() {
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Get a reference to 30
        var node = list.last;

        list.addLast(40);
        list.addLast(50);

        // Create the loop
        list.last.next = node;

        return list;
    }
}

