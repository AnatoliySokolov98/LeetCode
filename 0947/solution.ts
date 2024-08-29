class UnionFind {
  rank: number[];
  parent: number[];
  size: number[];

  constructor(n: number) {
    this.rank = new Array(n).fill(1);
    this.parent = Array.from({ length: n }, (_, i) => i);
    this.size = new Array(n).fill(1);
  }

  find(x: number): number {
    if (this.parent[x] !== x) {
      this.parent[x] = this.find(this.parent[x]);
    }
    return this.parent[x];
  }

  union(x: number, y: number): void {
    const X = this.find(x);
    const Y = this.find(y);

    if (X === Y) return;

    if (this.rank[X] < this.rank[Y]) {
      this.parent[X] = Y;
      this.size[Y] += this.size[X];
    } else if (this.rank[X] > this.rank[Y]) {
      this.parent[Y] = X;
      this.size[X] += this.size[Y];
    } else {
      this.parent[Y] = X;
      this.rank[X] += 1;
      this.size[X] += this.size[Y];
    }
  }
}

function removeStones(stones: number[][]): number {
  const N = stones.length;
  const uf = new UnionFind(N);
  const rows: Record<number, number> = {};
  const cols: Record<number, number> = {};

  for (let i = 0; i < N; i++) {
    const [r, c] = stones[i];
    if (rows.hasOwnProperty(r)) {
      uf.union(rows[r], i);
    }
    rows[r] = i;

    if (cols.hasOwnProperty(c)) {
      uf.union(cols[c], i);
    }
    cols[c] = i;
  }

  let res = 0;
  for (let i = 0; i < N; i++) {
    if (uf.find(i) === i) {
      res += uf.size[i] - 1;
    }
  }

  return res;
}
