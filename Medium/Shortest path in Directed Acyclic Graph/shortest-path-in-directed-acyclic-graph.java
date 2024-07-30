//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		HashMap<Integer, ArrayList<Pair>> adj = createGraph(N, M, edges);
		int[] minPath = new int[N];
		Arrays.fill(minPath, (int) 1e9);
		PriorityQueue<Pair> pq =
		    new PriorityQueue<Pair>((Pair p, Pair q) -> p.dist - q.dist);
		pq.offer(new Pair(0, 0));
		minPath[0] = 0;
		while (!pq.isEmpty()) {
		    Pair current = pq.poll();
		    int u = current.node;
		    int dist = current.dist;
		    for (Pair pair : adj.get(u)) {
		        int edgeNode = pair.node;
		        int edgeDist = pair.dist;
		        if (dist + edgeDist < minPath[edgeNode]) {
		            minPath[edgeNode] = dist + edgeDist;
		            pq.offer(new Pair(edgeNode, dist + edgeDist));
		        }
		    }
		}
		for (int i = 0; i < N; i++) {
		    if (minPath[i] == (int) 1e9) {
		        minPath[i] = -1;
		    }
		}
		return minPath;
	}
	
	private HashMap<Integer, ArrayList<Pair>> createGraph(int n,int m, int[][] edges) {
	    HashMap<Integer, ArrayList<Pair>> adj = new HashMap<Integer, ArrayList<Pair>>();
	    for (int i = 0; i < n; i++) {
	        adj.put(i, new ArrayList<Pair>());
	    }
	    for (int i = 0; i < m; i++) {
	        adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
	    }
	    return adj;
	}
	
	class Pair {
	    int node;
	    int dist;
	    public Pair(int node, int dist) {
	        this.node = node;
	        this.dist = dist;
	    }
	}
}
