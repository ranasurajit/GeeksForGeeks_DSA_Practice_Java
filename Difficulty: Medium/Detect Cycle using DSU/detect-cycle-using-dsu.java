class Solution {
    // Function to detect cycle using DSU in an undirected graph.
    /**
     * Approach : Using Disjoint-Set (Union By Rank and Find By Path Compression) Approach
     * 
     * TC: O(V) + O(V + E x α(V)) ~ O(V + E x α(V))
     * SC: O(V) + O(V) + O(V) ~ O(V)
     */
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] parent = new int[V];    // SC: O(V)
        int[] rank = new int[V];      // SC: O(V)
        for (int i = 0; i < V; i++) { // TC: O(V)
            parent[i] = i;
        }
        for (int u = 0; u < V; u++) { // TC: O(V)
            for (Integer v : adj.get(u)) { // TC: O(E)
                if (u < v) { // process each edge once
                    // u and v nodes are connected
                    int uParent = find(parent, u); // TC: O(α(V)), SC: O(V)
                    int vParent = find(parent, v); // TC: O(α(V)), SC: O(V)
                    if (uParent == vParent) {
                        return 1;
                    }
                    unionByRank(uParent, vParent, parent, rank); // TC: O(1)
                }
            }
        }
        return 0;
    }

    /**
     * Using Find By Path Compression
     * 
     * TC: O(α(V))
     * SC: O(V)
     */
    private int find(int[] parent, int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent, parent[x]);
    }
    
    /**
     * Using Union By Rank
     * 
     * TC: O(1)
     * SC: O(1)
     */
    private void unionByRank(int x, int y, int[] parent, int[] rank) {
        if (rank[x] > rank[y]) {
            // make x as parent of y
            parent[y] = x;
        } else if (rank[y] > rank[x]) {
            // make y as parent of x
            parent[x] = y;
        } else {
            // making anyone as parent
            parent[y] = x;
            rank[x]++;
        }
    }
}
