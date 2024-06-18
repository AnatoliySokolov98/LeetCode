function maxProfitAssignment(
  difficulty: number[],
  profit: number[],
  workers: number[]
): number {
  const pairs: Array<[number, number]> = [];

  for (let i = 0; i < profit.length; i++) {
    pairs.push([difficulty[i], profit[i]]);
  }
  pairs.sort((a, b) => a[0] - b[0]);
  workers.sort((a, b) => a - b);
  let p = 0;
  let bestProfit = 0;
  let totalProfit = 0;
  for (let w of workers) {
    while (p < pairs.length && w >= pairs[p][0]) {
      bestProfit = Math.max(bestProfit, pairs[p++][1]);
    }
    totalProfit += bestProfit;
  }
  return totalProfit;
}
