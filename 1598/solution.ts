function minOperations(logs: string[]): number {
  let level = 0;
  for (const log of logs) {
    if (log == "./") {
      continue;
    }
    if (log == "../") {
      level = Math.max(0, level - 1);
    } else {
      level++;
    }
  }
  return level;
}
