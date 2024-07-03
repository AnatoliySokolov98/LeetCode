function minDifference(nums: number[]): number {
  if (nums.length <= 4) {
    return 0;
  }
  nums.sort((a, b) => a - b);
  let res = Infinity;
  for (let i = 0; i < 4; i++) {
    for (let j = 0; j < 4 - i; j++) {
      res = Math.min(res, nums[nums.length - j - 1] - nums[i]);
    }
  }
  return res;
}
