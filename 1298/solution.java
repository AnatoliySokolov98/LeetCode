import java.util.*;

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] visited = new boolean[n];
        Deque<Integer> processing = new ArrayDeque<>();
        Set<Integer> lockedBoxes = new HashSet<>();

        for (int box : initialBoxes) {
            if (status[box] == 1) {
                visited[box] = true;
                processing.add(box);
            } else {
                lockedBoxes.add(box);
            }
        }

        int res = 0;

        while (!processing.isEmpty()) {
            int curr = processing.removeLast();
            res += candies[curr];
            for (int key : keys[curr]) {
                status[key] = 1;
                if (lockedBoxes.contains(key)) {
                    visited[key] = true;
                    lockedBoxes.remove(key);
                    processing.add(key);
                }
            }
            for (int box : containedBoxes[curr]) {
                if (visited[box]) {
                    continue;
                }
                if (status[box] == 1) {
                    processing.add(box);
                    visited[box] = true;
                } else {
                    lockedBoxes.add(box);
                }
            }
        }
        return res;

    }
}

// O(n)
// O(n)