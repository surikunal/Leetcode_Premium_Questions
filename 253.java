/*
Algorithm

Sort the given meetings by their start time.
Initialize a new min-heap and add the first meeting's ending time to the heap. We simply need to keep track of the ending times as that tells us when a meeting room will get free.
For every meeting room check if the minimum element of the heap i.e. the room at the top of the heap is free or not.
If the room is free, then we extract the topmost element and add it back with the ending time of the current meeting we are processing.
If not, then we allocate a new room and add it to the heap.
After processing all the meetings, the size of the heap will tell us the number of rooms allocated. This will be the minimum number of rooms needed to accommodate all the meetings.
Let us not look at the implementation for this algorithm.

*/

// using PQ ===================================================

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {    // sorting acc to start time
            return a[0] - b[0];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // to save end time
        for (int[] interval : intervals) {
            if (pq.size() == 0) {   // first meeting (have to add in PQ)
                pq.add(interval[1]);
            } else {
                if (pq.peek() > interval[0]) {  // if new meeting start before ending the last one so assign a new room
                    pq.add(interval[1]);
                } else {    // if last meeting already ended then remove previous one and now add new one
                    pq.poll();
                    pq.add(interval[1]);
                }
            }
        }
        return pq.size();   // size of PQ is our answer
    }
}


class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; ++i) {
            if (pq.peek() <= intervals[i][0]) pq.poll();
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}


// using chronological ordering ===================================================

/*

Algorithm

Separate out the start times and the end times in their separate arrays.
Sort the start times and the end times separately. Note that this will mess up the original correspondence of start times and end times. They will be treated individually now.
We consider two pointers: s_ptr and e_ptr which refer to start pointer and end pointer. The start pointer simply iterates over all the meetings and the end pointer helps us track if a meeting has ended and if we can reuse a room.
When considering a specific meeting pointed to by s_ptr, we check if this start timing is greater than the meeting pointed to by e_ptr. If this is the case then that would mean some meeting has ended by the time the meeting at s_ptr had to start. So we can reuse one of the rooms. Otherwise, we have to allocate a new room.
If a meeting has indeed ended i.e. if start[s_ptr] >= end[e_ptr], then we increment e_ptr.
Repeat this process until s_ptr processes all of the meetings.
Let us not look at the implementation for this algorithm.

*/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        int itr = 0;
        for (int[] i: intervals) {
            start[itr] = i[0];
            end[itr++] = i[1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int s = 0, e = 0;
        int count = 0;
        while (s < n) {
            if (start[s] < end[e]) {
                count++;
            } else {
                e++;
            }
            s++;
        }
        return count;
    }
}
