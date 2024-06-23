function longestSubarray(nums: number[], limit: number): number {
  const dequeMax: [number, number][] = [];
  const dequeMin: [number, number][] = [];
  let res = 0;
  let l = 0;

  for (let r = 0; r < nums.length; r++) {
    while (dequeMax.length && nums[r] > dequeMax[dequeMax.length - 1][1]) {
      dequeMax.pop();
    }
    dequeMax.push([r, nums[r]]);

    while (dequeMin.length && nums[r] < dequeMin[dequeMin.length - 1][1]) {
      dequeMin.pop();
    }
    dequeMin.push([r, nums[r]]);

    while (dequeMax[0][1] - dequeMin[0][1] > limit) {
      l++;
      if (dequeMax[0][0] < l) {
        dequeMax.shift();
      }
      if (dequeMin[0][0] < l) {
        dequeMin.shift();
      }
    }

    res = Math.max(res, r - l + 1);
  }

  return res;
}
