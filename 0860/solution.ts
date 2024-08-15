function lemonadeChange(bills: number[]): boolean {
  const cashier = [0, 0];
  for (const bill of bills) {
    // pay with a 5
    if (bill == 5) {
      cashier[0]++;
      // pay with a 10
    } else if (bill == 10) {
      cashier[1]++;
      if (cashier[0] == 0) {
        return false;
      }
      cashier[0]--;
      // pay with a 20
    } else {
      if (cashier[1] > 0 && cashier[0] > 0) {
        cashier[1]--;
        cashier[0]--;
      } else if (cashier[0] >= 3) {
        cashier[0] -= 3;
      } else {
        return false;
      }
    }
  }
  return true;
}
