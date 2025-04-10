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
     * Approach : Prim's Algorithm Approach
     * 
     * TC: O(2 x E x log(V)) ~ O(E x log(V))
     * SC: O(2 x V + E) ~ O(V + E)
     */
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
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

