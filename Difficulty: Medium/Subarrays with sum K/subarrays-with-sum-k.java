//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.findSubArraySum(Arr, N, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    /**
     * Optimal Approach
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param nums
     * @param n
     * @param k
     * @return
     */
    static int findSubArraySum(int Arr[], int N, int k) {
        int count = 0;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        hm.put(0, 1);
        int sum = 0;
        for (int i = 0; i < N; i++) { // TC: O(N)
            sum += Arr[i];
            int diff = sum - k;
            if (hm.containsKey(diff)) {
                count += hm.get(diff);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    
    /**
     * Brute-Force Approach
     * 
     * TC: O(N^2)
     * SC: O(1)
     * 
     * @param nums
     * @param n
     * @param k
     * @return
     */
    static int findSubArraySumBruteForce(int Arr[], int N, int k) {
        int count = 0;
        for (int i = 0; i < N; i++) { // TC: O(N)
            int sum = 0;
            for (int j = i; j < N; j++) { // TC: O(N)
                sum += Arr[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
