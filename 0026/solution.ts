function removeDuplicates(nums: number[]): number {
  let k = 0;
  let i = 0;
  while (i < nums.length) {
    nums[k++] = nums[i];
    while (i + 1 < nums.length && nums[i + 1] === nums[i]) {
      i++;
    }
    i++;
  }
  return k;
}
