const merge = (a: number[], b: number[]) => {
  let i = 0,
    j = 0;
  const res: number[] = [];
  while (i < a.length || j < b.length) {
    if (i == a.length || (j < b.length && b[j] < a[i])) {
      res.push(b[j++]);
    } else {
      res.push(a[i++]);
    }
  }
  return res;
};

function sortArray(nums: number[]): number[] {
  if (nums.length <= 1) return nums;
  const mid = Math.floor(nums.length / 2);
  return merge(sortArray(nums.slice(0, mid)), sortArray(nums.slice(mid)));
}
