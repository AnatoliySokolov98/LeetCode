function findErrorNums(nums: number[]): number[] {
  for (const num of nums) {
    nums[(num - 1) % 10_000] += 10_000;
  }

  const res = [0, 0];

  for (let i = 0; i < nums.length; i++) {
    if (nums[i] < 10_000) {
      res[1] = i + 1;
    }

    if (nums[i] > 20_000) {
      res[0] = i + 1;
    }
  }
  return res;
}
