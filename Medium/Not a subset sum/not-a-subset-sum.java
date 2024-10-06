//{ Driver Code Starts
// Initial Template for Java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] inputArr = input.split(" ");
            int[] arr = new int[inputArr.length];
            for (int i = 0; i < inputArr.length; i++) {
                arr[i] = Integer.parseInt(inputArr[i]);
            }

            Solution ob = new Solution();
            long ans = ob.findSmallest(arr);
            System.out.println(ans);
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public long findSmallest(int[] arr) {
        long smallest = 1L;
        int n = arr.length;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (arr[i] > smallest) {
                return smallest;
            } else {
                /* 
                 * addition of arr[i] to smallest will ensure a number
                 * which cannot be formed after adding arr[i] as a subset sum
                 */
                smallest += (long) arr[i];
            }
        }
        return smallest;
    }
}
