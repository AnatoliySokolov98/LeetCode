class NumMatrix {
    int[][] prefixes;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        prefixes = new int[rows + 1][cols + 1];
        for (int row = 0; row < rows; row++) {
            int total = 0;
            for (int col = 0; col < cols; col++) {
                total += matrix[row][col];
                prefixes[row + 1][col + 1] = total + prefixes[row][col + 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixes[row2 + 1][col2 + 1] - prefixes[row1][col2 + 1] - prefixes[row2 + 1][col1]
                + prefixes[row1][col1];
    }
}
