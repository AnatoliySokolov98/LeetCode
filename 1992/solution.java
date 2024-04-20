import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[][] findFarmland(int[][] land) {
        int ROWS = land.length;
        int COLS = land[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int r2 = i;
                    int c2 = j;
                    for (int k = i; k < ROWS; k++) {
                        if (land[k][j] == 0) {
                            break;
                        }
                        for (int m = j; m < COLS; m++) {
                            if (land[k][m] == 0) {
                                break;
                            }
                            visited[k][m] = true;
                            r2 = k;
                            c2 = m;
                        }
                    }
                    res.add(new int[] { i, j, r2, c2 });
                }
            }
        }
        return res.toArray(new int[res.size()][4]);

    }
}

// time O(n*m)
// space O(n*m)