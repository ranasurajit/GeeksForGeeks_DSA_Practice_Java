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
        // int n = arr.length;
        // /**
        //  * count stores the sum of all bits of numbers in array
        //  * from rightmost bit to leftmost bit
        //  * i.e. count is storing binary bits in reverse order
        //  */
        // int[] count = new int[32]; // SC: O(32) ~ O(1)
        // for (int item : arr) { // TC: O(N)
        //     int j = 0;
        //     while (item > 0) { // TC: O(1)
        //         int lastBit = (item & 1);
        //         count[j] += lastBit;
        //         j++;
        //         item = item >> 1;
        //     }
        // }
        // int unique = 0;
        // int pow = 1;
        // for (int i = 0; i < 32; i++) { // TC: O(32) ~ O(1)
        //     count[i] = count[i] % 3; // removes contribution from 3 times of duplicates
        //     unique += count[i] * pow;
        //     pow = pow << 1;
        // }
        // return unique;
        int ones = 0, twos = 0;

        for (int num : arr) {
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
