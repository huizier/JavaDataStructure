package com.learnJavaWithMosh;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Array numbers = new Array(3);
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
        /*other.insert(20);
        other.insert(30);*/
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
        System.out.println(listA);

    }
}
