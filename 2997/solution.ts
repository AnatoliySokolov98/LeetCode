function minOperations(nums: number[], k: number): number {
  let xor = nums.reduce((num, acc) => acc ^ num, 0);
  xor ^= k;
  let res = 0;
  while (xor) {
    if (xor & 1) {
      res++;
    }
    xor >>= 1;
  }
  return res;
}
