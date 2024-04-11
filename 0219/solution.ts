function containsNearbyDuplicate(nums: number[], k: number): boolean {
  const cache: Map<number, number> = new Map();
  for (let i = 0; i < nums.length; i++) {
    if (cache.has(nums[i]) && i - cache.get(nums[i])! <= k) {
      return true;
    } else {
      cache.set(nums[i], i);
    }
  }
  return false;
}
