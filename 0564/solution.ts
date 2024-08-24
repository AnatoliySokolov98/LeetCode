function nearestPalindromic(n: string): string {
  const N = n.length;

  // Handle the edge case for single-digit numbers
  if (N === 1) {
    return (parseInt(n) - 1).toString();
  }

  const original = BigInt(n);
  const lessDigits = BigInt(Math.pow(10, N - 1)) - 1n;
  const moreDigits = BigInt(Math.pow(10, N)) + 1n;

  // Generate the first half
  const halfVal = BigInt(n.substring(0, Math.ceil(N / 2)));

  const same = buildPal(halfVal, N % 2 === 0);
  const smaller = buildPal(halfVal - 1n, N % 2 === 0);
  const bigger = buildPal(halfVal + 1n, N % 2 === 0);

  // Collect all candidates
  const candidates = [lessDigits, moreDigits, smaller, same, bigger];
  candidates.sort((a, b) => (a < b ? -1 : 1)); // Sorting bigints correctly

  // Find the closest palindrome
  let closest = BigInt(Number.MAX_SAFE_INTEGER);
  for (const candidate of candidates) {
    if (candidate === original) continue;
    if (abs(candidate - original) < abs(closest - original)) {
      closest = candidate;
    }
  }
  return closest.toString();
}

function buildPal(half: bigint, isEven: boolean): bigint {
  const halfStr = half.toString();
  let palinStr: string;
  if (isEven) {
    palinStr = halfStr + halfStr.split("").reverse().join("");
  } else {
    palinStr =
      halfStr +
      halfStr
        .substring(0, halfStr.length - 1)
        .split("")
        .reverse()
        .join("");
  }
  return BigInt(palinStr);
}

function abs(value: bigint): bigint {
  return value < 0n ? -value : value;
}
