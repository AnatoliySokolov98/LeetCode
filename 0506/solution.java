import java.util.Arrays;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int S = score.length;
        int[][] sortedScore = new int[S][2];
        for (int i = 0; i < S; i++) {
            sortedScore[i] = new int[] { score[i], i };
        }
        Arrays.sort(sortedScore, (a, b) -> (b[0] - a[0]));
        String[] medals = { "Gold Medal", "Silver Medal", "Bronze Medal" };
        String[] res = new String[S];
        for (int i = 0; i < S; i++) {
            if (i <= 2) {
                res[sortedScore[i][1]] = medals[i];
            } else {
                res[sortedScore[i][1]] = Integer.toString(i + 1);
            }
        }
        return res;
    }
}

// time O(nlogn)
// space O(n)
