import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int findRotateSteps(String ring, String key) {
        int R = ring.length();
        int K = key.length();
        Map<Character, List<Integer>> locs = new HashMap<>();
        for (int i = 0; i < ring.length(); i++) {
            char c = ring.charAt(i);
            locs.putIfAbsent(c, new ArrayList<Integer>());
            locs.get(c).add(i);
        }
        boolean[][] visited = new boolean[R][K + 1];
        PriorityQueue<int[]> path = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        path.add(new int[] { 0, 0, 0 });
        while (!path.isEmpty()) {
            int[] curr = path.poll();
            int dist = curr[0];
            int rloc = curr[1];
            int kloc = curr[2];
            if (kloc == K) {
                return dist;
            }
            if (visited[rloc][kloc]) {
                continue;
            }
            visited[rloc][kloc] = true;
            if (ring.charAt(rloc) == key.charAt(kloc) && !visited[rloc][kloc + 1]) {
                path.add(new int[] { dist + 1, rloc, kloc + 1 });
            } else {
                int[] distances = shortestPath(rloc, key.charAt(kloc), locs, R);
                int leftLoc = distances[0];
                int leftDist = distances[1];
                int rightLoc = distances[2];
                int rightDist = distances[3];
                if (!visited[leftLoc][kloc + 1]) {
                    path.add(new int[] { dist + leftDist + 1, leftLoc, kloc + 1 });
                }
                if (!visited[rightLoc][kloc + 1]) {
                    path.add(new int[] { dist + rightDist + 1, rightLoc, kloc + 1 });
                }
            }
        }
        return -1;
    }

    private int[] shortestPath(int curr, char dest, Map<Character, List<Integer>> locs, int R) {
        List<Integer> charLocs = locs.get(dest);
        int leftLoc;
        if (charLocs.get(0) > curr) {
            leftLoc = charLocs.getLast();
        } else {
            leftLoc = curr;
            int l = 0;
            int r = charLocs.size() - 1;
            while (l <= r) {
                int p = (l + r) / 2;
                if (charLocs.get(p) < curr) {
                    leftLoc = charLocs.get(p);
                    l = p + 1;
                } else {
                    r = p - 1;
                }
            }
        }
        int rightLoc;
        if (charLocs.getLast() < curr) {
            rightLoc = charLocs.getFirst();
        } else {
            rightLoc = curr;
            int l = 0;
            int r = charLocs.size() - 1;
            while (l <= r) {
                int p = (l + r) / 2;
                if (charLocs.get(p) > curr) {
                    rightLoc = charLocs.get(p);
                    r = p - 1;
                } else {
                    l = p + 1;
                }
            }
        }
        int leftDist = leftLoc < curr ? curr - leftLoc : R - (leftLoc - curr);
        int rightDist = rightLoc > curr ? rightLoc - curr : R - (curr - rightLoc);
        return new int[] { leftLoc, leftDist, rightLoc, rightDist };
    }
}

// time R*K*log(R*K)
// space R*K
