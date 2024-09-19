//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] inputStrings = input.split(" ");
            int[] height = new int[inputStrings.length];
            for (int i = 0; i < inputStrings.length; i++) {
                height[i] = Integer.parseInt(inputStrings[i]);
            }
            Solution ob = new Solution();
            int ans = ob.countBuildings(height);
            System.out.println(ans);
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Returns count buildings that can see sunlight
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public int countBuildings(int[] height) {
        int n = height.length;
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (height[i] > max) {
                // at this condition building will face the sun
                count++;
            }
            max = Math.max(max, height[i]);
        }
        return count;
    }
}
