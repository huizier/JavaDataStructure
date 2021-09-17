package com.learnJavaWithMosh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {
    String str;
    private final List<Character> leftBracket
            = Arrays.asList('(', '<', '[', '{');
    private final List<Character> rightBrackets
            = Arrays.asList(')', '>', '[', '{');

    public Expression(String str) {
        this.str = str;
    }

    public boolean isBalanced(){
        if(str == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();
        for(char ch : str.toCharArray()){
            if(isLeftBracket(ch))
                stack.push(ch);
            if(isRightBracket(ch)) {
                if(stack.empty()) return false;

                if(!bracketMatch(stack.pop(), ch))
                    return false;
            }
        }

       /* if(!stack.empty())
            return false;

        return true;*/
        return stack.empty();
    }

    private boolean isLeftBracket(char ch) {
        return leftBracket.contains(ch);
    }

    private boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private boolean bracketMatch(char left, char right) {
        return leftBracket.indexOf(left) == rightBrackets.indexOf(right);
    }
}
