//{ Driver Code Starts
// driver

import java.util.*;


// } Driver Code Ends
/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
    // Function to add two numbers represented by linked list.
    public static Node addTwoLists(Node num1, Node num2) {
        if (num1 == null) {
            return num2;
        }
        if (num2 == null) {
            return num1;
        }
        while (num1 != null && num1.data == 0) {
            num1 = num1.next;
        }
        while (num2 != null && num2.data == 0) {
            num2 = num2.next;
        }
        Node revNum1 = reverseList(num1);
        Node revNum2 = reverseList(num2);
        Node dummy = new Node(-1);
        Node temp = dummy;
        Node t1 = revNum1;
        Node t2 = revNum2;
        int carry = 0;
        while (t1 != null || t2 != null) {
            int sum = carry;
            if (t1 != null) {
                sum += t1.data;
                t1 = t1.next;
            }
            if (t2 != null) {
                sum += t2.data;
                t2 = t2.next;
            }
            int rem = sum % 10;
            temp.next = new Node(rem);
            carry = sum / 10;
            temp = temp.next;
        }
        if (dummy.next == null) {
            return new Node(carry);
        }
        if (carry > 0) {
            temp.next = new Node(carry);
            return reverseList(dummy.next);
        }
        return reverseList(dummy.next);
    }
    
    private static Node reverseList(Node node) {
        Node current = node;
        Node prev = null;
        
        while (current != null) {
            Node temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        
        return prev;
    }
    
}

//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();
            int val = sc.nextInt();

            Node num1 = new Node(val);
            Node tail = num1;
            for (int i = 0; i < n - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            int m = sc.nextInt();
            val = sc.nextInt();

            Node num2 = new Node(val);
            tail = num2;
            for (int i = 0; i < m - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);
        }
    }
}

// } Driver Code Ends