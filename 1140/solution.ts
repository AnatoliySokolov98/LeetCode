function stoneGameII(piles: number[]): number {
  const cache: Map<string, number> = new Map();

  function dp(index: number, M: number, turn: number): number {
    const key = `${index}-${M}-${turn}`;
    if (cache.has(key)) {
      return cache.get(key)!;
    }

    if (index >= piles.length) {
      return 0;
    }

    let res: number;
    if (turn === 1) {
      res = 0;
    } else {
      res = Infinity;
    }

    let stones = 0;
    for (let X = 0; X < 2 * M; X++) {
      if (index + X >= piles.length) {
        break;
      }
      stones += piles[index + X];
      if (turn === 1) {
        res = Math.max(res, stones + dp(index + X + 1, Math.max(M, X + 1), 0));
      } else {
        res = Math.min(res, dp(index + X + 1, Math.max(M, X + 1), 1));
      }
    }

    cache.set(key, res);
    return res;
  }

  return dp(0, 1, 1);
}
