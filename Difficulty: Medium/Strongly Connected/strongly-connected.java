//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

// User function Template for Java

class Solution {
    // Function to find number of strongly connected components in the graph.
    /**
     * Approach: Using Kosaraju's Algorithm Approach
     * 
     * TC: O(3 x (V + E)) ~ O(V + E)
     * SC: O(3 x V + E) ~ O(V + E)
     */
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        // Step 1: Get the Topological Sort by DFS and populate the Stack
        Stack<Integer> st = new Stack<Integer>();
        boolean[] visited = new boolean[n]; // SC: O(V)
        for (int i = 0; i < n; i++) { // TC: O(1)
            if (!visited[i]) {
                dfsTopoSortGraph(i, visited, adj, st); // TC: O(V + E)
            }
        }
        // Step 2: Reverse the directions of directed graph adjacency list 'adj'
        Map<Integer, ArrayList<Integer>> revAdj = reverseDirections(adj); // TC: O(V + E), SC: O(V + E)
        // Step 3 Perform DFS on reversed Adjacency List in LIFO order from Stack 'st'
        visited = new boolean[n]; // SC: O(V)
        int countComponents = 0;
        while (!st.isEmpty()) { // TC: O(V)
            int u = st.pop();
            if (!visited[u]) {
                dfsGraph(u, visited, revAdj); // TC: O(V + E), SC: O(V)
                countComponents++;
            }
        }
        return countComponents;
    }
    
    /**
     * Using DFS Approach
     * 
     * TC: O(V + E)
     * SC: O(V)
     */
    private void dfsGraph(int u, boolean[] visited, Map<Integer, ArrayList<Integer>> revAdj) {
        visited[u] = true;
        for (Integer v : revAdj.getOrDefault(u, new ArrayList<Integer>())) {
            if (!visited[v]) {
                dfsGraph(v, visited, revAdj);
            }
        }
    }
    
    /**
     * Using Hashing Approach
     * 
     * TC: O(V + E)
     * SC: O(V + E)
     */
    private Map<Integer, ArrayList<Integer>> reverseDirections(ArrayList<ArrayList<Integer>> adj) {
        Map<Integer, ArrayList<Integer>> revAdj = new HashMap<Integer, ArrayList<Integer>>();
        for (int u = 0; u < adj.size(); u++) {
            for (Integer v : adj.get(u)) {
                revAdj.computeIfAbsent(v, k -> new ArrayList<Integer>()).add(u);
            }
        }
        return revAdj;
    }
    
    /**
     * Using DFS Approach
     * 
     * TC: O(V + E)
     * SC: O(V)
     */
    private void dfsTopoSortGraph(int u, boolean[] visited,
        ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        visited[u] = true;
        for (Integer v : adj.get(u)) {
            if (!visited[v]) {
                dfsTopoSortGraph(v, visited, adj, st);
            }
        }
        st.push(u);
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            System.out.println(obj.kosaraju(adj));

            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends