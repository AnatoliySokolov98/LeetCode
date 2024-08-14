function smallestDistancePair(nums: number[], k: number): number {
  nums.sort((a, b) => a - b);
  let l = 0;
  let r = nums[nums.length - 1] - nums[0];
  while (l < r) {
    const p = l + Math.floor((r - l) / 2);
    const count = countPairs(nums, p);
    if (count >= k) {
      r = p;
    } else {
      l = p + 1;
    }
  }
  return l;
}

function countPairs(nums: number[], dist: number): number {
  let res = 0;
  let l = 0;
  for (let r = 0; r < nums.length; r++) {
    while (l < r && nums[r] - nums[l] > dist) {
      l++;
    }
    res += r - l;
  }
  return res;
}
