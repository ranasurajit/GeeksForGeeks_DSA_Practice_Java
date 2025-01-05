//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    /**
     * Using Two Pointers Approach
     * 
     * TC: O(N x log(N) + N) ~ O(N x log(N)) 
     * SC: O(1)
     */
    int countPairs(int arr[], int target) {
        int n = arr.length;
        Arrays.sort(arr); // TC: O(N x log(N))
        int p = 0;
        int q = n - 1;
        int count = 0;
        while (p < q) { // TC: O(N)
            int sum = arr[p] + arr[q];
            if (sum < target) {
                count += q - p;
                p++;
            } else {
                // we need to decrease the sum so decrement 2nd pointer
                q--;
            }
        }
        return count;
    }
}


//{ Driver Code Starts.

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine());

            Solution obj = new Solution();

            System.out.println(obj.countPairs(nums, target));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends