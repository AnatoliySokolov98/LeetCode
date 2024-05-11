import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int L = quality.length;
        double[][] ratios = new double[L][2];
        for (int i = 0; i < L; i++) {
            ratios[i][0] = ((double) wage[i]) / quality[i];
            ratios[i][1] = quality[i];
        }
        Arrays.sort(ratios, (a, b) -> Double.compare(a[0], b[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        Double res = Double.MAX_VALUE;
        int total = 0;
        for (double[] ratio : ratios) {
            total += ratio[1];
            heap.add((int) ratio[1]);
            if (heap.size() > k) {
                total -= heap.poll();
            }
            if (heap.size() == k) {
                res = Math.min(res, ratio[0] * total);
            }
        }
        return res;
    }
}

// time O(nlogn)
// space O(n)