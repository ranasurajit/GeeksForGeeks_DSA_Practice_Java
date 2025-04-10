//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);

            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }

            Node head = new Node(arr.get(0));
            Node tail = head;

            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }

            Solution ob = new Solution();
            Node[] result = ob.alternatingSplitList(head);
            printList(result[0]);
            printList(result[1]);
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
/*
struct Node
{
    int data;
    struct Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }

};
*/

class Solution {
    // Function to append a new node with newData at the end of a linked list
    /**
     * TC: O(N) - tarverses all nodes
     * SC: O(1)
     */
    Node[] alternatingSplitList(Node head) {
        if (head == null) {
            return new Node[] { null, null };
        }
        Node head1 = head;
        Node head2 = head.next;
        if (head2 == null) {
            return new Node[] { head1, head2 };
        }
        Node current1 = head1;
        Node current2 = head2;
        while (current2 != null) {
            current1.next = current2.next;
            current1 = current1.next;
            if (current1 != null) {
                current2.next = current1.next;
            }
            current2 = current2.next;
        }
        return new Node[] { head1, head2 };
    }
}
