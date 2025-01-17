//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;

            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }

            Solution ob = new Solution();
            head = ob.reverseList(head);
            printList(head);
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// function Template for Java

/* linked list node class:

class Node {
    int data;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

*/

class Solution {
    /**
     * Using Iterative Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node temp = current.next; // saving the reference of next node
            current.next = prev; // de-linking the pointer
            // moving pointers prev and current further
            prev = current;
            current = temp;
        }
        // prev will be pointing to the head of reversed linked-list
        return prev;
    }
    
    /**
     * Using Recursive Approach
     * 
     * TC: O(N)
     * SC: O(N) - Recursion Stack space used
     */
    Node reverseListRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node nextNode = head.next;   // saving the reference of next node
        Node newHead = reverseListRecursive(nextNode);
        head.next = null;
        nextNode.next = head;
        return newHead;
    }
}
