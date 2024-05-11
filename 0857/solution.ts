function mincostToHireWorkers(
  quality: number[],
  wage: number[],
  k: number
): number {
  const L = quality.length;
  const ratios: [number, number][] = new Array(L);
  for (let i = 0; i < L; i++) {
    ratios[i] = [wage[i] / quality[i], quality[i]];
  }
  ratios.sort((a, b) => a[0] - b[0]);

  const heap = new MinPriorityQueue({ priority: (x) => -x });
  let res = Infinity;
  let total = 0;

  for (const ratio of ratios) {
    total += ratio[1];
    heap.enqueue(ratio[1]);

    if (heap.size() > k) {
      const q = heap.dequeue();
      total -= q.element as number;
    }
    if (heap.size() === k) {
      res = Math.min(res, ratio[0] * total);
    }
  }
  return res;
}
