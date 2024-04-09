function twoSum(nums: number[], target: number): number[] {
  const obj: Record<number, number> = {};
  for (let i: number = 0; i < nums.length; i++) {
    let complement: number = target - nums[i];

    if (complement in obj) {
      return [obj[complement], i];
    }
    obj[nums[i]] = i;
  }
  return [];
}
