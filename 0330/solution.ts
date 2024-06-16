function minPatches(nums: number[], n: number): number {
  let range = 0;
  let res = 0;
  let idx = 0;
  while (range < n) {
    if (idx == nums.length || range < nums[idx] - 1) {
      res++;
      range += range + 1;
    } else {
      range += nums[idx++];
    }
  }
  return res;
}
