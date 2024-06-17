//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			long a = sc.nextInt();
			Solution obj = new Solution();
			System.out.println(obj.floorSqrt(a));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution
{
     long floorSqrt(long x) {
		if (x == 0L) {
            return 0L;
        }
        long low = 1L;
        long high = x;
        long sqrt = 1;
        while (low <= high) {
            long mid = low + ((high - low) / 2);
            long prod = mid * mid;
            if (prod == x) {
                return mid;
            } else if (prod <= x) {
                sqrt = mid;
                low = mid + 1;
            } else if (prod > x) {
                high = mid - 1;
            }
        }
        return sqrt;
	 }
}
