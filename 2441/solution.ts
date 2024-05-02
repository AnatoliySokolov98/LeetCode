function findMaxK(nums: number[]): number {
  const cache = new Set<number>();
  let res = -1;
  for (const num of nums) {
    if (cache.has(-num)) {
      res = Math.max(res, Math.abs(num));
    }
    cache.add(num);
  }
  return res;
}
