from random import choice


class RandomizedSet:

    def __init__(self):
        self.items = []
        self.locations = {}

    def insert(self, val: int) -> bool:
        if val in self.locations:
            return False
        self.items.append(val)
        self.locations[val] = len(self.items) - 1
        return True

    def remove(self, val: int) -> bool:
        if val not in self.locations:
            return False
        to_remove = self.locations[val]
        last_item = self.items[-1]
        self.locations[last_item] = to_remove
        self.items[to_remove], self.items[-1] = self.items[-1], self.items[to_remove]
        self.items.pop()
        self.locations.pop(val)
        return True

    def getRandom(self) -> int:
        return choice(self.items)
