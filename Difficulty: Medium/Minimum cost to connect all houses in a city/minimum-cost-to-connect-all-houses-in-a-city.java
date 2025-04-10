//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] edge = new int[n][2];
            for (int i = 0; i < n; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.minCost(edge);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {
    /**
     * Approach: Using Prim's Algorithm Approach
     * 
     * TC: O(V ^ 2 x log(V))
     * SC: O(2 x V ^ 2 + V) ~ O(V ^ 2)
     */
    public int minCost(int[][] houses) {
        int n = houses.length;
        // create adjacency list
        Map<Integer, ArrayList<int[]>> adj = createGraph(n, houses); // TC: O(V ^ 2), SC: O(V ^ 2)
        // Creating a Min-Heap to store (edgeWeights, node)
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p, q) -> p[0] - q[0]); // SC: O(V ^ 2)
        pq.offer(new int[] { 0, 0 });
        boolean[] visited = new boolean[n]; // SC: O(V)
        int minimumCost = 0;
        
        while (!pq.isEmpty()) { // TC: O(V ^ 2)
            int[] current = pq.poll(); // TC: O(log(V))
            int w = current[0];
            int u = current[1];
            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            minimumCost += w;
            
            for (int[] ngbr : adj.get(u)) {
                int v = ngbr[0];
                int edgeWeight = ngbr[1];
                if (!visited[v]) {
                    pq.offer(new int[] { edgeWeight, v }); // TC: O(log(V))
                }
            }
        }
        return minimumCost;
    }
    
    /**
     * Creating Adjacency List from the Coordinates
     * 
     * TC: O(V ^ 2 + V) ~ O(V ^ 2)
     * SC: O(V ^ 2)
     */
    private Map<Integer, ArrayList<int[]>> createGraph(int v, int[][] houses) {
        Map<Integer, ArrayList<int[]>> adj = 
            new HashMap<Integer, ArrayList<int[]>>(); // SC: O(V ^ 2)
        for (int i = 0; i < v; i++) { // TC: O(V)
            adj.put(i, new ArrayList<int[]>());
        }
        for (int i = 0; i < v; i++) { // TC: O(V)
            for (int j = i + 1; j < v; j++) { // TC: O(V)
                int x1 = houses[i][0];
                int y1 = houses[i][1];
                int x2 = houses[j][0];
                int y2 = houses[j][1];
                int weight = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.get(i).add(new int[] { j, weight });
                adj.get(j).add(new int[] { i, weight });
            }
        }
        return adj;
    }
}
