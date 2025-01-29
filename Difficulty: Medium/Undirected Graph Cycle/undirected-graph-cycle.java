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
    // Function to detect cycle in an undirected graph.
    /**
     * BFS Approach
     * 
     * TC: O(2 x V + 2 x E) ~ O(V + E)
     * SC: O(2 x V) ~ O(V)
     * 
     * @param adj
     * @return
     */
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        boolean[] visited = new boolean[n]; // SC: O(V)
        for (int i = 0; i < n; i++) {       // TC: O(V)
            if (!visited[i] && hasCycleInGraphBFS(i, adj, visited)) {
                return true; // TC: O(V + 2 x E), SC: O(V)
            }
        }
        return false;
    }
    
    /**
     * BFS Approach
     * 
     * TC: O(V + 2 x E)
     * SC: O(V)
     * 
     * @param source
     * @param adj
     * @param visited
     * @return
     */
    private static boolean hasCycleInGraphBFS(int source,
        ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        // storing the (node, parent) in queue
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[] { source, -1 });
        visited[source] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int u = current[0];
            int parent = current[1];
            for (Integer v : adj.get(u)) {
                if (v == parent) {
                    continue;
                }
                if (!visited[v]) {
                    queue.offer(new int[] { v, u });
                    visited[v] = true;
                } else if (v != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * DFS Approach
     * 
     * TC: O(2 x V + 2 x E) ~ O(V + E)
     * SC: O(2 x V) ~ O(V)
     * 
     * @param adj
     * @return
     */
    public boolean isCycleDFS(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        boolean[] visited = new boolean[n]; // SC: O(V)
        for (int i = 0; i < n; i++) { // TC: O(V)
            if (!visited[i] && hasCycleInGraphDFS(i, -1, adj, visited)) {
                return true; // TC: O(V + 2 x E), SC: O(V)
            }
        }
        return false;
    }
    
    /**
     * DFS Approach
     * 
     * TC: O(V + 2 x E)
     * SC: O(V)
     * 
     * @param u
     * @param parent
     * @param adj
     * @param visited
     * @return
     */
    private boolean hasCycleInGraphDFS(int u, int parent,
            ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        for (Integer v : adj.get(u)) {
            if (v == parent) {
                continue;
            }
            if (visited[v]) {
                return true;
            }
            if (hasCycleInGraphDFS(v, u, adj, visited)) {
                return true;
            }
        }
        return false;
    }
}
