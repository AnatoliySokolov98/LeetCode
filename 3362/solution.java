import java.util.*;

class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));
        int[] diffs = new int[nums.length + 1];
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        int total = 0;
        int res = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            total += diffs[i];
            while (j < queries.length && queries[j][0] == i) {
                heap.add(queries[j++][1]);
            }
            while (nums[i] + total > 0) {
                if (heap.isEmpty()) {
                    return -1;
                }
                int num = heap.remove();
                if (num < i) {
                    continue;
                }
                total--;
                res++;
                diffs[num + 1]++;
            }
        }
        return queries.length - res;
    }
}

// time O(qlogq + n)
// space O(n + q)