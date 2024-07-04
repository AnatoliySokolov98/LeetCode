class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

function mergeNodes(head: ListNode | null): ListNode | null {
  const dummy = new ListNode(0, head);
  let curr = dummy;
  let total = 0;
  head = head!.next;
  while (head != null) {
    while (head!.val != 0) {
      total += head!.val;
      head = head!.next;
    }
    head = head!.next;
    curr = curr.next!;
    curr.val = total;
    total = 0;
  }
  curr.next = null;
  return dummy.next;
}
