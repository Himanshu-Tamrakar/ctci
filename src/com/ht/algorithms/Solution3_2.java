package com.ht.algorithms;

import edu.princeton.cs.algs4.Stack;

public class Solution3_2 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private int min = Integer.MAX_VALUE;

    public Solution3_2() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int item) {
        if(this.min > item) {
            this.min = item;
            this.minStack.push(this.min);
        }
        this.stack.push(item);

    }

    public int pop() {
        if(this.min() == this.stack.peek()) {
            this.minStack.pop();
        }
        return this.stack.pop();
    }

    public int min() {
        return this.minStack.peek();
    }

    public static void main() {
        Solution3_2 object = new Solution3_2();

        object.push(5);
        System.out.println("min is " + object.min());
        object.push(6);
        System.out.println("min is " + object.min());
        object.push(3);
        System.out.println("min is " + object.min());
        object.push(7);
        System.out.println("min is " + object.min());
        object.pop();
        System.out.println("min is " + object.min());
        object.pop();
        System.out.println("min is " + object.min());


    }
}
