//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class ReverseInSize {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {

            String s[] = in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < s.length; i++) {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverseKGroup(head, k);
            printList(res, out);
            out.println();

            out.println("~");
        }
        out.close();
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
    }
}

// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    /**
     * TC: O(N)
     * SC: O(N)
     * 
     * @param head
     * @param k
     * @return
     */
    public static Node reverseKGroup(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int count = 0;
        Node prev = null;
        Node current = head;
        while (current != null) {
            prev = current;
            current = current.next;
            count++;
            if (count == k) {
                break;
            }
        }
        prev.next = null;
        Node newHead = reverseLL(head); // TC: O(K), SC: O(K)
        head.next = reverseKGroup(current, k); // TC: O(N - K), SC: O(N - K)
        return newHead;
    }
    
    /**
     * TC: O(N)
     * SC: O(N)
     * 
     * @param head
     * @return
     */
    private static Node reverseLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node nextNode = head.next;
        Node newHead = reverseLL(nextNode);
        head.next = null;
        nextNode.next = head;
        return newHead;
    }
}
