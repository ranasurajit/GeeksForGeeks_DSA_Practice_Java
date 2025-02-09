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
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution tr = new Solution();
            int sum = tr.findMaxSum(root);
            System.out.println(sum);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


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
    // Function to return maximum path sum from any node in a tree.
    /**
     * Using DFS Approach
     * 
     * TC: O(N), as we are visiting all nodes only once
     * SC: O(N)
     */
    int findMaxSum(Node node) {
        int[] maxSum = { Integer.MIN_VALUE };
        solve(node, maxSum);
        return maxSum[0];
    }
    
    private int solve(Node node, int[] maxSum) {
        // Base case
        if (node == null) {
            return 0;
        }
        int leftSum = solve(node.left, maxSum);
        int rightSum = solve(node.right, maxSum);
        /**
         * 1st option - we get the answer in the bottom and 
         * we do not return to recursion
         * 
         * - neeche se hi accha hai
         */
        int convergedSum = leftSum + rightSum + node.data;
        /**
         * 2nd option - either of leftSum or rightSum contributes 
         * to answer so send it to recursion
         * 
         * koi ek hi accha hai
         */
        int comparedSum = Math.max(leftSum, rightSum) + node.data;
        /**
         * 3rd option - only root contributes to the answer 
         * so send it to recursion
         * 
         * sirf root hi accha hai
         */
        int rootSum = node.data;
        maxSum[0] = 
            Math.max(maxSum[0], 
                Math.max(convergedSum, 
                    Math.max(comparedSum, rootSum)));
        // send only comparedSum and rootSum to explore up the recursion
        return Math.max(comparedSum, rootSum);
    }
}
