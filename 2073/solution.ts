function timeRequiredToBuy(tickets: number[], k: number): number {
  let res = 0;
  for (let i = 0; i < tickets.length; i++) {
    if (i == k) {
      res += tickets[k];
    }
    if (i < k) {
      res += Math.min(tickets[i], tickets[k]);
    }

    if (i > k) {
      res += Math.min(tickets[i], tickets[k] - 1);
    }
  }
  return res;
}
