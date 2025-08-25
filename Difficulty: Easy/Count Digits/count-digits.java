// User function Template for Java

class Solution {
    /**
     * Approach : Using Math Approach
     * 
     * TC: O(log(N) Base10)
     * SC: O(1)
     */
    static int evenlyDivides(int n) {
        int num = n;
        int count = 0;
        while (num > 0) { // TC: O(log(N) Base10)
            int digit = num % 10;
            if (digit > 0 && n % digit == 0) {
                count++;
            }
            num = num / 10;
        }
        return count;
    }
}
