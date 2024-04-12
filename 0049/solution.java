class Solution {
    public int trap(int[] height) {
        int H = height.length;
        int res = 0;
        int leftMax = 0;
        int[] rightMax = new int[H];
        for (int i = H - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        for (int i = 1; i < H; i++) {
            leftMax = Math.max(leftMax, height[i - 1]);
            int contribution = Math.min(leftMax, rightMax[i]);
            res += Math.max(0, contribution - height[i]);
        }
        return res;
    }
}

// time O(n)
// space O(n)