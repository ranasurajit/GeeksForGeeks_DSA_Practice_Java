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

class pair {
    int first;
    int second;

    pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class GfG {

    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();

            String currVal = ip[i];

            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }

            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static boolean isBST(Node n, int lower, int upper) {
        if (n == null) return true;
        if (n.data <= lower || n.data >= upper) return false;
        return isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper);
    }

    static boolean compare(Node a, Node b, ArrayList<pair> mismatch) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        if (a.data != b.data) {
            mismatch.add(new pair(a.data, b.data));
        }

        return compare(a.left, b.left, mismatch) && compare(a.right, b.right, mismatch);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Node duplicate = buildTree(s);

            Solution ob = new Solution();
            ob.correctBST(root);

            if (!isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                System.out.println(0);
                continue;
            }

            ArrayList<pair> mismatch = new ArrayList<>();
            if (!compare(root, duplicate, mismatch)) {
                System.out.println(0);
                continue;
            }

            if (mismatch.size() != 2 ||
                mismatch.get(0).first != mismatch.get(1).second ||
                mismatch.get(0).second != mismatch.get(1).first) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }

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
    private Node prev;
    private Node first;
    private Node second;
    private Node temp;

    /**
     * Optimal Approach: Using In-order Traversal
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param root
     */
    void correctBST(Node root) {
        inorderDFS(root);
        if (second == null) {
            swapNodesValues(first, temp);
        } else {
            swapNodesValues(first, second);
        }
    }
    
    /**
     * TC: O(N)
     * SC: O(N)
     * 
     * @param root
     */
    private void inorderDFS(Node root) {
        if (root == null) {
            return;
        }
        inorderDFS(root.left);
        if (prev != null && root.data < prev.data) {
            if (first == null) {
                first = prev;
                temp = root;
            } else {
                second = root;
            }
        }
        prev = root;
        inorderDFS(root.right);
    }
    
    /**
     * TC: O(1)
     * SC: O(1)
     * 
     * @param node1
     * @param node2
     */
    private void swapNodesValues(Node node1, Node node2) {
        int tempRoot = node2.data;
        node2.data = node1.data;
        node1.data = tempRoot;
    }
    
    /**
     * Using In-order Traversal
     * 
     * TC: O(2 x N + N x log(N)) ~ O(N x log(N))
     * SC: O(4 x N) ~ O(N)
     * 
     * @param root
     */
    void correctBSTBruteForce(Node root) {
        // current path (should have been sorted for BST)
        List<Integer> path = new ArrayList<Integer>(); // SC: O(N)
        inorder(root, path); // TC: O(N), SC: O(N)
        List<Integer> sorted = new ArrayList<Integer>(path); // SC: O(N)
        // expected sorted array for BST
        Collections.sort(sorted); // TC: O(N x log(N))
        int[] index = { 0 };
        inorderCorrection(root, sorted, index); // TC: O(N), SC: O(N)
    }
    
    /**
     * Inorder Traversal
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param root
     * @param path
     */
    private void inorder(Node root, List<Integer> path) {
        if (root == null) {
            return;
        }
        inorder(root.left, path);
        path.add(root.data);
        inorder(root.right, path);
    }
    
    /**
     * Inorder Traversal
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param root
     * @param sorted
     * @param index
     */
    private void inorderCorrection(Node root,
            List<Integer> sorted, int[] index) {
        if (root == null) {
            return;
        }
        inorderCorrection(root.left, sorted, index);
        root.data = sorted.get(index[0]);
        index[0]++;
        inorderCorrection(root.right, sorted, index);
    }
}
