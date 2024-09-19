//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG {
    /**
     * Optimal Approach
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param arr
     * @param n
     * @return
     */
    int maxLen(int arr[], int n) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        hm.put(0, -1);
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            sum += arr[i];
            if (hm.containsKey(sum)) {
                max = Math.max(max, i - hm.get(sum));
            } else {
                hm.put(sum, i);
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
