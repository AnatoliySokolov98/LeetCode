import java.util.PriorityQueue;

class Solution {
   public int[][] kClosest(int[][] points, int k) {
      PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
         int A = a[0] * a[0] + a[1] * a[1];
         int B = b[0] * b[0] + b[1] * b[1];
         return B - A;
      });
      for (int[] point : points) {
         heap.add(point);
         if (heap.size() > k) {
            heap.poll();
         }
      }
      int[][] res = new int[k][2];
      int i = 0;
      while (!heap.isEmpty()) {
         res[i++] = heap.poll();
      }
      return res;
   }
}