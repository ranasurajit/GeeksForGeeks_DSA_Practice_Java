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
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(node.data);
        if (!isLeaf(node)) {
            // insert left boundary
            insertLeftBoundary(node, path);
            // insert leaf nodes
            insertLeafNodes(node, path);
            // insert right boundary
            insertRightBoundary(node, path);
        }
        return path;
    }
    
    private void insertLeftBoundary(Node node, ArrayList<Integer> path) {
        Node leftNode = node.left;
        while (leftNode != null) {
            if (isLeaf(leftNode)) {
                break;
            }
            path.add(leftNode.data);
            if (leftNode.left != null) {
                leftNode = leftNode.left;
            } else {
                leftNode = leftNode.right;
            }
        }
    }
    
    private void insertLeafNodes(Node node, ArrayList<Integer> path) {
        if (node == null) {
            return;
        }
        if (isLeaf(node)) {
            path.add(node.data);
        }
        insertLeafNodes(node.left, path);
        insertLeafNodes(node.right, path);
    }
    
    private void insertRightBoundary(Node node, ArrayList<Integer> path) {
        Node rightNode = node.right;
        Stack<Integer> st = new Stack<Integer>();
        while (rightNode != null) {
            if (isLeaf(rightNode)) {
                break;
            }
            st.push(rightNode.data);
            if (rightNode.right != null) {
                rightNode = rightNode.right;
            } else {
                rightNode = rightNode.left;
            }
        }
        while (!st.isEmpty()) {
            path.add(st.pop());
        }
    }
    
    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
}
