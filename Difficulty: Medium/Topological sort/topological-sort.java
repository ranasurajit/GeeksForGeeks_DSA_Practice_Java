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
    /**
     * Approach II : Using BFS Approach (Kahn's Algorithm)
     * 
     * TC: O(2 x (V + E)) ~ O(V + E)
     * SC: O(3 x V + E) ~ O(V + E)
     */
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        int[] indegrees = new int[V]; // SC: O(V)
        Map<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(V + E)
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
        while (!queue.isEmpty()) { // TC: O(V + E)
            Integer u = queue.poll();
            sorted.add(u);
            for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
                indegrees[v]--;
                if (indegrees[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return sorted;
    }

    /**
     * Approach I : Using DFS Approach
     * 
     * TC: O(3 x V + 2 x E) ~ O(V + E)
     * SC: O(4 x V + E) ~ O(V + E)
     */
    public static ArrayList<Integer> topoSortDFS(int V, int[][] edges) {
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        Map<Integer, ArrayList<Integer>> adj =
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(V + E)
        for (int[] edge : edges) { // TC: O(E)
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
        }
        Stack<Integer> st = new Stack<Integer>(); // needed for topological sort - SC: O(V)
        boolean[] visited = new boolean[V]; // SC: O(V)
        for (int i = 0; i < V; i++) { // TC: O(V)
            if (!visited[i]) {
                dfsGraph(i, adj, visited, st); // TC: O(V + E), SC: O(V)
            }
        }
        while (!st.isEmpty()) { // TC: O(V)
            sorted.add(st.pop());
        }
        return sorted;
    }
    
    /**
     * Using DFS Approach
     * 
     * TC: O(V + E)
     * SC: O(V)
     */
    private static void dfsGraph(int u, Map<Integer, ArrayList<Integer>> adj, 
        boolean[] visited, Stack<Integer> st) {
        visited[u] = true;
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (!visited[v]) {
                dfsGraph(v, adj, visited, st);
            }
        }
        st.push(u);
    }
}
