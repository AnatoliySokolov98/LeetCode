class Solution {
   public int regionsBySlashes(String[] grid) {
      int N = grid.length;
      int[][] newGrid = new int[N * 3][N * 3];

      for (int r = 0; r < N; r++) {
         for (int c = 0; c < N; c++) {
            char ch = grid[r].charAt(c);
            if (ch == '/') {
               newGrid[r * 3][c * 3 + 2] = 1;
               newGrid[r * 3 + 1][c * 3 + 1] = 1;
               newGrid[r * 3 + 2][c * 3] = 1;
            } else if (ch == '\\') {
               newGrid[r * 3][c * 3] = 1;
               newGrid[r * 3 + 1][c * 3 + 1] = 1;
               newGrid[r * 3 + 2][c * 3 + 2] = 1;
            }
         }
      }

      int res = 0;
      for (int r = 0; r < N * 3; r++) {
         for (int c = 0; c < N * 3; c++) {
            if (newGrid[r][c] == 0) {
               res++;
               dfs(newGrid, r, c, N * 3);
            }
         }
      }

      return res;
   }

   private void dfs(int[][] grid, int r, int c, int N) {
      if (r < 0 || r >= N || c < 0 || c >= N || grid[r][c] == 1) {
         return;
      }
      grid[r][c] = 1;
      dfs(grid, r + 1, c, N);
      dfs(grid, r - 1, c, N);
      dfs(grid, r, c + 1, N);
      dfs(grid, r, c - 1, N);
   }
}

// time O(n^2)
// space O(n^2)