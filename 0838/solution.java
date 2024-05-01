import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String pushDominoes(String dominoes) {
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder(dominoes);
        int rightLoc = -1;
        for (int i = 0; i < dominoes.length(); i++) {
            char curr = dominoes.charAt(i);
            if (curr == '.') {
                stack.addLast(i);
            } else if (curr == 'R') {
                if (rightLoc != -1) {
                    while (!stack.isEmpty()) {
                        int last = stack.pollLast();
                        res.setCharAt(last, 'R');
                    }
                } else {
                    stack.clear();
                }
                rightLoc = i;
            } else {
                while (!stack.isEmpty()) {
                    int last = stack.pollLast();
                    if (rightLoc == -1 || last - rightLoc > i - last) {
                        res.setCharAt(last, 'L');
                    } else if (last - rightLoc < i - last) {
                        res.setCharAt(last, 'R');
                    }
                }
                rightLoc = -1;
            }
        }
        while (rightLoc != -1 && !stack.isEmpty()) {
            int loc = stack.pollLast();
            res.setCharAt(loc, 'R');
        }
        return res.toString();
    }
}