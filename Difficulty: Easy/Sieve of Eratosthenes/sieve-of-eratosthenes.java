//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			
            Solution ob = new Solution();
            ArrayList<Integer> primes  = ob.sieveOfEratosthenes(N);
            for(int prime : primes) {
                System.out.print(prime+" ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    /**
     * TC: O(N + N x log(log(N)))
     * SC: O(N)
     */
    static ArrayList<Integer> sieveOfEratosthenes(int N){
        int[] primes = new int[N + 1];     // SC: O(N)
        Arrays.fill(primes, 1);
        primes[0] = 0;
        primes[1] = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 2; i * i <= N; i++) { // TC: O(N)
            if (primes[i] == 1) {
                for (int j = i * i; j <= N; j += i) { // TC: O(log(log(N))) - prime harmonic series
                    primes[j] = 0;
                }
            }
        }
        for (int i = 2; i < N + 1; i++) {  // TC: O(N)
            if (primes[i] == 1) {
                result.add(i);
            }
        }
        return result;
    }
}
