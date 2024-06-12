function sortColors(nums: number[]): void {
  let l = 0;
  let r = nums.length - 1;
  let i = 0;
  while (i <= r) {
    if (i < l) {
      i++;
      continue;
    }
    const curr = nums[i];
    if (curr == 0) {
      nums[i] = nums[l];
      nums[l++] = 0;
    } else if (curr == 2) {
      nums[i] = nums[r];
      nums[r--] = 2;
    } else {
      i++;
    }
  }
}
