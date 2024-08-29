import java.util.Arrays;

class UnionFind {
   private int[] parent;
   private int[] rank;
   private int[] size;

   public UnionFind(int n) {
      parent = new int[n];
      rank = new int[n];
      size = new int[n];
      for (int i = 0; i < n; i++) {
         parent[i] = i;
         rank[i] = 1;
         size[i] = 1;
      }
   }

   public int find(int x) {
      if (parent[x] != x) {
         parent[x] = find(parent[x]);
      }
      return parent[x];
   }

   public void union(int x, int y) {
      int rootX = find(x);
      int rootY = find(y);
      if (rootX == rootY) {
         return;
      }
      if (rank[rootX] < rank[rootY]) {
         parent[rootX] = rootY;
         size[rootY] += size[rootX];
      } else if (rank[rootX] > rank[rootY]) {
         parent[rootY] = rootX;
         size[rootX] += size[rootY];
      } else {
         parent[rootY] = rootX;
         rank[rootX]++;
         size[rootX] += size[rootY];
      }
   }

   public int getSize(int x) {
      return size[find(x)];
   }
}

class Solution {
   public int removeStones(int[][] stones) {
      int n = stones.length;
      UnionFind uf = new UnionFind(n);

      // Using arrays for rows and columns initialized to -1
      int[] rows = new int[10001];
      int[] cols = new int[10001];
      Arrays.fill(rows, -1);
      Arrays.fill(cols, -1);

      for (int i = 0; i < n; i++) {
         int r = stones[i][0];
         int c = stones[i][1];

         // Union with the existing stone in the same row if present
         if (rows[r] != -1) {
            uf.union(rows[r], i);
         } else {
            rows[r] = i; // Set the current stone index for this row
         }

         // Union with the existing stone in the same column if present
         if (cols[c] != -1) {
            uf.union(cols[c], i);
         } else {
            cols[c] = i; // Set the current stone index for this column
         }
      }

      int res = 0;
      for (int i = 0; i < n; i++) {
         if (uf.find(i) == i) {
            res += uf.getSize(i) - 1;
         }
      }

      return res;
   }
}

// time O(n)
// space O(n)