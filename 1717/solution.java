import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maximumGain(String s, int x, int y) {
        int res = 0;
        List<Character> stack = new ArrayList<>();
        String goodVal = x > y ? "ab" : "ba";
        int small = Math.min(x, y);
        int big = Math.max(x, y);

        for (char c : s.toCharArray()) {
            if (c > 'b') {
                res += calculateRemainingStack(stack, small);
                stack.clear();
            } else if (!stack.isEmpty() && c == goodVal.charAt(1) && stack.getLast() == goodVal.charAt(0)) {
                stack.removeLast();
                res += big;
            } else {
                stack.add(c);
            }
        }

        if (!stack.isEmpty()) {
            res += calculateRemainingStack(stack, small);
        }
        return res;
    }

    private int calculateRemainingStack(List<Character> stack, int val) {
        int ays = 0;
        int bees = 0;
        for (char c : stack) {
            if (c == 'a') {
                ays++;
            } else {
                bees++;
            }
        }
        return Math.min(ays, bees) * val;
    }
}

// time O(n)
// space O(n)