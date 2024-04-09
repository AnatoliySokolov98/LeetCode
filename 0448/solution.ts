function findDisappearedNumbers(nums: number[]): number[] {
  for (let i = 0; i < nums.length; i++) {
    const j = Math.abs(nums[i]) - 1;
    nums[j] = -Math.abs(nums[j]);
  }

  const res: number[] = [];
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] > 0) {
      res.push(i + 1);
    }
  }
  return res;
}
