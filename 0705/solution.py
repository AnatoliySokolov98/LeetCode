class Node:
    def __init__(self, val=0, nxt=None):
        self.val = val
        self.nxt = nxt


class Bucket:
    def __init__(self):
        self.dummy = Node()

    def in_bucket(self, key):
        curr = self.dummy.nxt
        while curr:
            if curr.val == key:
                return True
            curr = curr.nxt
        return False

    def insert(self, key):
        if self.in_bucket(key):
            return
        new_node = Node(key, self.dummy.nxt)
        self.dummy.nxt = new_node

    def delete(self, key):
        if not self.in_bucket(key):
            return
        curr = self.dummy.nxt
        prev = self.dummy

        while curr:
            if curr.val == key:
                prev.nxt = curr.nxt
                return
            prev = curr
            curr = curr.nxt


class MyHashSet:

    def __init__(self):
        self.buckets = [Bucket()] * 1000

    def add(self, key: int) -> None:
        self.buckets[key % 1000].insert(key)

    def remove(self, key: int) -> None:
        self.buckets[key % 1000].delete(key)

    def contains(self, key: int) -> bool:
        return self.buckets[key % 1000].in_bucket(key)
