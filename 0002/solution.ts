class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

function addTwoNumbers(
  l1: ListNode | null,
  l2: ListNode | null
): ListNode | null {
  const dummy = new ListNode();
  let curr = dummy;
  let cin = 0;
  while (l1 || l2 || cin) {
    const first = l1 ? l1.val : 0;
    const second = l2 ? l2.val : 0;
    if (l1) {
      l1 = l1.next;
    }
    if (l2) {
      l2 = l2.next;
    }
    const res = (first + second + cin) % 10;
    cin = Math.floor((first + second + cin) / 10);
    curr.next = new ListNode(res);
    curr = curr.next;
  }
  return dummy.next;
}
