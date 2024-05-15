import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int N = grid.size();
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        // Step 1: Initialize safety matrix with -1
        int[][] safetyDistances = new int[N][N];
        for (int[] row : safetyDistances) {
            Arrays.fill(row, -1);
        }

        // Step 2: BFS initialization
        Queue<int[]> bfsQueue = new LinkedList<>();
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (grid.get(row).get(col) == 1) {
                    bfsQueue.add(new int[] { row, col, 0 });
                    safetyDistances[row][col] = 0;
                }
            }
        }

        // Step 3: Perform BFS to compute safety distances
        while (!bfsQueue.isEmpty()) {
            int[] cell = bfsQueue.poll();
            int row = cell[0], col = cell[1], dist = cell[2];
            for (int[] direction : directions) {
                int newRow = row + direction[0], newCol = col + direction[1];
                if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= N || safetyDistances[newRow][newCol] != -1) {
                    continue;
                }
                safetyDistances[newRow][newCol] = dist + 1;
                bfsQueue.add(new int[] { newRow, newCol, dist + 1 });
            }
        }

        boolean[][] visited = new boolean[N][N];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        maxHeap.add(new int[] { safetyDistances[0][0], 0, 0 });

        // Step 4: Use a priority queue to find the maximum safeness path
        while (!maxHeap.isEmpty()) {
            int[] cell = maxHeap.poll();
            int currentSafeness = cell[0], row = cell[1], col = cell[2];
            if (row == N - 1 && col == N - 1) {
                return currentSafeness;
            }
            if (visited[row][col]) {
                continue;
            }
            visited[row][col] = true;
            for (int[] direction : directions) {
                int newRow = row + direction[0], newCol = col + direction[1];
                if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= N || visited[newRow][newCol]) {
                    continue;
                }
                maxHeap.add(new int[] { Math.min(currentSafeness, safetyDistances[newRow][newCol]), newRow, newCol });
            }
        }

        return -1;
    }
}

// time O(n^2log(n^2))
// space O(n^2)