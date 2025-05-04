//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    /**
     * Approach : Using Modified Binary Search
     * 
     * TC: O(log(N))
     * SC: O(1)
     */
    public int findTarget(int arr[], int target) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) { // TC: O(log(N))
            int mid = low + (high - low) / 2;
            // target can be at i, (i - 1) or (i + 1)th indices
            if (arr[mid] == target) {
                return mid;
            } else if (mid > 0 && arr[mid - 1] == target) {
                return mid - 1;
            } else if (mid < n - 1 && arr[mid + 1] == target) {
                return mid + 1;
            } else if (arr[mid] > target) {
                // range to consider till (mid - 1) instead of mid so high = (mid - 1) - 1
                high = mid - 2;
            } else {
                // range to consider till (mid + 1) instead of mid so low = (mid + 1) + 1
                low = mid + 2;
            }
        }
        return -1;
    }
}


//{ Driver Code Starts.

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String temp[] = sc.nextLine().trim().split(" ");
            int n = temp.length;
            int arr[] = new int[n];
            int target = sc.nextInt();
            if (sc.hasNextLine()) sc.nextLine();
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(temp[i]);
            Solution sln = new Solution();
            int ans = sln.findTarget(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends