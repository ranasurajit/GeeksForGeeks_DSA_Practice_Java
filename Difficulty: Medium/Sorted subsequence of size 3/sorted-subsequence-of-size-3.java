//{ Driver Code Starts
import java.util.*;

public class GFG {
    // Function to check if v2 is a subsequence of v1
    public static boolean isSubSequence(int[] v1, int[] v2) {
        int m = v2.length;
        int n = v1.length;
        int j = 0; // For index of v2

        // Traverse v1 and v2
        for (int i = 0; i < n && j < m; i++) {
            if (v1[i] == v2[j]) {
                j++;
            }
        }
        return j == m;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            int n = arr.length;
            Solution obj = new Solution();
            List<Integer> res = obj.find3Numbers(arr);
            if (!res.isEmpty() && res.size() != 3) {
                System.out.println(-1);
            } else {
                int[] resArray = res.stream().mapToInt(Integer::intValue).toArray();
                if (resArray.length == 0) {
                    System.out.println(0);
                } else if (resArray[0] < resArray[1] && resArray[1] < resArray[2] &&
                           isSubSequence(arr, resArray)) {
                    System.out.println(1);
                } else {
                    System.out.println(-1);
                }
            }
        }
        sc.close();
    }
}

// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to find three numbers such that arr[smaller[i]] < arr[i] <
    // arr[greater[i]]
    /**
     * TC: O(N)
     * SC: O(N)
     */
    public List<Integer> find3Numbers(int[] arr) {
        int n = arr.length;
        List<Integer> result = new ArrayList<Integer>();
        // pre-process array to find left smaller element at an index
        int[] small = new int[n]; // SC: O(N)
        Arrays.fill(small, Integer.MAX_VALUE);
        small[0] = arr[0];
        for (int i = 1; i < n; i++) { // TC: O(N)
            small[i] = Math.min(small[i - 1], arr[i]);
        }
        // pre-process array to find right larger element at an index
        int[] big = new int[n]; // SC: O(N)
        Arrays.fill(big, Integer.MIN_VALUE);
        big[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) { // TC: O(N)
            big[i] = Math.max(big[i + 1], arr[i]);
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (arr[i] > small[i] && arr[i] < big[i]) {
                result.add(small[i]);
                result.add(arr[i]);
                result.add(big[i]);
                break;
            }
        }
        return result;
    }
}
