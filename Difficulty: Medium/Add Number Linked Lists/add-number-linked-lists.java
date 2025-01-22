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
    /**
     * Using Two Pointers Approach
     * 
     * TC: O(3 x (M + N)) ~ O(M + N)
     * SC: O(1)
     * 
     * @param num1
     * @param num2
     * @return
     */
    static Node addTwoLists(Node num1, Node num2) {
        if (num1 == null) {
            return num2;
        }
        if (num2 == null) {
            return num1;
        }
        // reverse both the linked-lists
        num1 = reverseLL(num1); // TC: O(M)
        num2 = reverseLL(num2); // TC: O(N)
        // proceed with add operation
        int carry = 0;
        Node curr1 = num1;
        Node curr2 = num2;
        Node dummy = new Node(-1);
        Node temp = dummy;
        while (curr1 != null || curr2 != null) { // TC: O(M + N)
            int sum = carry;
            if (curr1 != null) {
                sum += curr1.data;
                curr1 = curr1.next;
            }
            if (curr2 != null) {
                sum += curr2.data;
                curr2 = curr2.next;
            }
            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            temp.next = new Node(sum);
            temp = temp.next;
        }
        if (carry > 0) {
            temp.next = new Node(carry);
        }
        // remove leading zeros after reversing the linked-list
        return removeLeadingZeros(reverseLL(dummy.next)); // TC: O(2 x (M + N)) ~ O(M + N)
    }
    
    /**
     * TC: O(N)
     * SC: O(1)
     */
    private static Node reverseLL(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     */
    private static Node removeLeadingZeros(Node head) {
        while (head.data == 0) {
            head = head.next;
        }
        return head;
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
