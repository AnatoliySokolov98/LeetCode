function firstMissingPositive(nums: number[]): number {
  const N = nums.length;
  let C = nums.length + 1;
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] < 0 || nums[i] > N) {
      nums[i] = 0;
    }
  }
  for (let i = 0; i < nums.length; i++) {
    let loc = (nums[i] % C) - 1;
    if (loc >= 0) {
      nums[loc] = (nums[loc] % C) + C;
    }
  }
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] < C) {
      return i + 1;
    }
  }
  return N + 1;
}
