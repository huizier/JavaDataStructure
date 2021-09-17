package com.learnJavaWithMosh;

import java.util.Arrays;
import java.util.LinkedList;

public class StackUsingLinkedList {
    LinkedList<Integer> stack = new LinkedList<>();

    // push
    public void push(int item) {
        stack.addLast(item);
    }

    // pop
    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();
        return stack.removeLast();
    }

    // peek
    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        return stack.peekLast();
    }

    // isEmpty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return Arrays.toString(stack.toArray());
    }
}
