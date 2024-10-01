class Solution:
    def canArrange(self, arr: list[int], k: int) -> bool:
        mods = {}

        for num in arr:
            mod = num % k
            complement = (k - mod) % k

            if complement in mods and mods[complement] > 0:
                mods[complement] -= 1
                if mods[complement] == 0:
                    del mods[complement]
            else:
                mods[mod] = mods.get(mod, 0) + 1

        return len(mods) == 0
