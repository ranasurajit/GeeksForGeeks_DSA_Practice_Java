//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        if (len1 < len2) {
            return getMedianElements(arr1, arr2, len1, len2);
        } else {
            return getMedianElements(arr2, arr1, len2, len1);
        }
    }
    
    private int getMedianElements(int[] small, int[] large, int m, int n) {
        int low = 0;
        int high = m;
        while (low <= high) {
            int px = low + (high - low) / 2;
            int py = (m + n + 1) / 2 - px;
            int x1 = px == 0 ? Integer.MIN_VALUE : small[px - 1];
            int x2 = py == 0 ? Integer.MIN_VALUE : large[py - 1];
            int x3 = px == m ? Integer.MAX_VALUE : small[px];
            int x4 = py == n ? Integer.MAX_VALUE : large[py];
            
            if (x1 <= x4 && x2 <= x3) {
                if ((m + n) % 2 == 0) {
                    // even
                    return Math.max(x1, x2) + Math.min(x3, x4);
                } else {
                    // odd
                    return Math.max(x1, x2);
                }
            } else if (x1 > x4) {
                high = px - 1; 
            } else {
                low = px + 1;
            }
        }
        return -1;
    }
}


//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends