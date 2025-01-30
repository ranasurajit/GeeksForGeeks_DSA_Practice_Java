//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    /**
     * Using DFS Approach
     *
     * TC: O(2 x V + E) ~ O(V + E)
     * SC: O(V)
     */
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V]; // SC: O(V)
        boolean[] inRecursion = new boolean[V]; // SC: O(V)

        for (int i = 0; i < V; i++) { // TC: O(V)
          if (!visited[i] && hasCycleDFS(i, adj, visited, inRecursion)) {
            return true; // TC: O(V + E), SC: O(V)
          }
        }
        return false;
    }
    
    /**
     * TC: O(V + E)
     * SC: O(V)
     */
    private static boolean hasCycleDFS(int u, ArrayList<ArrayList<Integer>> adj,
        boolean[] visited, boolean[] inRecursion) {
        visited[u] = true;
        inRecursion[u] = true;
        for (Integer v : adj.get(u)) {
          if (!visited[v] && hasCycleDFS(v, adj, visited, inRecursion)) {
            return true;
          } else if (inRecursion[v]) {
            return true;
          }
        }
        inRecursion[u] = false;
        return false;
    }
}

