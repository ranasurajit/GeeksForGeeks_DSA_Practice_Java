//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public long findMaxProduct(List<Integer> arr) {
        int n = arr.size();
        if (n == 1) {
            return arr.get(0);
        }
        long posProd = 1L, negProd = 1L;
        long cPos = 0, cNeg = 0;
        long negMax = Long.MIN_VALUE;
        long mod = 1000000007;
        for (int i = 0; i < n; i++) {
            long element = (long) arr.get(i);
            if (element > 0) {
                posProd = (posProd * element) % mod;
                cPos++;
            } else if (element < 0) {
                negProd = (negProd * element) % mod;
                negMax = Math.max(negMax, element);
                cNeg++;
            }
        }
        if (cNeg <= 1 && cPos == 0) {
            // array has 0 or 1 negative values and all other zeros so max value = 0
            return 0;
        }
        if (negProd < 0) {
            negProd = negProd / negMax;
        }
        return (posProd * negProd) % mod;
    }
}
