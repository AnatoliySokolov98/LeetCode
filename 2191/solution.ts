function sortJumbled(mapping: number[], nums: number[]): number[] {
  let pairs: [number, number, number][] = new Array(nums.length);

  for (let i = 0; i < nums.length; i++) {
    pairs[i] = [nums[i], i, mapNumber(nums[i], mapping)];
  }

  pairs.sort((a, b) => {
    if (a[2] === b[2]) {
      return a[1] - b[1];
    } else {
      return a[2] - b[2];
    }
  });

  let res: number[] = new Array(nums.length);
  for (let i = 0; i < nums.length; i++) {
    res[i] = pairs[i][0];
  }
  return res;
}

function mapNumber(num: number, mapping: number[]): number {
  if (num === 0) {
    return mapping[0];
  }

  let res = 0;
  let place = 1;
  while (num > 0) {
    let digit = num % 10;
    res += mapping[digit] * place;
    num = Math.floor(num / 10);
    place *= 10;
  }
  return res;
}
