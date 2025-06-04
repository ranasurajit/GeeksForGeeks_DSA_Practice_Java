class Solution {
    /**
     * Approach II : Using Topological Sorting (Kahn's Algorithm) Approach
     * 
     * TC: O(3 x V + 2 x E) ~ O(V + E)
     * SC: O(4 x V + E) ~ O(V + E)
     */
    public int countPaths(int[][] edges, int V, int src, int dest) {
        Map<Integer, ArrayList<Integer>> adj = 
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(V + E)
        int[] indegrees = new int[V]; // SC: O(V)
        for (int[] edge : edges) {    // TC: O(E)
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            indegrees[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>(); // SC: O(V)
        for (int i = 0; i < V; i++) { // TC: O(V)
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        Map<Integer, Integer> pathCount = new HashMap<Integer, Integer>(); // SC: O(V)
        pathCount.put(src, 1); // there will be 1 way from src node
        while (!queue.isEmpty()) { // TC: O(V)
            Integer u = queue.poll();
            int currentCount = pathCount.getOrDefault(u, 0);
            for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) { // TC: O(V + E)
                indegrees[v]--;
                pathCount.put(v, pathCount.getOrDefault(v, 0) + currentCount);
                if (indegrees[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return pathCount.getOrDefault(dest, 0);
    }
    
    /**
     * Approach I : Using DFS Approach
     * 
     * TC: O(V + 2 x E) ~ O(V + E)
     * SC: O(3 x V + E) ~ O(V + E)
     */
    public int countPathsDFS(int[][] edges, int V, int src, int dest) {
        Map<Integer, ArrayList<Integer>> adj = createGraph(edges); // TC: O(E), SC: O(V + E)
        int[] count = { 0 };
        boolean[] visited = new boolean[V]; // SC: O(V)
        dfsGraph(src, dest, visited, adj, count); // TC: O(V + E), SC: O(V)
        return count[0];
    }
    
    /**
     * Using DFS Approach
     * 
     * TC: O(V + E)
     * SC: O(V)
     */
    private void dfsGraph(int u, int dest, boolean[] visited,
        Map<Integer, ArrayList<Integer>> adj, int[] count) {
        if (u == dest) {
            count[0]++;
            return;
        }
        visited[u] = true;
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (!visited[v]) {
                dfsGraph(v, dest, visited, adj, count);
            }
        }
        // backtrack visited to explore other paths
        visited[u] = false;
    }
    
    /**
     * Using Hashing Approach
     * 
     * TC: O(E)
     * SC: O(V + E)
     */
    private Map<Integer, ArrayList<Integer>> createGraph(int[][] edges) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
        }
        return adj;
    }
}
