//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        HashMap<Integer, ArrayList<Pair>> adj = createGraph(edges, n, m);
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((p, q) -> p.dist - q.dist);
        pq.offer(new Pair(0, src));
        minDist[src] = 0;
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            int dist = current.dist;
            for (Pair pair : adj.getOrDefault(u, new ArrayList<Pair>())) {
                int v = pair.node;
                int w = pair.dist;
                if (dist + w < minDist[v]) {
                    minDist[v] = dist + w;
                    pq.offer(new Pair(dist + w, v));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (minDist[i] == Integer.MAX_VALUE) {
                minDist[i] = -1;
            }
        }
        return minDist;
    }
    
    private HashMap<Integer, ArrayList<Pair>> createGraph(int[][] edges, int n, int m) {
        HashMap<Integer, ArrayList<Pair>> adj = new HashMap<Integer, ArrayList<Pair>>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<Pair>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(1, edges[i][1]));
            adj.get(edges[i][1]).add(new Pair(1, edges[i][0]));
        }
        return adj;
    }
    
    class Pair {
        int dist;
        int node;
        public Pair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }
}
