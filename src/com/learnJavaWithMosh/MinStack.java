package com.learnJavaWithMosh;

/*
// Use basic array
public class MinStack {
    private int[] stack = new int[5];
    private int[] minStack = new int[5];
    private int count;

    // push
    public void push(int item) {
        if(count == stack.length)
            throw new IllegalStateException();

        if(count == 0 || minStack[count - 1] >= item)
            minStack[count] = item;
        else
            minStack[count] = minStack[count - 1];

        stack[count++] = item;
    }

    // pop
    public int pop() {
        if(count == 0)
            throw new IllegalStateException();
        return stack[--count];
    }

    // min
    public int min() {
        if(count == 0)
            throw new IllegalStateException();
        return minStack[count - 1];
    }
}
*/

// Use the stack defined in this package
public class MinStack {
    private Stack stack = new Stack();
    private Stack minStack = new Stack();

    public void push(int item) {
        stack.push(item);

        if(minStack.isEmpty() || minStack.peek() >= item)
            minStack.push(item);
        else
            minStack.push(minStack.peek());
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    public int min() {
        return minStack.peek();
    }
}

/*// Mosh's code. Wrong
public class MinStack {
    private Stack stack = new Stack();
    private Stack minStack = new Stack();

    public void push(int item) {
        stack.push(item);

        // Me: Wrong when two or more smallest value are in the stack, e.g., [3,2,5,1,1]
        // The min should be 1,1,2,2,3
        // With Moshes method, min is 1,2,2,2,3
        if (minStack.isEmpty())
            minStack.push(item);
        else if (item < minStack.peek())
            minStack.push(item);
    }

    public int pop() {
        if (stack.isEmpty()) // Me: unnecessary, the stack itself has this IllegalStateException when pop
            throw new IllegalStateException();

        var top = stack.pop();

        if (minStack.peek() == top)
            minStack.pop();

        return top;
    }

    public int min() {
        return minStack.peek();
    }
}*/

