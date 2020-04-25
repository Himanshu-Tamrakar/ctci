package com.ht.algorithms;

import libs.LinkedList;
import libs.Node;

public class Solution2_8 {
    /**
     * Very clever algorithms;
     * Run with slow with p and fast with 2p.
     * IT will meet at Starting loop point - k
     * Move from (head to k), and (loop point - k) and they meet loop starting point
     * @param list
     * @return
     */
    public static Node cycleNode(Node list) {
        Node slow = list;
        Node fast = list;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow.compareTo(fast) == 0) {
             break;
            }
        }
        if(fast == null) {
            return null;
        }

        slow = list;
        while (slow.compareTo(fast) != 0) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;


    }

    public static void main() {
     Node one = new Node(1, null);
     Node two = new Node(2, null);
     Node three = new Node(3, null);
     Node four = new Node(4, null);
     Node five = new Node(5, null);
     Node six = new Node(6, null);
     Node seven = new Node(7, null);
     Node eight = new Node(8, null);
     Node nine = new Node(9, null);
     Node ten = new Node(10, null);

     one.next = two;
     two.next = three;
     three.next = four;
     four.next = five;
     five.next = six;
     six.next = seven;
     seven.next = eight;
     eight.next = nine;
     nine.next = ten;
     ten.next = four;

     System.out.printf("%d", Solution2_8.cycleNode(one).data);

    }

    public static Node generateListAndReturn(int[] arr) {
        libs.LinkedList<Number> list = new LinkedList<Number>();
        for (int n: arr) {
            list.add(n);
        }
        return list.getList();
    }

}
