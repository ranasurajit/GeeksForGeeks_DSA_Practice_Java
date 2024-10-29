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

class SortLL {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            addToTheLast(head);

            for (int i = 1; i < n; i++) {
                int a = Integer.parseInt(str[i]);
                addToTheLast(new Node(a));
            }

            GfG gfg = new GfG();
            Node node = gfg.quickSort(head);

            printList(node);
            System.out.println();
        
System.out.println("~");
}
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
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

}*/
// you have to complete this function
class GfG {
    /**
     * TC: O(N x log(N))
     * SC: O(1)
     */
    public static Node quickSort(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node[] left = new Node[1];
        Node[] right = new Node[1];
        // considering head or 1st node as the pivot node
        partition(node, left, right);
        left[0] = quickSort(left[0]);
        right[0] = quickSort(right[0]);
        Node current = left[0];
        while (current != null && current.next != null) {
            current = current.next;
        }
        if (current != null) {
            current.next = node;
        } else {
            left[0] = node;
        }
        node.next = right[0];
        return left[0];
    }
    
    private static void partition(Node pivot, Node[] left, Node[] right) {
        Node temp = pivot.next;
        while (temp != null) {
            Node nxt = temp.next;
            if (temp.data <= pivot.data) {
                temp.next = left[0];
                left[0] = temp;
            } else {
                temp.next = right[0];
                right[0] = temp;
            }
            temp = nxt;
        }
    }
}
