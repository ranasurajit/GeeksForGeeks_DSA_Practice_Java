// User function Template for Java
class Solution {
    /**
     * Approach : Using Kruskal's Algorithm (MST) Approach
     * 
     * TC: O(E x log(E)) + O(V) + TC: O(2 x E x α(V)) ~ O(V + E x log(E) + E x α(V))
     * SC: O(V) + O(E) + O(V) ~ O(V + E)
     */
    static int kruskalsMST(int V, int[][] edges) {
        Arrays.sort(edges, (a, b) -> a[2] - b[2]); // TC: O(E x log(E))
        int[] parents = new int[V];   // SC: O(V)
        for (int i = 0; i < V; i++) { // TC: O(V)
            parents[i] = i;
        }
        int[] rank = new int[V]; // SC: O(V)
        int sumMST = 0;
        for (int[] edge : edges) { // TC: O(E)
            int uParent = find(parents, edge[0]); // TC: O(α(V)), SC: O(V)
            int vParent = find(parents, edge[1]); // TC: O(α(V)), SC: O(V)
            if (uParent == vParent) {
                continue;
            }
            sumMST += edge[2];
            unionByRank(uParent, vParent, parents, rank); // TC: O(1)
        }
        return sumMST;
    }

    /**
     * Using Find By Path Compression Approach
     * 
     * TC: O(1)
     * SC: O(1)
     */
    private static void unionByRank(int x, int y, int[] parents, int[] rank) {
        if (rank[x] > rank[y]) {
            // make x as parent of y
            parents[y] = x;
        } else if (rank[y] > rank[x]) {
            // make y as parent of x
            parents[x] = y;
        } else {
            // make anyone as parent increasing it's rank
            // make x as parent of y
            parents[y] = x;
            rank[x]++;
        }
    }

    /**
     * Using Find By Path Compression Approach
     * 
     * TC: O(α(V))
     * SC: O(V)
     */
    private static int find(int[] parents, int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents, parents[x]);
    }
}
