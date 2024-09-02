class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long total = 0;
        for(int student: chalk) {
            total += student;
        }
        k %= total;
        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] > k) {
                return i;
            }
            k -= chalk[i];
        }
        return -1;
    }
}

// time O(n)
// space O(1)