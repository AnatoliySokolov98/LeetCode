import java.util.PriorityQueue;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int A = arr.length;
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (a, b) -> Double.compare((double) (arr[a[0]]) / arr[a[1]], (double) (arr[b[0]]) / arr[b[1]]));
        heap.add(new int[] { 0, A - 1 });
        boolean[][] visited = new boolean[A][A];
        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int i = curr[0];
            int j = curr[1];
            k--;
            if (k == 0) {
                return new int[] { arr[i], arr[j] };
            }
            if (i + 1 < j) {
                if (!visited[i + 1][j]) {
                    visited[i + 1][j] = true;
                    heap.add(new int[] { i + 1, j });
                }
                if (!visited[i][j - 1]) {
                    visited[i][j - 1] = true;
                    heap.add(new int[] { i, j - 1 });
                }
            }
        }
        return new int[] {};
    }
}

// time O(klog(n^2))
// space O(n^2)
