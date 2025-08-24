// User function Template for Java

class Solution {
    /**
     * Approach : Using Switch Case Approach
     * 
     * TC: O(1)
     * SC: O(1)
     */
    static double switchCase(int choice, List<Double> arr) {
        double result = 0d;
        switch (choice) {
            case 1:
                result = Math.PI * arr.get(0) * arr.get(0);
                break;
            case 2:
                result = arr.get(0) * arr.get(1);
                break;
            default:
                result = 0d;
        }
        return result;
    }
}
