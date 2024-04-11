function arraySign(nums: number[]): number {
  let res = 1;
  for (let num of nums) {
    if (num === 0) {
      return 0;
    }

    res *= num < 0 ? -1 : 1;
  }
  return res;
}
