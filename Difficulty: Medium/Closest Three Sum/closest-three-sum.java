//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().threeSumClosest(arr, key));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int threeSumClosest(int[] array, int target) {
        int n = array.length;
        Arrays.sort(array);
        int diff = Integer.MAX_VALUE;
        int closest = 0;
        for (int i = 0; i < n - 2; i++) {
            int p = i + 1;
            int q = n - 1;
            while (p < q) {
                int sum = array[i] + array[p] + array[q];
                int d = Math.abs(sum - target);
                if (d < diff) {
                    diff = d;
                    closest = sum;
                } else if (d == diff) {
                    closest = Math.max(closest, sum);
                }
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    p++;
                } else {
                    q--;
                }
            }
        }
        return closest;
    }
}
