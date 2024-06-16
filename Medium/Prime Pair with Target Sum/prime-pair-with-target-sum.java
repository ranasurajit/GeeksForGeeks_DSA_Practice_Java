//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.ArrayList;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getPrimes(n);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    private static boolean[] primes;
    public static ArrayList<Integer> getPrimes(int n) {
        ArrayList<ArrayList<Integer>> pairList = new ArrayList<ArrayList<Integer>>();
        fillPrime(n);
        for (int x = 1; x <= n / 2; x++) {
            ArrayList<Integer> pair = new ArrayList<Integer>();
            // To validate x + y = n
            int y = n - x;
            if (primes[x] && primes[y]) {
                pair.add(x);
                pair.add(y);
                pairList.add(pair);
            }
        }
        if (pairList.size() == 0) {
            ArrayList<Integer> empty = new ArrayList<Integer>();
            empty.add(-1);
            empty.add(-1);
            return empty;
        }
        return pairList.get(0);
    }
    
    private static void fillPrime(int n) {
        primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i * i; j <= n; j = j + i) {
                if (j < primes.length) {
                    primes[j] = false;
                }
            }
        }
    }
}
