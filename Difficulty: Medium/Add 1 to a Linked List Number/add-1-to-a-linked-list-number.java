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

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        Node reverse = reverseLL(head);
        int carry = 1;
        Node current = reverse;
        while (current != null) {
            int value = current.data;
            // add previous carry = 1 to current node's data
            int addedValue = (carry + value);
            int rem = addedValue % 10;
            carry = addedValue / 10;
            current.data = rem;
            current = current.next;
        }
        reverse = reverseLL(reverse);
        /**
         * if carry is still left i.e > 0 we need to create a new Node 
         * with value 1 and add reverse nodes to it and return
         */
        if (carry > 0) {
            Node newNode = new Node(carry);
            newNode.next = reverse;
            return newNode;
        }
        // if carry = 0
        return reverse;
    }
    
    /**
     * Returns reverse of a LinkedList
     */
    private Node reverseLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
