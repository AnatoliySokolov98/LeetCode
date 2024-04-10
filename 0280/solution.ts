function wiggleSort(nums: number[]): void {
  for (let i = 0; i < nums.length - 1; i++) {
    if (i % 2 === 0) {
      if (nums[i] > nums[i + 1]) {
        [nums[i + 1], nums[i]] = [nums[i], nums[i + 1]];
      }
    } else if (nums[i] < nums[i + 1]) {
      [nums[i + 1], nums[i]] = [nums[i], nums[i + 1]];
    }
  }
}
