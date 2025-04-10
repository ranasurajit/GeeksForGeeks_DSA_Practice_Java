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
     * Approach II : Using Kruskal's Algorithm and Disjoint Set Union Approach
     * 
     * TC: O(V + E x log(E) + 3 x E x α(V)) ~ O(E x log(E) + E x α(V)) ~ O(E x log(E))
     * SC: O(2 x V ^ 2 + 2 x V) ~ O(V ^ 2)
     */
    public int minCost(int[][] houses) {
        int n = houses.length;
        int[] parent = new int[n]; // SC: O(V)
        int[] rank = new int[n]; // SC: O(V)
        for (int i = 0; i < n; i++) { // TC: O(V)
            parent[i] = i;
        }
        Arrays.fill(rank, 1);
        // creating the edges
        List<int[]> edges = createEdges(n, houses); // TC: O(V ^ 2), SC: O(V ^ 2)
        // Sort edges in ascending order of edge weights
        edges.sort(Comparator.comparingInt(a -> a[2])); // TC: O(E x log(E))
        // iterating over sorted edges and calculate sum
        int minimumCost = 0;
        for (int[] edge : edges) { // TC: O(E)
            if (find(edge[0], parent) != find(edge[1], parent)) { // TC: O(2 x α(V))
                unionByRank(edge[0], edge[1], parent, rank); // TC: O(α(V))
                minimumCost += edge[2];
            }
        }
        return minimumCost;
    }
    
    /**
     * Using DSU Approach - Find by Path Compression
     * 
     * TC: O(α(V))
     * SC: O(V)
     */
    private int find(int x, int[] parent) {
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
    private void unionByRank(int x, int y, int[] parent, int[] rank) {
        int xParent = find(x, parent); // TC: O(α(V)), SC: O(V)
        int yParent = find(y, parent); // TC: O(α(V)), SC: O(V)
        if (xParent == yParent) {
            return;
        }
        if (rank[xParent] > rank[yParent]) {
            // make x as parent of y
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            // make y as parent of x
            parent[xParent] = yParent;
        } else {
            // make x as parent of y
            parent[yParent] = xParent;
            rank[x]++;
        }
    }

    /**
     * Creating Edges from the coordinates
     * 
     * TC: O(V ^ 2)
     * SC: O(V ^ 2)
     */
    private List<int[]> createEdges(int v, int[][] houses) {
        List<int[]> edges = new ArrayList<int[]>();
        for (int i = 0; i < v; i++) {
            for (int j = i + 1; j < v; j++) {
                int x1 = houses[i][0];
                int y1 = houses[i][1];
                int x2 = houses[j][0];
                int y2 = houses[j][1];
                int weight = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                edges.add(new int[] { i, j, weight });
            }
        }
        return edges;
    }
    
    /**
     * Approach I : Using Prim's Algorithm Approach
     * 
     * TC: O(V ^ 2 x log(V))
     * SC: O(2 x V ^ 2 + V) ~ O(V ^ 2)
     */
    public int minCostPrimsAlgoApproach(int[][] houses) {
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
