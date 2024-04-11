function doubleCheck(index: number, last: number, numbers: number[]): boolean {
  for (let i = index; i < numbers.length; i++) {
    if (numbers[i] < last) {
      return false;
    }
    last = numbers[i];
  }
  return true;
}

function checkPossibility(nums: number[]): boolean {
  for (let i = 0; i < nums.length - 1; i++) {
    if (nums[i] > nums[i + 1]) {
      if (i == 0 || nums[i - 1] <= nums[i + 1]) {
        return doubleCheck(i + 2, nums[i + 1], nums);
      } else {
        return doubleCheck(i + 2, nums[i], nums);
      }
    }
  }
  return true;
}
