function subarraysDivByK(nums: number[], k: number): number {
  const counts = new Map<number, number>();
  counts.set(0, 1);
  let total = 0;
  let res = 0;
  for (const num of nums) {
    total += num;
    let remainder = total % k;
    if (remainder < 0) {
      remainder += k;
    }
    const currCount = counts.get(remainder) || 0;
    res += currCount;
    counts.set(remainder, currCount + 1);
  }
  return res;
}
