function search(nums: number[], target: number): number {
  let l = 0;
  let r = nums.length - 1;
  while (l <= r) {
    const p = Math.floor((l + r) / 2);
    if (nums[p] === target) {
      return p;
    }
    if (nums[p] < target) {
      l = p + 1;
    } else {
      r = p - 1;
    }
  }
  return -1;
}
