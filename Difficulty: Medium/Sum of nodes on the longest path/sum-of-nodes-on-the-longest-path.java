/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
class Solution {
    /**
     * Approach : Using DFS Approach
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public int sumOfLongRootToLeafPath(Node root) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        int[] sum = { 0 };
        int[] length = { 0 };
        dfsTree(root, sum, length, map); // TC: O(N), SC: O(N)
        int maxLength = 0;
        for (Integer key : map.keySet()) { // TC: O(N)
            if (maxLength < key) {
                maxLength = key;
            }
        }
        return map.get(maxLength);
    }
    
    /**
     * Using DFS Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    private void dfsTree(Node root, int[] sum, int[] length, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        sum[0] += root.data;
        length[0] += 1;
        if (root.left == null && root.right == null) {
            // reached leaf node
            map.put(length[0], Math.max(sum[0], map.getOrDefault(length[0], 0)));
        }
        dfsTree(root.left, sum, length, map);
        dfsTree(root.right, sum, length, map);
        sum[0] = sum[0] - root.data; // backtrack
        length[0] -= 1; // backtrack
    }
}
