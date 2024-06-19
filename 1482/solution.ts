function numSubseq(nums: number[], target: number): number {
  const MOD = 10 ** 9 + 7;
  let l = 0;
  let r = nums.length - 1;
  let res = 0;
  nums.sort((a, b) => a - b);
  const powers = [1];
  for (let i = 1; i < nums.length; i++) {
    powers.push((powers[i - 1] * 2) % MOD);
  }
  while (l <= r) {
    if (nums[l] + nums[r] > target) {
      r--;
    } else {
      res = (res + powers[r - l]) % MOD;
      l++;
    }
  }
  return res;
}
