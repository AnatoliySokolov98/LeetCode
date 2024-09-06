class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

function modifiedList(nums: number[], head: ListNode | null): ListNode | null {
  const badValues = new Set(nums);
  const dummy = new ListNode();
  let curr = dummy;
  while (head) {
    if (!badValues.has(head.val)) {
      curr.next = head;
      curr = curr.next;
    }
    head = head.next;
    curr.next = null;
  }
  return dummy.next;
}
