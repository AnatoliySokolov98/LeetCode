import java.util.PriorityQueue;

class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            minHeap.add(num);
            maxHeap.add(num);

            if (minHeap.size() > 4) {
                minHeap.poll();
            }
            if (maxHeap.size() > 4) {
                maxHeap.poll();
            }
        }

        int[] smallestNums = new int[4];
        int[] biggestNums = new int[4];
        for (int i = 0; i <= 3; i++) {
            biggestNums[i] = minHeap.poll();
            smallestNums[3 - i] = maxHeap.poll();
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3 - i; j++) {
                res = Math.min(res, biggestNums[3 - j] - smallestNums[i]);
            }
        }
        return res;
    }
}

// time O(n)
// space O(1)