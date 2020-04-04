package com.ht.algorithms;

import libs.Stack;

import java.util.ArrayList;
import java.util.Iterator;

public class Solution3_3 {
    private ArrayList<Stack> stackList = new ArrayList<>();
    private int capacity;

    public Solution3_3(int capacity) {
        this.capacity = capacity;
    }

    private Stack getLastStack() {
        int size = stackList.size();
        return this.stackList.get(size-1);
    }

    public void push(int item) {
        if(stackList.size() == 0) {
            Stack stack = new Stack(this.capacity);
            stack.push(item);
            stackList.add(stack);
            return;
        }
        Stack lastStack = getLastStack();

        if(!lastStack.push(item)) {
            Stack newStack = new Stack(capacity);
            newStack.push(item);
            stackList.add(newStack);
        }

    }

    private class Stack {
        private int capacity;
        private Node top = null, bottom = null;
        private int size = 0;

        public Stack(int capacity) {
            this.capacity = capacity;
        }

        public boolean push(int item) {
            if(this.size == this.capacity) return false;
            this.size++;
            Node newNode = new Node(item);
            if(top == null && bottom == null) {
                newNode.above = null;
                newNode.below = null;
                top = bottom = newNode;
            } else {
                Node tempTop = top;
                top = newNode;
                tempTop.above = top;
                top.below = tempTop;
            }
            return true;
        }

        private class Node {
            private int item;
            private Node above = null;
            private Node below = null;
            private Node(int item) {
                this.item = item;
            }
        }

    }

    public static void main() {
        Solution3_3 stackPlates = new Solution3_3(5);

        stackPlates.push(1);
        stackPlates.push(2);
        stackPlates.push(3);
        stackPlates.push(4);
        stackPlates.push(5);
        stackPlates.push(6);
        stackPlates.push(7);
        System.out.print(stackPlates);
    }
}
