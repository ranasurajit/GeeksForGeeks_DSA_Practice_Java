//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;


// } Driver Code Ends
class Solution {
    /**
     * TC: O(2N) ~ O(N)
     * SC: O(N)
     */
    public int maxDistance(int[] arr) {
        int n = arr.length;
        HashMap<Integer, ArrayList> hm = new HashMap<Integer, ArrayList>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (!hm.containsKey(arr[i])) {
                hm.put(arr[i], new ArrayList<Integer>());
            }
            hm.get(arr[i]).add(i);
        }
        int max = Integer.MIN_VALUE;
        for (Integer key : hm.keySet()) { // TC: O(N)
            ArrayList<Integer> list = hm.get(key);
            max = Math.max(max, list.get(list.size() - 1) - list.get(0));
        }
        return max;
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