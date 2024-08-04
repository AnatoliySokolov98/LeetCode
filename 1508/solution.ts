function rangeSum(
  nums: number[],
  n: number,
  left: number,
  right: number
): number {
  const sums: number[] = [];
  for (let i = 0; i < nums.length; i++) {
    let sum = 0;
    for (let j = i; j < nums.length; j++) {
      sum += nums[j];
      sums.push(sum);
    }
  }
  sums.sort((a, b) => a - b);
  let res = 0;
  const MOD = 1_000_000_007;
  for (let i = left - 1; i < right; i++) {
    res = (res + sums[i]) % MOD;
  }
  return res;
}
