package com.learnJavaWithMosh;

import java.util.Stack;

public class StringReverser {
    public String reverse(String input) {
        // Empty String means a String instance of zero length,
        // while a Null String means the absense of the String instance.
        if(input == null){
            throw new IllegalArgumentException();
        }
        Stack<Character> stack = new Stack<>();
        /*for(int i = 0; i < input.length(); i++)
            stack.push(input.charAt(i));*/
        for(char ch : input.toCharArray())
            stack.push(ch);

        /*String reversed = "";
        while(!stack.empty())
            // Mosh: There is a lot of string concatenations. Since String is immutable in Java, every concatenation
            // will cause a new String object being created in memory. Everytime a new memory is allocated,
            // and the existing characters are copied into the new memory space.
            // If the String is 1M characters long, it will be very expensive.
            reversed += stack.pop();*/

        // StringBuffer is used when we have a lot of string manipulation operations.
        StringBuffer reversed = new StringBuffer();
        while(!stack.empty())
            reversed.append(stack.pop());

        return reversed.toString();
    }
}
