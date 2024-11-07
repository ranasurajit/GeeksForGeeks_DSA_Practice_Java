//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            Solution ob = new Solution();
            List<Integer> result = ob.findSplit(arr);

            if (result.get(0) == -1 && result.get(1) == -1 || result.size() != 2) {
                System.out.println("false");
            } else {
                int sum1 = 0, sum2 = 0, sum3 = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (i <= result.get(0))
                        sum1 += arr[i];

                    else if (i <= result.get(1))
                        sum2 += arr[i];

                    else
                        sum3 += arr[i];
                }
                if (sum1 == sum2 && sum2 == sum3) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    /**
     * TC: O(2N) ~ O(N)
     * SC: O(1)
     */
    public List<Integer> findSplit(int[] arr) {
        List<Integer> result = new ArrayList<Integer>();
        long total = 0L;
        for (int it : arr) {                    // TC: O(N)
            total += it;
        }
        if (total % 3 != 0) {
            return Arrays.asList(-1, -1);
        }
        long segmentTotal = total / 3;
        long currentSum = 0L;
        int first = -1;
        int second = -1;
        for (int i = 0; i < arr.length; i++) {  // TC: O(N)
            currentSum += arr[i];
            if (currentSum == segmentTotal) {
               if (first == -1) {
                   first = i;
               } else if (second == -1) {
                   second = i;
                   break;
               }
               currentSum = 0;
            }
        }
        if (first != -1 && second != -1) {
            return Arrays.asList(first, second);
        }
        return Arrays.asList(-1, -1);
    }
}
