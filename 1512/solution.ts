function numIdenticalPairs(nums: number[]): number {
  const counts = new Map<number, number>();
  let res = 0;
  for (const num of nums) {
    res += counts.get(num) || 0;
    counts.set(num, (counts.get(num) || 0) + 1);
  }
  return res;
}
