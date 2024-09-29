class Node:
    def __init__(self, freq, prev=None, next=None):
        self.freq = freq
        self.strings = set()
        self.prev = prev
        self.next = next


class AllOne:

    def __init__(self):
        self.head = Node(float("-inf"))
        self.tail = Node(float("inf"))
        self.head.next = self.tail
        self.tail.prev = self.head
        self.strings = {}

    def inc(self, key: str) -> None:
        # node not in hash map
        if key not in self.strings:
            # no node with freq == 1
            if self.head.next.freq != 1:
                node = Node(1, self.head, self.head.next)
                self.head.next.prev = node
                self.head.next = node
            self.head.next.strings.add(key)
            self.strings[key] = self.head.next
        else:
            node = self.strings[key]
            node.strings.remove(key)
            next_freq = node.freq + 1
            # no node with freq = curr + 1
            if node.next.freq != next_freq:
                new_node = Node(next_freq, node, node.next)
                node.next.prev = new_node
                node.next = new_node
            else:
                new_node = node.next
            new_node.strings.add(key)
            self.strings[key] = new_node
            if not node.strings:
                self._remove_node(node)

    def dec(self, key: str) -> None:
        node = self.strings[key]
        node.strings.remove(key)
        if node.freq == 1:
            del self.strings[key]
        else:
            prev_freq = node.freq - 1
            # prev node freq != curr - 1
            if node.prev.freq != prev_freq:
                new_node = Node(prev_freq, node.prev, node)
                node.prev.next = new_node
                node.prev = new_node
            else:
                new_node = node.prev
            new_node.strings.add(key)
            self.strings[key] = new_node
        if not node.strings:
            self._remove_node(node)

    def getMaxKey(self) -> str:
        if self.tail.prev == self.head:
            return ""
        return next(iter(self.tail.prev.strings))

    def getMinKey(self) -> str:
        if self.head.next == self.tail:
            return ""
        return next(iter(self.head.next.strings))

    def _remove_node(self, node):
        node.prev.next = node.next
        node.next.prev = node.prev
