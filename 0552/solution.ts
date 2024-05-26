function checkRecord(n: number): number {
  const MOD = 1_000_000_007;
  //max absences
  const rows = 2;
  //max late days
  const cols = 3;
  let dp = [
    [0, 0, 0],
    [0, 0, 0],
  ];
  //first day present
  dp[0][0] = 1;
  //first day absent
  dp[1][0] = 1;
  //first day late
  dp[0][1] = 1;

  for (let i = 2; i <= n; i++) {
    const newDp = [
      [0, 0, 0],
      [0, 0, 0],
    ];
    for (let row = 0; row < rows; row++) {
      for (let col = 0; col < cols; col++) {
        const val = dp[row][col];
        newDp[row][0] = (newDp[row][0] + val) % MOD;
        if (row == 0) {
          newDp[row + 1][0] = (newDp[row + 1][0] + val) % MOD;
        }
        if (col < 2) {
          newDp[row][col + 1] = (newDp[row][col + 1] + val) % MOD;
        }
      }
    }
    dp = newDp;
  }
  let total = 0;
  for (let row = 0; row < rows; row++) {
    for (let col = 0; col < cols; col++) {
      total = (total + dp[row][col]) % MOD;
    }
  }
  return total;
}
