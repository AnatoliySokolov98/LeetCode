function specialArray(nums: number[]): number {
  nums.sort((a, b) => a - b);
  let i = 0;
  while (i < nums.length) {
    let numsLeft = nums.length - i;
    if (numsLeft == nums[i]) {
      return numsLeft;
    }
    let numBefore = i == 0 ? 0 : nums[i - 1];
    if (numsLeft < nums[i] && numsLeft > numBefore) {
      return numsLeft;
    }
    while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
      i++;
    }
    i++;
  }
  return -1;
}
