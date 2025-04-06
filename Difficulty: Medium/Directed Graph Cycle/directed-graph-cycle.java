//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    /**
     * Approach II : Using BFS Approach (Kahn's Algorithm's Topological Sort Approach)
     * 
     * TC: O(2 x V + 2 x E) ~ O(V + E)
     * SC: O(3 x V + E) ~ O(V + E)
     */
    public boolean isCyclic(int V, int[][] edges) {
        Map<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(V + E)
        int[] indegrees = new int[V]; // SC: O(V)
        for (int[] edge : edges) { // TC: O(E)
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            indegrees[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>(); // SC: O(V)
        for (int i = 0; i < V; i++) { // TC: O(V)
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int countVertices = 0;
        while (!queue.isEmpty()) { // TC: O(V + E)
            int u = queue.poll();
            countVertices++;
            for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
                indegrees[v]--;
                if (indegrees[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return countVertices != V;
    }

    /**
     * Approach I : Using DFS Approach
     * 
     * TC: O(2 x V + 2 x E) ~ O(V + E)
     * SC: O(4 x V + E) ~ O(V + E)
     */
    public boolean isCyclicDFS(int V, int[][] edges) {
        Map<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(V + E)
        for (int[] edge : edges) { // TC: O(E)
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
        }
        boolean[] visited = new boolean[V];     // SC: O(V)
        boolean[] inRecursion = new boolean[V]; // SC: O(V)
        for (int i = 0; i < V; i++) { // TC: O(V)
            if (!visited[i] && dfsGraph(i, adj, visited, inRecursion)) { // TC: O(V + E), SC: O(V)
                return true;   
            }
        }
        return false;
    }
    
    /**
     * Using DFS Approach
     * 
     * TC: O(V + E)
     * SC: O(V)
     */
    private boolean dfsGraph(int u, Map<Integer, ArrayList<Integer>> adj,
        boolean[] visited, boolean[] inRecursion) {
        visited[u] = true;
        inRecursion[u] = true;
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (!visited[v] && dfsGraph(v, adj, visited, inRecursion)) {
                return true;
            } else if (inRecursion[v]) {
                return true;
            }
        }
        inRecursion[u] = false;
        return false;
    }
}
