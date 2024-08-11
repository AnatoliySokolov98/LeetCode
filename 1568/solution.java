class Solution {
    private int ROWS;
    private int COLS;
    private int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int minDays(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int islands = 0;
        boolean[][] visited = new boolean[ROWS][COLS];

        // Count the number of islands
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (grid[row][col] == 1 && !visited[row][col]) {
                    islands++;
                    dfs(row, col, grid, visited);
                }
            }
        }

        if (islands != 1) {
            return 0;
        }

        int landCells = 0;
        int minConnections = Integer.MAX_VALUE;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (visited[row][col]) {
                    landCells++;
                    int connections = 0;
                    for (int[] direction : directions) {
                        int newRow = row + direction[0];
                        int newCol = col + direction[1];
                        if (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS && grid[newRow][newCol] == 1) {
                            connections++;
                        }
                    }
                    minConnections = Math.min(minConnections, connections);
                }
            }
        }

        if (landCells <= 2) {
            return landCells;
        }

        if (minConnections == 1) {
            return 1;
        }

        // Check if removing one land cell disconnects the island
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (grid[row][col] == 1) {
                    for (int[] direction : directions) {
                        int newRow = row + direction[0];
                        int newCol = col + direction[1];
                        if (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS && grid[newRow][newCol] == 1) {
                            grid[row][col] = 0;
                            boolean[][] newVisited = new boolean[ROWS][COLS];
                            dfs(newRow, newCol, grid, newVisited);
                            int newVisitedCount = 0;
                            for (boolean[] newRowArr : newVisited) {
                                for (boolean newCell : newRowArr) {
                                    if (newCell) {
                                        newVisitedCount++;
                                    }
                                }
                            }
                            if (newVisitedCount != landCells - 1) {
                                return 1;
                            }
                            grid[row][col] = 1;
                        }
                    }
                }
            }
        }

        return 2;
    }

    private void dfs(int row, int col, int[][] grid, boolean[][] visited) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS || visited[row][col] || grid[row][col] == 0) {
            return;
        }
        visited[row][col] = true;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            dfs(newRow, newCol, grid, visited);
        }
    }
}

// time O(m^2 * n^2)
// space O(mn)
