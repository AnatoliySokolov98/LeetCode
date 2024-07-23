function frequencySort(nums: number[]): number[] {
  const counts = new Map<number, number>();
  for (const num of nums) {
    counts.set(num, (counts.get(num) || 0) + 1);
  }
  nums.sort((a, b) => {
    return counts.get(a) !== counts.get(b)
      ? counts.get(a)! - counts.get(b)!
      : b - a;
  });
  return nums;
}
