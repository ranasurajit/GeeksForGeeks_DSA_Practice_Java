//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.articulationPoints(V, edges);
            Collections.sort(ans);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    private static int time;
    
    /**
     * Approach II : Using Tarjan's Algorithm Approach
     * 
     * TC: O(V + E)
     * SC: O(V + E)
     */
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] isArticulation = new boolean[V];
        Arrays.fill(parent, -1);
        time = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, disc, low, parent, isArticulation, adj);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isArticulation[i]) result.add(i);
        }
        if (result.isEmpty()) result.add(-1);
        return result;
    }
    
    static void dfs(int u, boolean[] visited, int[] disc, int[] low, int[] parent, 
                    boolean[] isArticulation, List<List<Integer>> adj) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                dfs(v, visited, disc, low, parent, isArticulation, adj);

                low[u] = Math.min(low[u], low[v]);

                if (parent[u] == -1 && children > 1) isArticulation[u] = true;
                if (parent[u] != -1 && low[v] >= disc[u]) isArticulation[u] = true;
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
    
    /**
     * Approach I : Using DFS Approach
     * 
     * TC: O(V + 2 x E + V x (V + 2 x E)) ~ O(V x (V + E))
     * SC: O(V x (2 x V + E) + 2 x V + E) ~ O(V x (V + E))
     */
    static ArrayList<Integer> articulationPointsBruteForce(int V, int[][] edges) {
        Map<Integer, ArrayList<Integer>> adj = createGraph(edges, -1); // TC: O(E), SC: O(V + E)
        int currentComponentsCount =
            getDisconnectedComponents(V, adj, -1); // TC: O(V + E), SC: O(V)
        ArrayList<Integer> points = new ArrayList<Integer>();
        for (int i = 0; i < V; i++) { // TC: O(V)
            Map<Integer, ArrayList<Integer>> modifiedAdj = 
                createGraph(edges, i); // TC: O(E), SC: O(V + E)
            int modifiedComponentsCount = 
                getDisconnectedComponents(V, modifiedAdj, i); // TC: O(V + E), SC: O(V)
            if (modifiedComponentsCount > currentComponentsCount) {
                points.add(i);
            }
        }
        if (points.isEmpty()) {
            points.add(-1);
        }
        return points;
    }
    
    /**
     * Using Hashing Approach
     * 
     * TC: O(2 x E) ~ O(E)
     * SC: O(V + E)
     */
    private static Map<Integer, ArrayList<Integer>> createGraph(int[][] edges, int skipped) {
        Map<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>();
        for (int[] edge : edges) {
            if (skipped == edge[0] || skipped == edge[1]) {
                continue;
            }
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        return adj;
    }
    
    /**
     * Using DFS Approach
     * 
     * TC: O(2 x V + E) ~ O(V + E)
     * SC: O(2 x V) ~ O(V)
     */
    private static int getDisconnectedComponents(int V, 
        Map<Integer, ArrayList<Integer>> adj, int skipped) {
        int components = 0;
        boolean[] visited = new boolean[V]; // SC: O(V)
        if (skipped != -1) {
            visited[skipped] = true;
        }
        for (int i = 0; i < V; i++) { // TC: O(V)
            if (!visited[i]) {
                dfsGraph(i, adj, visited); // TC: O(V + E), SC: O(V)
                components++;
            }
        }
        return components;
    }
    
    /**
     * Using DFS Approach
     * 
     * TC: O(V + E)
     * SC: O(V)
     */
    private static void dfsGraph(int u, Map<Integer, ArrayList<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (!visited[v]) {
                dfsGraph(v, adj, visited);
            }
        }
    }
}
