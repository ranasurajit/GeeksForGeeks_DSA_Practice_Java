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
     * Optimal Approach
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public List<Integer> findMajority(int[] nums) {
        // for majority elements > n / 3 then maximum number of elements = 2
        int n = nums.length;
        List<Integer> majority = new ArrayList<Integer>();
        int count1 = 0;
        int count2 = 0;
        int element1 = -1;
        int element2 = -1;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (nums[i] == element1) {
                count1++;
            } else if (nums[i] == element2) {
                count2++;
            } else if (count1 == 0) {
                element1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                element2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (nums[i] == element1) {
                count1++;
            } else if (nums[i] == element2) {
                count2++;
            }
        }
        if (count1 > n / 3) {
            majority.add(element1);
        }
        if (count2 > n / 3) {
            if (element1 > element2) {
                majority.add(0, element2);
            } else {
                majority.add(element2);
            }
        }
        return majority;
    }
    
    /**
     * Better Approach
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public List<Integer> findMajorityBetter(int[] nums) {
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
