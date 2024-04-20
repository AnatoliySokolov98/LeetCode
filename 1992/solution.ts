function findFarmland(land: number[][]): number[][] {
  const ROWS = land.length;
  const COLS = land[0].length;
  const rectangles: number[][] = [];

  for (let i = 0; i < ROWS; i++) {
    for (let j = 0; j < COLS; j++) {
      if (land[i][j] === 1) {
        let right = j;
        while (right + 1 < COLS && land[i][right + 1] === 1) {
          right++;
        }

        let bottoROWS = i;
        while (bottoROWS + 1 < ROWS && land[bottoROWS + 1][j] === 1) {
          let valid = true;
          for (let col = j; col <= right; col++) {
            if (land[bottoROWS + 1][col] !== 1) {
              valid = false;
              break;
            }
          }
          if (valid) {
            bottoROWS++;
          } else {
            break;
          }
        }

        for (let r = i; r <= bottoROWS; r++) {
          for (let c = j; c <= right; c++) {
            land[r][c] = 0;
          }
        }

        rectangles.push([i, j, bottoROWS, right]);
      }
    }
  }

  return rectangles;
}
