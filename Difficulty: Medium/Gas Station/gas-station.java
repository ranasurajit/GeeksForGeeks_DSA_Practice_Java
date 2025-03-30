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
     * Approach II : Improvement on Approach I
     * 
     * Using Greedy Approach Without Property of Circular Array
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
            // not possible to travel around the circuit
            return -1;
        }
        // possible to travel around the circuit
        // trying all possible start index of stations
        int start = 0;
        int currentGas = 0;
        /**
         * No need to check for circular aaray property as 
         * mentioned in Note: "If a solution exists, it is 
         * guaranteed to be unique."
         */
        for (int i = 0; i < n; i++) { // TC: O(N)
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                start = i + 1;
            }
        }
        return start;
    }

    /**
     * Approach I : Using Greedy Approach and Property of Circular Array
     * 
     * TC: O(3 x N) ~ O(N)
     * SC: O(4 x N) ~ O(N)
     */
    public int startStationApproachI(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0;
        int reqdGas = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            totalGas += gas[i];
            reqdGas += cost[i];
        }
        if (reqdGas > totalGas) {
            // not possible to travel around the circuit
            return -1;
        }
        // possible to travel around the circuit
        // creating circular array
        int[] cirGas = new int[2 * n];  // SC: O(2 x N)
        int[] cirCost = new int[2 * n]; // SC: O(2 x N)
        for (int i = 0; i < n; i++) {   // TC: O(N)
            cirGas[i] = gas[i];
            cirGas[n + i] = gas[i];
            cirCost[i] = cost[i];
            cirCost[n + i] = cost[i];
        }
        // trying all possible start index of stations
        int start = 0;
        int currentGas = 0;
        for (int i = start; i < start + n; i++) { // TC: O(N)
            currentGas += cirGas[i] - cirCost[i];
            if (currentGas < 0) {
                currentGas = 0;
                start = i + 1;
            }
        }
        return currentGas >= 0 ? start : -1;
    }
}
