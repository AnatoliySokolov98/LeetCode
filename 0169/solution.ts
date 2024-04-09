function majorityElement(nums: number[]): number {
  let res = -1;
  let res_count = 0;

  for (let num of nums) {
    if (num != res) {
      if (res_count == 0) {
        res_count++;
        res = num;
      } else {
        res_count--;
      }
    } else {
      res_count++;
    }
  }
  return res;
}
