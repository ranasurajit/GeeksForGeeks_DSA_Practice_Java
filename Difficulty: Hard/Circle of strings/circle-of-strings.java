//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int isCircle(String arr[]) {
        int n = arr.length;
        // taken size 26 as we are dealing with character nodes
        int[] indegrees = new int[26];
        int[] outdegrees = new int[26];
        HashMap<Character, ArrayList<Integer>> adj = 
            new HashMap<Character, ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            if (!adj.containsKey(arr[i].charAt(0))) {
                adj.put(arr[i].charAt(0), new ArrayList<Integer>());
            }
            adj.get(arr[i].charAt(0)).add(i);
            indegrees[arr[i].charAt(0) - 'a']++;
            outdegrees[arr[i].charAt(arr[i].length() - 1) - 'a']++;
        }
        int[] visited = new int[n];
        for (Character u : adj.keySet()) {
            if (indegrees[u - 'a'] != outdegrees[u - 'a']) {
                return 0;
            }
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        visited[0] = 1;
        int count = 1;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            char u = arr[index].charAt(arr[index].length() - 1);
            for (Integer v : adj.get(u)) {
                if (visited[v] == 0) {
                    count++;
                    visited[v] = 1;
                    queue.offer(v);
                }
            }
        }
        return count == arr.length ? 1 : 0;
    }
}
