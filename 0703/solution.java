import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> heap;
    int K;

    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>();
        K = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (heap.size() < K || heap.peek() < val) {
            heap.add(val);
            if (heap.size() > K) {
                heap.poll();
            }
        }
        return heap.peek();
    }
}

// time O(nlogk)
// space O(k)