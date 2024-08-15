function intersection(nums1: number[], nums2: number[]): number[] {
  const set1 = new Set(nums1);
  const set2 = new Set(nums2);
  const res: number[] = [];
  for (const num of set1) {
    if (set2.has(num)) {
      res.push(num);
    }
  }
  return res;
}
