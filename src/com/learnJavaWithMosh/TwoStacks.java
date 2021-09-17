package com.learnJavaWithMosh;

import java.util.Arrays;

public class TwoStacks {
    private int[] stack;
    private int top1;
    private int top2;

    public TwoStacks(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("capacity must be 1 or greater.");
        stack = new int[capacity];
        top1 = -1;
        top2 = capacity;
    }

    // push1
    public void push1(int item) {
        if (isFull1())
            throw new IllegalStateException();
        stack[++top1] = item;
    }
    // push2
    public void push2(int item) {
        if (isFull2())
            throw new IllegalStateException();
        stack[--top2] = item;
    }
    // pop1
    public int pop1() {
        if(isEmpty1())
            throw new IllegalStateException();
        return stack[top1--];
    }
    // pop2
    public int pop2() {
        if(isEmpty2())
            throw new IllegalStateException();
        return stack[top2++];
    }
    // isEmpty1
    public boolean isEmpty1() {
        return top1 == -1;
    }
    // isEmpty2
    public boolean isEmpty2() {
        return top2 == stack.length;
    }
    // isFull1
    public boolean isFull1() {
        return top2 - top1 == 1;
    }
    // isFull2
    public boolean isFull2() {
        return top2 - top1 == 1;
    }

    @Override
    public String toString() {
        return(Arrays.toString(stack));
    }
}
