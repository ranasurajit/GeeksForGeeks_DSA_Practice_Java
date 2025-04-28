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


// } Driver Code Ends

// User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    /**
     * Approach II : Using Dummy Nodes and Traversal Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    static Node segregate(Node head) {
        if (head == null) {
            return null;
        }
        Node zeroDummy = new Node(-1);
        Node oneDummy = new Node(-1);
        Node twoDummy = new Node(-1);
        Node zeroTemp = zeroDummy;
        Node oneTemp = oneDummy;
        Node twoTemp = twoDummy;
        
        Node current = head;
        while (current != null) { // TC: O(N)
            if (current.data == 0) {
                zeroTemp.next = current;
                zeroTemp = zeroTemp.next;
            } else if (current.data == 1) {
                oneTemp.next = current;
                oneTemp = oneTemp.next;
            } else {
                twoTemp.next = current;
                twoTemp = twoTemp.next;
            }
            current = current.next;
        }
        zeroTemp.next = oneTemp.data == -1 ? twoDummy.next : oneDummy.next;
        oneTemp.next = twoTemp.data == -1 ? null : twoDummy.next;
        twoTemp.next = null;
        return zeroDummy.next;
    }

    /**
     * Approach I : Using a Min-Heap and Traversal Approach
     *
     * TC: O(2 x N x log(N)) ~ O(N x log(N))
     * SC: O(N)
     */
    static Node segregateApproachI(Node head) {
        if (head == null) {
            return null;
        }
        // Creating Min-Heap to store Pair (node, index)
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((Pair p, Pair q) -> {
           if (p.node.data == q.node.data) {
               return p.index - q.index;
           }
           return p.node.data - q.node.data;
        }); // SC: O(N)
        Node current = head;
        int index = 0;
        while (current != null) { // TC: O(N)
            pq.offer(new Pair(current, index++)); // TC: O(log(N))
            current = current.next;
        }
        Node dummy = new Node(-1);
        Node temp = dummy;
        while (!pq.isEmpty()) { // TC: O(N)
            temp.next = pq.poll().node; // TC: O(log(N))
            temp = temp.next;
        }
        return dummy.next;
    }
    
    static class Pair {
        Node node;
        int index;
        
        public Pair(Node node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}


//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().segregate(head);
            printList(head);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends