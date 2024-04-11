function sortedSquares(nums: number[]): number[] {
  let l = 0;
  let r = nums.length - 1;
  const res: Array<number> = [];
  while (l <= r) {
    if (Math.abs(nums[l]) > Math.abs(nums[r])) {
      res.push(nums[l++] ** 2);
    } else {
      res.push(nums[r--] ** 2);
    }
  }
  return res.reverse();
}
