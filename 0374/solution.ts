/**
 * Forward declaration of guess API.
 * @param {number} num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * var guess = function(num) {}
 */
function guess(pivot: number): number {
  throw new Error("Function not implemented.");
}

function guessNumber(n: number): number {
  let left = 1,
    right = n;

  while (left <= right) {
    const pivot = Math.floor((left + right) / 2);
    const res = guess(pivot);
    if (!res) {
      return pivot;
    }
    if (res === 1) {
      left = pivot + 1;
    } else {
      right = pivot - 1;
    }
  }
  return -1;
}
