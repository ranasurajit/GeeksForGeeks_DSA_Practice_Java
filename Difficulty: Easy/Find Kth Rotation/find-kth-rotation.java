//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }
            Solution ob = new Solution();
            int res = ob.findKRotation(arr);
            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Using Binary Search Approach
     * 
     * TC: O(log(N))
     * SC: O(1)
     */
    public int findKRotation(List<Integer> arr) {
        int n = arr.size();
        int low = 0;
        int high = n - 1;
        while (low < high) { // TC: O(log(N))
            int mid = low + (high - low) / 2;
            if (arr.get(mid) > arr.get(high)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        // index of the minimum element is the number of times the array is rotated
        return low;
    }
}
