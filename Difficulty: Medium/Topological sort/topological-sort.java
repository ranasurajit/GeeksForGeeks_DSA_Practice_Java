//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


/*Complete the function below*/


class Solution {
    // Function to return list containing vertices in Topological order.
    /**
     * Topological Sort using DFS
     * 
     * TC: O(3 x V + E) ~ O(V + E)
     * SC: O(3 x V) ~ O(V)
     * 
     * @param adj
     * @return
     */
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> topoList = new ArrayList<Integer>();
        int v = adj.size();
        boolean[] visited = new boolean[v];       // SC: O(V)
        Stack<Integer> st = new Stack<Integer>(); // SC: O(V)
        for (int i = 0; i < v; i++) {             // TC: O(V)
            if (!visited[i]) {
                dfsGraph(i, adj, visited, st);    // TC: O(V + E), SC: O(V)
            }
        }
        while (!st.isEmpty()) {                   // TC: O(V)
            topoList.add(st.pop());
        }
        return topoList;
    }
    
    /**
     * TC: O(V + E)
     * SC: O(V)
     * 
     * @param u
     * @param adj
     * @param visited
     * @param st
     */
    private static void dfsGraph(int u, ArrayList<ArrayList<Integer>> adj,
            boolean[] visited, Stack<Integer> st) {
        visited[u] = true;
        for (Integer v : adj.get(u)) {
            if (!visited[v]) {
                dfsGraph(v, adj, visited, st);
            }
        }
        st.push(u);
    }
}
