import java.util.ArrayDeque;

class Solution {
    public int findTheWinner(int n, int k) {
        ArrayDeque<Integer> circle = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            circle.addLast(i);
        }
        while (circle.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                circle.addLast(circle.pollFirst());
            }
            circle.pollFirst();
        }
        return circle.getFirst();
    }
}

// time O(n*k)
// space O(n)