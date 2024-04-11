function minimumDifference(nums: number[], k: number): number {
  nums.sort((a, b) => a - b);
  let l = 0;
  let r = k - 1;
  let res = Infinity;
  while (r < nums.length) {
    res = Math.min(res, nums[r] - nums[l]);
    r++;
    l++;
  }
  return res;
}
