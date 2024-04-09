function isValidSudoku(board: string[][]): boolean {
  const rows = new Map<number, Set<number>>();
  const cols = new Map<number, Set<number>>();
  const boxes = new Map<number, Set<number>>();
  for (let i = 0; i < 9; i++) {
    for (let j = 0; j < 9; j++) {
      if (board[i][j] === ".") {
        continue;
      }
      const num = parseInt(board[i][j]);
      if (rows.has(i) && rows.get(i)!.has(num)) return false;
      if (cols.has(j) && cols.get(j)!.has(num)) return false;
      const box = Math.floor(i / 3) * 3 + Math.floor(j / 3);
      if (boxes.has(box) && boxes.get(box)!.has(num)) return false;
      if (!rows.has(i)) rows.set(i, new Set<number>());
      if (!cols.has(j)) cols.set(j, new Set<number>());
      if (!boxes.has(box)) boxes.set(box, new Set<number>());
      rows.get(i)!.add(num);
      cols.get(j)!.add(num);
      boxes.get(box)!.add(num);
    }
  }
  return true;
}
