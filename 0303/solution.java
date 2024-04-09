class NumArray {
    int [] prefixes;
    public NumArray(int[] nums) {
        this.prefixes = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            this.prefixes[i] = i == 0 ? nums[i] : this.prefixes[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return left == 0 ? this.prefixes[right] : this.prefixes[right] - this.prefixes[left - 1];
    }
}