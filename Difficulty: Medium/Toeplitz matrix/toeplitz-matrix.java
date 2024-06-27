//{ Driver Code Starts
import java.util.*;

class Check_IsToepliz {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int arr[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) arr[i][j] = sc.nextInt();
            }

            Solution g = new Solution();
            boolean b = g.isToepliz(arr);

            if (b == true)
                System.out.println("true");
            else
                System.out.println("false");

            T--;
        }
    }
}
// } Driver Code Ends


class Solution {
    /*You are required to complete this method*/
    boolean isToepliz(int mat[][]) {
        int rows = mat.length;
        int cols = mat[0].length;
        Map<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!hm.containsKey(i - j)) {
                    hm.put(i - j, new ArrayList<Integer>());
                }
                if (hm.get(i - j).size() == 0) {
                    hm.get(i - j).add(mat[i][j]);
                } else {
                    if (hm.get(i - j).get(0) != mat[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
