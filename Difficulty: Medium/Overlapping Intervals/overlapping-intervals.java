//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
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
            // The mergeOverlap function now returns a List<int[]>
            List<int[]> ans = obj.mergeOverlap(arr);

            // Printing the merged arr
            for (int[] interval : ans) {
                System.out.print(interval[0] + " " + interval[1] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    /**
     * TC: O(N + N x log(N)) ~ O(N x log(N))
     * SC: O(1)
     */
    public List<int[]> mergeOverlap(int[][] arr) {
        Arrays.sort(arr, (int[] a, int[] b) -> a[0] - b[0]); // TC: O(N x log(N))
        List<int[]> intervals = new ArrayList<int[]>();
        for (int[] event : arr) {                            // TC: O(N)
            if (intervals.isEmpty()) {
                intervals.add(event);
            } else {
                int[] prev = intervals.get(intervals.size() - 1);
                if (prev[1] >= event[0]) {
                    int index = intervals.size() - 1;
                    intervals.remove(index);
                    intervals.add(new int[] { prev[0], Math.max(prev[1], event[1]) });
                } else {
                    intervals.add(event);
                }
            }
        }
        return intervals;
    }
}
