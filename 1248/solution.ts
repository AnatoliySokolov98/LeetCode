function numberOfSubarrays(nums: number[], k: number): number {
  let l = 0;
  let mid = 0;
  let odds = 0;
  let res = 0;
  for (let r = 0; r < nums.length; r++) {
    odds += nums[r] % 2;
    if (odds > k) {
      mid++;
      l = mid;
      odds--;
    }
    while (odds == k && nums[mid] % 2 == 0) {
      mid++;
    }
    if (odds == k) {
      res += mid - l + 1;
    }
  }
  return res;
}
