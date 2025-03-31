//{ Driver Code Starts
// Initial Template for Java
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
            ArrayList<ArrayList<Integer>> adj =
                new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    /**
     * Approach: Using DFS on Graph Approach
     * 
     * TC: O(2 x V + 2 x E) ~ O(V + E)
     * SC: O(2 x V) ~ O(V)
     */
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfsPath = new ArrayList<Integer>();
        int n = adj.size();
        boolean[] visited = new boolean[n]; // SC: O(V)
        for (int i = 0; i < n; i++) { // TC: O(V)
            if (!visited[i]) {
                dfsGraph(i, adj, visited, dfsPath); // TC: O(V + 2 x E), SC: O(V)
            }
        }
        return dfsPath;
    }
    
    /**
     * TC: O(V + 2 x E)
     * SC: O(V)
     */
    private void dfsGraph(int u, ArrayList<ArrayList<Integer>> adj,
        boolean[] visited, ArrayList<Integer> dfsPath) {
        visited[u] = true;
        dfsPath.add(u);
        for (Integer v : adj.get(u)) {
            if (!visited[v]) {
                dfsGraph(v, adj, visited, dfsPath);
            }
        }
    }
}

