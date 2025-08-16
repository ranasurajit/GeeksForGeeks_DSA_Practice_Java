class Solution {
    /**
     * Approach : Using Strings + Sorting Approach
     * 
     * TC: O(N) + O(N x log(N)) + O(N) ~ O(N x log(N))
     * SC: O(N) + O(N) ~ O(N)
     */
    public String findLargest(int[] arr) {
        int n = arr.length;
        String[] strArr = new String[n]; // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            strArr[i] = String.valueOf(arr[i]);
        }
        Arrays.sort(strArr, (a, b) -> (b + a).compareTo(a + b)); // TC: O(N x log(N))
        if (strArr[0].equals("0")) {
            // if after sorting the 0th index String is "0" then entire result will be "0"
            return "0";
        }
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        for (String s : strArr) { // TC: O(N)
            sb.append(s);
        }
        return sb.toString();
    }
}
