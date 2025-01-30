//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            S = br.readLine().trim().split(" ");
            int E = Integer.parseInt(S[0]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(adj);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    /**
     * Using DFS Approach
     * 
     * TC: O(2 x V + 2 x E) ~ O(V + E)
     * SC: O(2 x V) ~ O(V)
     */
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size();
        int[] color = new int[v];     // SC: O(V)
        Arrays.fill(color, -1);
        for (int i = 0; i < v; i++) { // TC: O(V)
            if (color[i] == -1 && !isdfsBipartiteGraph(i, adj, color, 1)) {
                return false;          // TC: O(V + 2 x E), SC: O(V)
            }
        }
        return true;
    }
    
    /**
     * Using DFS Algorithm
     * 
     * TC: O(V + 2 x E)
     * SC: O(V)
     */
    private boolean isdfsBipartiteGraph(int u, ArrayList<ArrayList<Integer>> adj,
        int[] color, int currentColor) {
        color[u] = currentColor;
        for (Integer v : adj.get(u)) {
            if (color[v] == color[u]) {
                return false;
            }
            int altColor = 1 - currentColor;
            if (color[v] == -1 && !isdfsBipartiteGraph(v, adj, color, altColor)) {
                return false;
            }
        }
        return true;
    }
}
