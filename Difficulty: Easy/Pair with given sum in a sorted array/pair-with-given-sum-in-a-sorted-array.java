//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    /**
     * Using Two Pointers Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    int countPairs(int arr[], int target) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int pairs = 0;
        while (start < end) { // TC: O(N)
            int sum = arr[start] + arr[end];
            if (sum < target) {
                start++;
            } else  if (sum > target) {
                end--;
            } else {
                // sum == target
                int ele1 = arr[start];
                int ele2 = arr[end];
                int count1 = 0;
                int count2 = 0;
                // to check duplicate element near start index
                while (start <= end && ele1 == arr[start]) {
                    count1++;
                    start++;
                }
                // to check duplicate element near end index
                while (start <= end && ele2 == arr[end]) {
                    count2++;
                    end--;
                }
                if (ele1 == ele2) {
                    // if start and end index elements are same then pairs = NC2
                    pairs += (count1 * (count1 - 1)) / 2;
                } else {
                    pairs += count1 * count2;
                }
            }
        }
        return pairs;
    }
}


//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends