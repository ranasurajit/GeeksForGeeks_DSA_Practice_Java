//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            ArrayList<Integer> array2 = new ArrayList<Integer>();

            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            line = read.readLine();
            tokens = line.split(" ");
            for (String token : tokens) {
                array2.add(Integer.parseInt(token));
            }

            // ArrayList<Integer> v = new ArrayList<Integer>();
            int[] gas = new int[array1.size()];
            int idx = 0;
            for (int i : array1) gas[idx++] = i;

            int[] cost = new int[array2.size()];
            idx = 0;
            for (int i : array2) cost[idx++] = i;

            int ans = new Solution().startStation(gas, cost);

            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    /**
     * Approach: Using Greedy Approach
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public int startStation(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0;
        int reqdGas = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            totalGas += gas[i];
            reqdGas += cost[i];
        }
        if (reqdGas > totalGas) {
            return -1;
        }
        int start = 0;
        int currentGas = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                start = i + 1;
            }
        }
        return start;
    }
}
