package com.ht.algorithms;

import edu.princeton.cs.algs4.Stack;

import java.util.Iterator;

public class Solution3_4 {
    private static class MyQueqe {
        Stack<Integer> stack = null;
        Stack<Integer> queue = null;

        public MyQueqe() {
            stack = new Stack<>();
            queue = new Stack<>();
        }

        public void enqueue(int item) {
            stack.push(item);
        }

        public int dequeue() throws Exception {
            if(queue.size() == 0) {
              while (stack.size() > 0) {
                  queue.push(stack.pop());
              }
            }
            if(queue.size() > 0) return queue.pop();
            else throw new Exception("underflow");
        }

        public int size() {
            return stack.size() + queue.size();
        }
    }

    public static void main() {
        MyQueqe queqe = new MyQueqe();
        queqe.enqueue(1);
        queqe.enqueue(2);
        queqe.enqueue(3);
        queqe.enqueue(4);
        try {
            System.out.println("size " + queqe.size());
            System.out.println(queqe.dequeue());
            System.out.println(queqe.dequeue());
            System.out.println(queqe.dequeue());
            System.out.println(queqe.dequeue());
            System.out.println("size " + queqe.size());

        } catch (Exception ex) {
            System.out.println(ex);
        }


    }
}
