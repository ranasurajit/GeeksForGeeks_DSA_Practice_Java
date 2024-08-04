//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(n, start, end);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int n, int start[], int end[]) {
        PriorityQueue<Pair> pq = 
            new PriorityQueue<Pair>((Pair p, Pair q) -> p.end - q.end);
        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(start[i], end[i], i));
        }
        List<Pair> list = new ArrayList<Pair>();
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            if (list.isEmpty()) {
                list.add(current);
            } else {
                Pair last = list.get(list.size() - 1);
                if (last.end < current.start) {
                    list.add(current);
                }
            }
        }
        return list.size();
    }
    
    class Pair {
        int start;
        int end;
        int index;
        public Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}
