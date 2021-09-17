package com.learnJavaWithMosh;

import java.util.Arrays;

public class Stack {
    private int[] stack = new int[5];
    private int count;

    // push
    public void push(int item) {
        if(count == stack.length)
            throw new StackOverflowError();
        stack[count++] = item;
    }

    // pop
    public int pop() {
        if(isEmpty())
            throw new IllegalStateException();
        /*int top = stack[count - 1]; // Don't need to reset popped position to be 0
        stack[--count] = 0;
        return top;*/
        return stack[--count];
    }

    // peek
    public int peek() {
        if(isEmpty())
            throw new IllegalStateException();
        return stack[count - 1];
    }

    // isEmpty
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(stack, 0, count);
        return Arrays.toString(content);
    }

}
