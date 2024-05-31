function singleNumber(nums: number[]): number[] {
  let xor = 0;
  for (const num of nums) {
    xor ^= num;
  }
  let bit = 0;
  for (let i = 0; i < 32; i++) {
    if (((1 << i) & xor) != 0) {
      bit = 1 << i;
      break;
    }
  }
  let first = 0;
  for (const num of nums) {
    if ((num & bit) != 0) {
      first ^= num;
    }
  }
  const second = xor ^ first;
  return [first, second];
}
