//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends


class Solution {
    /**
     * Approach I : Using DFS Approach
     * 
     * TC: O(2 x V + 3 x E) ~ O(V + E)
     * SC: O(3 x V + E) ~ O(V + E)
     */
    public boolean isBridge(int V, int[][] edges, int u, int v) {
        Map<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(V + E)
        // creating adjacency list without creating edge between u and v
        for (int[] edge : edges) { // TC: O(E)
            if ((edge[0] == u && edge[1] == v) || (edge[0] == v && edge[1] == u)) {
                continue;
            }
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        // without considering edge between u and v
        int removalCount = getConnectedComponents(adj, V); // TC: O(V + E), SC: O(V)
        // now considering edge between u and v
        adj.computeIfAbsent(u, k -> new ArrayList<Integer>()).add(v);
        adj.computeIfAbsent(v, k -> new ArrayList<Integer>()).add(u);
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