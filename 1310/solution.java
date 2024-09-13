class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xors = new int[arr.length];
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total ^= arr[i];
            xors[i] = total;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            res[i] = xors[y] ^ (x == 0 ? 0 : xors[x - 1]);
        }
        return res;
    }
}

// time O(n + m)
// space O(n)