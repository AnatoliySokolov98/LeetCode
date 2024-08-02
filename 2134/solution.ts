function minSwaps(nums: number[]): number {
  let N = nums.length;
  let W = 0;
  for (const num of nums) {
    if (num == 1) {
      W++;
    }
  }

  if (W == 0) {
    return 0;
  }

  let res = Infinity;
  let zeroes = 0;
  for (let r = 0; r < nums.length + W - 1; r++) {
    if (nums[r % N] == 0) {
      zeroes++;
    }
    if (r >= W && nums[r - W] == 0) {
      zeroes--;
    }
    if (r >= W - 1) {
      res = Math.min(res, zeroes);
    }
  }
  return res;
}
