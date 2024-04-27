function findRotateSteps(ring: string, key: string): number {
  const R = ring.length;
  const locs: Record<string, number[]> = {};

  // Build the location map
  for (let i = 0; i < R; i++) {
    const char = ring[i];
    if (!locs[char]) {
      locs[char] = [];
    }
    locs[char].push(i);
  }

  // Helper function to find minimum steps to reach the next character in the key
  function findMoves(char: string, idx: number): [number, number] {
    const positions = locs[char];
    if (idx > positions[positions.length - 1]) {
      return [idx - positions[positions.length - 1], R - idx + positions[0]];
    }
    if (idx < positions[0]) {
      return [idx + R - positions[positions.length - 1], positions[0] - idx];
    }

    let right = Infinity;
    let l = 0;
    let r = positions.length - 1;

    while (l <= r) {
      let p = Math.floor((l + r) / 2);
      if (positions[p] > idx) {
        right = p;
        r = p - 1;
      } else {
        l = p + 1;
      }
    }
    return [idx - positions[right - 1], positions[right] - idx];
  }

  // Cache object for storing computed results of dp function
  const dpCache: { [key: string]: number } = {};

  function dp(curr: number, keyPos: number): number {
    const cacheKey = `${curr}-${keyPos}`;
    if (dpCache[cacheKey] !== undefined) {
      return dpCache[cacheKey];
    }

    if (keyPos === key.length) {
      return 0;
    }

    if (ring[curr] === key[keyPos]) {
      dpCache[cacheKey] = 1 + dp(curr, keyPos + 1);
      return dpCache[cacheKey];
    }

    const [leftTurns, rightTurns] = findMoves(key[keyPos], curr);
    const leftLoc = (curr - leftTurns + R) % R;
    const rightLoc = (curr + rightTurns) % R;

    dpCache[cacheKey] = Math.min(
      leftTurns + 1 + dp(leftLoc, keyPos + 1),
      rightTurns + 1 + dp(rightLoc, keyPos + 1)
    );
    return dpCache[cacheKey];
  }

  return dp(0, 0);
}
