package com.ht.algorithms;

import com.sun.org.apache.xerces.internal.xs.datatypes.XSDateTime;
import libs.Node;

import java.util.Stack;

public class Solution2_6 {
    private static Node reverse(Node root)  {
        Node head = null;
        while(root != null) {
            Node copyNode = new Node(root.data, null);
            copyNode.next = head;
            head = copyNode;
            root = root.next;
        }
        return head;
    }

    // Check length is lists has that method
    // if lenghts of list1 and list2 is not equal than return false;
    private static boolean isEqual(Node list1, Node list2) {
            while (list1 != null) {
                if(list1.data != list2.data) return false;
                list1 = list1.next;
                list2 = list2.next;
            }
            return true;
    }

    public static boolean isPalindrom_v1(Node root) {
        Node reverseRoot = reverse(root);
        return isEqual(root, reverseRoot);
    }

    public static boolean isPalindrom_v2(Node root) {
        Node first = root;
        Node runner = root.next;
        Stack<Integer> stack = new Stack<>();
        while (first != null && runner != null && runner.next != null) {
            stack.push(first.data);
            first = first.next;
            runner = runner.next.next;
        }

        if(runner != null) {
            stack.push(first.data);
            first = first.next;
        } else {
            first = first.next;
        }



        boolean notMatched = false;
        while (first != null) {
            if(first.data != stack.pop()) {
                return false;
            }
            first = first.next;
        }
        return stack.isEmpty();
    }
}

