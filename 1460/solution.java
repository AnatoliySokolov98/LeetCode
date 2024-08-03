class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] counts = new int[1001];
        for (int num : target) {
            counts[num]++;
        }
        for (int num : arr) {
            counts[num]--;
        }
        for (int num : counts) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}

// time O(n)
// space O(n)