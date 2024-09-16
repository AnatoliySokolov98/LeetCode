function findMinDifference(timePoints: string[]): number {
  const times = new Array(24 * 60).fill(false);
  let start = Infinity;
  let end = 0;

  // Mark time points and determine start and end time
  for (const time of timePoints) {
    const minutes = Number(time.slice(3));
    const hours = Number(time.slice(0, 2));
    const totalMinutes = hours * 60 + minutes;
    // If the time is already recorded, return 0
    if (times[totalMinutes]) {
      return 0;
    }
    times[totalMinutes] = true;
    start = Math.min(start, totalMinutes);
    end = Math.max(end, totalMinutes);
  }

  // Calculate the minimum time difference by considering the circular nature of the clock
  let minDifference = 24 * 60 - end + start;
  let prev = start;

  // Iterate through the time points to find the minimum difference
  for (let i = start + 1; i <= end; i++) {
    if (times[i]) {
      minDifference = Math.min(minDifference, i - prev);
      prev = i;
    }
  }

  return minDifference;
}
