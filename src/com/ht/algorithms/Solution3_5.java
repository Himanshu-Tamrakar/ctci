package com.ht.algorithms;

import edu.princeton.cs.algs4.Stack;

public class Solution3_5 {

    private static class SortStack {
        Stack<Integer> stack = null;
        Stack<Integer> sortStack = null;
        public SortStack() {
            this.stack = new Stack<>();
            this.sortStack = new Stack<>();
        }

        public void push(int item) {
            this.stack.push(item);
        }

        public int pop() throws Exception {
            if (this.stack.isEmpty()) {
                throw new Exception("Underflow");
            }
            return this.stack.pop();
        }

        public int peek() throws Exception {
            if (this.stack.isEmpty()) {
                throw new Exception("Underflow");
            }
            return this.stack.peek();
        }

        private void sortAscending(Stack<Integer> stack, Stack<Integer> sortStack, int elem) {
            int i = 0;
            while (sortStack.size() > 0 && sortStack.peek() < elem) {
                stack.push(sortStack.pop());
                i++;
            }
            sortStack.push(elem);
            while (i > 0) {
                sortStack.push(stack.pop());
                i--;
            }
        }

        private void sortDescending(Stack<Integer> stack, Stack<Integer> sortStack, int elem) {
            int i = 0;
            while (sortStack.size() > 0 && sortStack.peek() < elem) {
                stack.push(sortStack.pop());
                i++;
            }
            sortStack.push(elem);
            while (i > 0) {
                sortStack.push(stack.pop());
                i--;
            }
        }

        public Stack<Integer> sort() {
            while (stack.size() > 0) {
                sortAscending(stack, sortStack, stack.pop());
            }
            return sortStack;
        }
    }



    public static void main() {
        SortStack stack = new SortStack();
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(2);
        stack.push(8);
        Stack<Integer> sortStack = stack.sort();
        for (int item: sortStack) {
            System.out.printf("item: %d \n", item);
        }
    }

}
