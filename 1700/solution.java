class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int zeroes = 0;
        int ones = 0;
        int S = sandwiches.length;
        for (int student : students) {
            if (student == 1)
                ones++;
            else
                zeroes++;
        }
        for (int i = 0; i < S; i++) {
            if (sandwiches[i] == 0 && zeroes > 0)
                zeroes--;
            else if (sandwiches[i] == 1 && ones > 0)
                ones--;
            else
                return S - i;
        }
        return 0;
    }
}

// time O(st + sa)
// space O(1)