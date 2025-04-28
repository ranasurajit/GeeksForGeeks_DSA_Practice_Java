//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class MaxSum {
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

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution ob = new Solution();
            int ans = ob.getMaxSum(root);
            System.out.println(ans);
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
/*class Node
{
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}*/

class Solution {
    // Function to return the maximum sum of non-adjacent nodes.
    /**
     * Approach : Using DP on Trees Approach
     * 
     * TC: O(N), as all nodes are visited once
     * SC: O(N), (worst case) as we traverse the height of tree so SC: O(H)
     * where H = log(N) in case of balanced Binary Tree and O(N) in case of skewed Tree
     */
    public int getMaxSum(Node root) {
        Pair pair = solve(root);
        return Math.max(pair.include, pair.exclude);
    }
    
    private Pair solve(Node root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        Pair left = solve(root.left);
        Pair right = solve(root.right);
        int include = root.data + left.exclude + right.exclude;
        int exclude = Math.max(left.include, left.exclude) + 
            Math.max(right.include, right.exclude);
        return new Pair(include, exclude);
    }
    
    static class Pair {
        int include;
        int exclude;
        
        public Pair(int inc, int exc) {
            this.include = inc;
            this.exclude = exc;
        }
    }
}
