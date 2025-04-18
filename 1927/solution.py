class Solution:
    def sumGame(self, num: str) -> bool:
        total = 0
        chars = 0

        for i in range(len(num) // 2):
            a_num = num[i]
            if a_num == '?':
                chars -= 1
            else:
                total -= int(a_num)
            b_num = num[i + len(num) // 2]
            if b_num == '?':
                chars += 1
            else:
                total += int(b_num)
        if not chars:
            return total != 0
        if not total:
            return True
        if total * chars > 0:
            return True
        return chars % 2 == 1 or abs(chars * 4.5) != abs(total)
        
    #time O(n)
    #space O(1)

    