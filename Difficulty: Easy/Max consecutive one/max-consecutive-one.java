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
            Solution ob = new Solution();
            int ans = ob.maxConsecutiveCount(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    /**
     * Approach : Using Simulation Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int maxConsecutiveCount(int[] arr) {
        int n = arr.length;
        int maxCountZeros = 0;
        int maxCountOnes = 0;
        int countZeros = 0;
        int countOnes = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (arr[i] == 0) {
                // reset count ones
                countOnes = 0;
                countZeros++;
            } else {
                // reset count zeros
                countZeros = 0;
                countOnes++;
            }
            maxCountZeros = Math.max(maxCountZeros, countZeros);
            maxCountOnes = Math.max(maxCountOnes, countOnes);
        }
        return Math.max(maxCountZeros, maxCountOnes);
    }
}
