//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution ob = new Solution();
            if (ob.isHeap(root))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User Function template for JAVA

/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    /**
     * Approach : Using DFS Approach
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    boolean isHeap(Node tree) {
        int total = countNodes(tree); // TC: O(N), SC: O(N)
        return solveDFSTree(tree, 0, total); // TC: O(N), SC: O(N)
    }
    
    /**
     * Using DFS Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    private boolean solveDFSTree(Node root, int idx, int total) {
        // Base Case
        if (root == null) {
            // all nodes are traversed so it satisfies the condition
            return true;
        }
        // Checking for Completeness
        if (idx >= total) {
            // for completeness test idx is always < total
            return false;
        }
        // Checking for Max-Heap Property
        if (root.left != null && root.data < root.left.data) {
            return false;
        }
        if (root.right != null && root.data < root.right.data) {
            return false;
        }
        // Recursive Calls
        return solveDFSTree(root.left, 2 * idx + 1, total) &&
            solveDFSTree(root.right, 2 * idx + 2, total);
    }

    /**
     * Using DFS Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    private int countNodes(Node root) {
        // Base Case
        if (root == null) {
            return 0;
        }
        // Recursive Calls
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
