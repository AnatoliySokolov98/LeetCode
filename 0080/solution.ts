function removeDuplicates(nums: number[]): number {
  let streak = 0;
  let curr = Infinity;
  let k = 0;
  for (const num of nums) {
    if (num === curr) {
      streak++;
    } else {
      streak = 1;
      curr = num;
    }
    if (streak <= 2) {
      nums[k++] = curr;
    }
  }
  return k;
}
