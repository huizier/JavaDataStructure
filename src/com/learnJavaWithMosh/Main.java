package com.learnJavaWithMosh;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        /*Array numbers = new Array(3);
        System.out.println(numbers.max());
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.insert(50);
        numbers.insert(60);
        numbers.print();
        System.out.println("^^^^^");
        numbers.removeAt(5);
        numbers.print();
        System.out.println(numbers.max());
        System.out.println();
        numbers.print();
        System.out.println(numbers.getLength());
        System.out.println();
        System.out.println(numbers.indexOf(100));

        System.out.println();
        System.out.println("^^^^^");
        numbers.insertAt(100, 5);
        numbers.print();

        System.out.println();
        System.out.println("^^^^^");
        numbers.reverse();
        numbers.print();

        System.out.println("^^^^^");
        numbers.print();
        System.out.println("^^^^^");

        Array other = new Array(3);
        other.insert(40);
        *//*other.insert(20);
        other.insert(30);*//*
        other.print();
        System.out.println("^^^^^");
        numbers.intersect(other);
        numbers.print();




        System.out.println("-----------");
        ArrayList<Integer> listA = new ArrayList<>();
        listA.add(10);
        listA.add(20);
        listA.add(30);
        listA.add(20);

        ArrayList<Integer> listB = new ArrayList<>();
        listB.add(10);
        listB.add(20);
        listB.add(30);

        listA.retainAll(listB);
        System.out.println(listA);*/

        // Mosh: Use the standard java implementation to see how a specific case is handled
        //Exception in thread "main" java.util.NoSuchElementException
        //	at java.base/java.util.LinkedList.removeFirst(LinkedList.java:274)
        //	at com.learnJavaWithMosh.Main.main(Main.java:73)
        // This is a deliberate error handling, different from a NullPointerException
        /*java.util.LinkedList<String> x = new java.util.LinkedList<>();
        x.removeFirst();*/

        LinkedList list = new LinkedList();
        list.print();
        System.out.println(list.size());
        System.out.println(Arrays.toString(list.toArray()));
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addFirst(10);
        list.print();
        System.out.println();
        list.deleteLast();
        list.print();
        System.out.println();
        list.deleteFirst();
        list.print();
        System.out.println();
        System.out.println(list.contains(20));
        System.out.println(list.contains(50));
        System.out.println(list.indexOf(40));
        System.out.println(list.indexOf(0));
        System.out.println(list.size());
        System.out.println(Arrays.toString(list.toArray()));
        list.reverse();
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.getKthFromTheEnd(0));
        list.printMiddle();
        var listA = LinkedList.createWithLoop();
        System.out.println(listA.hasLoop());
    }
}
