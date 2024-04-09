import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int num: nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(-b[0], -a[0]));
        counts.forEach((key, value) -> {
            if ((heap.size() == k && value > heap.peek()[0])) {
                heap.poll();
                heap.add(new int[]{value, key});
            }
            else if (heap.size() < k) {
                heap.add(new int[]{value, key});
            }
        });
        int[] res = new int[k];
        int i = 0;
        while(!heap.isEmpty()) {
            int [] curr = heap.poll();
            res[i++] = curr[1];
        }
        return res;
    }
}