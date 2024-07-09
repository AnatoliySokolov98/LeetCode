function averageWaitingTime(customers: number[][]): number {
  let total = 0;
  let currTime = 0;
  for (const [start, wait] of customers) {
    if (currTime < start) {
      currTime = start;
    }
    currTime += wait;
    total += currTime - start;
  }
  return total / customers.length;
}
