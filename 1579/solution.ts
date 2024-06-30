class UnionFind {
  roots: Array<number>;
  ranks: Array<number>;
  components: number;
  constructor(n: number) {
    this.roots = new Array(n).fill(0).map((_, idx) => idx);
    this.ranks = new Array(n).fill(1);
    this.components = n;
  }

  private find(x: number): number {
    if (this.roots[x] != x) {
      this.roots[x] = this.find(this.roots[x]);
    }
    return this.roots[x];
  }

  public union(x: number, y: number): boolean {
    const X = this.find(x);
    const Y = this.find(y);
    if (X == Y) {
      return false;
    }
    if (this.ranks[X] > this.ranks[Y]) {
      this.roots[Y] = X;
    } else if (this.ranks[Y] > this.ranks[X]) {
      this.roots[X] = Y;
    } else {
      this.roots[X] = Y;
      this.ranks[Y]++;
    }
    this.components--;
    return true;
  }
}

function maxNumEdgesToRemove(n: number, edges: number[][]): number {
  const alice = new UnionFind(n);
  const bob = new UnionFind(n);
  let res = 0;
  for (const [t, x, y] of edges) {
    if (t == 3) {
      const a = alice.union(x - 1, y - 1);
      const b = bob.union(x - 1, y - 1);
      if (!a && !b) {
        res++;
      }
    }
  }
  for (const [t, x, y] of edges) {
    if (t == 1) {
      const a = alice.union(x - 1, y - 1);
      if (!a) {
        res++;
      }
    }
    if (t == 2) {
      const b = bob.union(x - 1, y - 1);
      if (!b) {
        res++;
      }
    }
  }
  return alice.components == 1 && bob.components == 1 ? res : -1;
}
