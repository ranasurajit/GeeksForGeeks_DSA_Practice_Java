//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,P,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		
System.out.println("~");
}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    /**
     * Using DFS Approach - cannot finish courses if graph has cycle
     * So, determine if the graph is DAG or not
     * 
     * If DAG then return true
     * 
     * TC: O(2 x V + 2 x E) ~ O(V + E)
     * SC: O(3 x V) ~ O(V)
     * 
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean isPossible(int N,int P, int[][] prerequisites) {
        // creating adjacency list
        Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
        for (int[] edge : prerequisites) {
            // dependency is between b[i] -> a[i]
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        boolean[] visited = new boolean[N]; // SC: O(V)
        boolean[] inRecursion = new boolean[N]; // SC: O(V)
        for (int i = 0; i < N; i++) { // TC: O(V)
            if (!visited[i] && hasCycleDFS(i, adj, visited, inRecursion)) {
                return false; // TC: O(V + 2 x E), SC: O(V)
            }
        }
        return true;
    }
    
    /**
     * DFS Approach
     * 
     * TC: O(V + 2 x E)
     * SC: O(V)
     * 
     * @param u
     * @param adj
     * @param visited
     * @param inRecursion
     * @return
     */
    private boolean hasCycleDFS(int u, Map<Integer, ArrayList<Integer>> adj,
            boolean[] visited, boolean[] inRecursion) {
        visited[u] = true;
        inRecursion[u] = true;
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (!visited[v] && hasCycleDFS(v, adj, visited, inRecursion)) {
                return true;
            } else if (inRecursion[v]) {
                return true;
            }
        }
        // reverting to false for next DFS calls (previous DFS call ends here)
        inRecursion[u] = false;
        return false;
    }
    
}
