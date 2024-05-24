class Solution {
    int res;
    int curr;
    int[] letterCounts;
    int[][] wordCounts;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        res = 0;
        curr = 0;
        letterCounts = new int[26];
        wordCounts = new int[words.length][26];
        for (char c : letters) {
            letterCounts[(int) (c - 'a')]++;
        }
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                wordCounts[i][(int) (c - 'a')]++;
            }
        }
        backtrack(0, score);
        return res;
    }

    private void backtrack(int i, int[] score) {
        if (i == wordCounts.length) {
            res = Math.max(res, curr);
            return;
        }
        boolean canBuild = true;
        for (int j = 0; j < wordCounts[i].length; j++) {
            if (wordCounts[i][j] > letterCounts[j]) {
                canBuild = false;
                break;
            }
        }

        if (canBuild) {
            for (int j = 0; j < wordCounts[i].length; j++) {
                letterCounts[j] -= wordCounts[i][j];
                curr += wordCounts[i][j] * score[j];
            }
            backtrack(i + 1, score);
            for (int j = 0; j < wordCounts[i].length; j++) {
                letterCounts[j] += wordCounts[i][j];
                curr -= wordCounts[i][j] * score[j];
            }
        }
        backtrack(i + 1, score);
    }
}

// time O(2^W)
// space O(W)