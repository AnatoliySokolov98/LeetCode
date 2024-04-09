class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                int curr = (int) board[i][j] - '0';
                int box = (i/3) * 3 + (j/3);
                if(rows[i][curr - 1] || cols[j][curr - 1] || boxes[box][curr - 1]){
                    return false;
                }
                rows[i][curr - 1] = true;
                cols[j][curr - 1] = true;
                boxes[box][curr - 1] = true;
            }
        }
        return true;
    }
}