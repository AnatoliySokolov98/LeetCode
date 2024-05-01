function maxFrequency(nums: number[], k: number): number {
  nums.sort((a, b) => a - b);
  let res = 1;
  let l = 0;
  let ops = 0;
  for (let r = 1; r < nums.length; r++) {
    ops += (r - l) * (nums[r] - nums[r - 1]);
    while (ops > k) {
      ops -= nums[r] - nums[l++];
    }
    res = Math.max(res, r - l + 1);
  }
  return res;
}
