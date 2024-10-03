//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String part : parts) {
                nums.add(Integer.parseInt(part));
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public List<Integer> findMajority(List<Integer> nums) {
        int n = nums.size();
        List<Integer> majority = new ArrayList<Integer>();
        /*
         * since we need to find elements of frequency more than n / 3
         * so there can be maximum 2 elements which can be having majority votes
         * solving by usage of Moore's Voting Algorithm
         */
        int element1 = -1;
        int element2 = -1;
        int count1 = 0;
        int count2 = 0;
        
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (nums.get(i) == element1) {
                count1++;
            } else if (nums.get(i) == element2) {
                count2++;
            } else if (count1 == 0) {
                element1 = nums.get(i);
                count1 = 1;
            } else if (count2 == 0) {
                element2 = nums.get(i);
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (nums.get(i) == element1) {
                count1++;
            }
            if (nums.get(i) == element2) {
                count2++;
            }
        }
        if (count1 > n / 3) {
            majority.add(element1);
        }
        if (count2 > n / 3) {
            majority.add(element2);
        }
        if (majority.isEmpty()) {
            majority.add(-1);
        }
        return majority;
    }
}
