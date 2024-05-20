function subsetXORSum(nums: number[]): number {
  let res = 0;
  let subset = 0;
  const backtrack = (i: number) => {
    if (i == nums.length) {
      res += subset;
      return;
    }
    subset ^= nums[i];
    backtrack(i + 1);
    subset ^= nums[i];
    backtrack(i + 1);
  };

  backtrack(0);
  return res;
}
