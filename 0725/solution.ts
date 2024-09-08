class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

function splitListToParts(
  head: ListNode | null,
  k: number
): Array<ListNode | null> {
  const res = Array(k);
  let len = 0;
  let curr = head;
  while (curr != null) {
    len++;
    curr = curr.next;
  }
  const piece = Math.floor(len / k);
  const extra = len % k;
  let dummy = new ListNode(0, head);
  let prev = dummy;
  curr = head;
  for (let i = 0; i < k; i++) {
    let j = piece + (i < extra ? 1 : 0);
    const beforeStart = prev;
    while (j > 0) {
      prev = curr;
      curr = curr.next;
      j--;
    }
    res[i] = beforeStart.next;
    beforeStart.next = null;
  }
  return res;
}
