function twoSum(numbers: number[], target: number): number[] {
  let l = 0;
  let r = numbers.length - 1;
  while (l < r) {
    const res = numbers[l] + numbers[r];
    if (res === target) {
      return [l + 1, r + 1];
    }
    if (res < target) {
      l++;
    } else {
      r--;
    }
  }
  return [-1, -1];
}
