//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    /**
     * Brute-Force Approach
     * TC: O(N)
     * SC: O(1)
     * 
     * @param n
     * @return
     */
    int floorSqrt(int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) { // TC: O(N)
            if (calculateProduct(i) <= n) {
                max = Math.max(max, i);
            }
        }
        return max;
    }
    
    private static int calculateProduct(int current) {
        return current * current;
    }
}
