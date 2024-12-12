//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        Solution ob = new Solution(); // Instantiate the Solution object once

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int[] arr = new int[elements.length]; // Changed to int[]

            for (int i = 0; i < elements.length; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            System.out.println(ob.findMin(arr));
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Using Binary Search
     * 
     * TC: O(log(N))
     * SC: O(1)
     */
    public int findMin(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int min = Integer.MAX_VALUE;
        while (low <= high) {                // TC: O(log(N))
            int mid = low + (high - low) / 2;
            if (arr[mid] >= arr[low]) {
                // left part is sorted so capture the minimum and minimize search space
                min = Math.min(min, arr[low]);
                low = mid + 1;
            } else if (arr[mid] <= arr[high]) {
                // right part is sorted so capture the minimum and minimize search space
                min = Math.min(min, arr[mid]);
                high = mid - 1;
            }
        }
        return min;
    }
}
