function maxProfit(prices: number[]): number {
  let res = 0;
  for (let i = 0; i < prices.length - 1; i++) {
    res += Math.max(prices[i + 1] - prices[i], 0);
  }
  return res;
}
