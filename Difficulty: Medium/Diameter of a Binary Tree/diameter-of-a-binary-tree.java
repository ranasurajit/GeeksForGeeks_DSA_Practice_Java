//{ Driver Code Starts
// Initial Template for Java

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

class GfG {

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

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            System.out.println(g.diameter(root));
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/*
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
*/

class Solution {
    /**
     * Using DFS Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    int diameter(Node root) {
        Pair treeDiameter = getDiameter(root);
        return treeDiameter.diameter;
    }
    
    /**
     * TC: O(N)
     * SC: O(N)
     */
    private Pair getDiameter(Node root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        Pair leftDiaPair = getDiameter(root.left);
        Pair rightDiaPair = getDiameter(root.right);
        // left diameter calculation
        int leftDia = leftDiaPair.diameter;
        // right diameter calculation
        int rightDia = rightDiaPair.diameter;
        // diameter = leftHeight + rightHeight
        int sumDia = leftDiaPair.height + rightDiaPair.height;
        // store the maximum diameter found
        int maxDia = Math.max(sumDia, Math.max(leftDia, rightDia));
        // store the maximum height found
        int maxHeight = 1 + Math.max(leftDiaPair.height, rightDiaPair.height);
        // return the max values to the method
        return new Pair(maxHeight, maxDia);
    }
    
    class Pair {
        int height;
        int diameter;
        
        public Pair(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
}
