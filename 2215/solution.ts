function findDifference(nums1: number[], nums2: number[]): number[][] {
  const n1 = new Set(nums1);
  const n2 = new Set(nums2);
  const res: number[][] = [];
  res.push([]);
  for (let item of n1) {
    if (!n2.has(item)) {
      res[0].push(item);
    }
  }
  res.push([]);
  for (let item of n2) {
    if (!n1.has(item)) {
      res[1].push(item);
    }
  }
  return res;
}
