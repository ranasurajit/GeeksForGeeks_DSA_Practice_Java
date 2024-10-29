//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
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

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.countPairsWithDiffK(arr, k);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    /**
     * TC: O(N + 2L) ~ O(N + L)
     * SC: O(L)
     */
    int countPairsWithDiffK(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        for (int it : arr) { // TC: O(N)
            max = Math.max(max, it);
        }
        int[] count = new int[max + 1]; // SC: O(L)
        for (int it : arr) { // TC: O(N)
            count[it]++;
        }
        int pairs = 0;
        for (int i = 0; i <= max; i++) { // TC: O(L)
            if (i + k <= max && count[i] > 0 && count[i + k] > 0) {
                pairs += count[i] * count[i + k];
            }
        }
        return pairs;
    }
}
