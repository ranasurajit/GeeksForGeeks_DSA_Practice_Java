//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		    Arrays.sort(arr);
		    ArrayList <ArrayList<Integer>> res = new solve().AllSubsets(arr,n);
		    for (int i = 0; i < res.size (); i++)
		    {
		        System.out.print ("(");
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		            if (j != res.get(i).size()-1)
		                System.out.print ((res.get(i)).get(j) + " ");
		            else
		                System.out.print ((res.get(i)).get(j));
		        }
		        System.out.print (")");
		      
		    }
		    System.out.println();
		
System.out.println("~");
}
	}
}
// } Driver Code Ends


class solve {
    // Function to find all possible unique subsets.
    /**
     * Approach : Using Recursion and Sorting Approach
     * 
     * TC: O(2 x N x 2 ^ N) ~ O(N x 2 ^ N)
     * SC: O(N x 2 ^ N)
     */
    public static ArrayList<ArrayList<Integer>> AllSubsets(int arr[], int n) {
        ArrayList<ArrayList<Integer>> uniques = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        solveRecursion(0, arr, n, current, uniques); // TC: O(2 ^ N), SC: O(N)
        for (ArrayList<Integer> list : uniques) { // TC: O(2 ^ N)
            Collections.sort(list); // TC: O(N)
        }
        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>(uniques); // SC: O(2 ^ N)
        uniques = new ArrayList<ArrayList<Integer>>(set);
        uniques.sort((a, b) -> { // TC: O(N x 2 ^ N)
            int len = Math.min(a.size(), b.size());
            for (int i = 0; i < len; i++) {
                int comp = Integer.compare(a.get(i), b.get(i));
                if (comp != 0) {
                    return comp;
                }
            }
            return a.size() - b.size();
        });
        return uniques;
    }

    /**
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private static void solveRecursion(int idx, int[] arr, int n, ArrayList<Integer> current,
        ArrayList<ArrayList<Integer>> uniques) {
        // Base Case
        if (idx == n) {
            uniques.add(new ArrayList<Integer>(current));
            return;
        }
        // Recursion Calls
        // not take
        solveRecursion(idx + 1, arr, n, current, uniques);
        // take
        current.add(arr[idx]);
        solveRecursion(idx + 1, arr, n, current, uniques);
        // backtrack to explore all other possibilities
        current.remove(current.size() - 1);
    }
}
