function getRow(rowIndex: number): number[] {
  let prevRow = [1];
  for (let i = 1; i <= rowIndex; i++) {
    const currRow = [1];
    for (let j = 1; j < i; j++) {
      currRow.push(prevRow[j - 1] + prevRow[j]);
    }
    currRow.push(1);
    prevRow = currRow;
  }
  return prevRow;
}
