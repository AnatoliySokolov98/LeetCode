function heightChecker(heights: number[]): number {
  let maximum = 0;
  for (const num of heights) {
    maximum = Math.max(maximum, num);
  }
  const counts = new Array(maximum + 1).fill(0);
  for (const num of heights) {
    counts[num]++;
  }
  let res = 0;
  let h = 0;
  let c = 0;
  while (h < heights.length && c < counts.length) {
    if (counts[c] == 0) {
      c++;
      continue;
    }
    if (heights[h] != c) {
      res++;
    }
    counts[c]--;
    h++;
  }
  return res;
}
