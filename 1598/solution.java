class Solution {
    public int minOperations(String[] logs) {
        int level = 0;
        for (String log : logs) {
            if (log.equals("./")) {
                continue;
            }
            if (log.equals("../")) {
                level = Math.max(0, level - 1);
            } else {
                level++;
            }
        }
        return level;
    }
}

// time O(n)
// space O(1)