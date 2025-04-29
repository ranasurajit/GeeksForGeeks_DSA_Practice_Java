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

public class LinkedList {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void makeLoop(Node head, Node tail, int x) {
        if (x == 0) return;

        Node curr = head;
        for (int i = 1; i < x; i++) curr = curr.next;

        tail.next = curr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            ArrayList<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int k = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            makeLoop(head, tail, k);

            Solution ob = new Solution();
            System.out.println(ob.countNodesinLoop(head));
        }
    }
}

// } Driver Code Ends


/*

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

class Solution {
    // Function to find the length of a loop in the linked list.
    /**
     * Approach : Using Floyd's Fast and Slow Pointers Approach
     * 
     * TC: O(3 x N) ~ O(N)
     * SC: O(1)
     */
    public int countNodesinLoop(Node head) {
        if (head == null) {
            // the linkedlist has no loop
            return 0;
        }
        Node slow = head;
        Node fast = head;
        // move slow pointer by 1 step and fast pointer by 2 steps
        while (fast != null && fast.next != null) { // TC: O(N)
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            // the linkedlist has no loop
            return 0;
        }
        /**
         * at this point slow and fast points to same node
         * 
         * now move slow pointer back to head
         * move both slow and fast pointers by 1 step to find
         * the start point of the loop
         */
        slow = head;
        while (slow != fast) { // TC: O(N)
            slow = slow.next;
            fast = fast.next;
        }
        int length = 1;
        // now move only fast pointer by 1 step till it meets slow pointer at start of loop
        fast = fast.next;
        while (slow != fast) { // TC: O(N)
            length++;
            fast = fast.next;
        }
        return length;
    }
}
