class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

function reverseBetween(
  head: ListNode | null,
  left: number,
  right: number
): ListNode | null {
  const dummy: ListNode = new ListNode(0, head);
  let curr: ListNode | null = dummy;
  let i = 1;

  // Traverse until the start of the segment to be reversed
  while (i < left) {
    curr = curr.next!;
    i++;
  }

  const segmentStartPrev = curr;
  const segmentStart = curr.next;

  // Traverse to the end of the segment to be reversed
  while (i < right + 1) {
    curr = curr.next!;
    i++;
  }

  const segmentEnd = curr;
  const segmentEndNext = curr.next;

  // Disconnect the segment from the list for reversal
  segmentStartPrev.next = null;
  segmentEnd.next = null;

  // Reverse the segment
  let prev: ListNode | null = segmentEndNext;
  let node: ListNode | null = segmentStart;
  while (node) {
    const nextNode = node.next;
    node.next = prev;
    prev = node;
    node = nextNode;
  }

  // Reconnect the reversed segment back to the list
  segmentStartPrev.next = segmentEnd;
  return dummy.next;
}
