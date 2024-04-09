class MyHashMap:

    def __init__(self):
        self.hash_map = [[] for i in range(1000)]

    def put(self, key: int, value: int) -> None:
        i = key % 1000
        bucket = self.hash_map[i]
        for i in range(len(bucket)):
            if bucket[i][0] == key:
                bucket[i][1] = value
                return
        bucket.append([key, value])

    def get(self, key: int) -> int:
        i = key % 1000
        bucket = self.hash_map[i]
        for i in range(len(bucket)):
            if bucket[i][0] == key:
                return bucket[i][1]
        return -1

    def remove(self, key: int) -> None:
        i = key % 1000
        bucket = self.hash_map[i]
        for i in range(len(bucket)):
            if bucket[i][0] == key:
                bucket.pop(i)
                return
