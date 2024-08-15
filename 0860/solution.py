class Solution:
    def lemonadeChange(self, bills: list[int]) -> bool:
        cashier = [0, 0]
        for bill in bills:
            if bill == 5:
                cashier[0] += 1
            elif bill == 10:
                cashier[1] += 1
                if cashier[0] == 0:
                    return False
                cashier[0] -= 1
            else:
                if cashier[1] > 0 and cashier[0] > 0:
                    cashier[1] -= 1
                    cashier[0] -= 1
                elif cashier[0] >= 3:
                    cashier[0] -= 3
                else:
                    return False
        return True
