//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int p1[] = new int[2];
            int q1[] = new int[2];
            int p2[] = new int[2];
            int q2[] = new int[2];
            String S1[] = read.readLine().split(" ");
            p1[0] = Integer.parseInt(S1[0]);
            p1[1] = Integer.parseInt(S1[1]);
            q1[0] = Integer.parseInt(S1[2]);
            q1[1] = Integer.parseInt(S1[3]);
            String S2[] = read.readLine().split(" ");
            p2[0] = Integer.parseInt(S2[0]);
            p2[1] = Integer.parseInt(S2[1]);
            q2[0] = Integer.parseInt(S2[2]);
            q2[1] = Integer.parseInt(S2[3]);
            Solution ob = new Solution();
            String ans = ob.doIntersect(p1, q1, p2, q2);
            // if(ans)
            System.out.println(ans);
            // else
            // System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String doIntersect(int p1[], int q1[], int p2[], int q2[]) {
        Point a = new Point(p1[0], p1[1]);
        Point b = new Point(q1[0], q1[1]);
        Point c = new Point(p2[0], p2[1]);
        Point d = new Point(q2[0], q2[1]);
        int o1 = getOrientation(a, b, c);
        int o2 = getOrientation(a, b, d);
        int o3 = getOrientation(c, d, a);
        int o4 = getOrientation(c, d, b);
        // if orientation of points wrt a line from both points are Clockwise and Anti-clockwise
        if (o1 != o2 && o3 != o4) {
            return "true";
        }
        // check for collinearity
        if (o1 == 0 && o4 == 0) {
            if (isValidProjection(a.x, b.x, c.x, d.x) && isValidProjection(a.y, b.y, c.y, d.y)) {
                return "true";
            }
        }
        return "false";
    }
    
    private int getOrientation(Point p1, Point p2, Point p0) {
        long val = (long) (p1.x - p0.x) * (long) (p2.y - p0.y) - (long) (p2.x - p0.x) * (long) (p1.y - p0.y);
        if (val == 0) {
            return 0;
        }
        return val > 0 ? 1 : 2;
    }
    
    private boolean isValidProjection(int a, int b, int c, int d) {
        if (a > b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        if (c > d) {
            c = c ^ d;
            d = c ^ d;
            c = c ^ d;
        }
        return Math.max(a, c) <= Math.min(b, d);
    }
    
    class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
