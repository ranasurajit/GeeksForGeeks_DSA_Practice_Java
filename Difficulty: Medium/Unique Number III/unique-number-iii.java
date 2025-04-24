//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSingle(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Approach II : Using Bit-Manipulation Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int getSingle(int[] arr) {
        int ones = 0, twos = 0;
        for (int num : arr) { // TC: O(N)
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }

    /**
     * Approach I : Using Hashing Approach
     * 
     * TC: O(4 x (N / 3)) ~ O(N)
     * SC: O(N / 3) ~ O(N)
     */
    public int getSingleApproachI(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // TC: O(N / 3 + 1)
        for (int item : arr) { // TC: O(N)
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        for (Integer key : map.keySet()) { // TC: O(N / 3 + 1)
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }
}
