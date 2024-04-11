function searchInsert(nums: number[], target: number): number {
  let res = nums.length;
  let l = 0,
    r = nums.length - 1;
  while (l <= r) {
    const p = Math.floor((l + r) / 2);
    if (nums[p] >= target) {
      res = p;
      r = p - 1;
    } else {
      l = p + 1;
    }
  }
  return res;
}
