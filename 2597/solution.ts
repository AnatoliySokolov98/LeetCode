function beautifulSubsets(nums: number[], k: number): number {
  let res = 0;
  const subset: Array<number> = [];
  const backtrack = (i: number) => {
    if (i == nums.length) {
      if (subset.length) {
        res++;
      }
      return;
    }
    let valid = true;
    for (const num of subset) {
      if (Math.abs(num - nums[i]) === k) {
        valid = false;
        break;
      }
    }
    if (valid) {
      subset.push(nums[i]);
      backtrack(i + 1);
      subset.pop();
    }
    backtrack(i + 1);
  };
  backtrack(0);
  return res;
}
