//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        
        while (tc-- > 0) {
            int V = scanner.nextInt();
            int E = scanner.nextInt();
            
            List<Integer>[] adj = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < E; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                adj[u].add(v);
                adj[v].add(u);
            }
            
            // String x=scanner.nextLine();
            // scanner.nextLine();
            
            Solution obj = new Solution();
            int ans = obj.isEulerCircuit(V, adj);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Solution{
    /**
     * TC: O(V + E)
     * SC: O(V)
     */
    public int isEulerCircuit(int V, List<Integer>[] adj) {
        // are all non-zero outdegree vertices connected
        boolean isConnected = isVerticesConnected(adj, V); // TC: O(V + E), SC: O(V)
        if (!isConnected) {
            return 0; // Non-Eulerian Graph
        }
        // calculate odd outdegrees
        int countOddDegrees = 0;
        for (int i = 0; i < V; i++) {                     // TC: O(V)
            if (adj[i].size() % 2 != 0) {
                // odd out degree
                countOddDegrees++;
            }
        }
        if (countOddDegrees > 2) {
            return 0; // Non-Eulerian Graph
        } else if (countOddDegrees == 2) {
            return 1; // Semi-Eulerian Graph (contains Eulerian Path)
        }
        return 2; // Eulerian Graph (contains Eulerian Circuit)
    }
    
    /**
     * TC: O(3 x V + E) ~ O(V + E)
     * SC: O(2 x V) ~ O(V)
     */
    private boolean isVerticesConnected(List<Integer>[] adj, int V) {
        int nonDegreeVertex = -1;
        for (int i = 0; i < V; i++) {            // TC: O(V)
            if (adj[i].size() > 0) {
                nonDegreeVertex = i;
                break;
            }
        }
        // perform DFS from non-zero vertex to populate the visited array
        boolean[] visited = new boolean[V];      // SC: O(V)
        dfsGraph(nonDegreeVertex, adj, visited); // TC: O(V + E), SC: O(V)
        for (int i = 0; i < V; i++) {            // TC: O(V)
            if (!visited[i] && adj[i].size() > 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * TC: O(V + E)
     * SC: O(V)
     */
    private void dfsGraph(int u, List<Integer>[] adj, boolean[] visited) {
        visited[u] = true;
        for (Integer v : adj[u]) {
            if (!visited[v]) {
                dfsGraph(v, adj, visited);
            }
        }
    }
}
