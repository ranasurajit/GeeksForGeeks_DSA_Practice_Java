class Solution {
    // Function to find number of strongly connected components in the graph.
    /**
     * Approach : Using Kosaraju's Algorithm Approach
     * 
     * TC: O(2 x V + E) + O(V + E) + O(2 x V + E) ~ O(V + E)
     * SC: O(V) + O(V) + O(V + E) + O(V) ~ O(V + E)
     */
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        /**
         * step 1: we need to find the topological sort Stack
         */
        Stack<Integer> st = new Stack<Integer>(); // SC: O(V)
        int v = adj.size();
        boolean[] visited = new boolean[v]; // SC: O(V)
        for (int i = 0; i < v; i++) { // TC: O(V)
            if (!visited[i]) {
                dfsTopoSortGraph(i, visited, st, adj); // TC: O(V + E), SC: O(V)
            }
        }
        /**
         * step 2 : reverse the adjacency list adj
         */
        Map<Integer, ArrayList<Integer>> revAdj = 
            reverseAdjacencyList(adj); // TC: O(V + E), SC: O(V + E)
        /**
         * step 3: reset the visited array and perform DFS on revAdj with nodes
         * popped from Stack formed in Step 1 and count disconnected components
         */
        visited = new boolean[v]; // SC: O(V) - reused
        int count = 0;
        while (!st.isEmpty()) { // TC: O(V)
            int u = st.pop();
            if (!visited[u]) {
                dfsGraphTraverse(u, visited, revAdj); // TC: O(V + E), SC: O(V)
                count++;
            }
        }
        return count;
    }
    
    /**
     * Using DFS Traversal Approach
     * 
     * TC: O(V + E)
     * SC: O(V)
     */
    private void dfsGraphTraverse(int u, boolean[] visited,
        Map<Integer, ArrayList<Integer>> revAdj) {
        visited[u] = true;
        for (Integer v : revAdj.getOrDefault(u, new ArrayList<Integer>())) {
            if (!visited[v]) {
                dfsGraphTraverse(v, visited, revAdj);
            }
        }
    }

    /**
     * Using Hashing Approach
     * 
     * TC: O(V + E)
     * SC: O(V + E)
     */
    private Map<Integer, ArrayList<Integer>> reverseAdjacencyList(ArrayList<ArrayList<Integer>> adj) {
        Map<Integer, ArrayList<Integer>> revAdj = new HashMap<Integer, ArrayList<Integer>>();
        for (int u = 0; u < adj.size(); u++) { // TC: O(V)
            for (int v : adj.get(u)) { // TC: O(E)
                revAdj.computeIfAbsent(v, k -> new ArrayList<Integer>()).add(u);
            }
        }
        return revAdj;
    }
    
    /**
     * Using DFS Traversal Approach
     * 
     * TC: O(V + E)
     * SC: O(V)
     */
    private void dfsTopoSortGraph(int u, boolean[] visited, Stack<Integer> st,
        ArrayList<ArrayList<Integer>> adj) {
        visited[u] = true;
        for (Integer v : adj.get(u)) {
            if (!visited[v]) {
                dfsTopoSortGraph(v, visited, st, adj);
            }
        }
        st.push(u);
    }
}
