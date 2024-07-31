function minHeightShelves(books: number[][], shelfWidth: number): number {
  const cache = new Map<number, number>();

  const dp = (i: number): number => {
    if (i == books.length) {
      return 0;
    }
    if (cache.has(i)) {
      return cache.get(i)!;
    }
    let res = Infinity;
    let width = 0;
    let height = 0;
    for (let j = i; j < books.length; j++) {
      width += books[j][0];
      if (width > shelfWidth) {
        break;
      }
      height = Math.max(height, books[j][1]);
      res = Math.min(res, height + dp(j + 1));
    }
    cache.set(i, res);
    return res;
  };

  return dp(0);
}
