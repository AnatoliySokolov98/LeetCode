/**
 Do not return anything, modify nums in-place instead.
 */
function moveZeroes(nums: number[]): void {
  let writeTo = 0;
  for (let i = 0; i < nums.length; i++) {
    if (nums[i]) {
      nums[writeTo++] = nums[i];
    }
  }
  for (let i = writeTo; i < nums.length; i++) {
    nums[i] = 0;
  }
}
