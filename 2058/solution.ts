class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

function nodesBetweenCriticalPoints(head: ListNode | null): number[] {
  const res = [Infinity, -Infinity];
  let i = 1;
  let firstLoc = 0;
  let lastLoc = 0;
  let curr = head!.next;
  let prev = head;

  while (curr!.next != null) {
    if (
      (curr!.val > curr!.next.val && curr!.val > prev!.val) ||
      (curr!.val < curr!.next.val && curr!.val < prev!.val)
    ) {
      if (firstLoc != 0) {
        res[0] = Math.min(res[0], i - lastLoc);
        res[1] = i - firstLoc;
      } else {
        firstLoc = i;
      }
      lastLoc = i;
    }
    i++;
    curr = curr!.next;
    prev = prev!.next;
  }
  return res[0] == Infinity ? [-1, -1] : res;
}
