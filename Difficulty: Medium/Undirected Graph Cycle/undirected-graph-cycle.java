//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    /**
     * Approach III : Using DSU Approach
     * 
     * TC: O(2 x V + E + 2 x V + 2 x E x α(V)) ~ O(V + E x α(V)) ~ O(V + E)
     * SC: O(4 x V + E) ~ O(V + E)
     */
    public boolean isCycle(int V, int[][] edges) {
        int[] parent = new int[V]; // SC: O(V)
        for (int i = 0; i < V; i++) { // TC: O(V)
            parent[i] = i;
        }
        int[] rank = new int[V]; // SC: O(V)
        Arrays.fill(rank, 1);
        
        // Creating Adjacency List
        Map<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(V + E)
        for (int[] edge : edges) { // TC: O(E)
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        // Checking for all vertices
        for (int u = 0; u < V; u++) { // TC: O(V)
            for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) { 
                if (u < v) {
                    int parentU = find(parent, u); // TC: O(α(V)), SC: O(V)
                    int parentV = find(parent, v); // TC: O(α(V)), SC: O(V)
                    if (parentU == parentV) {
                        return true;
                    } else {
                        unionByRank(u, v, parent, rank); // TC: O(V), SC: O(1)
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * Find by Path Compression Approach
     * 
     * TC: O(α(V))
     * SC: O(V)
     */
    private int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent, parent[x]);
    }
    
    /**
     * Union By Rank Approach
     * 
     * TC: O(2 x V) ~ O(V)
     * SC: O(1)
     */
    private void unionByRank(int x, int y, int[] parent, int[] rank) {
        int parentX = find(parent, x); // TC: O(N), SC: O(N)
        int parentY = find(parent, y); // TC: O(N), SC: O(N)
        if (parentX == parentY) {
            return;
        }
        if (rank[x] > rank[y]) {
            // parentX will be parent of parentY
            parent[parentY] = parentX;
        } else if (rank[x] < rank[y]) {
            // parentY will be parent of parentX
            parent[parentX] = parentY;
        } else {
            // make anyone as parent
            parent[parentY] = parentX;
        }
    }

    /**
     * Approach II : Using BFS Approach
     * 
     * TC: O(2 x V + 2 x E) ~ O(V + E)
     * SC: O(3 x V + E) ~ O(V + E)
     */
    public boolean isCycleBFS(int V, int[][] edges) {
        Map<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(V + E)
        for (int[] edge : edges) { // TC: O(E)
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        boolean[] visited = new boolean[V]; // SC: O(V)
        for (int i = 0; i < V; i++) {
            if (!visited[i] && bfsGraphHasCycle(i, adj, visited)) { // TC: O(V + E), SC: O(V)
                return true;
            }
        }
        return false;
    }
    
    /**
     * Using BFS Approach
     * 
     * TC: O(V + 2 x E) ~ O(V + E)
     * SC: O(V)
     */
    private boolean bfsGraphHasCycle(int src, Map<Integer, ArrayList<Integer>> adj,
        boolean[] visited) {
        // adding { node, parent } to the Queue
        Queue<int[]> queue = new LinkedList<int[]>(); // SC: O(V)
        queue.offer(new int[] { src , -1 });
        visited[src] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int u = current[0];
            int parent = current[1];
            for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
                if (v == parent) {
                    continue;
                }
                if (visited[v]) {
                    return true;
                } else {
                    queue.offer(new int[] { v, u });
                    visited[v] = true;
                }
            }
        }
        return false;
    }
 
    /**
     * Approach I : Using DFS Approach
     * 
     * TC: O(2 x V + 2 x E) ~ O(V + E)
     * SC: O(3 x V + E) ~ O(V + E)
     */
    public boolean isCycleDFS(int V, int[][] edges) {
        Map<Integer, ArrayList<Integer>> adj = 
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(V + E)
        for (int[] edge : edges) { // TC: O(E)
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        boolean[] visited = new boolean[V]; // SC: O(V)
        for (int i = 0; i < V; i++) { // TC: O(V)
            if (!visited[i] && dfsGraphHasCycle(i, -1, adj, visited)) { // TC: O(V + E), SC: O(V)
                return true;
            }
        }
        return false;
    }
    
    /**
     * Using DFS Approach
     * 
     * TC: O(V + 2 x E) ~ O(V + E)
     * SC: O(V)
     */
    private boolean dfsGraphHasCycle(int u, int parent, 
        Map<Integer, ArrayList<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (parent == v) {
                continue;
            }
            if (visited[v]) {
                return true;
            }
            if (dfsGraphHasCycle(v, u, adj, visited)) {
                return true;
            }
        }
        return false;
    }
}
