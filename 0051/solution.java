import java.util.*;

class Solution {
    Set<Integer> cols = new HashSet<>();
    Set<Integer> diagonalsLeft = new HashSet<>();
    Set<Integer> diagonalsRight = new HashSet<>();
    List<List<String>> results = new ArrayList<>();
    List<String> currentBoard = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        backtrack(0, n);
        return results;
    }

    private void backtrack(int row, int n) {
        if (row == n) {
            results.add(new ArrayList<>(currentBoard));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || diagonalsLeft.contains(row - col) || diagonalsRight.contains(row + col)) {
                continue;
            }
            char[] rowArray = new char[n];
            Arrays.fill(rowArray, '.');
            rowArray[col] = 'Q';
            String rowString = new String(rowArray);

            currentBoard.add(rowString);
            cols.add(col);
            diagonalsLeft.add(row - col);
            diagonalsRight.add(row + col);

            backtrack(row + 1, n);

            currentBoard.remove(currentBoard.size() - 1);
            cols.remove(col);
            diagonalsLeft.remove(row - col);
            diagonalsRight.remove(row + col);
        }
    }
}
