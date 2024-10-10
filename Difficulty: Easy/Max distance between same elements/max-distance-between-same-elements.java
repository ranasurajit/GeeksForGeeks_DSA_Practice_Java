//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;


// } Driver Code Ends
class Solution {
    /**
     * TC:O(N)
     * SC:O(N)
     */ 
    public int maxDistance(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC:O(N)
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC:O(N)
            if (hm.containsKey(arr[i])) {
                maxDiff = Math.max(maxDiff, i - hm.get(arr[i]));
            } else {
                hm.put(arr[i], i);
            }
        }
        return maxDiff;
    }
}


//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxDistance(arr));
        }
        sc.close();
    }
}
// } Driver Code Ends