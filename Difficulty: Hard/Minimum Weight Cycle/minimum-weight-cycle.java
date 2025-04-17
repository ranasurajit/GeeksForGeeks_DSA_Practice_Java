//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            Solution obj = new Solution();
            int res = obj.findMinCycle(V, edges);

            System.out.println(res);
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    /**
     * Approach: Removing Edges one by one and Using Dijkstra's Algorithm
     * 
     * TC: O(E x (V + E) x log(V))
     * SC: O(2 x V + E) ~ O(V + E)
     */
    public int findMinCycle(int V, int[][] edges) {
        Map<Integer, ArrayList<int[]>> adj = createGraph(edges); // TC: O(E), SC: O(V + E)
        int minWeight = Integer.MAX_VALUE;
        for (int[] edge : edges) { // TC: O(E)
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            int shortestWeight = dijkstra(u, v, V, adj); // TC: O((V + E) x log(V)), SC: O(V)
            
            // adding the removed egde weight to 'shortestWeight'
            if (shortestWeight != Integer.MAX_VALUE) {
                minWeight = Math.min(minWeight, shortestWeight + w);
            }
        }
        return minWeight;
    }
    
    /**
     * Using Dijkstra's Algorithm
     * 
     * TC: O((V + E) x log(V))
     * SC: O(2 x V) ~ O(V)
     */
    private int dijkstra(int src, int dest, int n, Map<Integer, ArrayList<int[]>> adj) {
        int[] minDist = new int[n]; // SC: O(V)
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[src] = 0;
        PriorityQueue<int[]> pq =
            new PriorityQueue<int[]>((p, q) -> p[0] - q[0]); // SC: O(V)
        pq.offer(new int[] { 0, src }); // TC: O(log(V))
        while (!pq.isEmpty()) { // TC: O(V + E)
            int[] current = pq.poll();
            int w = current[0];
            int u = current[1];
            if (w > minDist[u]) {
                continue;
            }
            for (int[] ngbr : adj.getOrDefault(u, new ArrayList<int[]>())) {
                int v = ngbr[0];
                int edgeWeight = ngbr[1];
                if ((u == src && v == dest) || (v == src && u == dest)) {
                    // temporarily remove edge
                    continue;
                }
                if (w + edgeWeight < minDist[v]) {
                    minDist[v] = w + edgeWeight;
                    pq.offer(new int[] { w + edgeWeight, v }); // TC: O(log(V))
                }
            }
        }
        return minDist[dest];
    }
    
    /**
     * Creating Adjacency List
     * 
     * TC: O(E)
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
};
