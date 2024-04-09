function subarraySum(nums: number[], k: number): number {
  const sums: Map<number, number> = new Map();
  sums.set(0, 1);
  let res = 0;
  let curr = 0;
  for (let i = 0; i < nums.length; i++) {
    curr += nums[i];
    const diff = curr - k;
    res += sums.has(diff) ? sums.get(diff)! : 0;
    sums.set(curr, (sums.get(curr) || 0) + 1);
  }
  return res;
}
