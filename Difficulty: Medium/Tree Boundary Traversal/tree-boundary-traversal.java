//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution T = new Solution();

            ArrayList<Integer> res = T.boundaryTraversal(root);
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    /**
     * Approach : Using DFS, Pre-order Traversal and Stacks Approach
     * 
     * TC: O(N + 2 x log(N)) ~ O(N)
     * SC: O(3 x log(N)) ~ O(log(N))
     */
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        if (node == null) {
            return path;
        }
        path.add(node.data);
        if (isLeafNode(node)) {
            return path;
        }
        printLeftBoundary(node, path);  // TC: O(log(N)), SC: O(log(N))
        printLeafNodes(node, path);     // TC: O(N), SC: O(log(N))
        printRightBoundary(node, path); // TC: O(log(N)), SC: O(log(N))
        return path;
    }
    
    /**
     * As we are travelling through height nodes
     * 
     * TC: O(log(N))
     * SC: O(log(N))
     */
    private void printLeftBoundary(Node node, ArrayList<Integer> path) {
        Node current = node.left;
        while (current != null) {
            if (isLeafNode(current)) {
                break;
            }
            path.add(current.data);
            if (current.left != null) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
    }
    
    /**
     * Using Pre-order Traversal
     * 
     * As we are travelling all nodes
     * 
     * TC: O(N)
     * SC: O(log(N))
     */
    private void printLeafNodes(Node node, ArrayList<Integer> path) {
        if (node == null) {
            return;
        }
        if (isLeafNode(node)) {
            path.add(node.data);
        }
        printLeafNodes(node.left, path);
        printLeafNodes(node.right, path);
    }
    
    /**
     * As we are travelling through height nodes
     * 
     * TC: O(log(N))
     * SC: O(log(N))
     */
    private void printRightBoundary(Node node, ArrayList<Integer> path) {
        Stack<Integer> st = new Stack<Integer>();
        Node current = node.right;
        while (current != null) {
            if (isLeafNode(current)) {
                break;
            }
            st.push(current.data);
            if (current.right != null) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        while (!st.isEmpty()) {
            path.add(st.pop());
        }
    }
    
    /**
     * TC: O(1)
     * SC: O(1)
     */
    private boolean isLeafNode(Node node) {
        return node != null && node.left == null && node.right == null;
    }
}
