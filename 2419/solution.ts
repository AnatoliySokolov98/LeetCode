function longestSubarray(nums: number[]): number {
  let biggest = -1;
  let res = 0;
  let streak = 0;
  for (const num of nums) {
    if (num > biggest) {
      biggest = num;
      res = 0;
      streak = 1;
    } else if (num == biggest) {
      streak++;
    } else {
      streak = 0;
    }
    res = Math.max(res, streak);
  }
  return res;
}
