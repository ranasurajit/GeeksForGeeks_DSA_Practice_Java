//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution {
    /**
     * Approach IV : Using Disjoint Set Union (By Rank and Path Compression) Approach
     * 
     * For c and d to be a Bridge, the parent of c and d should be different
     * 
     * TC: O(V + 4 x E x α(V)) ~ O(V + E)
     * SC: O(6 x V) ~ O(V)
     */
    public boolean isBridge(int V, int[][] edges, int c, int d) {
        int[] parent = new int[V]; // SC: O(V)
        for (int i = 0; i < V; i++) { // TC: O(V)
            parent[i] = i;
        }
        int[] rank = new int[V]; // SC: O(V)
        Arrays.fill(rank, 1);
        for (int[] edge : edges) { // TC: O(E)
            if ((edge[0] == c && edge[1] == d) || (edge[0] == d && edge[1] == c)) {
                continue;
            }
            int parentU = find(edge[0], parent); // TC: O(α(V)), SC: O(V)
            int parentV = find(edge[1], parent); // TC: O(α(V)), SC: O(V)
            if (parentU != parentV) {
                unionByRank(edge[0], edge[1], parent, rank); // TC: O(α(V)), SC: O(V)
            }
        }
        return find(parent[c], parent) != find(parent[d], parent); // TC: O(α(V)), SC: O(V)
    }

    /**
     * Using DSU Approach - Find By Path Compression
     * 
     * TC: O(α(V))
     * SC: O(V)
     */
    private int find(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }
    
    /**
     * Using DSU Approach - Union By Rank
     * 
     * TC: O(2 x α(V)) ~ O(α(V))
     * SC: O(2 x V) ~ O(V)
     */
    private void unionByRank(int x, int y, int[] parent, int[] rank) {
        int xParent = find(x, parent); // TC: O(α(V)), SC: O(V)
        int yParent = find(y, parent); // TC: O(α(V)), SC: O(V)
        if (xParent == yParent) {
            return;
        }
        if (rank[xParent] > rank[yParent]) {
            // x becomes parent of y
            parent[yParent] = xParent;
        } else if (rank[yParent] > rank[xParent]) {
            // y becomes parent of x
            parent[xParent] = yParent;
        } else {
            // anyone can become parent
            parent[yParent] = xParent;
            rank[x]++;
        }
    }
   
    /**
     * Approach III : Using BFS Approach
     * 
     * TC: O(V + 2 x E) ~ O(V + E)
     * SC: O(2 x V + E) ~ O(V + E)
     */
    public boolean isBridgeBFSApproachIII(int V, int[][] edges, int c, int d) {
        Map<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(V + E)
        // creating adjacency list without creating edge between u and v
        for (int[] edge : edges) { // TC: O(E)
            if ((edge[0] == c && edge[1] == d) || (edge[0] == d && edge[1] == c)) {
                continue;
            }
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        // we can check if we can somehow reach from source (c) to destination (d)
        boolean[] visited = new boolean[V]; // SC: O(V)
        if (bfsGraph(c, d, adj, visited)) { // TC: O(V + E), SC: O(V)
            return false;
        }
        return true;
    }
    
    /**
     * Using BFS Approach
     * 
     * TC: O(V + E)
     * SC: O(V)
     */
    private boolean bfsGraph(int src, int dest, Map<Integer, ArrayList<Integer>> adj, 
        boolean[] visited) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(src);
        visited[src] = true;
        while (!queue.isEmpty()) {
            Integer u = queue.poll();
            if (u == dest) {
                return true;
            }
            for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
                if (!visited[v]) {
                    queue.offer(v);
                    visited[v] = true;
                }
            }
        }
        return false;
    }
    
    /**
     * Approach II : Using DFS Approach
     * 
     * TC: O(V + 2 x E) ~ O(V + E)
     * SC: O(2 x V + E) ~ O(V + E)
     */
    public boolean isBridgeDFSApproachII(int V, int[][] edges, int c, int d) {
        Map<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(V + E)
        // creating adjacency list without creating edge between u and v
        for (int[] edge : edges) { // TC: O(E)
            if ((edge[0] == c && edge[1] == d) || (edge[0] == d && edge[1] == c)) {
                continue;
            }
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        // we can check if we can somehow reach from source (c) to destination (d)
        boolean[] visited = new boolean[V]; // SC: O(V)
        if (dfsGraphCanReach(c, d, adj, visited)) { // TC: O(V + E), SC: O(V)
            return false;
        }
        return true;
    }
    
    /**
     * Using DFS Approach
     * 
     * TC: O(V + E)
     * SC: O(V)
     */
    private boolean dfsGraphCanReach(int u, int dest, Map<Integer, ArrayList<Integer>> adj, 
        boolean[] visited) {
        if (dest == u) {
            return true;
        }
        visited[u] = true;
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (!visited[v]) {
                if (dfsGraphCanReach(v, dest, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Approach I : Using DFS Approach
     * 
     * TC: O(2 x V + 3 x E) ~ O(V + E)
     * SC: O(3 x V + E) ~ O(V + E)
     */
    public boolean isBridgeDFSApproachI(int V, int[][] edges, int c, int d) {
        Map<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(V + E)
        // creating adjacency list without creating edge between u and v
        for (int[] edge : edges) { // TC: O(E)
            if ((edge[0] == c && edge[1] == d) || (edge[0] == d && edge[1] == c)) {
                continue;
            }
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        // without considering edge between u and v
        int removalCount = getConnectedComponents(adj, V); // TC: O(V + E), SC: O(V)
        // now considering edge between u and v
        adj.computeIfAbsent(c, k -> new ArrayList<Integer>()).add(d);
        adj.computeIfAbsent(d, k -> new ArrayList<Integer>()).add(c);
        int additionCount = getConnectedComponents(adj, V); // TC: O(V + E), SC: O(V)
        return removalCount > additionCount;
    }
    
    /**
     * Using DFS Approach
     * 
     * TC: O(2 x V + E) ~ O(V + E)
     * SC: O(2 x V) ~ O(V)
     */
    private int getConnectedComponents(Map<Integer, ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V]; // SC: O(V)
        int count = 0;
        for (int i = 0; i < V; i++) { // TC: O(V)
            if (!visited[i]) {
                dfsGraph(i, adj, visited); // TC: O(V + E), SC: O(V)
                count++;
            }
        }
        return count;
    }
    
    /**
     * Using DFS Approach
     * 
     * TC: O(V + E)
     * SC: O(V)
     */
    private void dfsGraph(int u, Map<Integer, ArrayList<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (!visited[v]) {
                dfsGraph(v, adj, visited);
            }
        }
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            // V and E on separate lines
            int V = Integer.parseInt(sc.nextLine().trim());
            int E = Integer.parseInt(sc.nextLine().trim());

            // Using a 2D array to store edges.
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                // Use split("\\s+") to handle one or more whitespace characters
                String[] parts = sc.nextLine().trim().split("\\s+");
                edges[i][0] = Integer.parseInt(parts[0]);
                edges[i][1] = Integer.parseInt(parts[1]);
            }

            // c and d on separate lines
            int c = Integer.parseInt(sc.nextLine().trim());
            int d = Integer.parseInt(sc.nextLine().trim());

            Solution obj = new Solution();
            boolean result = obj.isBridge(V, edges, c, d);
            System.out.println(result ? "true" : "false");
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends