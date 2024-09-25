//{ Driver Code Starts
import java.util.*;

class Count
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int m = sc.nextInt();
            int n = sc.nextInt();
            
            int arr1[] = new int[m];
            int arr2[] = new int[n];
            
            for(int i = 0; i < m; i++)
              arr1[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              arr2[i] = sc.nextInt();
              
            Solution gfg = new Solution();
            ArrayList<Integer> res = gfg.countEleLessThanOrEqual(arr1, arr2, m, n);
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
        
    }
}
// } Driver Code Ends


// Complete the function given below
class Solution {
    /**
     * TC: O((M + N) x log(N))
     * SC: O(1)
     */
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n) {
       Arrays.sort(arr2); // TC: O(Nlog(N))
       ArrayList<Integer> result = new ArrayList<Integer>();
       for (int i = 0; i < m; i++) { // TC: O(M)
           result.add(upperBound(arr2, n, arr1[i])); // TC: O(log(N))
       }
       return result;
    }
    
    /**
     * TC: O(log(N))
     * SC: O(1)
     */
    private static int upperBound(int[] arr2, int n, int x) {
        int low = 0;
        int high = n - 1;
        int minIndex = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr2[mid] > x) {
                minIndex = Math.min(minIndex, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minIndex;
    }
}
