//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().majorityElement(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Approach II : Using Moore's Voting Approach
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    static int majorityElement(int arr[]) {
        int n = arr.length;
        int current = arr[0];
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (current != arr[i]) {
                count--;
                if (count == 0) {
                    current = arr[i];
                    count = 1;
                }
            } else {
                count++;
            }
        }
        // double check to verify if current occurs > n / 2
        count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (arr[i] == current) {
                count++;
            }
        }
        return count > n / 2 ? current : -1;
    }

    /**
     * Approach I : Using Hashing Approach
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    static int majorityElementApproachI(int arr[]) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (Integer key : map.keySet()) { // TC: O(N)
            if (map.get(key) > n / 2) {
                return key;
            }
        }
        return -1;
    }
}
