function subsets(nums: number[]): number[][] {
  const res: number[][] = [];
  const curr: number[] = [];
  const backtrack = (index: number) => {
    res.push(curr.slice());
    if (curr.length === nums.length) return;
    for (let i = index; i < nums.length; i++) {
      curr.push(nums[i]);
      backtrack(i + 1);
      curr.pop();
    }
  };
  backtrack(0);
  return res;
}
