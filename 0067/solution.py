class Solution:
    def addBinary(self, a: str, b: str) -> str:
        a = a[::-1]
        b = b[::-1]
        res = []
        index = 0
        cin = 0
        while True:
            if index < len(a) and index < len(b):
                temp = int(a[index]) + int(b[index]) + cin
                res.append(str(temp % 2))
                cin = temp // 2
                index += 1
            elif index < len(a):
                temp = int(a[index]) + cin
                res.append(str(temp % 2))
                cin = temp // 2
                index += 1
            elif index < len(b):
                temp = int(b[index]) + cin
                res.append(str(temp % 2))
                cin = temp // 2
                index += 1
            else:
                break
        if cin:
            res.append("1")
        res = res[::-1]
        return "".join(res)

        # time O(max length(a or b))
        # space O (1)
