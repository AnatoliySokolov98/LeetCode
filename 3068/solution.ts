function maximumValueSum(nums: number[], k: number, edges: number[][]): number {
  let totalNums = 0;
  let res = 0;
  let smallestDecrease = Infinity;
  let smallestIncrease = Infinity;

  for (const num of nums) {
    if ((num ^ k) > num) {
      totalNums++;
      res += num ^ k;
      smallestIncrease = Math.min(smallestIncrease, (num ^ k) - num);
    } else {
      res += num;
      smallestDecrease = Math.min(smallestDecrease, num - (num ^ k));
    }
  }

  if (totalNums % 2 == 0) {
    return res;
  } else {
    return Math.max(res - smallestIncrease, res - smallestDecrease);
  }
}
