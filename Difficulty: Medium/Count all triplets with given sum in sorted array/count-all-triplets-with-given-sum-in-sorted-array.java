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
            int target = Integer.parseInt(sc.nextLine());

            Solution ob = new Solution();
            int ans = ob.countTriplets(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    /**
     * Using Two Pointers approach
     *
     * TC: O(N x N)
     * SC: O(1)
     */
    public int countTriplets(int[] arr, int target) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) { // TC O(N)
            int start = i + 1;
            int end = n - 1;
            while (start < end) {         // TC O(N)
                int sum = arr[i] + arr[start] + arr[end];
                if (sum == target) {
                    count++;
                    int temp = start + 1;
                    while (temp < end && arr[temp] == arr[temp - 1]) {
                        count++;
                        temp++;
                    }
                    end--;
                } else if (sum < target) {
                    start++;
                } else if (sum > target) {
                    end--;
                }
            }
        }
        return count;
    }
}
