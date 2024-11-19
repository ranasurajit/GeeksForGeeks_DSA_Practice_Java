//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);

            if (ans.size() == 0) {
                System.out.println("[]");
            } else {
                for (int i : ans) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
    /**
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public List<Integer> findMajority(int[] nums) {
        int n = nums.length;
        List<Integer> majority = new ArrayList<Integer>();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int it : nums) { // TC: O(N)
            hm.put(it, hm.getOrDefault(it, 0) + 1);
        }
        for (Integer key : hm.keySet()) { // TC: O(N)
            if (hm.get(key) > n / 3) {
                majority.add(key);
            }
        }
        return majority;
    }
}
