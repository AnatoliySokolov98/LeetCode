import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int openLock(String[] deadends, String target) {
        Deque<Pair<Integer, String>> bfs = new ArrayDeque<>();
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains("0000")) {
            return -1;
        }

        bfs.add(new Pair<Integer, String>(0, "0000"));
        visited.add("0000");
        while (!bfs.isEmpty()) {
            Pair<Integer, String> item = bfs.pollFirst();
            if (item.comb.equals(target)) {
                return item.moves;
            }

            for (String child : combinations(item.comb)) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    bfs.addLast(new Pair<Integer, String>(item.moves + 1, child));
                }
            }
        }
        return -1;
    }

    private List<String> combinations(String comb) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int curr = (int) comb.charAt(i) - '0';
            int bigger = (curr + 1) % 10;
            int smaller = curr == 0 ? 9 : curr - 1;
            res.add(comb.substring(0, i) + (char) ('0' + bigger) + comb.substring(i + 1));
            res.add(comb.substring(0, i) + (char) ('0' + smaller) + comb.substring(i + 1));
        }
        return res;
    }
}

class Pair<K, V> {
    K moves;
    V comb;

    public Pair(K moves, V comb) {
        this.moves = moves;
        this.comb = comb;
    }
}

// time O(10^deadends.length)
// space O(10^deadends.length)