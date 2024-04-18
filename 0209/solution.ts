function minSubArrayLen(target: number, nums: number[]): number {
  let l = 0;
  let sum = 0;
  let res = Infinity;
  for (let i = 0; i < nums.length; i++) {
    sum += nums[i];
    while (sum - nums[l] >= target) {
      sum -= nums[l++];
    }
    if (sum >= target) {
      res = Math.min(res, i - l + 1);
    }
  }
  return res === Infinity ? 0 : res;
}
