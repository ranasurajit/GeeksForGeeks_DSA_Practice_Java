//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Node root = null;

            // Read inorder array
            String[] inorderStr = (br.readLine()).trim().split(" ");
            int inorder[] = new int[inorderStr.length];
            for (int i = 0; i < inorderStr.length; i++) {
                inorder[i] = Integer.parseInt(inorderStr[i]);
            }

            // Read preorder array
            String[] preorderStr = (br.readLine()).trim().split(" ");
            int preorder[] = new int[preorderStr.length];
            for (int i = 0; i < preorderStr.length; i++) {
                preorder[i] = Integer.parseInt(preorderStr[i]);
            }

            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder);
            postOrder(root);
            System.out.println();
        }
    }

    // Function to print postorder traversal of the tree
    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/

class Solution {
    /**
     * TC: O(N)
     * SC: O(N)
     */
    public static Node buildTree(int inorder[], int preorder[]) {
        int n = inorder.length;
        int[] index = { 0 };
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);
        }
        return solve(0, n - 1, index, inorder, preorder, n, inMap);
    }
    
    /**
     * TC: O(N)
     * SC: O(N)
     */ 
    private static Node solve(int start, int end, int[] index,
        int inorder[], int preorder[], int n, Map<Integer, Integer> inMap) {
        if (start > end) {
            return null;
        }
        // pre-order means - Root Left Right, so root of our Tree is 0th index of pre-order
        // in-order means - Left Roor Right
        int rootValue = preorder[index[0]];
        index[0]++;
        Node root = new Node(rootValue);
        // find the index of root node value in in-order
        int p = inMap.get(rootValue);
        root.left = solve(start, p - 1, index, inorder, preorder, n, inMap);
        root.right = solve(p + 1, end, index, inorder, preorder, n, inMap);
        return root;
    }
}
