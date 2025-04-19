//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            // Read the array from input line
            String inputLine = read.readLine().trim();
            String[] inputArr = inputLine.split("\\s+");
            int n = inputArr.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputArr[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findDuplicate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    /**
     * Approach II : Using Bit-Manipulation Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int findDuplicate(int[] arr) {
        int n = arr.length;
        int xor = 0;
        int xorNums = 0;

        for (int i = 0; i < n; i++) { // TC: O(N)
            xor ^= arr[i];
            if (i < n - 1) {
                xorNums ^= (i + 1);
            }
        }
        return xor ^ xorNums;
    }

    /**
     * Approach I : Using Hashing Approach
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(L), where L = Max(arr))
     */
    public int findDuplicateApproachI(int[] arr) {
        int n = arr.length;
        int duplicate = 0;
        int maxValue = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            maxValue = Math.max(maxValue, arr[i]);
        }
        int[] freq = new int[maxValue + 1]; // SC: O(Max(arr))
        for (int i = 0; i < n; i++) { // TC: O(N)
            freq[arr[i]]++;
            if (freq[arr[i]] > 1) {
                duplicate = arr[i];
                break;
            }
        }
        return duplicate;
    }
}
