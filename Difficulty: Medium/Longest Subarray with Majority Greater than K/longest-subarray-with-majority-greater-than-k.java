//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    /**
     * Approach II : Using Array Transformation Approach
     * convert elements > k = 1 and elements <= k = -1
     * then find the longest sub-array with sum > 0
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    static int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) { // TC: O(N)
            arr[i] = arr[i] <= k ? -1 : 1;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > 0) {
                maxLength = i + 1;
            } else {
                map.putIfAbsent(sum, i);
                int diff = sum - 1;
                if (map.containsKey(diff)) {
                    maxLength = Math.max(maxLength, i - map.get(diff));
                }
            }
        }
        return maxLength;
    }
  
    /**
     * Approach I : Using Brute-Force Approach
     * 
     * TC: O(N ^ 2)
     * SC: O(1)
     */
    static int longestSubarrayApproachI(int[] arr, int k) {
        int n = arr.length;
        int maxLength = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int countKPlus = 0;
            int countKMinus = 0;
            for (int j = i; j < n; j++) { // TC: O(N)
                if (arr[j] > k) {
                    countKPlus++;
                } else {
                    countKMinus++;
                }
                if (countKPlus > countKMinus) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            int n = tokens.length;
            int[] arr = new int[n];

            int i = 0;
            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr[i] = Integer.parseInt(token);
                i++;
            }

            int k = Integer.parseInt(br.readLine().trim());
            System.out.println(new Solution().longestSubarray(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends