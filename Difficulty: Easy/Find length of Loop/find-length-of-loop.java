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
     * Approach : Using Two Pointers (Fast and Slow Pointers) Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public int countNodesinLoop(Node head) {
        if (head == null || head.next == null) {
            return 0;
        }
        Node slow = head;
        Node fast = head;
        /**
         * Move slow and fast pointers by 1 and 2 steps respectively until
         * they meet
         */
        boolean hasLoop = false;
        while (fast != null && fast.next != null) { // TC: O(N)
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasLoop = true;
                break;
            }
        }
        if (!hasLoop) {
            return 0;
        }
        int count = 0;
        /**
         * Keep the fast pointer as is and move the slow pointer by 1 step
         * until they meet and keep incrementing count which will give the 
         * length of the loop
         */
        while (slow != null) { // TC: O(N)
            slow = slow.next;
            count++;
            if (slow == fast) {
                // count has the length of the loop
                break;
            }
        }
        return count;
    }
}
