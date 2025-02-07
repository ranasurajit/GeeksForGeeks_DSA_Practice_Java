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
     * Using DFS Approach
     * 
     * TC: O(N + 2 x log(N)) ~ O(N + log(N))
     * SC: O(N + 3 x log(N)) ~ O(N + log(N))
     * 
     * @param root
     * @return
     */
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(node.data);
        if (!isLeafNode(node)) {
            // get left boundary
            leftBoundary(node, path); // TC: O(log(N)), SC: O(log(N))
            // get leaf nodes boundary
            leafBoundary(node, path); // TC: O(N), SC: O(N)
            // get right boundary
            rightBoundary(node, path); // TC: O(log(N)), SC: O(2 x log(N))
        }
        return path;
    }
    
    /**
     * TC: O(log(N)), as only left side nodes are traversed
     * SC: O(log(N))
     * 
     * @param root
     * @param path
     */
    private void leftBoundary(Node root, ArrayList<Integer> path) {
        Node leftNode = root.left;
        while (leftNode != null) {
            if (isLeafNode(leftNode)) {
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

    /**
     * TC: O(log(N)), as only right side nodes are traversed
     * SC: O(2 x log(N))
     * 
     * @param root
     * @param path
     */
    private void rightBoundary(Node root, ArrayList<Integer> path) {
        Node rightNode = root.right;
        // needed as we need to print in reverse order
        Stack<Integer> st = new Stack<Integer>(); // SC: O(log(N))
        while (rightNode != null) {
            if (isLeafNode(rightNode)) {
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

    /**
     * TC: O(N), need to traverse all nodes
     * SC: O(N)
     * 
     * @param root
     * @param path
     */
    private void leafBoundary(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        if (isLeafNode(root)) {
            path.add(root.data);
        }
        leafBoundary(root.left, path);
        leafBoundary(root.right, path);
    }

    /**
     * TC: O(1)
     * SC: O(1)
     * 
     * @param root
     * @return
     */
    private boolean isLeafNode(Node root) {
        return root != null && root.left == null && root.right == null;
    }
}
