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


class Solution
{
    // Function to find the shortest distance of all the vertices
    // from the source vertex src.
    /**
     * Dijkstra Algorithm Approach
     * 
     * TC: O((V + E) x log(V) + V) ~ O((V + E) x log(V))
     * SC: O(2 x V) ~ O(V)
     * 
     * @param adj
     * @param src
     * @return
     */
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        ArrayList<Integer> minDistList = new ArrayList<Integer>();
        int n = adj.size();
        int[] minDist = new int[n]; // SC: O(V)
        Arrays.fill(minDist, Integer.MAX_VALUE);
        // distance from src to src is 0
        minDist[src] = 0;
        // Create a PriorityQueue (min-heap) in order of distance
        // SC: O(V)
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p, q) -> p[0] - q[0]);
        pq.offer(new int[] { 0, src }); // TC: O(log(1))
        while (!pq.isEmpty()) { // TC: O(V)
            int[] current = pq.poll();
            int weight = current[0];
            int u = current[1];
            for (iPair neighbour : adj.get(u)) { // TC: O(E)
                int v = neighbour.first;
                int edgeWeight = neighbour.second;
                if (weight + edgeWeight < minDist[v]) {
                    minDist[v] = weight + edgeWeight;
                    pq.offer(new int[] { weight + edgeWeight, v }); // TC: O(log(V))
                }
            }
        }
        for (int item : minDist) { // TC: O(V)
            minDistList.add(item);
        }
        return minDistList;
    }
}
