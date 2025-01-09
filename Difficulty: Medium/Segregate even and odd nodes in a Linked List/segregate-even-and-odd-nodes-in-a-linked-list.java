//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    Integer nextInt() { return Integer.parseInt(next()); }
}

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
            Node ans = ob.divide(head);
            printList(ans);
            t--;
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

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
    /**
     * Optimal Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    Node divide(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node evenHead = null;
        Node oddHead = null;
        Node evenTail = null;
        Node oddTail = null;
        Node current = head;
        while (current != null) {
            if (current.data % 2 == 0) {
                // even value nodes
                if (evenHead == null) {
                    evenHead = evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = evenTail.next;
                }
            } else {
                // odd value nodes
                if (oddHead == null) {
                    oddHead = oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = oddTail.next;
                }
            }
            current = current.next;
        }
        if (evenHead == null) {
            return oddHead;
        }
        if (oddHead == null) {
            return evenHead;
        }
        // removing unwanted values from end of odd node
        oddTail.next = null;
        evenTail.next = oddHead;
        return evenHead;
    }
    
    /**
     * Brute-Force Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    Node divideBruteForce(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node evenHead = new Node(-1);
        Node oddHead = new Node(-1);
        Node evenNode = evenHead;
        Node oddNode = oddHead;
        Node current = head;
        while (current != null) {
            if (current.data % 2 == 0) {
                evenNode.next = new Node(current.data);
            } else {
                oddNode.next = new Node(current.data);
            }
            if (evenNode.next != null) {
                evenNode = evenNode.next;
            }
            if (oddNode.next != null) {
                oddNode = oddNode.next;
            }
            current = current.next;
        }
        evenNode.next = oddHead.next;
        return evenHead.next;
    }
}
