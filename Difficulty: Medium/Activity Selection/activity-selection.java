//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        while (t-- > 0) {
            // Read the start times
            String[] startInput = reader.readLine().trim().split("\\s+");
            int[] start = new int[startInput.length];
            for (int i = 0; i < startInput.length; i++) {
                start[i] = Integer.parseInt(startInput[i]);
            }

            // Read the end times
            String[] endInput = reader.readLine().trim().split("\\s+");
            int[] finish = new int[endInput.length];
            for (int i = 0; i < endInput.length; i++) {
                finish[i] = Integer.parseInt(endInput[i]);
            }

            // Create solution object and call activitySelection
            Solution obj = new Solution();
            System.out.println(obj.activitySelection(start, finish));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    /**
     * Approach : Using Sorting Approach
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public int activitySelection(int[] start, int[] finish) {
        int n = start.length;
        int[][] timeline = new int[n][2]; // SC: O(2 x N) ~ O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            timeline[i] = new int[] { start[i], finish[i] };
        }
        /**
         * Sorting the timeline in ascending order of finish time
         * to select short duration to select maximum number of activities
         * greedily
         */
        Arrays.sort(timeline, (int[] a, int[] b) -> a[1] - b [1]); // TC: O(N x log(N))
        Stack<int[]> st = new Stack<int[]>(); // SC: O(N)
        st.push(timeline[0]);
        int activites = 1;
        for (int i = 1; i < n; i++) { // TC: O(N)
            if (!doesOverlap(st.peek(), timeline[i])) {
                st.push(timeline[i]);
                activites++;
            }
        }
        return activites;
    }
    
    /**
     * Check if two timeline intervals overlap
     * 
     * TC: O(1)
     * SC: O(1)
     */
    private boolean doesOverlap(int[] prev, int[] next) {
        if (next[0] <= prev[1]) {
            return true;
        }
        return false;
    }
}
