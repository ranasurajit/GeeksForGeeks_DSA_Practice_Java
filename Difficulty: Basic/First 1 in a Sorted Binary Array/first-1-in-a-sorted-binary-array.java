//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    public long firstIndex(int arr[]) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int minIndex = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == 1) {
                high = mid - 1;
                minIndex = Math.min(minIndex, mid);
            } else {
                low = mid + 1;
            }
        }
        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }
}


//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.firstIndex(arr));
        }
        sc.close();
    }
}
// } Driver Code Ends