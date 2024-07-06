class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        extra = time % (n - 1)
        cycles = (time // (n - 1)) % 2
        return extra + 1 if cycles == 0 else n - extra
