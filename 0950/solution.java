import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
   public int[] deckRevealedIncreasing(int[] deck) {
      Arrays.sort(deck);
      int D = deck.length;
      Deque<Integer> queue = new ArrayDeque<>();
      for (int i = 0; i < D; i++) {
         queue.add(i);
      }
      int i = 0;
      int[] res = new int[D];
      while (queue.size() > 0) {
         int curr = queue.pollFirst();
         res[curr] = deck[i++];
         if (queue.size() > 0) {
            queue.add(queue.pollFirst());
         }
      }
      return res;
   }
}

// time O(nlogn)
// space O(n)