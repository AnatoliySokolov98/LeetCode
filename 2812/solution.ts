class MaxHeap {
  private heap: [number, number, number][];

  constructor() {
    this.heap = [];
  }

  public push(item: [number, number, number]): void {
    this.heap.push(item);
    this.bubbleUp();
  }

  public pop(): [number, number, number] | undefined {
    if (this.size() === 0) return undefined;
    const top = this.heap[0];
    const end = this.heap.pop();
    if (this.size() > 0 && end !== undefined) {
      this.heap[0] = end;
      this.bubbleDown();
    }
    return top;
  }

  public size(): number {
    return this.heap.length;
  }

  private bubbleUp(): void {
    let index = this.heap.length - 1;
    const element = this.heap[index];

    while (index > 0) {
      const parentIndex = Math.floor((index - 1) / 2);
      const parent = this.heap[parentIndex];

      if (element[0] <= parent[0]) break;

      this.heap[index] = parent;
      index = parentIndex;
    }
    this.heap[index] = element;
  }

  private bubbleDown(): void {
    let index = 0;
    const length = this.heap.length;
    const element = this.heap[0];

    while (true) {
      const leftChildIndex = 2 * index + 1;
      const rightChildIndex = 2 * index + 2;
      let leftChild: [number, number, number] | undefined;
      let rightChild: [number, number, number] | undefined;
      let swapIndex = -1;

      if (leftChildIndex < length) {
        leftChild = this.heap[leftChildIndex];
        if (leftChild[0] > element[0]) {
          swapIndex = leftChildIndex;
        }
      }

      if (rightChildIndex < length) {
        rightChild = this.heap[rightChildIndex];
        if (
          (swapIndex === -1 && rightChild[0] > element[0]) ||
          (swapIndex !== -1 &&
            rightChild[0] > (leftChild as [number, number, number])[0])
        ) {
          swapIndex = rightChildIndex;
        }
      }

      if (swapIndex === -1) break;

      this.heap[index] = this.heap[swapIndex];
      index = swapIndex;
    }
    this.heap[index] = element;
  }
}

function maximumSafenessFactor(grid: number[][]): number {
  const dir = [1, 0, -1, 0, 1];
  const n = grid.length;
  const safenessQueue: [number, number][] = [];

  for (let i = 0; i < n; ++i) {
    for (let j = 0; j < n; ++j) {
      if (grid[i][j] === 1) {
        safenessQueue.push([i, j]);
      }
    }
  }

  while (safenessQueue.length > 0) {
    const [i, j] = safenessQueue.shift()!;
    for (let d = 0; d < 4; ++d) {
      const x = i + dir[d];
      const y = j + dir[d + 1];
      if (x >= 0 && y >= 0 && x < n && y < n && grid[x][y] === 0) {
        grid[x][y] = grid[i][j] + 1;
        safenessQueue.push([x, y]);
      }
    }
  }

  const dijSafenessMaxHeap = new MaxHeap();
  dijSafenessMaxHeap.push([grid[0][0], 0, 0]);

  while (true) {
    const [sf, i, j] = dijSafenessMaxHeap.pop()!;
    if (i === n - 1 && j === n - 1) {
      return sf - 1;
    }
    for (let d = 0; d < 4; ++d) {
      const x = i + dir[d];
      const y = j + dir[d + 1];
      if (x >= 0 && y >= 0 && x < n && y < n && grid[x][y] > 0) {
        dijSafenessMaxHeap.push([Math.min(sf, grid[x][y]), x, y]);
        grid[x][y] *= -1;
      }
    }
  }
}
