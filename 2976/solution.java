import java.util.Arrays;

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int T = target.length();
        int O = original.length;
        int[][] graph = new int[26][26];

        for (int[] row : graph) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int i = 0; i < O; i++) {
            int x = original[i] - 'a';
            int y = changed[i] - 'a';
            graph[x][y] = Math.min(graph[x][y], cost[i]);
        }

        for (int i = 0; i < 26; i++) {
            graph[i][i] = 0;
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }

        long res = 0;
        for (int i = 0; i < T; i++) {
            int x = source.charAt(i) - 'a';
            int y = target.charAt(i) - 'a';
            if (graph[x][y] == Integer.MAX_VALUE) {
                return -1;
            }
            res += graph[x][y];
        }

        return res;
    }
}

// time O(S + E)
// space O(1)