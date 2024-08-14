function maxProductDifference(nums: number[]): number {
  let curr: number[] = [];

  for (let num of nums) {
    curr.push(num);
    curr.sort((a, b) => a - b);

    if (curr.length > 4) {
      curr.splice(2, 1);
    }
  }

  return curr[3] * curr[2] - curr[1] * curr[0];
}
