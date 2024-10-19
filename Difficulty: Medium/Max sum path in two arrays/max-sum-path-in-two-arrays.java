//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline

        for (int k = 0; k < t; k++) {
            List<Integer> arr1 = new ArrayList<>();
            String input = sc.nextLine();
            Scanner lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr1.add(lineScanner.nextInt());
            }
            lineScanner.close();

            List<Integer> arr2 = new ArrayList<>();
            input = sc.nextLine();
            lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr2.add(lineScanner.nextInt());
            }
            lineScanner.close();

            Solution ob = new Solution();
            int ans = ob.maxPathSum(arr1, arr2);
            System.out.println(ans);
        }

        sc.close();
    }
}

// } Driver Code Ends



class Solution {
    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        int m = arr1.size();
        int n = arr2.size();
        int p = m - 1;
        int q = n - 1;
        int sum1 = 0;
        int sum2 = 0;
        while (p >= 0 && q >= 0) {
            if (arr1.get(p) > arr2.get(q)) {
                sum1 += arr1.get(p--);
            } else if (arr1.get(p) < arr2.get(q)) {
                sum2 += arr2.get(q--);
            } else {
                int common = arr1.get(p);
                sum1 += common;
                sum2 += common;
                sum1 = Math.max(sum1, sum2);
                sum2 = sum1;
                p--;
                q--;
            }
        }
        while (p >= 0) {
            sum1 += arr1.get(p--);
        }
        while (q >= 0) {
            sum2 += arr2.get(q--);
        }
        return Math.max(sum1, sum2);
    }
}
