function deckRevealedIncreasing(deck: number[]): number[] {
  deck.sort((a, b) => a - b);
  const res = Array.from({ length: deck.length }, () => 0);
  let i = 0;
  const queue: Array<number> = [];
  for (let i = 0; i < deck.length; i++) {
    queue.push(i);
  }
  while (queue.length) {
    const curr = queue.shift()!;
    res[curr] = deck[i++];
    if (queue.length) {
      queue.push(queue.shift()!);
    }
  }
  return res;
}
