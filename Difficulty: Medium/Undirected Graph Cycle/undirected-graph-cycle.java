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
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && graphHasCycleBFS(adj, visited, i)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean graphHasCycleBFS(ArrayList<ArrayList<Integer>> adj,
        boolean[] visited, int index) {
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(index, -1));
        visited[index] = true;
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int u = current.node;
            int parent = current.parent;
            for (Integer v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(new Pair(v, u));
                } else if (v != parent) {
                    return true;
                }
            }
        }
        return false;
    }
    
    class Pair {
        int node;
        int parent;
        
        public Pair (int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
}
