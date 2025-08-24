// User function Template for Java
class Solution {
    public static String compareNM(int n, int m) {
        if (n == m) {
            return "equal";
        } else if (n < m) {
            return "lesser";
        } else {
            return "greater";
        }
    }
}
