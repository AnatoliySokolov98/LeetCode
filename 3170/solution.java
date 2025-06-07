import java.util.*;

class Solution {
    public String clearStars(String s) {
        List<Deque<Integer>> stacks = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            stacks.add(new ArrayDeque<>());
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr != '*') {
                stacks.get(curr - 'a').add(i);
                continue;
            }
            for (int j = 0; j < 26; j++) {
                if (!stacks.get(j).isEmpty()) {
                    int charIndex = stacks.get(j).pollLast();
                    chars[charIndex] = '*';
                    break;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] != '*') {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}

// time O(n * uniqueChars)
// space O(n)