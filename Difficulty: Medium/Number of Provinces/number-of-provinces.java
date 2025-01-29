//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    /**
     * Graph DFS Approach
     * 
     * TC: O(2 x V + 2 x E) ~ O(V + E)
     * SC: O(2 x V) ~ O(V)
     */
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        int n = adj.get(0).size();
        boolean[] visited = new boolean[V]; // SC: O(V)
        
        int provinces = 0;
        for (int i = 0; i < V; i++) { // TC: O(V)
            if (!visited[i]) {
                dfsGraph(i, adj, visited, n); // TC: O(V + 2 x E), SC: O(V)
                provinces++;
            }
        }
        return provinces;
    }
    
    /**
     * DFS Approach
     * 
     * TC: O(V + 2 x E) ~ O(V + E)
     * SC: O(V)
     */
    private static void dfsGraph(int u, ArrayList<ArrayList<Integer>> adj,
        boolean[] visited, int n) {
        visited[u] = true;
        for (int v = 0; v < n; v++) { // TC: O(E)
            if (u != v && adj.get(u).get(v) == 1 && !visited[v]) {
                dfsGraph(v, adj, visited, n); // TC: O(V + E)
            }
        }
    }
};
