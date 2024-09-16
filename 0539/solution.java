import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] times = new boolean[24 * 60];
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        // Mark time points and determine start and end time
        for (String time : timePoints) {
            int minutes = Integer.parseInt(time.substring(3, 5));
            int hours = Integer.parseInt(time.substring(0, 2));
            int totalMinutes = hours * 60 + minutes;

            // If the time is already recorded, return 0
            if (times[totalMinutes]) {
                return 0;
            }
            times[totalMinutes] = true;
            start = Math.min(start, totalMinutes);
            end = Math.max(end, totalMinutes);
        }

        // Calculate the minimum time difference by considering the circular nature of
        // the clock
        int minDifference = 24 * 60 - end + start;
        int prev = start;

        // Iterate through the time points to find the minimum difference
        for (int i = start + 1; i <= end; i++) {
            if (times[i]) {
                minDifference = Math.min(minDifference, i - prev);
                prev = i;
            }
        }

        return minDifference;
    }
}

// time O(n)
// space O(1)