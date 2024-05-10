function kthSmallestPrimeFraction(arr: Array<number>, k: number) {
  const heap = new MinPriorityQueue({ priority: (x: any[]) => x[0] });
  const n = arr.length;
  const visited = new Array(n).fill(0).map(() => new Array(n).fill(false));

  visited[0][n - 1] = true;
  heap.enqueue([arr[0] / arr[n - 1], 0, n - 1]);

  while (heap.size()) {
    const minItem = heap.dequeue();
    const i = minItem.element[1];
    const j = minItem.element[2];
    k--;

    if (k === 0) {
      return [arr[i], arr[j]];
    }

    if (i + 1 < j && !visited[i][j - 1]) {
      visited[i][j - 1] = true;
      heap.enqueue([arr[i] / arr[j - 1], i, j - 1]);
    }

    if (i + 1 < j && !visited[i + 1][j]) {
      visited[i + 1][j] = true;
      heap.enqueue([arr[i + 1] / arr[j], i + 1, j]);
    }
  }
}
