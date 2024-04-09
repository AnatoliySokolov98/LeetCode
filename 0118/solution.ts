function generate(numRows: number): number[][] {
  const rows: number[][] = [[1]];
  for (let i = 1; i < numRows; i++) {
    const newRow: number[] = [1];
    for (let j = 0; j < rows[i - 1].length - 1; j++) {
      newRow.push(rows[i - 1][j] + rows[i - 1][j + 1]);
    }
    newRow.push(1);
    rows.push(newRow);
  }
  return rows;
}
