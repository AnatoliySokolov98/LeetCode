import java.util.PriorityQueue;

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int N = grid.length;
        if (N == 1) {
            return grid[0][0];
        }

        int[] smallest = new int[] { 0, -1 };
        int[] biggest = new int[] { 0, -1 };
        for (int row = 0; row < N; row++) {
            PriorityQueue<int[]> currRow = new PriorityQueue<>((int[] a, int[] b) -> b[0] - a[0]);
            for (int col = 0; col < N; col++) {
                if (col != smallest[1]) {
                    currRow.add(new int[] { grid[row][col] + smallest[0], col });
                } else {
                    currRow.add(new int[] { grid[row][col] + biggest[0], col });
                }
                if (currRow.size() > 2) {
                    currRow.poll();
                }
            }
            biggest = currRow.poll();
            smallest = currRow.poll();
        }
        return smallest[0];
    }
}

// time O(n^2)
// space O(1)