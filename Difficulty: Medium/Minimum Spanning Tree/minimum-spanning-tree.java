//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            int E = Integer.parseInt(br.readLine().trim());
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));

            ot.println("~");
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Approach II : Kruskal's Algorithm Approach
     * 
     * TC: O(E + V + E + E x log(E) + 3 x E x α(V)) ~ O(E x log(E) + E x α(V))
     * SC: O(2 x V + E) ~ O(V + E)
     */
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        int[] parent = new int[V]; // SC: O(V)
        int[] rank = new int[V]; // SC: O(V)
        List<int[]> edges = new ArrayList<int[]>(); // SC: O(E)
        for (int i = 0; i < V; i++) { // TC: O(V)
            for (int[] ngbr : adj.get(i)) { // TC: O(E)
                edges.add(new int[] { i, ngbr[0], ngbr[1] });
            }
            parent[i] = i;
            rank[i] = 1;
        }
        // Sorting edges in ascending order of edgeWeights
        edges.sort(Comparator.comparingInt(a -> a[2])); // TC: O(E x log(E))
        // iterating over edges
        int sumWeights = 0;
        for (int[] edge : edges) { // TC: O(E)
            if (find(edge[0], parent) != find(edge[1], parent)) { // TC: O(2 x α(V))
                unionByRank(edge[0], edge[1], parent, rank); // TC: O(α(V))
                sumWeights += edge[2];
            }
        }
        return sumWeights;
    }
    
    /**
     * Using DSU Approach - Find by Path Compression
     * 
     * TC: O(α(V))
     * SC: O(V)
     */
    private static int find(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }
    
    /**
     * Using DSU Approach - Union By Rank
     * 
     * TC: O(2 x α(V)) ~ O(α(V))
     * SC: O(V)
     */
    private static void unionByRank(int x, int y, int[] parent, int[] rank) {
        int xParent = find(x, parent); // TC: O(α(V)), SC: O(V)
        int yParent = find(y, parent); // TC: O(α(V)), SC: O(V)
        if (xParent == yParent) {
            return;
        }
        if (rank[xParent] > rank[yParent]) {
            // make x parent of y
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            // make y parent of x
            parent[xParent] = yParent;
        } else {
            // make x parent of y
            parent[yParent] = xParent;
            rank[x]++;
        }
    }

    /**
     * Approach I : Prim's Algorithm Approach
     * 
     * TC: O(2 x E x log(V)) ~ O(E x log(V))
     * SC: O(2 x V + E) ~ O(V + E)
     */
    static int spanningTreePrimsAlgoApproach(int V, int E, List<List<int[]>> adj) {
        boolean[] visited = new boolean[V]; // SC: O(V)
        int[] parent = new int[V]; // SC: O(V)
        Arrays.fill(parent, -1);
        // we will be storing int[] { weight, node, parent } in Min-Heap
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p, q) -> p[0] - q[0]); // SC: O(E)
        pq.offer(new int[] { 0, 0, -1 }); // TC: O(log(V))
        int sumWeights = 0;
        while (!pq.isEmpty()) { // TC: O(E)
            int[] current = pq.poll();
            int w = current[0];
            int u = current[1];
            int par = current[2];
            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            parent[u] = par;
            sumWeights += w;
            for (int[] ngbr : adj.get(u)) { // TC: O(E)
                int v = ngbr[0];
                int edgeWeight = ngbr[1];
                if (!visited[v]) {
                    pq.offer(new int[] { edgeWeight, v, u }); // TC: O(log(V))
                }
            }
        }
        return sumWeights;
    }
}
