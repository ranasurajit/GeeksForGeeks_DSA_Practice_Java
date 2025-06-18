/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    /**
     * Approach : Using BFS Approach
     * 
     * TC: O(N x log(N) + 2 x N) ~ O(N x log(N))
     * SC: O(2 x N) ~ O(N)
     */
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        List<int[]> nodePair = new ArrayList<int[]>(); // SC: O(N)
        Queue<Pair> queue = new LinkedList<Pair>();    // SC: O(N)
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) { // TC: O(N)
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                Node node = current.node;
                int col = current.col;
                nodePair.add(new int[] { node.data, col });
                if (node.left != null) {
                    queue.offer(new Pair(node.left, col - 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, col + 1));
                }
            }
        }
        nodePair.sort((int[] a, int[] b) -> a[1] - b[1]); // TC: O(N x log(N))
        int prevCol = Integer.MIN_VALUE;
        for (int[] node : nodePair) { // TC: O(N)
            int col = node[1];
            if (col != prevCol) {
                path.add(node[0]);
            }
            prevCol = col;
        }
        return path;
    }

    static class Pair {
        Node node;
        int col;
        
        public Pair (Node node, int col) {
            this.node = node;
            this.col = col;
        }
    }
}
