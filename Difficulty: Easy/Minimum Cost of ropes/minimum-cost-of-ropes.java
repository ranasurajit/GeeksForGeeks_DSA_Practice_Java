//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            long[] a = new long[input.length];

            for (int i = 0; i < input.length; i++) {
                a[i] = Long.parseLong(input[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.minCost(a));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    // Function to return the minimum cost of connecting the ropes.
    /**
     * TC: O(Nlog(N))
     * SC: O(N)
     */
    public long minCost(long[] arr) {
        int n = arr.length;
        // TC: O(Nlog(N))
        // SC: O(N)
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        for (int i = 0; i < n; i++) { // TC: O(N)
            pq.offer(arr[i]);
        }
        long cost = 0L;
        while (pq.size() > 1) { // TC: O(N)
            long p = pq.poll();
            long q = pq.poll();
            cost += p + q;
            pq.offer(p + q);
        }
        return cost;
    }
}
