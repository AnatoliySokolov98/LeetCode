class Solution {
    List<List<Integer>> combs;

    public int colorTheGrid(int m, int n) {
        combs = new ArrayList<>();
        backtrack(new ArrayList<>(), m);

        int[][] cache = new int[n][combs.size()];
        for (int[] row : cache) Arrays.fill(row, -1);

        int res = 0;
        for (int i = 0; i < combs.size(); i++) {
            res = (res + dp(1, i, cache, n)) % 1_000_000_007;
        }

        return res;
    }

    private int dp(int col, int prevIdx, int[][] cache, int n) {
        if (col == n) return 1;
        if (cache[col][prevIdx] != -1) return cache[col][prevIdx];

        int res = 0;
        List<Integer> prev = combs.get(prevIdx);

        for (int i = 0; i < combs.size(); i++) {
            if (isValid(prev, combs.get(i))) {
                res = (res + dp(col + 1, i, cache, n)) % 1_000_000_007;
            }
        }

        return cache[col][prevIdx] = res;
    }

    private void backtrack(List<Integer> curr, int m) {
        if (curr.size() == m) {
            combs.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (curr.isEmpty() || curr.get(curr.size() - 1) != i) {
                curr.add(i);
                backtrack(curr, m);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isValid(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals(b.get(i))) return false;
        }
        return true;
    }
}

// time O(3^2m * n)
// space O(3^m * n)
