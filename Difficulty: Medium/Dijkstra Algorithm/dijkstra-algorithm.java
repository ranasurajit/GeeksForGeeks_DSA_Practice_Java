//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    /**
     * Approach: Using Dijkstra Algorithm
     * 
     * TC: O(E + log(V) + 2 x E x log(V)) ~ O(E x log(V))
     * SC: O(2 x V + 2 x E) ~ O(V + E)
     */
    public int[] dijkstra(int V, int[][] edges, int src) {
        Map<Integer, ArrayList<int[]>> adj = createGraph(edges); // TC: O(E), SC: O(V + E)
        // Create a Min-Heap to store { weight, node }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p, q) -> p[0] - q[0]); // SC: O(E)
        int[] minDist = new int[V]; // SC: O(V)
        Arrays.fill(minDist, (int) 1e9);
        minDist[src] = 0;
        pq.offer(new int[] { 0, src }); // TC: O(log(V)) - distance from origin to origin = 0
        while (!pq.isEmpty()) { // TC: O(E)
            int[] current = pq.poll(); // TC: O(log(V))
            int weight = current[0];
            int u = current[1];
            if (weight > minDist[u]) {
                continue;
            }
            for (int[] ngbr : adj.getOrDefault(u, new ArrayList<int[]>())) {
                int v = ngbr[0];
                int edgeWeight = ngbr[1];
                if (edgeWeight + weight < minDist[v]) {
                    minDist[v] = edgeWeight + weight;
                    pq.offer(new int[] { edgeWeight + weight, v }); // TC: O(log(V))
                }
            }
        }
        return minDist;
    }
    
    /**
     * Creating Adjacency List
     * 
     * TC: O(2 x E) ~ O(E)
     * SC: O(V + E)
     */
    private Map<Integer, ArrayList<int[]>> createGraph(int[][] edges) {
        Map<Integer, ArrayList<int[]>> adj =
            new HashMap<Integer, ArrayList<int[]>>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<int[]>())
                .add(new int[] { edge[1], edge[2] });
            adj.computeIfAbsent(edge[1], k -> new ArrayList<int[]>())
                .add(new int[] { edge[0], edge[2] });
        }
        return adj;
    }
}
