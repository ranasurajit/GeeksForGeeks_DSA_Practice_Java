//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends



class Solution {
    public String smallestNumber(int s, int d) {
        int maxSum = 0;
        for (int i = 0; i < d; i++) {
            maxSum += 9;
        }
        if (s > maxSum) {
            return "-1";
        }
        String result = "";
        for (int i = d - 1; i >= 0; i--) {
            if (s > 9) {
                result = "9" + result;
                s = s - 9;
            } else {
                if (i == 0) {
                    result = Integer.toString(s) + result;
                } else {
                    s = s - 1;
                    result = Integer.toString(s) + result;
                    i--;
                    while (i > 0) {
                        result = "0" + result;
                        i--;
                    }
                    result = "1" + result;
                    break;
                }
            }
        }
        return result;
    }
}
