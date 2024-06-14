function minIncrementForUnique(nums: number[]): number {
  nums.sort((a, b) => a - b);
  let res = 0;
  let avail = nums[0];
  for (const num of nums) {
    if (num <= avail) {
      res += avail - num;
      avail++;
    } else {
      avail = num + 1;
    }
  }
  return res;
}
