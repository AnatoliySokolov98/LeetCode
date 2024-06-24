function minKBitFlips(nums: number[], k: number): number {
  const flips: Array<number> = [];
  let res = 0;
  for (let i = 0; i < nums.length; i++) {
    if (flips.length && flips[0] < i) {
      flips.shift();
    }
    let curr = (nums[i] + flips.length) % 2;
    if (curr == 0) {
      if (i > nums.length - k) {
        return -1;
      }
      res++;
      flips.push(i + k - 1);
    }
  }
  return res;
}
