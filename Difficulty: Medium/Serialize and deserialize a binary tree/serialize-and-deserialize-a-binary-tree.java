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

    static void deletetree(Node root) {
        if (root == null) return;
        deletetree(root.left);
        deletetree(root.right);
        root.left = null;
        root.right = null;
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

            Tree tr = new Tree();
            ArrayList<Integer> A = tr.serialize(root);
            deletetree(root);
            root = null;

            Node getRoot = tr.deSerialize(A);
            printInorder(getRoot);
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the given function
Node is as follows:
class Tree{
    int data;
    Tree left,right;
    Tree(int d){
        data=d;
        left=right=null;
    }
}*/

class Tree {
    // Function to serialize a tree and return a list containing nodes of tree.
    /**
     * Using Pre-Order Traversal (DFS Approach)
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public ArrayList<Integer> serialize(Node root) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        serializeTree(root, path);
        return path;
    }
    
    /**
     * Using Pre-Order Traversal (DFS Approach) - Root, Left, Right
     * 
     * TC: O(N)
     * SC: O(N)
     */
    private void serializeTree(Node root, ArrayList<Integer> path) {
        if (root == null) {
            path.add(-1);
            return;
        }
        path.add(root.data);
        serializeTree(root.left, path);
        serializeTree(root.right, path);
    }

    // Function to deserialize a list and construct the tree.
    /**
     * Using DFS Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public Node deSerialize(ArrayList<Integer> arr) {
        int[] index = { 0 };
        return deSerializeTree(arr, index);
    }
    
    private Node deSerializeTree(ArrayList<Integer> arr, int[] index) {
        int value = arr.get(index[0]);
        index[0]++;
        if (value == -1) {
            return null;
        }
        Node node = new Node(value);
        node.left = deSerializeTree(arr, index);
        node.right = deSerializeTree(arr, index);
        return node;
    }
};
