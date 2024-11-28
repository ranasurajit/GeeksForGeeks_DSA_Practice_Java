//{ Driver Code Starts
// Initial template for JAVA

import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();

            Solution obj = new Solution();
            int num = obj.myAtoi(str);
            System.out.println(num);
            System.out.println("~");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        boolean isNegative = false;
        // remove all leading zeros
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        // check for negative number
        if (s.charAt(i) == '-') {
            isNegative = true;
            i++;
        }
        // checking if pointer goes out of bound
        if (i == n) {
            return 0;
        }
        long number = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            number = 10 * number + (s.charAt(i) - '0');
            i++;
        }
        // check for numbers outside range of Integer
        if (number > Integer.MAX_VALUE) {
            if (isNegative) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        if (isNegative) {
            return -1 * (int) number;
        } else {
            return (int) number;
        }
    }
}
