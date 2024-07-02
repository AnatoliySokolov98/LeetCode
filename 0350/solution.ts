function intersect(nums1: number[], nums2: number[]): number[] {
  if (nums1.length > nums2.length) {
    return intersect(nums2, nums1);
  }

  const counts = new Map<number, number>();
  for (const num of nums1) {
    counts.set(num, (counts.get(num) || 0) + 1);
  }
  const res: Array<number> = [];
  for (const num of nums2) {
    if (counts.has(num)) {
      res.push(num);
      counts.set(num, counts.get(num)! - 1);
      if (counts.get(num) == 0) {
        counts.delete(num);
      }
    }
  }
  return res;
}
