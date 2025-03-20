package patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
//        int[][] res = mergeIntervals.merge(new int[][]{{1, 4}, {4, 5}});

//        int[][] res = mergeIntervals.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
//        for (int i = 0; i < res.length; i++) {
//            System.out.println(Arrays.toString(res[i]));
//        }

//        int[] start = {0, 3, 1, 5, 5, 8};
//        int[] end = {5, 4, 2, 9, 7, 9};
//        System.out.println(mergeIntervals.maxMeetings(start, end));

        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(mergeIntervals.eraseOverlapIntervals(intervals));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curInterval = intervals[i];
            int[] lastMergedInterval = list.get(list.size() - 1);

            if (curInterval[0] <= lastMergedInterval[1]) {
                lastMergedInterval[1] = Math.max(curInterval[1], lastMergedInterval[1]);
            } else {
                list.add(curInterval);
            }
        }
        return list.toArray(new int[0][]);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> input = new ArrayList<>(Arrays.asList(intervals));
        input.add(newInterval);
        intervals = input.toArray(new int[0][]);
        return merge(intervals);
    }

    class Meeting {
        int start;
        int end;
        int position;

        public Meeting(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getPosition() {
            return position;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "start=" + start +
                    ", end=" + end +
                    ", position=" + position +
                    '}';
        }
    }

    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        int maxMeetings = 0;
        Meeting[] allMeetings = new Meeting[start.length];
        for (int i = 0; i < start.length; i++) {
            allMeetings[i] = new Meeting(start[i], end[i], i + 1);
        }
//        Sort based on end timings
        Arrays.sort(allMeetings, Comparator.comparingInt(Meeting::getEnd));

        System.out.println(Arrays.toString(allMeetings));

//      As ends are sorted we can obviulsy perform 1st meeting
        maxMeetings = 1;
        List<Integer> positions = new ArrayList<>();
        positions.add(allMeetings[0].position);
        int freeTime = allMeetings[0].end;  // 1st meeting ends here, so other can use after this

        for (int i = 1; i < allMeetings.length; i++) {
            if (allMeetings[i].start > freeTime) {
                maxMeetings++;
                freeTime = allMeetings[i].end;
                positions.add(allMeetings[i].position);
            }
        }
        System.out.println(positions);
        return maxMeetings;
    }


    //   Same as max meetings problem
//    But just inverse it
    public int eraseOverlapIntervals(int[][] intervals) {
        int size = 0;
//        sort based on end time-> if both are equal then sort on start time
        Arrays.sort(intervals, Comparator.comparingInt((int[] i) -> i[1])
                .thenComparingInt((int[] s) -> s[0]));

//        1st meeting can be done
        size = 1;
//        1st interval end time
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                size++;
            }
        }

//        total meetings can be done = size .
//        remaining meetings = overlapping meetings
        return intervals.length - size;
    }
}
