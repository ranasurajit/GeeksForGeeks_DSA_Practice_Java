//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine()); // Read number of test cases

        // Loop through each test case
        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.split(" ");
            List<Integer> arr = new ArrayList<>();

            // Convert input to list of integers
            for (String str : inputArr) {
                arr.add(Integer.parseInt(str));
            }

            Solution ob = new Solution();
            boolean ans = ob.checkSorted(arr);

            // Output result
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");
        }

        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public boolean checkSorted(List<Integer> arr) {
        int n = arr.size();
        int swaps = 0;
        int i = 0;
        while (i < n) { // TC: O(N)
            if (arr.get(i) != i + 1) {
                // swap arr.get(i) with arr.get(arr.get(i) - 1)
                int idx = arr.get(i) - 1;
                int temp = arr.get(i);
                arr.set(i, arr.get(idx));
                arr.set(idx, temp);
                swaps++;
            } else {
                i++;
            }
        }
        return swaps == 0 || swaps == 2;
    }
}
