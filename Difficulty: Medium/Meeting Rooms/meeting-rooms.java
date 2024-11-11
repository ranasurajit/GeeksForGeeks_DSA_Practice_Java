//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String temp[] = br.readLine().trim().split(" ");
                arr[i][0] = Integer.parseInt(temp[0]);
                String x = temp[1];
                arr[i][1] = Integer.parseInt(x);
            }
            Solution obj = new Solution();
            boolean ans = obj.canAttend(arr);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


class Solution {
    /**
     * TC: O(N x log(N) + N) ~ TC: O(N x log(N))
     * SC: O(N)
     */
    static boolean canAttend(int[][] arr) {
        PriorityQueue<int[]> pq = 
            new PriorityQueue<int[]>((int[] p, int[] q) -> p[0] - q[0]); // SC: O(N)
        for (int[] time : arr) { // TC: O(N x log(N))
            pq.offer(time);
        }
        int[] prev = new int[2];
        if (!pq.isEmpty()) {
            prev = pq.poll();
        }
        while (!pq.isEmpty()) { // TC: O(N)
            int[] current = pq.poll();
            if (hasOverlap(prev, current)) {
                return false;
            }
            prev = current;
        }
        return true;
    }
    
    private static boolean hasOverlap(int[] prev, int[] current) {
        if (current[0] > prev[0] && current[1] < prev[1]) {
            return true;
        } else if (current[0] < prev[1]) {
            return true;
        }
        return false;
    }
}
