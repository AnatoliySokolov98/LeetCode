function topKFrequent(nums: number[], k: number): number[] {
  const counts: Record<number, number> = {};
  for (let num of nums) {
    counts[num] = (counts[num] || 0) + 1;
  }

  const buckets: Record<number, number[]> = {};
  for (let key in counts) {
    const val = counts[key];
    buckets[val] = buckets[val] ?? [];
    buckets[val].push(Number(key));
  }

  const res: number[] = [];
  let choice = nums.length;
  while (k) {
    if (buckets[choice]) {
      for (let item of buckets[choice]) {
        res.push(item);
        k--;
      }
    }
    choice--;
  }
  return res;
}
