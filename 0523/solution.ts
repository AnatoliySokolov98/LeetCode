function checkSubarraySum(nums: number[], k: number): boolean {
  const prefixes: Map<number, number> = new Map();
  prefixes.set(0, -1);
  let curr = 0;
  for (let i = 0; i < nums.length; i++) {
    curr += nums[i];
    if (prefixes.has(curr % k)) {
      if (i - prefixes.get(curr % k)! >= 2) {
        return true;
      }
    } else {
      prefixes.set(curr % k, i);
    }
  }
  return false;
}
