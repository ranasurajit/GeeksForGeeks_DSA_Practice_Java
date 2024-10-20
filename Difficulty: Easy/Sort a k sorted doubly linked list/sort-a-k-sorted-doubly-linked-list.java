//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}

public class Main {
    public static void push(DLLNode tail, int new_data) {
        DLLNode newNode = new DLLNode(new_data);
        newNode.next = null;
        newNode.prev = tail;

        if (tail != null) {
            tail.next = newNode;
        }
    }

    public static void printList(DLLNode head) {
        if (head == null) {
            return;
        }

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String[] arr = br.readLine().trim().split(" ");
            int k = Integer.parseInt(br.readLine().trim());

            DLLNode head = new DLLNode(Integer.parseInt(arr[0]));
            DLLNode tail = head;

            for (int i = 1; i < arr.length; i++) {
                push(tail, Integer.parseInt(arr[i]));
                tail = tail.next;
            }

            Solution obj = new Solution();
            DLLNode sorted_head = obj.sortAKSortedDLL(head, k);
            printList(sorted_head);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    /**
     * TC: O(N x log(K)) where N is total number of nodes of DLL
     * SC: O(K)
     */
    public DLLNode sortAKSortedDLL(DLLNode head, int k) {
        // Using min-heap to store k nodes - SC: O(K)
        PriorityQueue<DLLNode> pq = new PriorityQueue<DLLNode>((DLLNode p, DLLNode q) -> {
            return p.data - q.data;
        });
        int i = 0;
        while (i <= k) { // TC: O(log(K))
            pq.offer(head);
            head = head.next;
            i++;
        }
        DLLNode newHead = null;
        DLLNode current = null;
        while (!pq.isEmpty()) { // TC: O(N)
            if (newHead == null) {
                newHead = pq.poll(); // TC: O(log(K))
                newHead.next = null;
                newHead.prev = null;
                current = newHead;
            } else {
                current.next = pq.poll(); // TC: O(log(K))
                current.next.prev = current;
                current = current.next;
            }
            if (head != null) {
                // adding head to the Priority Queue
                pq.offer(head); // TC: O(log(K))
                head = head.next;
            }
        }
        current.next = null;
        return newHead;
    }
}
