function pivotIndex(nums: number[]): number {
  let sum = 0;
  for (let num of nums) {
    sum += num;
  }
  let left = sum;
  let right = 0;
  for (let i = 0; i < nums.length; i++) {
    left -= nums[i];
    if (left === right) {
      return i;
    }
    right += nums[i];
  }
  return -1;
}
