function isNStraightHand(hand: number[], groupSize: number): boolean {
  const counts = new Map<number, number>();
  for (const num of hand) {
    counts.set(num, (counts.get(num) || 0) + 1);
  }
  hand.sort((a, b) => a - b);
  for (let num of hand) {
    while (counts.get(num) != 0) {
      for (let i = 0; i < groupSize; i++) {
        const curr = counts.get(num + i) || 0;
        if (curr == 0) {
          return false;
        }
        counts.set(num + i, curr - 1);
      }
    }
  }
  return true;
}
