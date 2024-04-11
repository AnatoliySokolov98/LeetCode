function zeroFilledSubarray(nums: number[]): number {
  let res = 0;
  let curr = 0;
  for (let num of nums) {
    curr = num ? 0 : curr + 1;
    res += curr;
  }
  return res;
}
