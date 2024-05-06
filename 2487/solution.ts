class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

function removeNodes(head: ListNode | null): ListNode | null {
  let curr: ListNode | null = head;
  let prev: ListNode | null = null;
  while (curr != null) {
    const temp = curr.next;
    curr.next = prev;
    prev = curr;
    curr = temp;
  }
  curr = prev;
  let biggest = curr!.val;
  while (curr!.next != null) {
    if (curr!.next.val >= biggest) {
      curr = curr!.next;
      biggest = Math.max(biggest, curr.val);
    } else {
      curr!.next = curr!.next.next;
    }
  }
  curr = prev;
  prev = null;
  while (curr != null) {
    const temp = curr.next;
    curr.next = prev;
    prev = curr;
    curr = temp;
  }
  return prev;
}
