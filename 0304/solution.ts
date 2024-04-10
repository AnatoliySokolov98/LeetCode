class NumMatrix {
  prefixes: Array<Array<number>>;
  constructor(matrix: number[][]) {
    const rows = matrix.length;
    const cols = matrix[0].length;
    this.prefixes = new Array(rows + 1)
      .fill(0)
      .map((el) => new Array(cols + 1).fill(0));
    for (let row = 0; row < rows; row++) {
      let total = 0;
      for (let col = 0; col < cols; col++) {
        total += matrix[row][col];
        this.prefixes[row + 1][col + 1] = total + this.prefixes[row][col + 1];
      }
    }
  }

  sumRegion(row1: number, col1: number, row2: number, col2: number): number {
    return (
      this.prefixes[row2 + 1][col2 + 1] -
      this.prefixes[row1][col2 + 1] -
      this.prefixes[row2 + 1][col1] +
      this.prefixes[row1][col1]
    );
  }
}
