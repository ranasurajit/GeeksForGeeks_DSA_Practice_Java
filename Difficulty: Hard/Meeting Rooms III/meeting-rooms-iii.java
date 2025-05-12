//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of rooms
            int m = sc.nextInt(); // Number of meetings
            int[][] meetings = new int[m][2];
            for (int i = 0; i < m; i++) {
                meetings[i][0] = sc.nextInt(); // Start time
                meetings[i][1] = sc.nextInt(); // End time
            }
            Solution ob = new Solution();
            System.out.println(ob.mostBooked(n, meetings));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends

// User function Template for Java
class Solution {
    /**
     * Approach : Using Heaps (PriorityQueue) Approach
     *
     * TC: O(M x log(N) + M x log(M) + N x log(N) + 2 x N) ~ O(M x log(N) + M x log(M) + N x log(N))
     * SC: O(3 x N) ~ O(N)
     */
    public int mostBooked(int n, int[][] meetings) {
        // sort the array 'meetings' based on increasing value of start time
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]); // TC: O(M x log(M))
        // We need a PriorityQueue (Min-Heap) to store { endTime, index } of used rooms
        PriorityQueue<long[]> usedRooms = new PriorityQueue<long[]>((p, q) -> {
            if (p[0] == q[0]) {
                // if end times are same return the smallest index
                return Long.compare(p[1], q[1]);
            }
            // return the room with smallest end time 
            return Long.compare(p[0], q[0]);
        }); // SC: O(N)
        // We need a PriorityQueue (Min-Heap) to store { index } of available rooms
        PriorityQueue<Integer> availableRooms = new PriorityQueue<Integer>(); // SC: O(N)
        // intially all rooms are available
        for (int i = 0; i < n; i++) { // TC: O(N)
            availableRooms.offer(i);  // TC: O(log(N))
        }
        int[] roomUsageCount = new int[n]; // SC: O(N)
        for (int[] meeting : meetings) { // TC: O(M)
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;
            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
                long[] roomDetail = usedRooms.poll();
                availableRooms.offer((int) roomDetail[1]); // TC: O(log(N))
            }
            if (!availableRooms.isEmpty()) {
                // assign from available rooms
                int roomIndex = availableRooms.poll();
                usedRooms.offer(new long[] { end, roomIndex }); // TC: O(log(N))
                roomUsageCount[roomIndex]++;
            } else {
                // wait for the earliest available room i.e. add offset and add back
                long[] earlyRoom = usedRooms.poll();
                usedRooms.offer(new long[] {
                    earlyRoom[0] + duration,
                    earlyRoom[1]
                }); // TC: O(log(N))
                roomUsageCount[(int) earlyRoom[1]]++;
            }
        }
        int maxUsage = 0;
        int roomIndex = -1;
        for (int room = 0; room < n; room++) { // TC: O(N)
            if (maxUsage < roomUsageCount[room]) {
                maxUsage = roomUsageCount[room];
                roomIndex = room;
            }
        }
        return roomIndex;
    }
}


//{ Driver Code Starts.
// } Driver Code Ends